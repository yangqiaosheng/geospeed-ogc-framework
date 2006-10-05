package org.geospeed.ogc.api.wfs;

import java.util.List;

public interface IOgcWfsTransactionRequest extends IOgcWfsRequest
{
    public String getOperation();
    
    public List getTypenames();
    
    public String getReleaseAction();
    
    public List getFeatureIds();
    
    public List getFilters();
    
    public double getMaxX();
    
    public double getMaxY();
    
    public double getMinX();
    
    public double getMinY();
}
