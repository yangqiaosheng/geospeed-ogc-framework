package org.geospeed.ogc.api.wcs;

import java.util.List;

public interface IOgcWcsGetCoverageRequest extends IOgcWcsRequest
{
    public String getCoverage();
    
    public String getCrs();
    
    public String getResponseCrs();
    
    public double getMaxX();
    
    public double getMaxY();
    
    public double getMinX();
    
    public double getMinY();
    
    public List getTime();
    
    public List getParameters();
    
    public int getWidth();
    
    public int getHeight();
    
    public int getDepth();
    
    public double getResX();
    
    public double getResY();
    
    public double getResZ();
    
    public String getInterpolation();
    
    public String getFormat();
    
    public String getExceptions();
    
}
