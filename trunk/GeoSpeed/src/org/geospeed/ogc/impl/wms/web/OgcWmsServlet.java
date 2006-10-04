package org.geospeed.ogc.impl.wms.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.IOgcResponse;
import org.geospeed.ogc.api.IOgcService;
import org.geospeed.ogc.impl.OgcHashMap;
import org.geospeed.ogc.impl.wms.OgcWebMappingService;


/**
 * The OgcWmsServlet is the entry point to the Web Mapping Service exposed
 * through the framework.  It is a very light weight servlet that simply 
 * packages up the request parameters into a custom Map implementation
 * and passes that map on to a POJO that handles all of the dirty work
 * of processing the various WMS requests.  Finally, this class takes the
 * result of that processing and simply streams a byte array back to the 
 * caller.  
 * 
 * @author Mike Abner
 *
 */
public class OgcWmsServlet extends HttpServlet 
{
    private static final long serialVersionUID = 0;
    private Logger log = Logger.getLogger(OgcWmsServlet.class);
    
	public void doGet(HttpServletRequest httpReq, HttpServletResponse httpRes)
	{
        log.info("Starting " + httpReq.getMethod() + " request recieved from " + httpReq.getRemoteAddr() + " initiated by user " + httpReq.getRemoteUser());
        long start = System.currentTimeMillis();
        
        /*
         * Get the names of the parameters passed to the service and iterate through them 
         * and place them into a Map for the WMS implementation to use.
         */
		Enumeration paramNames = httpReq.getParameterNames();
        IOgcMap params = new OgcHashMap();
        
        while (paramNames.hasMoreElements())
        {
            String param = (String)paramNames.nextElement();
            params.put(param, httpReq.getParameter(param).toUpperCase());
            log.debug("Adding param " + param + " with value " + httpReq.getParameter(param).toUpperCase() + " to the params Map.");
        }
        paramNames = null;
        
        /*
         * Include the authtype and userprincipal so that the implementation can have an
         * idea about who the user of this service is.
         */
        params.put(httpReq.getAuthType(), "AUTHTYPE");
        log.debug("Adding param AUTHTYPE with value " + httpReq.getAuthType() + " to the params Map.");
        params.put(httpReq.getUserPrincipal(), "USERPRINCIPAL");
        log.debug("Adding param USERPRINCIPAL with value " + httpReq.getUserPrincipal() + " to the params Map.");
        
        /*
         * Create the object that implements the WMS service and send it the params gathered
         * above.  This is where all the magic happens!  Or rather, this is where the actual
         * WMS server implementation is invoked.
         */
        log.debug("Creating the OgcWebMappingService.");
        IOgcService wms = new OgcWebMappingService();
        log.debug("Calling OgcWebMappingService.execute(params).");
        IOgcResponse wmsRes = wms.executeRequest(params);
        log.debug("IOgcResponse recieved with response type " + wmsRes.getResponseType() + ".");
        
        //send the response
        try
        {
            log.debug("Sending the IOgcResponse.");
        	ServletOutputStream sos = httpRes.getOutputStream();
        	sos.write(wmsRes.getBytes());
        	sos.flush();
        	sos.close();
            log.debug("Finished sending the response to " + httpReq.getRemoteAddr() + ".");
        }
        catch (IOException ioe)
        {
        	//ack!!!  Bad bad things happenned that we don't know how to recover from!
            log.fatal("An IOException occurred while getting the ServletOutputStream or while sending" +
                    " the IOgcResponse.\n" + ioe.getMessage());
        }
        
        long end = System.currentTimeMillis();
        log.info("Finished processing " + httpReq.getMethod() + " request that was recieved from " + httpReq.getRemoteAddr() + " initiated by user " + httpReq.getRemoteUser());
        log.trace("Execution time: " + (end - start));
	}
}
