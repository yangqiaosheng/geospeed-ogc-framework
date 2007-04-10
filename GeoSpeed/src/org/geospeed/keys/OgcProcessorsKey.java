package org.geospeed.keys;

public class OgcProcessorsKey extends Key
{
    public static final OgcProcessorsKey WMSGETCAPABILITIES = new OgcProcessorsKey("WmsGetCapabilitiesProcessor");
    public static final OgcProcessorsKey WMSGETMAP = new OgcProcessorsKey("WmsGetMapProcessor");
    public static final OgcProcessorsKey WMSGETFEATUREINFO = new OgcProcessorsKey("WmsGetFeatureInfoProcessor");
    public static final OgcProcessorsKey WMSDESCRIBELAYER = new OgcProcessorsKey("WmsDescribeLayerProcessor");
    public static final OgcProcessorsKey WMSGETLEGENDGRAPHIC = new OgcProcessorsKey("WmsGetLegendGraphicProcessor");
    public static final OgcProcessorsKey WMSGETSTYLES = new OgcProcessorsKey("WmsGetStylesProcessor");
    public static final OgcProcessorsKey WMSPUTSTYLES = new OgcProcessorsKey("WmsPutStylesProcessor");
    
    public OgcProcessorsKey(String _name)
    {
        super(_name);
    }
}
