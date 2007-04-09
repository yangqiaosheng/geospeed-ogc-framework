package org.geospeed.ogc.impl.wcs.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.IOgcResponse;
import org.geospeed.ogc.api.IOgcService;
import org.geospeed.ogc.impl.wcs.OgcWebCoverageService;
import org.geospeed.ogc.impl.web.AbstractOgcServlet;
import org.geospeed.ogc.impl.wfs.web.OgcWfsServlet;

/********************************************************************************
 * 
 * This is the entry point for the web version of the GeoSpeed Web Coverage Service
 * implementation.  This servlet is a simple dispatcher that is responsible for
 * gathering the request parameters, calling the appropriate IOgcService
 * implementation, and returning the results.
 * 
 * @author Mike Abner
 *
 ********************************************************************************/
public class OgcWcsServlet extends AbstractOgcServlet
{
    private static final long serialVersionUID = 0;
    private Logger log = Logger.getLogger(OgcWfsServlet.class);
    
    public void doGet(HttpServletRequest httpReq, HttpServletResponse httpRes)
    {
        log.info("Starting " + httpReq.getMethod() + " request recieved from " + httpReq.getRemoteAddr() + " initiated by user " + httpReq.getRemoteUser());
        long start = System.currentTimeMillis();
        
        IOgcMap params = gatherRequestParameters(httpReq); 
        
        IOgcService wcs = new OgcWebCoverageService();
        IOgcResponse wcsRes = wcs.executeRequest(params);
        
        sendResponse(httpRes, wcsRes);

        long end = System.currentTimeMillis();
        log.info("Finished processing " + httpReq.getMethod() + " request that was recieved from " + httpReq.getRemoteAddr() + " initiated by user " + httpReq.getRemoteUser());
        log.trace("Execution time: " + (end - start));
    }
}