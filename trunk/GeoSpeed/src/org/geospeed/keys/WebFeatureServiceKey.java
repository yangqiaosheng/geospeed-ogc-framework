package org.geospeed.keys;

public class WebFeatureServiceKey extends Key
{
    //Service type
    public static final WebFeatureServiceKey SERVICE_NAME = new WebFeatureServiceKey("WFS");
    
    //versions
    public static final WebFeatureServiceKey V1_0 = new WebFeatureServiceKey("1.0");
    public static final WebFeatureServiceKey V1_1 = new WebFeatureServiceKey("1.1");
    
    //Request types
    public static final WebFeatureServiceKey GETCAPABILITIES = new WebFeatureServiceKey("GetCapabilities");
    public static final WebFeatureServiceKey DESCRIBEFEATURETYPE = new WebFeatureServiceKey("DescribeFeatureType");
    public static final WebFeatureServiceKey GETFEATURE = new WebFeatureServiceKey("GetFeature");
    public static final WebFeatureServiceKey GETGMLOBJECT = new WebFeatureServiceKey("GetGmlObject");
    public static final WebFeatureServiceKey LOCKFEATURE = new WebFeatureServiceKey("LockFeature");
    public static final WebFeatureServiceKey TRANSACTION = new WebFeatureServiceKey("Transaction");
    
    //request attributes
    public static final WebFeatureServiceKey TYPENAME = new WebFeatureServiceKey("TYPENAME");
    public static final WebFeatureServiceKey OUTPUTFORMAT = new WebFeatureServiceKey("OUTPUTFORMAT");
    public static final WebFeatureServiceKey PROPERTYNAME = new WebFeatureServiceKey("PROPERTYNAME");
    public static final WebFeatureServiceKey FEATUREVERSION = new WebFeatureServiceKey("FEATUREVERSION");
    public static final WebFeatureServiceKey MAXFEATURES = new WebFeatureServiceKey("MAXFEATURES");
    public static final WebFeatureServiceKey FEATUREID = new WebFeatureServiceKey("FEATUREID");
    public static final WebFeatureServiceKey FILTER = new WebFeatureServiceKey("FILTER");
    public static final WebFeatureServiceKey BBOX = new WebFeatureServiceKey("BBOX");
    public static final WebFeatureServiceKey EXPIRY = new WebFeatureServiceKey("EXPIRY");
    public static final WebFeatureServiceKey LOCKACTION = new WebFeatureServiceKey("LOCKACTION");
    public static final WebFeatureServiceKey OPERATION = new WebFeatureServiceKey("OPERATION");
    public static final WebFeatureServiceKey RELEASEACTION = new WebFeatureServiceKey("RELEASEACTION");
 
    private WebFeatureServiceKey(String _name)
    {
        super(_name);
    }
}
