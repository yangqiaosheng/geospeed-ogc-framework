package org.geospeed.ogc.impl;

import java.util.HashMap;
import java.util.Map;

import org.geospeed.ogc.api.IOgcMap;


public class OgcHashMap extends HashMap implements IOgcMap
{
    private static final long serialVersionUID = 0;
    
    public OgcHashMap()
    {
        super();
    }

    public OgcHashMap(int initialCapacity)
    {
        super(initialCapacity);
    }

    public OgcHashMap(int initialCapacity, float loadFactor)
    {
        super(initialCapacity, loadFactor);
    }

    public OgcHashMap(Map m)
    {
        super(m);
    }

    public Object getAndRemove(Object key)
    {
        Object o = super.get(key);
        super.remove(key);
        return o;
    }
    
}
