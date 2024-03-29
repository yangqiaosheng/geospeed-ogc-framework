package org.geospeed.impl.wms.request;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.geospeed.api.wms.IOgcWmsGetCapabilitiesRequest;
import org.geospeed.keys.OgcRequestKey;
import org.geospeed.keys.WebMappingServiceKey;


public class OgcWmsGetCapabilitiesRequest implements IOgcWmsGetCapabilitiesRequest 
{
	private String service;
	private String version;
    private String wmtver;
	private String request;
    private String format;
    private String updateSequence;
    private Map<String, String> vendorSpecificParams = new HashMap<String, String>();
	
    private Logger log = Logger.getLogger(this.getClass());
    
	public OgcWmsGetCapabilitiesRequest(Map<String, String> params)
	{
        log.debug("Entering OgcWmsGetCapabilitiesRequest(Map).");
        
		service = params.remove(OgcRequestKey.SERVICE.name());
        wmtver = params.remove(OgcRequestKey.WMTVER.name());
		version = params.remove(OgcRequestKey.VERSION.name());
		request = params.remove(OgcRequestKey.REQUEST.name());
        format = params.remove(WebMappingServiceKey.FORMAT.name());
        updateSequence = params.remove(WebMappingServiceKey.UPDATESEQUENCE.name());

        vendorSpecificParams = params;
        
        log.debug("Created an OgcWmsGetCapabilitiesRequest with parameter:value pairs - \n" +
                "\t" + OgcRequestKey.WMTVER.name() + " : " + wmtver + "\n" +
                "\t" + OgcRequestKey.VERSION.name() + " : " + version + "\n" +
                "\t" + OgcRequestKey.REQUEST.name() + " : " + request + "\n" +
                "\t" + OgcRequestKey.SERVICE.name() + " : " + service + "\n" +
                "\t" + WebMappingServiceKey.FORMAT.name() + " : " + format + "\n" +
                "\t" + WebMappingServiceKey.UPDATESEQUENCE.name() + " : " + updateSequence + "\n" +
                "\tand " + vendorSpecificParams.size() + " vendor specific parameters.");
        log.debug("Exiting OgcWmsGetCapabilitiesRequest(Map).");
	}
	
	public String getService() 
	{
        //the WMS 1.0 spec does not contain a service parameter.  So we should just return null for
        //a WMS 1.0 request even though it may cause an issue with different service type requests.
		//return (service == null || service.equals("")) ? WebMappingServiceKey.SERVICE_NAME.name() : service;
        return service;
	}

	public String getVersion() 
	{
		return (wmtver == null || wmtver.equals("")) ? version : wmtver;
	}

	public String getRequest() 
	{
		return request;
	}

    public String getFormat()
    {
        return format;
    }
    
	public String getUpdateSequence()
    {
	    return updateSequence;
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
        s.append("\nUPDATESEQUENCE: " + updateSequence);
        
        for (Iterator i = vendorSpecificParams.keySet().iterator(); i.hasNext();)
        {
            String key = (String)i.next();
            s.append("\n" + key + ": " + vendorSpecificParams.get(key));
        }
        
        return s.toString();
    }
}
