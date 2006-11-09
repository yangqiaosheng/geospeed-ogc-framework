package org.geospeed.ogc.impl.wcs.request;

import java.util.HashMap;
import java.util.Map;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.wcs.IOgcWcsGetCapabilitiesRequest;


public class OgcWcsGetCapabilitiesRequest implements IOgcWcsGetCapabilitiesRequest
{
    private String service;
    private String version;
    private String request;
    private String section;
    private String updateSequence;
    private Map vendorSpecificParams = new HashMap();
    
    public OgcWcsGetCapabilitiesRequest(IOgcMap params)
    {
        service = (String)params.getAndRemove("SERVICE");
        version = (String)params.getAndRemove("VERSION");
        request = (String)params.getAndRemove("REQUEST");
        section = (String)params.getAndRemove("SECTION");
        updateSequence = (String)params.getAndRemove("UPDATESEQUENCE");
        vendorSpecificParams = params;        
    }
    
    public String getSection()
    {
        return section;
    }

    public String getUpdateSequence()
    {
        return updateSequence;
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
