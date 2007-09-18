package org.geospeed.keys;

public class OgcRequestKey extends Key
{
    public static final OgcRequestKey SERVICE = new OgcRequestKey("SERVICE");
    public static final OgcRequestKey VERSION = new OgcRequestKey("VERSION");
    public static final OgcRequestKey WMTVER = new OgcRequestKey("WMTVER");
    public static final OgcRequestKey REQUEST = new OgcRequestKey("REQUEST");
    public static final OgcRequestKey VENDORPARAMS = new OgcRequestKey("VENDORPARAMS");
    public static final OgcRequestKey AUTHTYPE = new OgcRequestKey("AUTHTYPE");
    public static final OgcRequestKey METHOD = new OgcRequestKey("METHOD");
    public static final OgcRequestKey PATHINFO = new OgcRequestKey("PATHINFO");
    public static final OgcRequestKey PATHTRANSLATED = new OgcRequestKey("PATHTRANSLATED");
    public static final OgcRequestKey QUERYSTRING = new OgcRequestKey("QUERYSTRING");
    public static final OgcRequestKey REMOTEUSER = new OgcRequestKey("REMOTEUSER");
    public static final OgcRequestKey REQUESTEDSESSIONID = new OgcRequestKey("REQUESTEDSESSIONID");
    public static final OgcRequestKey REQUESTURI = new OgcRequestKey("REQUESTURI");
    public static final OgcRequestKey SERVLETPATH = new OgcRequestKey("SERVLETPATH");
    
    private OgcRequestKey(String _name)
    {
        super(_name);
    }
}
