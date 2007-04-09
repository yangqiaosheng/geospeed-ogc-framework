package org.geospeed.api.wms;

public interface IOgcWmsPutStylesRequest extends IOgcWmsRequest
{
    public String getMode();
    
    public String getSld();
    
}
