package org.geospeed.ogc.impl.wms.request;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.wms.IOgcWmsGetMapRequest;


public class OgcWmsGetMapRequest implements IOgcWmsGetMapRequest 
{
	private List layers = new ArrayList();
    private List styles = new ArrayList();
    private String version;
    private String request;
    private String service;
    private String sld;
    private String crs;
    //BBOX format is BBOX=minx,miny,maxx,maxy
    private String minx = "0";
    private String maxx = "0";
    private String miny = "0";
    private String maxy = "0";
    private String width;
    private String height;
    private String format;
    private String transparent;
    private String bgColor;
    private String exceptionFormat;
    private String elevation;
    private String time;
    private Map vendorSpecificParams;
    
	public OgcWmsGetMapRequest(IOgcMap params)
	{
		version = (String)params.getAndRemove("VERSION");
		request = (String)params.getAndRemove("REQUEST");
        service = (String)params.getAndRemove("SERVICE");
		sld = (String)params.getAndRemove("SLD");
		crs = (String)params.getAndRemove("CRS");
		width = (String)params.getAndRemove("WIDTH");
		height = (String)params.getAndRemove("HEIGHT");
		format = (String)params.getAndRemove("FORMAT");
		transparent = (String)params.getAndRemove("TRANSPARENT");
		bgColor = (String)params.getAndRemove("BGCOLOR");
		exceptionFormat = (String)params.getAndRemove("EXCEPTIONS");
		elevation = (String)params.getAndRemove("ELEVATION");
		time = (String)params.getAndRemove("TIME");
		
		String tmp = (String)params.getAndRemove("LAYERS");
        
		if (tmp != null && !tmp.equals(""))
		{
			String[] tmpLayers = tmp.split(",");
			
			for (int i = 0; i < tmpLayers.length; i++)
				layers.add(tmpLayers[i].trim());
		}
		
		tmp = (String)params.getAndRemove("STYLES");
        
		if (tmp != null && !tmp.equals(""))
		{
			String[] tmpStyles = tmp.split(",");
			
			for (int i = 0; i < tmpStyles.length; i++)
				styles.add(tmpStyles[i].trim());
		}
        
        if (params.get("BBOX") != null)
        {
            String[] tmpBbox = ((String)params.getAndRemove("BBOX")).split(",");
            
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
		return sld;
	}

	public List getStyles() 
	{
		return styles;
	}

	public String getCRS() 
	{
		return crs;
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
        
        for (Iterator i = styles.iterator(); i.hasNext();)
            s += "\nSTYLE: " + (String)i.next();
        
        s += "\nSLD: " + sld;
        s += "\nCRS: " + crs;
        s += "\nMINX: " + minx;
        s += "\nMAXX: " + maxx;
        s += "\nMINY: " + miny;
        s += "\nMAXY: " + maxy;
        s += "\nWIDTH: " + width;
        s += "\nHEIGHT: " + height;
        s += "\nFORMAT: " + format;
        s += "\nTRANSPARENT: " + transparent;
        s += "\nBGCOLOR: " + bgColor;
        s += "\nEXCEPTIONS: " + exceptionFormat;
        s += "\nELEVATION: " + elevation;
        s += "\nTIME: " + time;
        
        for (Iterator i = vendorSpecificParams.keySet().iterator(); i.hasNext();)
        {
            String key = (String)i.next();
            s += "\n" + key + ": " + vendorSpecificParams.get(key);
        }
        
        return s;
    }
}
