package org.geospeed.impl.wms.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
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
    private String wfs; //wfs_url in spec version 1.1.0
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
    
    private Logger log = Logger.getLogger(this.getClass());
    
	public OgcWmsGetMapRequest(Map<String, String> params)
	{
        log.debug("Entering OgcWmsGetMapRequest(Map).");
        
		version = params.remove(OgcRequestKey.VERSION.name());
        wmtver = params.remove(OgcRequestKey.WMTVER.name());
		request = params.remove(OgcRequestKey.REQUEST.name());
        service = params.remove(OgcRequestKey.SERVICE.name());
		sld = params.remove(WebMappingServiceKey.SLD.name());
        wfs = params.remove(WebMappingServiceKey.WFS.name());
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
		String tmplayers = tmp;
		tmp = params.remove(WebMappingServiceKey.STYLES.name());
        
		if (tmp != null && !tmp.equals(""))
		{
			String[] tmpStyles = tmp.split(",");
			
			for (int i = 0; i < tmpStyles.length; i++)
				styles.add(tmpStyles[i].trim());
		}

        String tmpbox = params.remove(WebMappingServiceKey.BBOX.name());
        
        if (params.get("BBOX") != null)
        {
            String[] tmpBbox = tmpbox.split(",");

            if (tmpBbox.length == 4)
            {
                minx = tmpBbox[0];
                miny = tmpBbox[1];
                maxx = tmpBbox[2];
                maxy = tmpBbox[3];
            }
        }
        
        vendorSpecificParams = params;
        
        log.debug("Created an OgcWmsGetMapRequest with parameter:value pairs - \n" +
                "\t" + OgcRequestKey.WMTVER.name() + " : " + wmtver + "\n" +
                "\t" + OgcRequestKey.VERSION.name() + " : " + version + "\n" +
                "\t" + OgcRequestKey.REQUEST.name() + " : " + request + "\n" +
                "\t" + OgcRequestKey.SERVICE.name() + " : " + service + "\n" +
                "\t" + WebMappingServiceKey.LAYERS.name() + " : " + tmplayers + "\n" +
                "\t" + WebMappingServiceKey.STYLES.name() + " : " + tmp + "\n" +
                "\t" + WebMappingServiceKey.CRS.name() + " : " + crs + "\n" +
                "\t" + WebMappingServiceKey.SRS.name() + " : " + srs + "\n" +
                "\t" + WebMappingServiceKey.BBOX.name() + " : " + tmpbox + "\n" +
                "\t" + WebMappingServiceKey.SLD.name() + " : " + sld + "\n" +
                "\t" + WebMappingServiceKey.WFS.name() + " : " + wfs + "\n" +
                "\t" + WebMappingServiceKey.SLD_BODY.name() + " : " + sldBody + "\n" +
                "\t" + WebMappingServiceKey.REMOTE_OWS_TYPE.name() + " : " + remoteOwsType + "\n" +
                "\t" + WebMappingServiceKey.REMOTE_OWS_URL.name() + " : " + remoteOwsUrl + "\n" +
                "\t" + WebMappingServiceKey.FORMAT.name() + " : " + format + "\n" +
                "\t" + WebMappingServiceKey.WIDTH.name() + " : " + width + "\n" +
                "\t" + WebMappingServiceKey.HEIGHT.name() + " : " + height + "\n" +
                "\t" + WebMappingServiceKey.TRANSPARENT.name() + " : " + transparent + "\n" +
                "\t" + WebMappingServiceKey.BGCOLOR.name() + " : " + bgColor + "\n" +
                "\t" + WebMappingServiceKey.EXCEPTIONS.name() + " : " + exceptionFormat + "\n" +
                "\t" + WebMappingServiceKey.ELEVATION.name() + " : " + elevation + "\n" +
                "\t" + WebMappingServiceKey.TIME.name() + " : " + time + "\n" +
                "\tand " + vendorSpecificParams.size() + " vendor specific parameters.");
        log.debug("Exiting OgcWmsGetMapRequest(Map).");
	}
	
	public List<String> getLayers() 
	{
		return layers;
	}
 
	public String getSLD() 
	{
		return (sld == null || sld.equals("")) ? sldBody : sld;
	}

    public String getWFS()
    {
        return wfs;
    }
    
    public String getRemoteOwsType()
    {
        return remoteOwsType;
    }
    
    public String getRemoteOwsUrl()
    {
        return remoteOwsUrl;
    }
    
	public List<String> getStyles() 
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
        //return (service == null || service.equals("")) ? WebMappingServiceKey.SERVICE_NAME.name() : service;
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
