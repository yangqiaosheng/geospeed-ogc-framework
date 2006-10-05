package org.geospeed.ogc.impl.wms.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.IOgcResponse;
import org.geospeed.ogc.api.IOgcService;
import org.geospeed.ogc.impl.OgcHashMap;
import org.geospeed.ogc.impl.web.AbstractOgcServlet;
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
public class OgcWmsServlet extends AbstractOgcServlet 
{
    private static final long serialVersionUID = 0;
    private Logger log = Logger.getLogger(OgcWmsServlet.class);
    
	public void doGet(HttpServletRequest httpReq, HttpServletResponse httpRes)
	{
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
}
