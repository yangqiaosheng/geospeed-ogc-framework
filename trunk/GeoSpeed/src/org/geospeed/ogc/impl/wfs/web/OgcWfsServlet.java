package org.geospeed.ogc.impl.wfs.web;

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
import org.geospeed.ogc.impl.web.AbstractOgcServlet;
import org.geospeed.ogc.impl.wfs.OgcWebFeatureService;


public class OgcWfsServlet extends AbstractOgcServlet
{
    private static final long serialVersionUID = 0;
    private Logger log = Logger.getLogger(OgcWfsServlet.class);
    
    public void doGet(HttpServletRequest httpReq, HttpServletResponse httpRes)
    {
        log.info("Starting " + httpReq.getMethod() + " request recieved from " + httpReq.getRemoteAddr() + " initiated by user " + httpReq.getRemoteUser());
        long start = System.currentTimeMillis();

        IOgcMap params = gatherRequestParameters(httpReq);
        
        IOgcService wfs = new OgcWebFeatureService();
        IOgcResponse wfsRes = wfs.executeRequest(params);
        
        sendResponse(httpRes, wfsRes);

        long end = System.currentTimeMillis();
        log.info("Finished processing " + httpReq.getMethod() + " request that was recieved from " + httpReq.getRemoteAddr() + " initiated by user " + httpReq.getRemoteUser());
        log.trace("Execution time: " + (end - start));
    }
}
