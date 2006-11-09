package org.geospeed.ogc.impl.wfs.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.wfs.IOgcWfsGetFeatureRequest;


public class OgcWfsGetFeatureRequest implements IOgcWfsGetFeatureRequest
{
    private String service;
    private String version;
    private String request = "";
    private String outputFormat;
    private String resultType;
    private String propertyName;
    private String featureVersion;
    private String maxFeatures;
    private String expiry;
    private String srsName;
    private List typenames = new ArrayList();
    private List featureIds = new ArrayList();
    private List filters = new ArrayList();
    private String maxX = "0";
    private String maxY = "0";
    private String minX = "0";
    private String minY = "0";
    private String sortBy;
    private Map vendorSpecificParams = new HashMap();
    
    public OgcWfsGetFeatureRequest(IOgcMap params)
    {
        service = (String)params.getAndRemove("SERVICE");
        version = (String)params.getAndRemove("VERSION");
        request = (String)params.getAndRemove("REQUEST");
        outputFormat = (String)params.getAndRemove("OUTPUTFORMAT");
        resultType = (String)params.getAndRemove("RESULTTYPE");
        propertyName = (String)params.getAndRemove("PROPERTYNAME");
        featureVersion = (String)params.getAndRemove("FEATUREVERSION");
        maxFeatures = (String)params.getAndRemove("MAXFEATURES");
        expiry = (String)params.getAndRemove("EXPIRY");
        srsName = (String)params.getAndRemove("SRSNAME");
        
        String tmp = (String)params.getAndRemove("TYPENAME");
        
        if (tmp != null && !tmp.equals(""))
        {
            String[] tmpTypes = tmp.split(",");
            
            for (int i = 0; i < tmpTypes.length; i++)
                typenames.add(tmpTypes[i].trim());
        }
        
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
        
        sortBy = (String)params.getAndRemove("SORTBY");
        
        vendorSpecificParams = params;
    }
    
    public String getOutputFormat()
    {
        return outputFormat;
    }

    public String getResultType()
    {
        return resultType;
    }

    public String getPropertyName()
    {
        return propertyName;
    }

    public String getFeatureVersion()
    {
        return featureVersion;
    }

    public long getMaxFeatures()
    {
        return Long.parseLong(maxFeatures);
    }

    public String getExpiry()
    {
        return expiry;
    }

    public String getSrsName()
    {
        return srsName;
    }

    public List getTypenames()
    {
        return typenames;
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

    public String getSortBy()
    {
        return sortBy;
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
