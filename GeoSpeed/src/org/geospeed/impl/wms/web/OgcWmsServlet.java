package org.geospeed.impl.wms.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.geospeed.api.IOgcResponse;
import org.geospeed.api.IOgcService;
import org.geospeed.impl.web.AbstractOgcServlet;
import org.geospeed.impl.wms.OgcWebMappingService;
import org.geospeed.keys.OgcRequestKey;
import org.geospeed.keys.WebMappingServiceKey;


/********************************************************************************
 * 
 * This is the entry point for the web version of the GeoSpeed Web Mapping Service
 * implementation.  This servlet is a simple dispatcher that is responsible for
 * gathering the request parameters, calling the appropriate IOgcService
 * implementation, and returning the results.
 * 
 * @author Mike Abner
 *
 ********************************************************************************/
public class OgcWmsServlet extends AbstractOgcServlet 
{
    private static final long serialVersionUID = 0;
    private Logger log = Logger.getLogger(OgcWmsServlet.class);
    
	public void doGet(HttpServletRequest httpReq, HttpServletResponse httpRes)
	{
        log.info("Starting " + httpReq.getMethod() + " request recieved from " + httpReq.getRemoteAddr() + " initiated by user " + httpReq.getRemoteUser());
        long start = System.currentTimeMillis();
        
        log.debug("Attempting to gather parameters from the http request.");
        Map<String, String> params = gatherRequestParameters(httpReq);
        log.debug("Successfully gathered the request parameters.");
        
        String service = params.get(OgcRequestKey.SERVICE);
        
        //Check to make sure that the correct service is being called.  If not then 
        //the OgcWebMappingService class can't processes it and will blow up.
        if (service != null && !service.equals(WebMappingServiceKey.SERVICE_NAME))
        {    
            String msg = "Incorrect service type!  Check the web.xml to ensure that the URL that" +
            " forwards to this service is correct and that the correct URL is being" +
            " called from the client application.";
            log.debug(msg);
            log.debug("Attempting to send Error response.");
            sendResponse(httpRes, createGenericResponse(msg));
            log.debug("Successfully sent Error response.");
            return;
        }
        
        IOgcService wms = new OgcWebMappingService();
        
        log.debug("Attempting to execute the WMS request.");
        IOgcResponse wmsRes = wms.executeRequest(params);
        log.debug("Successfully executed the WMS request.");
        
        log.debug("Attempting to send the IOgcResponse.");
        sendResponse(httpRes, wmsRes);
        log.debug("Successfully sent the IOgcResponse.");
        
        long end = System.currentTimeMillis();
        log.info("Finished processing " + httpReq.getMethod() + " request that was recieved from " + httpReq.getRemoteAddr() + " initiated by user " + httpReq.getRemoteUser() + " Execution time: " + (end - start));
	}

	public void doPost(HttpServletRequest httpReq, HttpServletResponse httpRes)
    {
	    
    }
}
