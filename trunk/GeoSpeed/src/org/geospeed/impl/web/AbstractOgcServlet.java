package org.geospeed.impl.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.geospeed.api.IOgcResponse;
import org.geospeed.impl.OgcResponse;
import org.geospeed.keys.ContentTypeKey;

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
    private Logger log = Logger.getLogger(AbstractOgcServlet.class);
    
    /**
     * Gathers the list of request parameters into an IOgcMap.  The keys that
     * access the IOgcMap are UPPERCASE Strings.
     * 
     * @return an IOgcMap containing all of the parameters in the HttpRequest.
     */
    public Map<String, String> gatherRequestParameters(HttpServletRequest httpReq)
    {
        log.debug("Entering gatherRequestParameters(HttpServletRequest).");
        
        Enumeration paramNames = httpReq.getParameterNames();
        Map<String, String> params = new HashMap<String, String>();
        
        while (paramNames.hasMoreElements())
        {
            String param = (String)paramNames.nextElement();
            String value = httpReq.getParameter(param).toUpperCase();
            params.put(param, value);
        
            log.debug("Added parameter '" + param + "' with value '" + value + "'.");
        }
        
        log.debug("Exiting gatherRequestParameters(HttpServletRequest).");
        return params;
    }
    
    /**
     * Sends the contents of the IOgcResponse through the stream from the
     * HttpServletResponse
     * 
     * @param httpRes The HttpServletResponse created when this servlet was called.
     * @param ogcRes The IOgcResponse created by the IOgcService implementation.
     */
    public void sendResponse(HttpServletResponse httpRes, IOgcResponse ogcRes)
    {      
        log.debug("Entering sendResponse(HttpServletResponse, IOgcResponse).");
        
        try
        {
            httpRes.setContentType(ogcRes.getContentType());
            httpRes.setContentLength(ogcRes.getLength());
            ServletOutputStream sos = httpRes.getOutputStream();
            log.debug("Sending response...");
            sos.write(ogcRes.getBytes());
            sos.flush();
            sos.close();
            log.debug("Response sent.");
        }
        catch (IOException ioe)
        {
            log.debug("Error sending response!  " + ioe.getLocalizedMessage());
            ioe.printStackTrace();
        }
        
        log.debug("Exiting sendResponse(HttpServletResponse, IOgcResponse).");
    }

    public OgcResponse createGenericResponse(String message)
    {
        OgcResponse res = new OgcResponse(message.getBytes());
        res.setContentType(ContentTypeKey.TEXT_PLAIN.name());
        
        return res;
    }
}
