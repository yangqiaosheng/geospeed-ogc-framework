package org.geospeed.ogc.impl.wms.xmlresponse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.geospeed.ogc.api.IOgcXmlResponse;

public class OgcWmsGetCapabilitiesLayer130 implements IOgcXmlResponse
{
    private List layers = new ArrayList();
    private String name = new String();
    private String title = new String();
    private String crs = new String();
    private String xml = new String();
    private String minX = "-180.0";
    private String maxX = "180.0";
    private String minY = "-90.0";
    private String maxY = "90.0";
    private String resX = "0.0";
    private String resY = "0.0";
    
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
    
    public String getLayerCrs()
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
    
    public String getMinX()
    {
        return minX;
    }
    
    public void setMinX(String _minX)
    {
        minX = _minX;
    }
    
    public String getMaxX()
    {
        return maxX;
    }
    
    public void setMaxX(String _maxX)
    {
        maxX = _maxX;
    }
    
    public String getMinY()
    {
        return minY;
    }
    
    public void setMinY(String _minY)
    {
        minY = _minY;
    }
    
    public String getMaxY()
    {
        return maxY;
    }
    
    public void setMaxY(String _maxY)
    {
        maxY = _maxY;
    }
    
    public void setBoundingBox(String _minX, String _maxX, String _minY, String _maxY)
    {
        minX = _minX;
        maxX = _maxX;
        minY = _minY;
        maxY = _maxY;
    }
    
    public String getResX()
    {
        return resX;
    }
    
    public void setResX(String _resX)
    {
        resX = _resX;
    }
    
    public String getResY()
    {
        return resY;
    }
    
    public void setResY(String _resY)
    {
        resY = _resY;
    }
    
    private String getExGeographicBoundingBox()
    {
        
        String bbox = "<EX_GeographicBoundingBox>" +
                "<westBoundLongitude>" + minX + "</westBoundLongitude>" +
                "<eastBoundLongitude>" + maxX + "</eastBoundLongitude>" +
                "<southBoundLatitude>" + minY + "</southBoundLatitude>" +
                "<northBoundLatitude>" + maxY + "</northBoundLatitude>" +
                "</EX_GeographicBoundingBox>";
        
        return bbox;                
    }
    
    private String getBoundingBox()
    {
        if (minX == "")
            return "";
        
        String bbox = "<BoundingBox CRS='EPSG:4326' minx='" + minX + "' miny='" + minY + "' maxx='" + maxX + "' maxy='" + maxY + "' resx='" + resX + "' resy='" + resY + "'/>";
        
        return bbox;
    }
    
    public String getXml()
    {
        xml = "";
        xml = "<Layer><Name>" + name + "</Name><Title>" + title + "</Title><CRS>" + crs + "</CRS>";
        
        for (Iterator i = layers.iterator(); i.hasNext();)
        {
            OgcWmsGetCapabilitiesLayer130 l = (OgcWmsGetCapabilitiesLayer130)i.next();
            xml = xml + l.getXml();
        }
        
        xml = xml + getExGeographicBoundingBox();
        xml = xml + getBoundingBox();
        
        xml = xml + "</Layer>";        
        
        return xml;
    }
}
