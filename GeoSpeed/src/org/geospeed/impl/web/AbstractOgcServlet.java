package org.geospeed.impl.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
     * access the entries in the IOgcMap are converte to UPPERCASE Strings.
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
            String value = httpReq.getParameter(param);
            params.put(param.toUpperCase(), value);
        
            log.debug("Added parameter '" + param + "' with value '" + value + "'.");
        }
        
        log.debug("Exiting gatherRequestParameters(HttpServletRequest).");
        return params;
    }
    
    /**
     * Sends the contents of the IOgcResponse through the stream from the
     * HttpServletResponse.
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
            
            Map<String, Long> dateHeader = ogcRes.getDateHeader();
            
            if (dateHeader.size() > 0)
            {
                Set<String> keys = dateHeader.keySet();
                
                for (String key : keys)
                {
                    Long value = dateHeader.get(key);
                    
                    httpRes.addDateHeader(key, value.longValue());
                }
            }

            Map<String, String> header = ogcRes.getHeaders();
            
            if (header.size() > 0)
            {
                Set<String> keys = header.keySet();
                
                for (String key : keys)
                {
                    String value = header.get(key);
                    
                    httpRes.addHeader(key, value);
                }
            }
            
            Map<String, Integer> intHeader = ogcRes.getIntHeaders();
            
            if (intHeader.size() > 0)
            {
                Set<String> keys = intHeader.keySet();
                
                for (String key : keys)
                {
                    Integer value = intHeader.get(key);
                    
                    httpRes.addIntHeader(key, value.intValue());
                }
            }
            
            if (ogcRes.getStatus() != 0)
                httpRes.setStatus(ogcRes.getStatus());
            
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

    /**
     * Sends a plain text message to the request initiator.  Used primarily for testing.
     * @param message
     * @return
     */
    public OgcResponse createGenericResponse(String message)
    {
        OgcResponse res = new OgcResponse(message.getBytes());
        res.setContentType(ContentTypeKey.TEXT_PLAIN.name());
        
        return res;
    }
}
