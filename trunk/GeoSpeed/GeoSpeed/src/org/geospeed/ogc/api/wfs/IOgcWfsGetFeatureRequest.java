package org.geospeed.ogc.api.wfs;

import java.util.List;

public interface IOgcWfsGetFeatureRequest extends IOgcWfsRequest
{
    public String getOutputFormat();
    
    public String getResultType();
    
    public String getPropertyName();
    
    public String getFeatureVersion();
    
    public long getMaxFeatures();
    
    public String getExpiry();
    
    public String getSrsName();
    
    public List getTypenames();
    
    public List getFeatureIds();
    
    public List getFilters();
    
    public double getMaxX();
    
    public double getMaxY();
    
    public double getMinX();
    
    public double getMinY();
    
    public String getSortBy();
}
