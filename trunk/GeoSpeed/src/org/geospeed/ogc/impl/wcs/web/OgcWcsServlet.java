package org.geospeed.ogc.impl.wcs.web;

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
import org.geospeed.ogc.impl.wcs.OgcWebCoverageService;
import org.geospeed.ogc.impl.wfs.web.OgcWfsServlet;


public class OgcWcsServlet extends HttpServlet
{
    private static final long serialVersionUID = 0;
    private Logger log = Logger.getLogger(OgcWfsServlet.class);
    
    public void doGet(HttpServletRequest httpReq, HttpServletResponse httpRes)
    {
        log.info("Starting " + httpReq.getMethod() + " request recieved from " + httpReq.getRemoteAddr() + " initiated by user " + httpReq.getRemoteUser());
        long start = System.currentTimeMillis();
        
        Enumeration paramNames = httpReq.getParameterNames();
        IOgcMap params = new OgcHashMap();
        
        while (paramNames.hasMoreElements())
        {
            String param = (String)paramNames.nextElement();
            //params.put(param, httpReq.getParameter(param));
            params.put(param, httpReq.getParameter(param).toUpperCase());
            //params.put(param, httpReq.getParameter(param).toLowerCase());
        }
        
        params.put(httpReq.getAuthType(), "AUTHTYPE");
        params.put(httpReq.getUserPrincipal(), "USERPRINCIPAL");
        
        IOgcService wcs = new OgcWebCoverageService();
        IOgcResponse wcsRes = wcs.executeRequest(params);
        
        //send the response
        try
        {
            ServletOutputStream sos = httpRes.getOutputStream();
            sos.write(wcsRes.getBytes());
            sos.flush();
            sos.close();
        }
        catch (IOException ioe)
        {
            //ack!!!
        }

        long end = System.currentTimeMillis();
        log.info("Finished processing " + httpReq.getMethod() + " request that was recieved from " + httpReq.getRemoteAddr() + " initiated by user " + httpReq.getRemoteUser());
        log.trace("Execution time: " + (end - start));
    }
}
