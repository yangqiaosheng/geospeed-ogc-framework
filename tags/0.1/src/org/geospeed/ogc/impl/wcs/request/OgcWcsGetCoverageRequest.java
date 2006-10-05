package org.geospeed.ogc.impl.wcs.request;

import java.util.List;
import java.util.Map;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.wcs.IOgcWcsGetCoverageRequest;


public class OgcWcsGetCoverageRequest implements IOgcWcsGetCoverageRequest
{
    private String coverage;
    private String crs;
    private String rCrs;
    private String maxX = "0";
    private String maxY = "0";
    private String minX = "0";
    private String minY = "0";
    private List time;
    private List parameters;
    private String width = "0";
    private String height = "0";
    private String depth = "0";
    private String resX = "0";
    private String resY = "0";
    private String resZ = "0";
    private String interpolation;
    private String format;
    private String exceptions;
    private String service;
    private String version;
    private String request;
    private Map vendorSpecificParams;
    
    public OgcWcsGetCoverageRequest(IOgcMap params)
    {
        coverage = (String)params.getAndRemove("COVERAGE");
        crs = (String)params.getAndRemove("CRS");
        rCrs = (String)params.getAndRemove("RESPONSE_CRS");
        
        if (params.get("BBOX") != null)
        {
            String[] tmpBbox = ((String)params.getAndRemove("BBOX")).split(",");
            
            if (tmpBbox.length == 4)
            {
                minX = tmpBbox[0];
                minY = tmpBbox[1];
                maxX = tmpBbox[2];
                maxY = tmpBbox[3];
            }
        }
        
        String tmp = (String)params.getAndRemove("TIME");
        
        if (tmp != null && !tmp.equals(""))
        {
            String[] tmpTime = tmp.split(",");
            
            for (int i = 0; i < tmpTime.length; i++)
                time.add(tmpTime[i].trim());
        }
        
        tmp = (String)params.getAndRemove("PARAMETER");
        
        if (tmp != null && !tmp.equals(""))
        {
            String[] tmpParameter = tmp.split(",");
            
            for (int i = 0; i < tmpParameter.length; i++)
                parameters.add(tmpParameter[i].trim());
        }
        
        width = (String)params.getAndRemove("WIDTH");
        height = (String)params.getAndRemove("HEIGHT");
        depth = (String)params.getAndRemove("DEPTH");
        resX = (String)params.getAndRemove("RESX");
        resY = (String)params.getAndRemove("RESY");
        resZ = (String)params.getAndRemove("RESZ");
        interpolation = (String)params.getAndRemove("INTERPOLATION");
        format = (String)params.getAndRemove("FORMAT");
        exceptions = (String)params.getAndRemove("EXCEPTIONS");
        service = (String)params.getAndRemove("SERVICE");
        version = (String)params.getAndRemove("VERSION");
        request = (String)params.getAndRemove("REQUEST");
        vendorSpecificParams = params;
    }
    
    public String getCoverage()
    {
        return coverage;
    }

    public String getCrs()
    {
        return crs;
    }

    public String getResponseCrs()
    {
        return rCrs;
    }

    public double getMaxX()
    {
        return Double.parseDouble(maxX);
    }

    public double getMaxY()
    {
        return Double.parseDouble(maxY);
    }

    public double getMinX()
    {
        return Double.parseDouble(minX);
    }

    public double getMinY()
    {
        return Double.parseDouble(minY);
    }

    public List getTime()
    {
        return time;
    }

    public List getParameters()
    {
        return parameters;
    }
 
    public int getWidth()
    {
        return Integer.parseInt(width);
    }

    public int getHeight()
    {
        return Integer.parseInt(height);
    }

    public int getDepth()
    {
        return Integer.parseInt(depth);
    }

    public double getResX()
    {
        return Double.parseDouble(resX);
    }

    public double getResY()
    {
        return Double.parseDouble(resY);
    }

    public double getResZ()
    {
        return Double.parseDouble(resZ);
    }

    public String getInterpolation()
    {
        return interpolation;
    }

    public String getFormat()
    {
        return format;
    }

    public String getExceptions()
    {
        return exceptions;
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

    public Map getVendorSpecificParams()
    {
        return vendorSpecificParams;
    }

}
