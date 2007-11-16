package org.geospeed.impl.wfs.request;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.geospeed.api.wfs.IOgcWfsGetCapabilitiesRequest;
import org.geospeed.keys.OgcRequestKey;


public class OgcWfsGetCapabilitiesRequest implements IOgcWfsGetCapabilitiesRequest 
{
	private String service;
	private String version;
	private String request;
    private Map<String, String> vendorSpecificParams = new HashMap<String, String>();
	
    private Logger log = Logger.getLogger(this.getClass());
    
	public OgcWfsGetCapabilitiesRequest(Map<String, String> params)
	{
        log.debug("Entering OgcWfsGetCapabilitiesRequest(Map).");
        
		service = params.remove(OgcRequestKey.SERVICE.name());
		version = params.remove(OgcRequestKey.VERSION.name());
		request = params.remove(OgcRequestKey.REQUEST.name());
        vendorSpecificParams = params;
        
        log.debug("Created an OgcWfsGetCapabilitiesRequest with parameter:value pairs - \n" +
                "\t" + OgcRequestKey.VERSION.name() + " : " + version + "\n" +
                "\t" + OgcRequestKey.REQUEST.name() + " : " + request + "\n" +
                "\t" + OgcRequestKey.SERVICE.name() + " : " + service + "\n" +
                "\tand " + vendorSpecificParams.size() + " vendor specific parameters.");
        log.debug("Exiting OgcWfsGetCapabilitiesRequest(Map).");
	}
	
	public String getService() 
	{
        return service;
	}

	public String getVersion() 
	{
		return version;
	}

	public String getRequest() 
	{
		return request;
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
        
        for (Iterator<String> i = vendorSpecificParams.keySet().iterator(); i.hasNext();)
        {
            String key = i.next();
            s.append("\n" + key + ": " + vendorSpecificParams.get(key));
        }
        
        return s.toString();
    }
}
