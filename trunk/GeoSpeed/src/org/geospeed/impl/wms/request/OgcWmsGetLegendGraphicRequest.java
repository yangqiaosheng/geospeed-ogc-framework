package org.geospeed.impl.wms.request;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.geospeed.api.wms.IOgcWmsGetLegendGraphicRequest;
import org.geospeed.keys.OgcRequestKey;
import org.geospeed.keys.WebMappingServiceKey;

public class OgcWmsGetLegendGraphicRequest implements IOgcWmsGetLegendGraphicRequest
{
    private String service;
    private String version;
    private String request;
    private String layer;
    private String style;
    private String featureType;
    private String rule;
    private String scale;
    private String sld;
    private String sldBody;
    private String format;
    private String width;
    private String height;
    private String exceptions;
    private Map<String, String> vendorParams = new HashMap<String, String>();
    
    private Logger log = Logger.getLogger(this.getClass());
    
    public OgcWmsGetLegendGraphicRequest(Map<String, String> params)
    {
        log.debug("Entering OgcWmsGetLegendGraphicRequest(Map).");
        
        service = params.remove(OgcRequestKey.SERVICE.name());
        version = params.remove(OgcRequestKey.VERSION.name());
        request = params.remove(OgcRequestKey.REQUEST.name());
        layer = params.remove(WebMappingServiceKey.LAYER.name());
        style = params.remove(WebMappingServiceKey.STYLE.name());
        featureType = params.remove(WebMappingServiceKey.FEATURETYPE.name());
        rule = params.remove(WebMappingServiceKey.RULE.name());
        scale = params.remove(WebMappingServiceKey.SCALE.name());
        sld = params.remove(WebMappingServiceKey.SLD.name());
        sldBody = params.remove(WebMappingServiceKey.SLD_BODY.name());
        format = params.remove(WebMappingServiceKey.FORMAT.name());
        width = params.remove(WebMappingServiceKey.WIDTH.name());
        height = params.remove(WebMappingServiceKey.HEIGHT.name());
        exceptions = params.remove(WebMappingServiceKey.EXCEPTIONS.name());
        vendorParams = params;
        
        log.debug("Created an OgcWmsGetLegendGraphicRequest with parameter:value pairs - \n" +
                "\t" + OgcRequestKey.VERSION.name() + " : " + version + "\n" +
                "\t" + OgcRequestKey.REQUEST.name() + " : " + request + "\n" +
                "\t" + OgcRequestKey.SERVICE.name() + " : " + service + "\n" +
                "\t" + WebMappingServiceKey.LAYER.name() + " : " + layer + "\n" +
                "\t" + WebMappingServiceKey.STYLE.name() + " : " + style + "\n" +
                "\t" + WebMappingServiceKey.FEATURETYPE.name() + " : " + featureType + "\n" +
                "\t" + WebMappingServiceKey.RULE.name() + " : " + rule + "\n" +
                "\t" + WebMappingServiceKey.SCALE.name() + " : " + scale + "\n" +
                "\t" + WebMappingServiceKey.SLD.name() + " : " + sld + "\n" +
                "\t" + WebMappingServiceKey.SLD_BODY.name() + " : " + sldBody + "\n" +
                "\t" + WebMappingServiceKey.FORMAT.name() + " : " + format + "\n" +
                "\t" + WebMappingServiceKey.WIDTH.name() + " : " + width + "\n" +
                "\t" + WebMappingServiceKey.HEIGHT.name() + " : " + height + "\n" +
                "\t" + WebMappingServiceKey.EXCEPTIONS.name() + " : " + exceptions + "\n" +
                "\tand " + vendorParams.size() + " vendor specific parameters.");
        log.debug("Exiting OgcWmsGetLegendGraphicRequest(Map).");
    }
    
    public String getLayer()
    {
        return layer;
    }

    public String getStyle()
    {
        return style;
    }

    public String getFeatureType()
    {
        return featureType;
    }

    public String getRule()
    {
        return rule;
    }

    public double getScale()
    {
        if (scale == null || scale.equals(""))
            return 0.0;
        
        try
        {
            return Double.parseDouble(scale);
        }
        catch (NumberFormatException nfe)
        {
            return 0.0;
        }
    }

    public String getSld()
    {
        return (sld == null || sld.equals("")) ? sldBody : sld;
    }

    public String getFormat()
    {
        return format;
    }

    public int getWidth()
    {
        if (width == null || width.equals(""))
            return 0;
        
        try
        {
            return Integer.parseInt(width);
        }
        catch (NumberFormatException nfe)
        {
            return 0;
        }
    }

    public int getHeight()
    {
        if (height == null || height.equals(""))
            return 0;
        
        try
        {
            return Integer.parseInt(height);
        }
        catch (NumberFormatException nfe)
        {
            return 0;
        }
    }

    public String getExceptions()
    {
        return exceptions;
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
