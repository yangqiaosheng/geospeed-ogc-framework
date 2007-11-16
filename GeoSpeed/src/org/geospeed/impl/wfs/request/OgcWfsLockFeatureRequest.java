package org.geospeed.impl.wfs.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.geospeed.api.wfs.IOgcWfsLockFeatureRequest;
import org.geospeed.keys.OgcRequestKey;
import org.geospeed.keys.WebFeatureServiceKey;

public class OgcWfsLockFeatureRequest implements IOgcWfsLockFeatureRequest
{
	private String service;
	private String request;
	private String version;
	private List<String> typenames = new ArrayList<String>();
	private int expiry;
	private String lockAction;
	private List<String> featureIds = new ArrayList<String>();
	private String filter;
	private String bbox;
	private Map<String, String> vendorParams = new HashMap<String, String>();
	
	private Logger log = Logger.getLogger(this.getClass());
	
	public OgcWfsLockFeatureRequest(Map<String, String> params)
	{
		log.debug("Entering OgcWfsLockFeatureRequest(Map).");
        
		service = params.remove(OgcRequestKey.SERVICE.name());
		version = params.remove(OgcRequestKey.VERSION.name());
		request = params.remove(OgcRequestKey.REQUEST.name());
		
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
		
		String ex = params.remove(WebFeatureServiceKey.EXPIRY);
		
		try
		{
			expiry = Integer.parseInt(ex);
		}
		catch (NumberFormatException nfe)
		{
			nfe.printStackTrace();
			expiry = 0;
		}
		filter = params.remove(WebFeatureServiceKey.FILTER);
		lockAction = params.remove(WebFeatureServiceKey.LOCKACTION);
		bbox = params.remove(WebFeatureServiceKey.BBOX);		
        vendorParams = params;		
        
        log.debug("Exiting OgcWfsLockFeatureRequest(Map).");
	}
	
	public String getService()
	{
		return service;
	}
	
	public String getRequest()
	{
		return request;
	}
	
	public String getVersion()
	{
		return version;
	}
	
	public List<String> getTypeName()
	{
		return typenames;
	}

	public int getExpiry()
	{
		return expiry;
	}
	
	public String getLockAction()
	{
		return lockAction;
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
