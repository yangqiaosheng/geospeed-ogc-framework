package org.geospeed.impl.wms.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
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
    
    private Logger log = Logger.getLogger(this.getClass());
    
    public OgcWmsGetStylesRequest(Map<String, String> params)
    {
        log.debug("Entering OgcWmsGetStylesRequest(Map).");
        
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
        
        log.debug("Created an OgcWmsGetStylesRequest with parameter:value pairs - \n" +
                "\t" + OgcRequestKey.VERSION.name() + " : " + version + "\n" +
                "\t" + OgcRequestKey.REQUEST.name() + " : " + request + "\n" +
                "\t" + OgcRequestKey.SERVICE.name() + " : " + service + "\n" +
                "\t" + WebMappingServiceKey.SLDVER.name() + " : " + sldVersion + "\n" +
                "\t" + WebMappingServiceKey.LAYERS.name() + " : " + tmp + "\n" +
                "\tand " + vendorParams.size() + " vendor specific parameters.");
        log.debug("Exiting OgcWmsGetStylesRequest(Map).");
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
