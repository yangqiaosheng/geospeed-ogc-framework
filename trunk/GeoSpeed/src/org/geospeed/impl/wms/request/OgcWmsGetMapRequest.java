package org.geospeed.impl.wms.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.geospeed.api.wms.IOgcWmsGetMapRequest;
import org.geospeed.keys.OgcRequestKey;
import org.geospeed.keys.WebMappingServiceKey;


public class OgcWmsGetMapRequest implements IOgcWmsGetMapRequest 
{
	private List<String> layers = new ArrayList<String>();
    private List<String> styles = new ArrayList<String>();
    private String version;
    private String wmtver;
    private String request;
    private String service;
    private String sld;
    private String sldBody;
    private String remoteOwsType;
    private String remoteOwsUrl;
    private String crs;
    private String srs;
    //BBOX format is BBOX=minx,miny,maxx,maxy
    private String minx = "0.0";
    private String maxx = "0.0";
    private String miny = "0.0";
    private String maxy = "0.0";
    private String width;
    private String height;
    private String format;
    private String transparent;
    private String bgColor;
    private String exceptionFormat;
    private String elevation;
    private String time;
    private Map<String, String> vendorSpecificParams = new HashMap<String, String>();
    
	public OgcWmsGetMapRequest(Map<String, String> params)
	{
		version = params.remove(OgcRequestKey.VERSION.name());
        wmtver = params.remove(OgcRequestKey.WMTVER.name());
		request = params.remove(OgcRequestKey.REQUEST.name());
        service = params.remove(OgcRequestKey.SERVICE.name());
		sld = params.remove(WebMappingServiceKey.SLD.name());
        sldBody = params.remove(WebMappingServiceKey.SLD_BODY.name());
        remoteOwsType = params.remove(WebMappingServiceKey.REMOTE_OWS_TYPE.name());
        remoteOwsUrl = params.remove(WebMappingServiceKey.REMOTE_OWS_URL.name());
		crs = params.remove(WebMappingServiceKey.CRS.name());
        srs = params.remove(WebMappingServiceKey.SRS.name());
		width = params.remove(WebMappingServiceKey.WIDTH.name());
		height = params.remove(WebMappingServiceKey.HEIGHT.name());
		format = params.remove(WebMappingServiceKey.FORMAT.name());
		transparent = params.remove(WebMappingServiceKey.TRANSPARENT.name());
		bgColor = params.remove(WebMappingServiceKey.BGCOLOR.name());
		exceptionFormat = params.remove(WebMappingServiceKey.EXCEPTIONS.name());
		elevation = params.remove(WebMappingServiceKey.ELEVATION.name());
		time = params.remove(WebMappingServiceKey.TIME.name());
		
		String tmp = params.remove(WebMappingServiceKey.LAYERS.name());
        
		if (tmp != null && !tmp.equals(""))
		{
			String[] tmpLayers = tmp.split(",");
			
			for (int i = 0; i < tmpLayers.length; i++)
				layers.add(tmpLayers[i].trim());
		}
		
		tmp = params.remove(WebMappingServiceKey.STYLES.name());
        
		if (tmp != null && !tmp.equals(""))
		{
			String[] tmpStyles = tmp.split(",");
			
			for (int i = 0; i < tmpStyles.length; i++)
				styles.add(tmpStyles[i].trim());
		}
        
        if (params.get("BBOX") != null)
        {
            String[] tmpBbox = (params.remove(WebMappingServiceKey.BBOX.name())).split(",");
            
            if (tmpBbox.length == 4)
            {
                minx = tmpBbox[0];
                miny = tmpBbox[1];
                maxx = tmpBbox[2];
                maxy = tmpBbox[3];
            }
        }
        
        vendorSpecificParams = params;
	}
	
	public List getLayers() 
	{
		return layers;
	}
 
	public String getSLD() 
	{
		return (sld == null || sld.equals("")) ? sldBody : sld;
	}

    public String getRemoteOwsType()
    {
        return remoteOwsType;
    }
    
    public String getRemoteOwsUrl()
    {
        return remoteOwsUrl;
    }
    
	public List getStyles() 
	{
		return styles;
	}

	public String getCRS() 
	{
        return (crs == null || crs.equals("")) ? srs : crs;
	}

    public String getSRS()
    {
        return (srs == null || srs.equals("")) ? crs : srs;
    }
    
	public double getMinX() 
	{
		return Double.parseDouble(minx);
	}

	public double getMaxX() 
	{
		return Double.parseDouble(maxx);
	}

	public double getMinY() 
	{
		return Double.parseDouble(miny);
	}

	public double getMaxY() 
	{
		return Double.parseDouble(maxy);
	}

	public int getWidth() 
	{
		return Integer.parseInt(width);
	}

	public int getHeight() 
	{
		return Integer.parseInt(height);
	}

	public String getFormat() 
	{
		return format;
	}

	public boolean getTransparent() 
	{
		return Boolean.valueOf(transparent).booleanValue();
	}

	public String getBackgroundColor() 
	{
		return bgColor;
	}

	public String getExceptionFormat() 
	{
		return exceptionFormat;
	}
 
	public int getElevation() 
	{
		return Integer.parseInt(elevation);
	}
 
	public String getTime() 
	{
		return time;
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
        
        for (Iterator i = layers.iterator(); i.hasNext();)
            s.append("\nLAYER: " + i.next());
        
        for (Iterator i = styles.iterator(); i.hasNext();)
            s.append("\nSTYLE: " + i.next());
        
        s.append("\nSLD: " + sld);
        s.append("\nCRS: " + crs);
        s.append("\nMINX: " + minx);
        s.append("\nMAXX: " + maxx);
        s.append("\nMINY: " + miny);
        s.append("\nMAXY: " + maxy);
        s.append("\nWIDTH: " + width);
        s.append("\nHEIGHT: " + height);
        s.append("\nFORMAT: " + format);
        s.append("\nTRANSPARENT: " + transparent);
        s.append("\nBGCOLOR: " + bgColor);
        s.append("\nEXCEPTIONS: " + exceptionFormat);
        s.append("\nELEVATION: " + elevation);
        s.append("\nTIME: " + time);
        
        for (Iterator i = vendorSpecificParams.keySet().iterator(); i.hasNext();)
        {
            String key = (String)i.next();
            s.append("\n" + key + ": " + vendorSpecificParams.get(key));
        }
        
        return s.toString();
    }
}
