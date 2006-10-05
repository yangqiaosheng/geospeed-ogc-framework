package org.geospeed.ogc.impl.wfs.request;

import java.util.List;
import java.util.Map;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.wfs.IOgcWfsTransactionRequest;


public class OgcWfsTransactionRequest implements IOgcWfsTransactionRequest
{
    private String operation;
    private List typenames;
    private String releaseAction;
    private List featureIds;
    private List filters;
    private String maxX;
    private String maxY;
    private String minX;
    private String minY;
    private String service;
    private String version;
    private String request = "";
    private Map vendorSpecificParams;
    
    
    public OgcWfsTransactionRequest(IOgcMap params)
    {
        operation = (String)params.getAndRemove("OPERATION");
        
        String tmp = (String)params.getAndRemove("TYPENAME");
        
        if (tmp != null && !tmp.equals(""))
        {
            String[] tmpTypes = tmp.split(",");
            
            for (int i = 0; i < tmpTypes.length; i++)
                typenames.add(tmpTypes[i].trim());
        }
        
        releaseAction = (String)params.getAndRemove("RELEASEACTION");
        
        tmp = (String)params.getAndRemove("FEATUREID");
        
        if (tmp != null && !tmp.equals(""))
        {
            String[] tmpIds = tmp.split(",");
            
            for (int i = 0; i < tmpIds.length; i++)
                featureIds.add(tmpIds[i].trim());
        }
        
        tmp = (String)params.getAndRemove("FILTER");
        
        if (tmp != null && !tmp.equals(""))
        {
            String[] tmpFilters = tmp.split(",");
            
            for (int i = 0; i < tmpFilters.length; i++)
                filters.add(tmpFilters[i].trim());
        }
        
        if (params.get("BBOX") != null)
        {
            String[] tmpBbox = ((String)params.getAndRemove("BBOX")).split(",");
            
            if (tmpBbox.length == 4)
            {
                minX = tmpBbox[0];
                minY = tmpBbox[1];
                maxX = tmpBbox[2];
                maxY = tmpBbox[3];
            }
        }
        
        service = (String)params.getAndRemove("SERVICE");
        version = (String)params.getAndRemove("VERSION");
        request = (String)params.getAndRemove("REQUEST");
        
        vendorSpecificParams = params;
    }
    
    public String getOperation()
    {
        return operation;
    }

    public List getTypenames()
    {
        return typenames;
    }

    public String getReleaseAction()
    {
        return releaseAction;
    }

    public List getFeatureIds()
    {
        return featureIds;
    }

    public List getFilters()
    {
        return filters;
    }

    public double getMaxX()
    {
        return Double.parseDouble(maxX);
    }

    public double getMaxY()
    {
        return Double.parseDouble(maxY);
    }

    public double getMinX()
    {
        return Double.parseDouble(minX);
    }

    public double getMinY()
    {
        return Double.parseDouble(minY);
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