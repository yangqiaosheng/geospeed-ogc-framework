package org.geospeed.ogc.impl.wms.request;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.wms.IOgcWmsGetCapabilitiesRequest;


public class OgcWmsGetCapabilitiesRequest implements IOgcWmsGetCapabilitiesRequest 
{
	private String service;
	private String version;
	private String request;
    private String updateSequence;
    private Map vendorSpecificParams = new HashMap();
	
	public OgcWmsGetCapabilitiesRequest(IOgcMap params)
	{
		service = (String)params.getAndRemove("SERVICE");
		version = (String)params.getAndRemove("VERSION");
		request = (String)params.getAndRemove("REQUEST");
        updateSequence = (String)params.getAndRemove("UPDATESEQUENCE");

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
