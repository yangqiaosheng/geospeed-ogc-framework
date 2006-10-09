package org.geospeed.ogc.impl.wms.xmlresponse;

import java.util.List;

public class OgcWmsDescribeLayerLayer
{
    private String name;
    private List querys;
    private String url;
    
    public String getLayerName()
    {
        return name;
    }
    
    public void setLayerName(String layerName)
    {
        name = layerName;
    }
    
    public String getWfsUrl()
    {
        return url;
    }
    
    public void setWfsUrl(String wfsUrl)
    {
        url = wfsUrl;
    }
    
    public List getQuerys()
    {
        return querys;
    }
    
    /**
     * 
     * @param queryList a java.util.List that contains java.lang.Strings 
     */
    public void setQuerys(List queryList)
    {
        querys = queryList;
    }
}
