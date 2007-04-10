package org.geospeed.api.wms;


public interface IOgcWmsGetLegendGraphicRequest extends IOgcWmsRequest
{
    public String getLayer();
    
    public String getStyle();
    
    public String getFeatureType();
    
    public String getRule();
    
    public double getScale();
    
    public String getSld();
    
    public String getFormat();
    
    public int getWidth();
    
    public int getHeight();
    
    public String getExceptions();
}
