package org.geospeed.ogc.impl.wms.request;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.wms.IOgcWmsDescribeLayerRequest;


public class OgcWmsDescribeLayerRequest implements IOgcWmsDescribeLayerRequest 
{
    private String version;
    private String request;
    private String service;
    private List layers = new ArrayList();
	private Map vendorSpecificParams;
    
	public OgcWmsDescribeLayerRequest(IOgcMap params)
	{
		version = (String)params.getAndRemove("VERSION");
		request = (String)params.getAndRemove("REQUEST");
        service = (String)params.getAndRemove("SERVICE");
		
		String tmp = (String)params.getAndRemove("LAYER");
        
		if (tmp != null && !tmp.equals(""))
		{
			String[] tmpLayers = tmp.split(",");
			
			for (int i = 0; i < tmpLayers.length; i++)
				layers.add(tmpLayers[i].trim());
		}
        
        vendorSpecificParams = params;
	}
	
	public List getLayers() 
	{
		return layers;
	}

	public String getVersion() 
	{
		return version;
	}
 
	public String getRequest() 
	{
		return request;
	}

    public String getService()
    {
        return service;
    }
    
    public Map getVendorSpecificParams()
    {
        return vendorSpecificParams;
    }

    public String toString()
    {
        String s = "REQUEST: " + request;
        s += "\nSERVICE: " + service;
        s += "\nVERSION: " + version;
        
        for (Iterator i = layers.iterator(); i.hasNext();)
            s += "\nLAYER: " + (String)i.next();
        
        for (Iterator i = vendorSpecificParams.keySet().iterator(); i.hasNext();)
        {
            String key = (String)i.next();
            s += "\n" + key + ": " + vendorSpecificParams.get(key);
        }
        
        return s;           
    }
}
