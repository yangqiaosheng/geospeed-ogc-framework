package org.geospeed.ogc.impl.wcs.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.wcs.IOgcWcsDescribeCoverageRequest;


public class OgcWcsDescribeCoverageRequest implements IOgcWcsDescribeCoverageRequest
{
    private List coverages = new ArrayList();
    private String service;
    private String version;
    private String request;
    private Map vendorSpecificParams = new HashMap();

    public OgcWcsDescribeCoverageRequest(IOgcMap params)
    {
        service = (String)params.getAndRemove("SERVICE");
        version = (String)params.getAndRemove("VERSION");
        request = (String)params.getAndRemove("REQUEST");
        
        String tmp = (String)params.getAndRemove("COVERAGE");
        
        if (tmp != null && !tmp.equals(""))
        {
            String[] tmpCoverages = tmp.split(",");
            
            for (int i = 0; i < tmpCoverages.length; i++)
                coverages.add(tmpCoverages[i].trim());
        }
        
        vendorSpecificParams = params;
    }
    
    public List getCoverages()
    {
        return coverages;
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
