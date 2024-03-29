package org.geospeed.impl.wms.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.geospeed.api.wms.IOgcWmsDescribeLayerRequest;
import org.geospeed.keys.OgcRequestKey;
import org.geospeed.keys.WebMappingServiceKey;


public class OgcWmsDescribeLayerRequest implements IOgcWmsDescribeLayerRequest 
{
    private String version;
    private String request;
    private String service;
    private List<String> layers = new ArrayList<String>();
	private Map<String, String> vendorSpecificParams = new HashMap<String, String>();
    
    private Logger log = Logger.getLogger(this.getClass());
    
	public OgcWmsDescribeLayerRequest(Map<String, String> params)
	{
        log.debug("Entering OgcWmsDescribeLayerRequest(Map).");
        
		version = params.remove(OgcRequestKey.VERSION.name());
		request = params.remove(OgcRequestKey.REQUEST.name());
        service = params.remove(OgcRequestKey.SERVICE.name());
		
		String tmp = params.remove(WebMappingServiceKey.LAYER.name());
        
		if (tmp != null && !tmp.equals(""))
		{
			String[] tmpLayers = tmp.split(",");
			
			for (int i = 0; i < tmpLayers.length; i++)
				layers.add(tmpLayers[i].trim());
		}
        
        vendorSpecificParams = params;
        
        log.debug("Created an OgcWmsDescribeLayerRequest with parameter:value pairs - \n" +
                "\t" + OgcRequestKey.VERSION.name() + " : " + version + "\n" +
                "\t" + OgcRequestKey.REQUEST.name() + " : " + request + "\n" +
                "\t" + OgcRequestKey.SERVICE.name() + " : " + service + "\n" +
                "\t" + WebMappingServiceKey.LAYER.name() + " : " + tmp + "\n" +
                "\tand " + vendorSpecificParams.size() + " vendor specific parameters.");
        log.debug("Exiting OgcWmsDescribeLayerRequest(Map).");
	}
	
	public List<String> getLayers() 
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
    
    public Map<String, String> getVendorSpecificParams()
    {
        return vendorSpecificParams;
    }

    public String toString()
    {
        StringBuffer s = new StringBuffer("REQUEST: " + request);
        s.append("\nSERVICE: " + service);
        s.append("\nVERSION: " + version);
        
        for (Iterator i = layers.iterator(); i.hasNext();)
            s.append("\nLAYER: " + (String)i.next());
        
        for (Iterator i = vendorSpecificParams.keySet().iterator(); i.hasNext();)
        {
            String key = (String)i.next();
            s.append("\n" + key + ": " + vendorSpecificParams.get(key));
        }
        
        return s.toString();           
    }
}
