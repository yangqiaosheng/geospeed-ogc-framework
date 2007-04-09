package org.geospeed.api.wms;

import org.geospeed.api.IOgcRequest;

public interface IOgcWmsGetLegendGraphicRequest extends IOgcWmsRequest
{
    public String getLayer();
    
    public String getStyle();
    
    public String getFeatureType();
    
    public String getRule();
    
    public String getScale();
    
    public String getSld();
    
    public String getFormat();
    
    public int getWidth();
    
    public int getHeight();
    
    public String getExceptions();
}
