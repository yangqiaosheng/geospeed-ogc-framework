package org.geospeed.ogc.impl.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.IOgcResponse;
import org.geospeed.ogc.impl.OgcHashMap;

/********************************************************************************
 * 
 * This class implements a few common methods useful for the implementing servlets.
 * These include gathering the passed parameters and returning a response.
 * 
 * 
 * @author Mike Abner
 *
 ********************************************************************************/
public abstract class AbstractOgcServlet extends HttpServlet
{
    /**
     * Gathers the list of request parameters into an IOgcMap.  The keys that
     * access the IOgcMap are UPPERCASE Strings.
     * 
     * @return an IOgcMap containing all of the parameters in the HttpRequest
     */
    public IOgcMap gatherRequestParameters(HttpServletRequest httpReq)
    {
        Enumeration paramNames = httpReq.getParameterNames();
        IOgcMap params = new OgcHashMap();
        
        while (paramNames.hasMoreElements())
        {
            String param = (String)paramNames.nextElement();
            params.put(param, httpReq.getParameter(param).toUpperCase());
        }
        
        return params;
    }
    
    public void sendResponse(HttpServletResponse httpRes, IOgcResponse ogcRes)
    {
        try
        {
            ServletOutputStream sos = httpRes.getOutputStream();
            sos.write(ogcRes.getBytes());
            sos.flush();
            sos.close();
        }
        catch (IOException ioe)
        {
            //ack!!!
        }
    }
}
