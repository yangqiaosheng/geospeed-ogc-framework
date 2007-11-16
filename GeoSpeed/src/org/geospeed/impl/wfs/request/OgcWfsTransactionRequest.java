package org.geospeed.impl.wfs.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.geospeed.api.wfs.IOgcWfsTransactionRequest;
import org.geospeed.keys.OgcRequestKey;
import org.geospeed.keys.WebFeatureServiceKey;

public class OgcWfsTransactionRequest implements IOgcWfsTransactionRequest
{
	private String request;
	private String service;
	private String version;
	private String operation;
	private List<String> typenames = new ArrayList<String>();
	private String releaseAction;
	private List<String> featureIds = new ArrayList<String>();
	private String filter;
	private String bbox;
	private Map<String, String> vendorParams = new HashMap<String, String>();
	
	private Logger log = Logger.getLogger(this.getClass());
	
	public OgcWfsTransactionRequest(Map<String, String> params)
	{
		log.debug("Entering OgcWfsTransactionRequest(Map).");
        
		service = params.remove(OgcRequestKey.SERVICE.name());
		version = params.remove(OgcRequestKey.VERSION.name());
		request = params.remove(OgcRequestKey.REQUEST.name());
		operation = params.remove(WebFeatureServiceKey.OPERATION);
		
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
		
		filter = params.remove(WebFeatureServiceKey.FILTER);
		releaseAction = params.remove(WebFeatureServiceKey.RELEASEACTION);
		bbox = params.remove(WebFeatureServiceKey.BBOX);		
        vendorParams = params;		
        
        log.debug("Exiting OgcWfsTransactionRequest(Map).");
	}
	
	public String getRequest()
	{
		return request;
	}

	public String getService()
	{
		return service;
	}

	public String getVersion()
	{
		return version;
	}

	public String getOperation()
	{
		return operation;
	}
	
	public List<String> getTypeName()
	{
		return typenames;
	}
	
	public String getReleaseAction()
	{
		return releaseAction;
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
