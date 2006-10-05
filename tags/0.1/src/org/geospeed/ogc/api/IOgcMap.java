package org.geospeed.ogc.api;

import java.util.Map;

public interface IOgcMap extends Map
{
    /**
     * Returns the value to which this map maps the specified key and removes 
     * the key/vaule pair from the map.  
     * 
     * @param key key whose associated value is to be returned.
     * @return the value to which this map maps the specified key, or
     *         <tt>null</tt> if the map contains no mapping for this key.
     */
    public Object getAndRemove(Object key);
}
