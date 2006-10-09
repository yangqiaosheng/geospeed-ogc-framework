package org.geospeed.ogc.impl.wms.xmlresponse;

import java.util.List;

import org.geospeed.ogc.api.IOgcXmlResponse;

public class OgcWmsGetCapabilitiesLayer130 implements IOgcXmlResponse
{
    private List layers = null;
    private String name = null;
    private String title = null;
    private String crs = null;
    private String xml = null;
    
    public OgcWmsGetCapabilitiesLayer130()
    {
        
    }
    
    public OgcWmsGetCapabilitiesLayer130(String layerName, String layerTitle, String layerCrs, List layerList)
    {
        name = layerName;
        title = layerTitle;
        crs = layerCrs;
        layers = layerList;
    }
    
    public String getLayerName()
    {
        return name;
    }
    
    public void setLayerName(String layerName)
    {
        name = layerName;
    }
    
    public String getLayerTitle()
    {
        return title;
    }
    
    public void setLayerTitle(String layerTitle)
    {
        title = layerTitle;
    }
    
    public String getCrs()
    {
        return crs;
    }
    
    public void setLayerCrs(String layerCrs)
    {
        crs = layerCrs;
    }
    
    public List getLayerList()
    {
        return layers;
    }
    
    public void setLayerList(List layerList)
    {
        layers = layerList;
    }
    
    public String getXml()
    {
        String xml = "<Layer><Name>" + name + "</Name><Title>" + title + "</Title><CRS>" + crs + "</CRS></Layer>";
        
        return xml;
    }
}
