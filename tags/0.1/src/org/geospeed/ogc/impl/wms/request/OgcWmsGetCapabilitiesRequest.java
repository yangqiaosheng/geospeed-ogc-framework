package org.geospeed.ogc.impl.wms.request;

import java.util.Map;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.wms.IOgcWmsGetCapabilitiesRequest;


public class OgcWmsGetCapabilitiesRequest implements IOgcWmsGetCapabilitiesRequest 
{
	private String service;
	private String version;
	private String request;
    private String updateSequence;
    private Map vendorSpecificParams;
	
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
}
