package org.geospeed.ogc.impl.wms.xmlresponse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.geospeed.ogc.api.IOgcXmlResponse;

public class OgcWmsDescribeLayerResponse implements IOgcXmlResponse
{
    List layers = new ArrayList();
    
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
        StringBuffer xml = new StringBuffer("<WMS_DescribeLayerResponse version=\"1.1.0\" >");
        
        for (Iterator i = layers.iterator(); i.hasNext();)
        {
            OgcWmsDescribeLayerLayer layer = (OgcWmsDescribeLayerLayer)i.next();
            
            xml.append("<LayerDescription name=\"" + layer.getLayerName() + "\" wfs=\"" + layer.getWfsUrl() + "\">");
            
            for (Iterator q = layer.getQuerys().iterator(); q.hasNext();)
            {
                String query = (String)q.next();
                
                xml.append("<Query typeName=\"" + query + "\"/>");
            }
            
            xml.append("</LayerDescription>");
        }
        
        return xml.toString();
    }

}
