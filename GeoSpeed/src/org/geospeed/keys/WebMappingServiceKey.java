package org.geospeed.keys;

public class WebMappingServiceKey extends Key
{
    //Service type
    public static final WebMappingServiceKey SERVICE_NAME = new WebMappingServiceKey("WMS");
    //versions
    public static final WebMappingServiceKey V1_0 = new WebMappingServiceKey("1.0");
    public static final WebMappingServiceKey V1_0_0 = new WebMappingServiceKey("1.0.0");
    public static final WebMappingServiceKey V1_1_0 = new WebMappingServiceKey("1.1.0");
    public static final WebMappingServiceKey V1_1_1 = new WebMappingServiceKey("1.1.1");
    public static final WebMappingServiceKey V1_3_0 = new WebMappingServiceKey("1.3.0");
    
    //Request types
    public static final WebMappingServiceKey GETCAPABILITIES = new WebMappingServiceKey("GetCapabilities");
    public static final WebMappingServiceKey CAPABILITIES = new WebMappingServiceKey("capabilities");
    public static final WebMappingServiceKey GETMAP = new WebMappingServiceKey("GetMap");
    public static final WebMappingServiceKey MAP = new WebMappingServiceKey("map");
    public static final WebMappingServiceKey GETFEATUREINFO = new WebMappingServiceKey("GetFeatureInfo");
    public static final WebMappingServiceKey FEATUREINFO = new WebMappingServiceKey("feature_info");
    public static final WebMappingServiceKey DESCRIBELAYER = new WebMappingServiceKey("DescribeLayer");
    public static final WebMappingServiceKey GETLEGENDGRAPHIC = new WebMappingServiceKey("GetLegendGraphic");
    public static final WebMappingServiceKey GETSYTLES = new WebMappingServiceKey("GetStyles");
    public static final WebMappingServiceKey PUTSTYLES = new WebMappingServiceKey("PutStyles");
    //for the GetCapabilities request
    public static final WebMappingServiceKey UPDATESEQUENCE = new WebMappingServiceKey("UPDATESEQUENCE");
    //For the GetMap request 
    public static final WebMappingServiceKey SLD = new WebMappingServiceKey("SLD");
    public static final WebMappingServiceKey WFS = new WebMappingServiceKey("WFS");
    public static final WebMappingServiceKey SLD_BODY = new WebMappingServiceKey("SLD_BODY");
    public static final WebMappingServiceKey REMOTE_OWS_TYPE = new WebMappingServiceKey("REMOTE_OWS_TYPE");
    public static final WebMappingServiceKey REMOTE_OWS_URL = new WebMappingServiceKey("REMOTE_OWS_URL");
    public static final WebMappingServiceKey CRS = new WebMappingServiceKey("CRS");
    public static final WebMappingServiceKey SRS = new WebMappingServiceKey("SRS");
    public static final WebMappingServiceKey WIDTH = new WebMappingServiceKey("WIDTH");
    public static final WebMappingServiceKey HEIGHT = new WebMappingServiceKey("HEIGHT");
    public static final WebMappingServiceKey FORMAT = new WebMappingServiceKey("FORMAT");
    public static final WebMappingServiceKey TRANSPARENT = new WebMappingServiceKey("TRANSPARENT");
    public static final WebMappingServiceKey BGCOLOR = new WebMappingServiceKey("BGCOLOR");
    public static final WebMappingServiceKey EXCEPTIONS = new WebMappingServiceKey("EXCEPTIONS");
    public static final WebMappingServiceKey ELEVATION = new WebMappingServiceKey("ELEVATION");
    public static final WebMappingServiceKey TIME = new WebMappingServiceKey("TIME");
    public static final WebMappingServiceKey LAYERS = new WebMappingServiceKey("LAYERS");
    public static final WebMappingServiceKey STYLES = new WebMappingServiceKey("STYLES");
    public static final WebMappingServiceKey BBOX = new WebMappingServiceKey("BBOX");
    //for the GetFeatureInfo request
    public static final WebMappingServiceKey INFO_FORMAT = new WebMappingServiceKey("INFO_FORMAT");
    public static final WebMappingServiceKey FEATURE_COUNT = new WebMappingServiceKey("FEATURE_COUNT");
    public static final WebMappingServiceKey I = new WebMappingServiceKey("I");
    public static final WebMappingServiceKey J = new WebMappingServiceKey("J");
    public static final WebMappingServiceKey X = new WebMappingServiceKey("X");
    public static final WebMappingServiceKey Y = new WebMappingServiceKey("Y");
    public static final WebMappingServiceKey QUERY_LAYERS = new WebMappingServiceKey("QUERY_LAYERS");
    //for the DescribeLayer request
    public static final WebMappingServiceKey LAYER = new WebMappingServiceKey("LAYER");
    //for the GetLegendGraphic request
    public static final WebMappingServiceKey STYLE = new WebMappingServiceKey("STYLE");
    public static final WebMappingServiceKey RULE = new WebMappingServiceKey("RULE");
    public static final WebMappingServiceKey FEATURETYPE = new WebMappingServiceKey("FEATURETYPE");
    public static final WebMappingServiceKey SCALE = new WebMappingServiceKey("SCALE");
    //for the GetStyles request
    public static final WebMappingServiceKey SLDVER = new WebMappingServiceKey("SLDVER");
    //for the PutStyles request
    public static final WebMappingServiceKey MODE = new WebMappingServiceKey("MODE");
    
    
    private WebMappingServiceKey(String _name)
    {
        super(_name);
    }
}
