package org.geospeed.impl.wfs.factory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.geospeed.api.IOgcRequest;
import org.geospeed.impl.wfs.request.OgcWfsDescribeFeatureTypeRequest;
import org.geospeed.impl.wfs.request.OgcWfsGetCapabilitiesRequest;
import org.geospeed.impl.wfs.request.OgcWfsGetFeatureRequest;
import org.geospeed.keys.OgcRequestKey;
import org.geospeed.keys.WebFeatureServiceKey;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;


/********************************************************************************
 * 
 * @author Mike Abner
 * 
 * The OgcWmsRequestFactory examines the value of the "REQUEST" parameter as passed
 * by the requestor and creates an IOgcRequest object that corresponds to that
 * value.  Developers of IOgcRequestProcessors should cast the IOgcRequest object
 * that is passed to them into the appropriate request type to access the attributes
 * of the object that is created here.
 *
 ********************************************************************************/
public class OgcWfsRequestFactory 
{
    private static Logger log = Logger.getLogger(OgcWfsRequestFactory.class);
    
    /**
     * Given a Map that contains a key of "REQUEST", create the appropriate
     * IOgcRequest to expose the attributes passed by the requestor.
     * 
     * @param params - Map that contains all of the attributes passed by the requestor.
     * @return IOgcRequest - an IOgcWmsRequest that has been "filled out" with the
     * parameters from the params Map.
     * @throws IOException Is thrown when no REQUEST key is available in the params Map 
     * OR when the value returned with the REQUEST key does not match any valid WMS
     * request types. 
     */
	public static IOgcRequest createWfsRequest(Map<String, String> params) throws IOException
    {
        log.debug("Entering createWfsRequest(IOgcMap).");

        params = parseXML(params);
        
        log.debug("Looking up the '" + OgcRequestKey.REQUEST.name() + "' parameter.");
        String requestParameter = (String)params.get(OgcRequestKey.REQUEST.name());
        log.debug("The '" + OgcRequestKey.REQUEST.name() + "' parameter value is '" + requestParameter + "'.");
        
        if (requestParameter == null || requestParameter.equals(""))
        {
            StringBuffer msg = new StringBuffer("The " + OgcRequestKey.REQUEST.name() + " parameter was null.");
            log.error(msg.toString());
            throw new IOException(msg.toString());
        }

        if (requestParameter.equalsIgnoreCase(WebFeatureServiceKey.GETCAPABILITIES.name()))
        {
            log.debug("Exiting createWfsRequest(Map).  Returning an IOgcWfsGetCapabilitiesRequest");
            return new OgcWfsGetCapabilitiesRequest(params);
        }
        if (requestParameter.equalsIgnoreCase(WebFeatureServiceKey.DESCRIBEFEATURETYPE.name()))
        {
            log.debug("Exiting createWfsRequest(Map).  Returning an IOgcWfsDescribeFeatureTypeRequest");
            return new OgcWfsDescribeFeatureTypeRequest(params);
        }
        if (requestParameter.equalsIgnoreCase(WebFeatureServiceKey.GETFEATURE.name()))
        {
            log.debug("Exiting createWfsRequest(Map).  Returning an IOgcWfsGetFeatureRequest");
            return new OgcWfsGetFeatureRequest(params);
        }
        
        
        String msg = "No IOgcWfsRequest object could be created from the REQUEST parameter '" + requestParameter + "'. "; 
        log.error(msg);
        log.debug("Exiting createWmsRequest(Map).");
        throw new IOException(msg);
    }

	private static Map<String, String> parseXML(Map<String, String> params)
	{
		String service = "";
        
		String xml = params.get(WebFeatureServiceKey.XML.name());
		
		if (xml != null && !xml.equals(""))
		{
			try
	        {
	        	ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes());
	        	
	        	log.debug("Building the XML DOM!");;
	        	
		        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		        Document doc = builder.parse(is);
		        
		        Node root = doc.getFirstChild();
	
		        NamedNodeMap attributes = root.getAttributes();
		        String request = root.getNodeName();
		        service = attributes.getNamedItem("service").getNodeValue();
		        String version = attributes.getNamedItem("version").getNodeValue();
		        String outputFormat = attributes.getNamedItem("outputFormat").getNodeValue();
		        String maxFeatures = attributes.getNamedItem("maxFeatures").getNodeValue();
		        String handle = attributes.getNamedItem("handle").getNodeValue();
		        
		        if (request.equals("GetFeature"))
		        	params.put(OgcRequestKey.REQUEST.name(), WebFeatureServiceKey.GETFEATURE.name());
		        params.put(OgcRequestKey.SERVICE.name(), service);
		        params.put(OgcRequestKey.VERSION.name(), version);
		        params.put(WebFeatureServiceKey.OUTPUTFORMAT.name(), outputFormat);
		        params.put(WebFeatureServiceKey.MAXFEATURES.name(), maxFeatures);
		        params.put(WebFeatureServiceKey.HANDLE.name(), handle);
		        
		        log.debug("request: " + request);
		        log.debug("service: " + service);
		        log.debug("version: " + version);
		        log.debug("outputFormat: " + outputFormat);
		        log.debug("maxFeatures: " + maxFeatures);
		        log.debug("handle: " + handle);
		    
		        Node query = root.getFirstChild();
		        
		        attributes = query.getAttributes();
		        
		        String typename = attributes.getNamedItem("typeName").getNodeValue();
		        params.put(WebFeatureServiceKey.TYPENAME.name(), typename);
		        log.debug("typeName: " + typename);
		        
	        }
	        catch(ParserConfigurationException pce)
	        {
	        	pce.printStackTrace();
	        }
	        catch(IOException ioe)
	        {
	        	ioe.printStackTrace();
	        }
	        catch(SAXException se)
	        {
	        	se.printStackTrace();
	        }
		}
	
        return params;
	}
}
