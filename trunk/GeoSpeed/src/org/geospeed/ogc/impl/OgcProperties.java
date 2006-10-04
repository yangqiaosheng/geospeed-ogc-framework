package org.geospeed.ogc.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class OgcProperties
{
    private static OgcProperties me = null;
    private Properties p;
    
    private void load(String filename) throws IOException
    {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(filename);
        
        if (is == null)
        {
            throw new IOException("Could not find the " + filename + " file.  Check to make sure the" + filename + 
                    " file (or the folder that contains that file) is on the classpath of your application");
        }
        
        p = new Properties();
        p.load(is);
    }
    
    public static OgcProperties getInstance(String filename) throws IOException
    {
        if (me == null)
        {
            me = new OgcProperties();
            me.load(filename);
        }
        
        return me;
    }

    public String getProperty(String key)
    {
        return p.getProperty(key);
    }

}
