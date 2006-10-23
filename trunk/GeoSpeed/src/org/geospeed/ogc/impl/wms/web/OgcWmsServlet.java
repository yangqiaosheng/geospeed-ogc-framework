package org.geospeed.ogc.impl.wms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.IOgcResponse;
import org.geospeed.ogc.api.IOgcService;
import org.geospeed.ogc.impl.web.AbstractOgcServlet;
import org.geospeed.ogc.impl.wms.OgcWebMappingService;


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
        System.out.println("Starting " + httpReq.getMethod() + " request recieved from " + httpReq.getRemoteAddr() + " initiated by user " + httpReq.getRemoteUser());
        log.info("Starting " + httpReq.getMethod() + " request recieved from " + httpReq.getRemoteAddr() + " initiated by user " + httpReq.getRemoteUser());
        long start = System.currentTimeMillis();
        
        IOgcMap params = gatherRequestParameters(httpReq);
        
        IOgcService wms = new OgcWebMappingService();
        IOgcResponse wmsRes = wms.executeRequest(params);
                
        sendResponse(httpRes, wmsRes);
        
        long end = System.currentTimeMillis();
        log.info("Finished processing " + httpReq.getMethod() + " request that was recieved from " + httpReq.getRemoteAddr() + " initiated by user " + httpReq.getRemoteUser());
        log.trace("Execution time: " + (end - start));
	}

	public void doPost(HttpServletRequest httpReq, HttpServletResponse httpRes)
    {
	    doGet(httpReq, httpRes);
    }
}
