package org.geospeed.keys;

public class OgcRequestKey extends Key
{
    public static final OgcRequestKey SERVICE = new OgcRequestKey("SERVICE");
    public static final OgcRequestKey VERSION = new OgcRequestKey("VERSION");
    public static final OgcRequestKey WMTVER = new OgcRequestKey("WMTVER");
    public static final OgcRequestKey REQUEST = new OgcRequestKey("REQUEST");
    public static final OgcRequestKey VendorParams = new OgcRequestKey("VENDORPARAMS");
    
    private OgcRequestKey(String _name)
    {
        super(_name);
    }
}
