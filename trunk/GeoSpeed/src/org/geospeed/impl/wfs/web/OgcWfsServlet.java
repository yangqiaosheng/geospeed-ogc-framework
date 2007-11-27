package org.geospeed.impl.wfs.web;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.geospeed.api.IOgcResponse;
import org.geospeed.api.IOgcService;
import org.geospeed.impl.web.AbstractOgcServlet;
import org.geospeed.impl.wfs.OgcWebFeatureService;
import org.geospeed.keys.OgcRequestKey;
import org.geospeed.keys.WebFeatureServiceKey;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class OgcWfsServlet extends AbstractOgcServlet
{
	private static final long serialVersionUID = 0;
    private Logger log = Logger.getLogger(this.getClass());
    
	public void doGet(HttpServletRequest httpReq, HttpServletResponse httpRes)
	{
		log.debug("doGet::enter.");
		
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
        
        log.debug("doGet::exit.");
	}
	
	public void doPost(HttpServletRequest httpReq, HttpServletResponse httpRes)
    {
		log.debug("doPost::enter.");
		
        log.trace("Starting " + httpReq.getMethod() + " request recieved from '" + httpReq.getRemoteAddr() + "'.");
        long start = System.currentTimeMillis();   
        
        log.debug("Attempting to gather parameters from the http request.");
        Map<String, String> params = gatherRequestParameters(httpReq);
        log.debug("Successfully gathered the request parameters.");
        /*
        String xml = ""; 
        
        try
        {
        	BufferedReader br = httpReq.getReader();
        	
        	String s = "";        	
        	
        	while((s = br.readLine()) != null)
        	{
        		xml = xml + s;
        	}
        	
        	log.debug(xml);
        }
        catch (IOException ioe)
        {
        	ioe.printStackTrace();
        }
        
        params.put(WebFeatureServiceKey.XML.name(), xml);
        */
        IOgcService wfs = new OgcWebFeatureService();
        
        log.debug("Attempting to execute the WFS request.");
        IOgcResponse wfsRes = wfs.executeRequest(params);
        log.debug("Successfully executed the WFS request.");
        
        log.debug("Attempting to send the IOgcResponse.");
        sendResponse(httpRes, wfsRes);
        log.debug("Successfully sent the IOgcResponse.");
        
        
        long end = System.currentTimeMillis();
        log.trace("Finished processing " + httpReq.getMethod() + " request that was recieved from '" + httpReq.getRemoteAddr() + "'. Execution time: " + (end - start) + ".");
        
        log.debug("doPost::exit.");
    }
}
