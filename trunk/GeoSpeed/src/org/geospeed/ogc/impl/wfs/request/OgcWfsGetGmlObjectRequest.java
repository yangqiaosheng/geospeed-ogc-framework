package org.geospeed.ogc.impl.wfs.request;

import java.util.HashMap;
import java.util.Map;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.wfs.IOgcWfsGetGmlObjectRequest;


public class OgcWfsGetGmlObjectRequest implements IOgcWfsGetGmlObjectRequest
{
    private String traverseDepth;
    private String traverseExpiry;
    private String gmlId;
    private String service;
    private String version;
    private String request = "";
    private Map vendorSpecificParams = new HashMap();
    
    public OgcWfsGetGmlObjectRequest(IOgcMap params)
    {
        traverseDepth = (String)params.getAndRemove("TRAVERSEXLINKDEPTH");
        traverseExpiry = (String)params.getAndRemove("TRAVERSEXLINKEXPIRY");
        gmlId = (String)params.getAndRemove("GMLOBJECTID");
        service = (String)params.getAndRemove("SERVICE");
        version = (String)params.getAndRemove("VERSION");
        request = (String)params.getAndRemove("REQUEST");
        
        vendorSpecificParams = params;
    }
    
    public String getTraverseXlinkDepth()
    {
        return traverseDepth;
    }

    public String getTraverseXlinkExpiry()
    {
        return traverseExpiry;
    }

    public String getGmlObjectId()
    {
        return gmlId;
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
