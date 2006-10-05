package org.geospeed.ogc.api.wcs.factory;

import java.io.IOException;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.IOgcRequest;
import org.geospeed.ogc.impl.wcs.request.OgcWcsDescribeCoverageRequest;
import org.geospeed.ogc.impl.wcs.request.OgcWcsGetCapabilitiesRequest;
import org.geospeed.ogc.impl.wcs.request.OgcWcsGetCoverageRequest;


public class OgcWcsRequestFactory
{
    public static IOgcRequest createWcsRequest(IOgcMap params) throws IOException
    {
        String requestParameter = (String)params.get("REQUEST");
        
        if (requestParameter == null || requestParameter.equals(""))
            throw new IOException("No wcs request object could be created from the request parameter '" + requestParameter + "'");
        
        if (requestParameter.equalsIgnoreCase("GetCapabilities"))
            return new OgcWcsGetCapabilitiesRequest(params);
        
        if (requestParameter.equalsIgnoreCase("DescribeCoverage"))
            return new OgcWcsDescribeCoverageRequest(params);
        
        if (requestParameter.equalsIgnoreCase("GetCoverage"))
            return new OgcWcsGetCoverageRequest(params);
        
        throw new IOException("No wcs request object could be created from the request parameter '" + requestParameter + "'");
    }
}
