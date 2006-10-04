package org.geospeed.ogc.impl.wfs.request;

import java.util.List;
import java.util.Map;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.wfs.IOgcWfsDescribeFeatureTypeRequest;


public class OgcWfsDescribeFeatureTypeRequest implements IOgcWfsDescribeFeatureTypeRequest
{
    private List typenames;
    private String outputFormat;
    private String service;
    private String version;
    private String request = "";
    private Map vendorSpecificParams;

    public OgcWfsDescribeFeatureTypeRequest(IOgcMap params)
    {
        service = (String)params.getAndRemove("SERVICE");
        version = (String)params.getAndRemove("VERSION");
        request = (String)params.getAndRemove("REQUEST");
        outputFormat = (String)params.getAndRemove("OUTPUTFORMAT");
        
        String tmp = (String)params.getAndRemove("TYPENAME");
        
        if (tmp != null && !tmp.equals(""))
        {
            String[] tmpTypes = tmp.split(",");
            
            for (int i = 0; i < tmpTypes.length; i++)
                typenames.add(tmpTypes[i].trim());
        }
        
        vendorSpecificParams = params;
    }
    
    public List getTypenames()
    {
        return typenames;
    }

    public String getOutputFormat()
    {
        return outputFormat;
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
