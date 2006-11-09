package org.geospeed.ogc.impl.wfs.request;

import java.util.HashMap;
import java.util.Map;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.wfs.IOgcWfsGetCapabilitiesRequest;


public class OgcWfsGetCapabilitiesRequest implements IOgcWfsGetCapabilitiesRequest
{
    private String service;
    private String version;
    private String request = "";
    private Map vendorSpecificParams = new HashMap();
    
    public OgcWfsGetCapabilitiesRequest(IOgcMap params)
    {
        service = (String)params.getAndRemove("SERVICE");
        version = (String)params.getAndRemove("VERSION");
        request = (String)params.getAndRemove("REQUEST");
    
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

    public Map getVendorSpecificParams()
    {
        return vendorSpecificParams;
    }
}
