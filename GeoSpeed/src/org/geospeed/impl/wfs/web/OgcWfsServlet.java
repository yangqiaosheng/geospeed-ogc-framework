package org.geospeed.impl.wfs.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.geospeed.api.IOgcResponse;
import org.geospeed.api.IOgcService;
import org.geospeed.impl.web.AbstractOgcServlet;
import org.geospeed.impl.wfs.OgcWebFeatureService;
import org.geospeed.keys.OgcRequestKey;
import org.geospeed.keys.WebFeatureServiceKey;

public class OgcWfsServlet extends AbstractOgcServlet
{
	private static final long serialVersionUID = 0;
    private Logger log = Logger.getLogger(this.getClass());
    
	public void doGet(HttpServletRequest httpReq, HttpServletResponse httpRes)
	{
		log.trace("Starting " + httpReq.getMethod() + " request recieved from '" + httpReq.getRemoteAddr() + "'.");
        long start = System.currentTimeMillis();
        
        log.debug("Attempting to gather parameters from the http request.");
        Map<String, String> params = gatherRequestParameters(httpReq);
        log.debug("Successfully gathered the request parameters.");
        
        String service = params.get(OgcRequestKey.SERVICE.name());
        
        //Check to make sure that the correct service is being called.  If not then 
        //the OgcWebFeatureService class can't processes it and will blow up.
        if (service != null && !service.equals(WebFeatureServiceKey.SERVICE_NAME.name()))
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
        
        IOgcService wfs = new OgcWebFeatureService();
        
        log.debug("Attempting to execute the WFS request.");
        IOgcResponse wfsRes = wfs.executeRequest(params);
        log.debug("Successfully executed the WFS request.");
        
        log.debug("Attempting to send the IOgcResponse.");
        sendResponse(httpRes, wfsRes);
        log.debug("Successfully sent the IOgcResponse.");
        
        long end = System.currentTimeMillis();
        log.trace("Finished processing " + httpReq.getMethod() + " request that was recieved from '" + httpReq.getRemoteAddr() + "'. Execution time: " + (end - start) + ".");
	}
	
	public void doPost(HttpServletRequest httpReq, HttpServletResponse httpRes)
    {
        log.trace("Starting " + httpReq.getMethod() + " request recieved from '" + httpReq.getRemoteAddr() + "'.");
        long start = System.currentTimeMillis();   
        
        String msg = "The GeoSpeed OGC Framework does not currenty support POST requests for the WFS specification.  " +
                "Please edit your capabilities document to remove all references to the HTTP POST method.";
        log.debug(msg);
        log.debug("Attempting to send Error response.");
        sendResponse(httpRes, createGenericResponse(msg));
        log.debug("Successfully sent Error response.");
        
        long end = System.currentTimeMillis();
        log.trace("Finished processing " + httpReq.getMethod() + " request that was recieved from '" + httpReq.getRemoteAddr() + "'. Execution time: " + (end - start) + ".");
    }
}
