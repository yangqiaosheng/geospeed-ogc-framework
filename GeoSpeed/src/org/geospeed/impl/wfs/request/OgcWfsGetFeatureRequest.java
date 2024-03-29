package org.geospeed.impl.wfs.request;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.geospeed.api.wfs.IOgcWfsGetFeatureRequest;
import org.geospeed.keys.OgcRequestKey;
import org.geospeed.keys.WebFeatureServiceKey;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class OgcWfsGetFeatureRequest implements IOgcWfsGetFeatureRequest
{
	private String request;
	private String version;
	private String service;
	private String propertyName;
	private String featureVersion;
	private int maxFeatures;
	private List<String> typenames = new ArrayList<String>();
	private List<String> featureIds = new ArrayList<String>();
	private String filter;
	private String bbox;
	private String outputFormat;
	private String handle;
	private Map<String, String> vendorParams = new HashMap<String, String>();
	
	private Logger log = Logger.getLogger(this.getClass());
	
	public OgcWfsGetFeatureRequest(Map<String, String> params)
	{
		log.debug("Entering OgcWfsGetFeatureRequest(Map).");
        
		service = params.remove(OgcRequestKey.SERVICE.name());
		version = params.remove(OgcRequestKey.VERSION.name());
		request = params.remove(OgcRequestKey.REQUEST.name());
		propertyName = params.remove(WebFeatureServiceKey.PROPERTYNAME.name());
		featureVersion = params.remove(WebFeatureServiceKey.FEATUREVERSION.name());
		
		String mf = params.remove(WebFeatureServiceKey.MAXFEATURES.name());
		
		try
		{
			maxFeatures = Integer.parseInt(mf);
		}
		catch (NumberFormatException nfe)
		{
			nfe.printStackTrace();
			maxFeatures = 0;
		}
		
		String t = params.remove(WebFeatureServiceKey.TYPENAME.name());
		String[] tmp;
		
		if (t != null && !t.equals(""))
			tmp = t.split(",");
		else
			tmp = new String[] {};
		
		for (int i = 0; i < tmp.length; i++)
			typenames.add(tmp[i]);
		
		String f = params.remove(WebFeatureServiceKey.FEATUREID.name());
		
		if (f != null && !f.equals(""))
			tmp = t.split(",");
		else
			tmp = new String[] {};
		
		for (int i = 0; i < tmp.length; i++)
			featureIds.add(tmp[i]);
		
		filter = params.remove(WebFeatureServiceKey.FILTER.name());
		bbox = params.remove(WebFeatureServiceKey.BBOX.name());	
		outputFormat = params.remove(WebFeatureServiceKey.OUTPUTFORMAT.name());
        vendorParams = params;
        
        log.debug("Exiting OgcWfsGetFeatureRequest(Map).");
	}

	
	public String getRequest()
	{
		return request;
	}
	
	public String getVersion()
	{
		return version;
	}
	
	public String getService()
	{
		return service;
	}

	public String getPropertyName()
	{
		return propertyName;
	}
	
	public String getFeatureVersion()
	{
		return featureVersion;
	}
	
	public int getMaxFeatures()
	{
		return maxFeatures;
	}
	
	public List<String> getTypeName()
	{
		return typenames;
	}
	
	public List<String> getFeatureId()
	{
		return featureIds;
	}
	
	public String getFilter()
	{
		return filter;
	}
	
	public String getBBox()
	{
		return bbox;
	}
	
	public Map<String, String> getVendorSpecificParams()
	{
		return vendorParams;
	}
}
