package org.geospeed.ogc.impl.wms.request;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.wms.IOgcWmsGetFeatureInfoRequest;
import org.geospeed.ogc.api.wms.IOgcWmsGetMapRequest;


public class OgcWmsGetFeatureInfoRequest implements IOgcWmsGetFeatureInfoRequest 
{
    private IOgcWmsGetMapRequest mapRequest;
    private List queryLayers = new ArrayList();
    private String version;
    private String request;
    private String service;
    private String infoFormat;
    private String featureCount;
    private String i;
    private String j;
    private String exceptions;
	private Map vendorSpecificParams;
    
	public OgcWmsGetFeatureInfoRequest(IOgcMap params)
	{
		version = (String)params.getAndRemove("VERSION");
		request = (String)params.getAndRemove("REQUEST");
        service = (String)params.getAndRemove("SERVICE");
		infoFormat = (String)params.getAndRemove("INFO_FORMAT");
		featureCount = (String)params.getAndRemove("FEATURE_COUNT");
		i = (String)params.getAndRemove("I");
		j = (String)params.getAndRemove("J");
		exceptions = (String)params.getAndRemove("EXCEPTIONS");
        
		String tmp = (String)params.getAndRemove("QUERY_LAYERS");
        
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
		return i;
	}

	public String getJ() 
	{
		return j;
	}

	public String getExceptions() 
	{
		return exceptions;
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
        s += "\nINFO_FORMAT: " + infoFormat;
        s += "\nFEATURE_COUNT: " + featureCount;
        s += "\nI: " + i;
        s += "\nJ: " + j;
        s += "\nEXCEPTIONS: " + exceptions;
        
        for (Iterator i = queryLayers.iterator(); i.hasNext();)
            s += "\nLAYER: " + (String)i.next();
        
        for (Iterator i = vendorSpecificParams.keySet().iterator(); i.hasNext();)
        {
            String key = (String)i.next();
            s += "\n" + key + ": " + vendorSpecificParams.get(key);
        }
        
        return s;
    }
}
