package org.geospeed.impl.wms.request;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.geospeed.api.wms.IOgcWmsGetCapabilitiesRequest;
import org.geospeed.keys.OgcRequestKey;
import org.geospeed.keys.WebMappingServiceKey;


public class OgcWmsGetCapabilitiesRequest implements IOgcWmsGetCapabilitiesRequest 
{
	private String service;
	private String version;
	private String request;
    private String updateSequence;
    private Map<String, String> vendorSpecificParams = new HashMap<String, String>();
	
	public OgcWmsGetCapabilitiesRequest(Map<String, String> params)
	{
		service = params.remove(OgcRequestKey.SERVICE.name());
		version = params.remove(OgcRequestKey.VERSION.name());
		request = params.remove(OgcRequestKey.REQUEST.name());
        updateSequence = params.remove(WebMappingServiceKey.UPDATESEQUENCE.name());

        vendorSpecificParams = params;
	}
	
	public String getService() 
	{
		return service;
	}

	public String getVersion() 
	{
		return version;
	}

	public String getRequest() 
	{
		return request;
	}

	public String getUpdateSequence()
    {
	    return updateSequence;
    }

    public Map getVendorSpecificParams()
    {
        return vendorSpecificParams;
    }

    public String toString()
    {
        StringBuffer s = new StringBuffer("REQUEST: " + request);
        s.append("\nSERVICE: " + service);
        s.append("\nVERSION: " + version);
        s.append("\nUPDATESEQUENCE: " + updateSequence);
        
        for (Iterator i = vendorSpecificParams.keySet().iterator(); i.hasNext();)
        {
            String key = (String)i.next();
            s.append("\n" + key + ": " + vendorSpecificParams.get(key));
        }
        
        return s.toString();
    }
}
