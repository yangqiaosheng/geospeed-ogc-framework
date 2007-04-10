package org.geospeed.impl.wms.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.geospeed.api.wms.IOgcWmsGetStylesRequest;
import org.geospeed.keys.OgcRequestKey;
import org.geospeed.keys.WebMappingServiceKey;

public class OgcWmsGetStylesRequest implements IOgcWmsGetStylesRequest
{
    private List<String> layers = new ArrayList<String>();
    private String sldVersion;
    private String version;
    private String service;
    private String request;
    private Map<String, String> vendorParams = new HashMap<String, String>();
    
    public OgcWmsGetStylesRequest(Map<String, String> params)
    {
        version = params.remove(OgcRequestKey.VERSION.name());
        service = params.remove(OgcRequestKey.SERVICE.name());
        request = params.remove(OgcRequestKey.REQUEST.name());
        sldVersion = params.remove(WebMappingServiceKey.SLDVER.name());
        
        String tmp = params.remove(WebMappingServiceKey.LAYERS.name());
        
        if (tmp != null && !tmp.equals(""))
        {
            String[] tmpLayers = tmp.split(",");
            
            for (int i = 0; i < tmpLayers.length; i++)
                layers.add(tmpLayers[i].trim());
        }        
        
        vendorParams = params;
    }
    
    public List<String> getLayers()
    {
        return layers;
    }

    public String getSldVer()
    {
        return sldVersion;
    }

    public String getVersion()
    {
        return version;
    }

    public String getRequest()
    {
        return request;
    }

    public String getService()
    {
        return service;
    }

    public Map<String, String> getVendorSpecificParams()
    {
        return vendorParams;
    }

}
