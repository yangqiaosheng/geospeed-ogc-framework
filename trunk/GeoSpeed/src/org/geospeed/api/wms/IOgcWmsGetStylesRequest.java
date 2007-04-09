package org.geospeed.api.wms;

import java.util.List;


public interface IOgcWmsGetStylesRequest extends IOgcWmsRequest
{
    public List getLayers();
    
    public String getSldVer();
    
}
