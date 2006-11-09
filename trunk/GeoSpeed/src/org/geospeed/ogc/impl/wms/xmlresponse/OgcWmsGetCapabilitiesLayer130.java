package org.geospeed.ogc.impl.wms.xmlresponse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.geospeed.ogc.api.IOgcXmlResponse;
import org.jdom.Element;

public class OgcWmsGetCapabilitiesLayer130 implements IOgcXmlResponse
{
    private List layers = new ArrayList();
    private String name = "";
    private String title = "";
    private String abstractText = "";
    private List keywords = new ArrayList();
    private String crs = "";
    private StringBuffer xml = new StringBuffer();
    private String minX = "-180.0";
    private String maxX = "180.0";
    private String minY = "-90.0";
    private String maxY = "90.0";
    private String resX = "0.0";
    private String resY = "0.0";
    private String attribution = "";
    private String authorityUrl = "";
    private String identifier = "";
    private String metadataUrl = "";
    private String dataUrl = "";
    private String featureListUrl = "";
    private String style = "";
    private String minScaleDenominator = "";
    private String maxScaleDenominator = "";
    private String queryable = "0";
    private String cascaded = "0";
    private String opaque = "0";
    private String noSubsets = "0";
    private String fixedWidth = "";
    private String fixedHeight = "";
    
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
        if (minX.equals(""))
            return "";
        
        String bbox = "<BoundingBox CRS='EPSG:4326' minx='" + minX + "' miny='" + minY + "' maxx='" + maxX + "' maxy='" + maxY + "' resx='" + resX + "' resy='" + resY + "'/>";
        
        return bbox;
    }
    
    public String getAbstractText()
    {
        return abstractText;
    }

    public void setAbstractText(String _abstractText)
    {
        abstractText = _abstractText;
    }

    public String getAttribution()
    {
        return attribution;
    }

    public void setAttribution(String _attribution)
    {
        attribution = _attribution;
    }

    public String getAuthorityUrl()
    {
        return authorityUrl;
    }

    public void setAuthorityUrl(String _authorityUrl)
    {
        authorityUrl = _authorityUrl;
    }

    public boolean getCascaded()
    {
        if (cascaded.equals("0"))
            return false;
        else
            return true;
    }

    public void setCascaded(boolean _cascaded)
    {
        if (_cascaded)
            cascaded = "1";
        else
            cascaded = "0";
        
    }

    public String getDataUrl()
    {
        return dataUrl;
    }

    public void setDataUrl(String _dataUrl)
    {
        dataUrl = _dataUrl;
    }

    public String getFeatureListUrl()
    {
        return featureListUrl;
    }

    public void setFeatureListUrl(String _featureListUrl)
    {
        featureListUrl = _featureListUrl;
    }

    public String getFixedHeight()
    {
        return fixedHeight;
    }

    public void setFixedHeight(String _fixedHeight)
    {
        fixedHeight = _fixedHeight;
    }

    public String getFixedWidth()
    {
        return fixedWidth;
    }

    public void setFixedWidth(String _fixedWidth)
    {
        fixedWidth = _fixedWidth;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public void setIdentifier(String _identifier)
    {
        identifier = _identifier;
    }

    public List getKeywords()
    {
        return keywords;
    }

    public void setKeywords(List _keywords)
    {
        keywords = _keywords;
    }

    public String getMaxScaleDenominator()
    {
        return maxScaleDenominator;
    }

    public void setMaxScaleDenominator(String _maxScaleDenominator)
    {
        maxScaleDenominator = _maxScaleDenominator;
    }

    public String getMetadataUrl()
    {
        return metadataUrl;
    }

    public void setMetadataUrl(String _metadataUrl)
    {
        metadataUrl = _metadataUrl;
    }

    public String getMinScaleDenominator()
    {
        return minScaleDenominator;
    }

    public void setMinScaleDenominator(String _minScaleDenominator)
    {
        minScaleDenominator = _minScaleDenominator;
    }

    public boolean getNoSubsets()
    {
        if (noSubsets.equals("0"))
            return false;
        else
            return true;
    }

    public void setNoSubsets(boolean _noSubsets)
    {
        if (_noSubsets)
            noSubsets = "1";
        else
            noSubsets = "0";
    }

    public boolean getOpaque()
    {
        if (opaque.equals("0"))
            return false;
        else
            return true;
    }

    public void setOpaque(boolean _opaque)
    {
        if (_opaque)
            opaque = "1";
        else
            opaque = "0";
    }

    public boolean getQueryable()
    {
        if (queryable.equals("0"))
            return false;
        else
            return true;
    }

    public void setQueryable(boolean _queryable)
    {
        if (_queryable)
            queryable = "1";
        else
            queryable = "0";
    }

    public String getStyle()
    {
        return style;
    }

    public void setStyle(String _style)
    {
        style = _style;
    }

    public String getXml()
    {
        xml = new StringBuffer();
        xml.append("<Layer><Name>" + name + "</Name><Title>" + title + "</Title><CRS>" + crs + "</CRS>");
        
        for (Iterator i = layers.iterator(); i.hasNext();)
        {
            OgcWmsGetCapabilitiesLayer130 l = (OgcWmsGetCapabilitiesLayer130)i.next();
            xml.append(xml + l.getXml());
        }
        
        xml.append(xml + getExGeographicBoundingBox());
        xml.append(xml + getBoundingBox());
        
        xml.append(xml + "</Layer>");        
        
        return xml.toString();
    }

    public Element getTag()
    {
        Element layer = new Element("Layer");
        layer.setAttribute("queryable", queryable);
        
        if (!cascaded.equals(""))
            layer.setAttribute("cascaded", cascaded);
        
        layer.setAttribute("opaque", opaque);
        layer.setAttribute("noSubsets", noSubsets);
        
        if (!fixedWidth.equals(""))
            layer.setAttribute("fixedWidth", fixedWidth);
        
        if (!fixedHeight.equals(""))
            layer.setAttribute("fixedHeight", fixedHeight);
        
        Element nameTag = new Element("Name");
        nameTag.setText(name);
        Element titleTag = new Element("Title");
        titleTag.setText(title);
        Element abstractTag = new Element("Abstract");
        abstractTag.setText(abstractText);
        Element keywordsTag = new Element("KeywordList");
        String kwds = "";
        for (Iterator i = keywords.iterator(); i.hasNext();)
            kwds += (String)i.next() + ",";
        keywordsTag.setText(kwds);
        Element crsTag = new Element("CRS");
        crsTag.setText(crs);
        
        Element geoBBox = new Element("EX_GeographicBoundingBox");
        Element westBoundLon = new Element("westBoundLongitude");
        westBoundLon.setText(minX);
        Element eastBoundLon = new Element("eastBoundLongitude");
        eastBoundLon.setText(maxX);
        Element southBoundLat = new Element("southBoundLatitude");
        southBoundLat.setText(minY);
        Element northBoundLat = new Element("northBoundLatitude");
        northBoundLat.setText(maxY);
        geoBBox.addContent(westBoundLon);
        geoBBox.addContent(eastBoundLon);
        geoBBox.addContent(southBoundLat);
        geoBBox.addContent(northBoundLat);
        
        Element bbox = new Element("BoundingBox");
        bbox.setAttribute("CRS", crs);
        bbox.setAttribute("minx", minX);
        bbox.setAttribute("miny", minY);
        bbox.setAttribute("maxx", maxX);
        bbox.setAttribute("maxy", maxY);
        bbox.setAttribute("resx", resX);
        bbox.setAttribute("resy", resY);
        
        layer.addContent(nameTag);
        layer.addContent(titleTag);
        layer.addContent(abstractTag);
        layer.addContent(keywordsTag);
        layer.addContent(crsTag);
        layer.addContent(geoBBox);
        layer.addContent(bbox);
        
        List layerTagList = new ArrayList();
        
        for (Iterator i = layers.iterator(); i.hasNext();)
        {
            OgcWmsGetCapabilitiesLayer130 l = (OgcWmsGetCapabilitiesLayer130)i.next();
            Element innerLayer = l.getTag();
            layerTagList.add(innerLayer);
        }
        layer.addContent(layerTagList);
        
        return layer;
    }
}
