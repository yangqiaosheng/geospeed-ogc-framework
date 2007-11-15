package org.geospeed.keys;

public class OgcProcessorsKey extends Key
{
	//WMS
    public static final OgcProcessorsKey WMSGETCAPABILITIES = new OgcProcessorsKey("WmsGetCapabilitiesProcessor");
    public static final OgcProcessorsKey WMSGETMAP = new OgcProcessorsKey("WmsGetMapProcessor");
    public static final OgcProcessorsKey WMSGETFEATUREINFO = new OgcProcessorsKey("WmsGetFeatureInfoProcessor");
    public static final OgcProcessorsKey WMSDESCRIBELAYER = new OgcProcessorsKey("WmsDescribeLayerProcessor");
    public static final OgcProcessorsKey WMSGETLEGENDGRAPHIC = new OgcProcessorsKey("WmsGetLegendGraphicProcessor");
    public static final OgcProcessorsKey WMSGETSTYLES = new OgcProcessorsKey("WmsGetStylesProcessor");
    public static final OgcProcessorsKey WMSPUTSTYLES = new OgcProcessorsKey("WmsPutStylesProcessor");
    
    //WFS
    public static final OgcProcessorsKey WFSGETCAPABILITIES = new OgcProcessorsKey("WfsGetCapabilitiesProcessor");
    public static final OgcProcessorsKey WFSDESCRIBEFEATURETYPE = new OgcProcessorsKey("WfsDescribeFeatureTypeProcessor");
    public static final OgcProcessorsKey WFSGETFEATURE = new OgcProcessorsKey("WfsGetFeatureProcessor");
    public static final OgcProcessorsKey WFSLOCKFEATURE = new OgcProcessorsKey("WfsLockFeatureProcessor");
    public static final OgcProcessorsKey WFSTRANSACTION = new OgcProcessorsKey("WfsTransactionProcessor");
    public static final OgcProcessorsKey WFSGETGMLOBJECT = new OgcProcessorsKey("WfsGetGmlObjectProcessor");
    
    public OgcProcessorsKey(String _name)
    {
        super(_name);
    }
}
