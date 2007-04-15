package org.geospeed.keys;

public class ContentTypeKey extends Key
{
    public static final ContentTypeKey TEXT_PLAIN = new ContentTypeKey("text/plain");
    public static final ContentTypeKey TEXT_XML = new ContentTypeKey("text/xml");
    
    public static final ContentTypeKey IMAGE_GIF = new ContentTypeKey("image/gif");
    public static final ContentTypeKey IMAGE_JPEG = new ContentTypeKey("image/jpg");
    public static final ContentTypeKey IMAGE_PNG = new ContentTypeKey("image/png");
    
    private ContentTypeKey(String _name)
    {
        super(_name);
    }
}
