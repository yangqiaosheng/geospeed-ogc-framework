package org.geospeed.ogc.impl.wfs.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.wfs.IOgcWfsLockFeatureRequest;


public class OgcWfsLockFeatureRequest implements IOgcWfsLockFeatureRequest
{
    private List typenames = new ArrayList();
    private String expiry;
    private String lockAction;
    private List featureIds = new ArrayList();
    private List filters = new ArrayList();
    private String maxX;
    private String maxY;
    private String minX;
    private String minY;
    private String service;
    private String version;
    private String request = "";
    private Map vendorSpecificParams = new HashMap();
    
    public OgcWfsLockFeatureRequest(IOgcMap params)
    {
        String tmp = (String)params.getAndRemove("TYPENAME");
        
        if (tmp != null && !tmp.equals(""))
        {
            String[] tmpTypes = tmp.split(",");
            
            for (int i = 0; i < tmpTypes.length; i++)
                typenames.add(tmpTypes[i].trim());
        }
        
        expiry = (String)params.getAndRemove("EXPIRY");
        lockAction = (String)params.getAndRemove("LOCKACTION");
        
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
    
    public List getTypenames()
    {
        return typenames;
    }

    public String getExpiry()
    {
        return expiry;
    }
 
    public String getLockAction()
    {
        return lockAction;
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
