package org.geospeed.ogc.api.wfs;

import java.util.List;

public interface IOgcWfsLockFeatureRequest extends IOgcWfsRequest
{
    public List getTypenames();
    
    public String getExpiry();
    
    public String getLockAction();
    
    public List getFeatureIds();
    
    public List getFilters();
    
    public double getMaxX();
    
    public double getMaxY();
    
    public double getMinX();
    
    public double getMinY();
}
