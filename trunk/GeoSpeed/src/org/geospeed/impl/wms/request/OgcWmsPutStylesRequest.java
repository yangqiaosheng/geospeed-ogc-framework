package org.geospeed.impl.wms.request;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.geospeed.api.wms.IOgcWmsPutStylesRequest;
import org.geospeed.keys.OgcRequestKey;
import org.geospeed.keys.WebMappingServiceKey;

public class OgcWmsPutStylesRequest implements IOgcWmsPutStylesRequest
{
    private String version;
    private String request;
    private String service;
    private String mode;
    private String sld;
    private String sldBody;
    private Map<String, String> vendorParams = new HashMap<String, String>();
    
    private Logger log = Logger.getLogger(this.getClass());
    
    public OgcWmsPutStylesRequest(Map<String, String> params)
    {
        log.debug("Entering OgcWmsPutStylesRequest(Map).");
        
        version = params.remove(OgcRequestKey.VERSION.name());
        request = params.remove(OgcRequestKey.REQUEST.name());
        service = params.remove(OgcRequestKey.SERVICE.name());
        mode = params.remove(WebMappingServiceKey.MODE.name());
        sld = params.remove(WebMappingServiceKey.SLD.name());
        sldBody = params.remove(WebMappingServiceKey.SLD_BODY.name());
        vendorParams = params;
        
        log.debug("Created an OgcWmsPutStylesRequest with parameter:value pairs - \n" +
                "\t" + OgcRequestKey.VERSION.name() + " : " + version + "\n" +
                "\t" + OgcRequestKey.REQUEST.name() + " : " + request + "\n" +
                "\t" + OgcRequestKey.SERVICE.name() + " : " + service + "\n" +
                "\t" + WebMappingServiceKey.MODE.name() + " : " + mode + "\n" +
                "\t" + WebMappingServiceKey.SLD.name() + " : " + sld + "\n" +
                "\t" + WebMappingServiceKey.SLD_BODY.name() + " : " + sldBody + "\n" +
                "\tand " + vendorParams.size() + " vendor specific parameters.");
        log.debug("Exiting OgcWmsPutCapabilitiesRequest(Map).");
    }
    
    public String getMode()
    {
        return mode;
    }

    public String getSld()
    {
        return (sld == null || sld.equals("")) ? sldBody : sld;
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
