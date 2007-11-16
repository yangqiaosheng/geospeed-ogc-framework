package org.geospeed.impl.wfs.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.geospeed.api.wfs.IOgcWfsDescribeFeatureTypeRequest;
import org.geospeed.keys.OgcRequestKey;
import org.geospeed.keys.WebFeatureServiceKey;


public class OgcWfsDescribeFeatureTypeRequest implements IOgcWfsDescribeFeatureTypeRequest 
{
	private String service;
	private String version;
	private String request;
	private List<String> typenames = new ArrayList<String>();
	private String outputFormat;
    private Map<String, String> vendorSpecificParams = new HashMap<String, String>();
	
    private Logger log = Logger.getLogger(this.getClass());
    
	public OgcWfsDescribeFeatureTypeRequest(Map<String, String> params)
	{
        log.debug("Entering OgcWmsGetCapabilitiesRequest(Map).");
        
		service = params.remove(OgcRequestKey.SERVICE.name());
		version = params.remove(OgcRequestKey.VERSION.name());
		request = params.remove(OgcRequestKey.REQUEST.name());
        
		String t = params.remove(WebFeatureServiceKey.TYPENAME.name());
		String[] tmp;
		
		if (t != null && !t.equals(""))
			tmp = t.split(",");
		else
			tmp = new String[] {};
		
		for (int i = 0; i < tmp.length; i++)
			typenames.add(tmp[i]);
		
		outputFormat = params.remove(WebFeatureServiceKey.OUTPUTFORMAT.name());		
		
		vendorSpecificParams = params;
        
        log.debug("Created an OgcWfsGetCapabilitiesRequest with parameter:value pairs - \n" +
                "\t" + OgcRequestKey.VERSION.name() + " : " + version + "\n" +
                "\t" + OgcRequestKey.REQUEST.name() + " : " + request + "\n" +
                "\t" + OgcRequestKey.SERVICE.name() + " : " + service + "\n" +
                "\tand " + vendorSpecificParams.size() + " vendor specific parameters.");
        log.debug("Exiting OgcWmsGetCapabilitiesRequest(Map).");
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

	public List<String> getTypeName()
	{
		return typenames;
	}
	
	public String getOutputFormat()
	{
		return outputFormat;
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
