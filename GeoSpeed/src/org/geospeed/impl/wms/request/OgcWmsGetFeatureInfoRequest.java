package org.geospeed.impl.wms.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.geospeed.api.wms.IOgcWmsGetFeatureInfoRequest;
import org.geospeed.api.wms.IOgcWmsGetMapRequest;
import org.geospeed.keys.OgcRequestKey;
import org.geospeed.keys.WebMappingServiceKey;


public class OgcWmsGetFeatureInfoRequest implements IOgcWmsGetFeatureInfoRequest 
{
    private IOgcWmsGetMapRequest mapRequest;
    private List<String> queryLayers = new ArrayList<String>();
    private String version;
    private String wmtver;
    private String request;
    private String service;
    private String infoFormat;
    private String featureCount;
    private String i;
    private String j;
    private String x;
    private String y;
    private String exceptions;
	private Map<String, String> vendorSpecificParams = new HashMap<String, String>();
    
	public OgcWmsGetFeatureInfoRequest(Map<String, String> params)
	{
		version = (String)params.remove(OgcRequestKey.VERSION.name());
        wmtver = (String)params.remove(OgcRequestKey.WMTVER.name());
		request = (String)params.remove(OgcRequestKey.REQUEST.name());
        service = (String)params.remove(OgcRequestKey.SERVICE.name());
		infoFormat = (String)params.remove(WebMappingServiceKey.INFO_FORMAT.name());
		featureCount = (String)params.remove(WebMappingServiceKey.FEATURE_COUNT.name());
		i = (String)params.remove(WebMappingServiceKey.I.name());
		j = (String)params.remove(WebMappingServiceKey.J.name());
        x = (String)params.remove(WebMappingServiceKey.X.name());
        y = (String)params.remove(WebMappingServiceKey.Y.name());
		exceptions = (String)params.remove(WebMappingServiceKey.EXCEPTIONS.name());
        
		String tmp = (String)params.remove(WebMappingServiceKey.QUERY_LAYERS.name());
        
		if (tmp != null && !tmp.equals(""))
		{
			String[] tmpLayers = tmp.split(",");
			
			for (int i = 0; i < tmpLayers.length; i++)
				queryLayers.add(tmpLayers[i].trim());
		}

        mapRequest = new OgcWmsGetMapRequest(params);
        
        vendorSpecificParams = params;
	}
	
	public IOgcWmsGetMapRequest getMapRequest() 
	{
		return mapRequest;
	}

	public List getQueryLayers() 
	{
		return queryLayers;
	}
 
	public String getInfoFormat() 
	{
		return infoFormat;
	}

	public String getFeatureCount() 
	{
		return featureCount;
	}

	public String getI() 
	{
        return (i == null || i.equals("")) ? x : i;
	}

	public String getJ() 
	{
        return (j == null || j.equals("")) ? y : j;
	}

    public String getX()
    {
        return (x == null || x.equals("")) ? i : x;
    }
    
    public String getY()
    {
        return (y == null || y.equals("")) ? j : y;
    }
    
	public String getExceptions() 
	{
		return exceptions;
	}

	public String getVersion() 
	{
        return (wmtver == null || wmtver.equals("")) ? version : wmtver;
	}

	public String getRequest() 
	{
		return request;
	}

    public String getService()
    {
        return (service == null || service.equals("")) ? WebMappingServiceKey.SERVICE_NAME.name() : service;
    }

    public Map getVendorSpecificParams()
    {
        return vendorSpecificParams;
    }

    public String toString()
    {
        StringBuffer s = new StringBuffer("REQUEST: " + request);
        s.append("\nSERVICE: " + service);
        s.append("\nVERSION: " + version);
        s.append("\nINFO_FORMAT: " + infoFormat);
        s.append("\nFEATURE_COUNT: " + featureCount);
        s.append("\nI: " + i);
        s.append("\nJ: " + j);
        s.append("\nEXCEPTIONS: " + exceptions);
        
        for (Iterator i = queryLayers.iterator(); i.hasNext();)
            s.append("\nLAYER: " + (String)i.next());
        
        for (Iterator i = vendorSpecificParams.keySet().iterator(); i.hasNext();)
        {
            String key = (String)i.next();
            s.append("\n" + key + ": " + vendorSpecificParams.get(key));
        }
        
        return s.toString();
    }
}
