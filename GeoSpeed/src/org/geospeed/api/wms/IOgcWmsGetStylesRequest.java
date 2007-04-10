package org.geospeed.api.wms;

import java.util.List;


public interface IOgcWmsGetStylesRequest extends IOgcWmsRequest
{
    public List<String> getLayers();
    
    public String getSldVer();
    
}
