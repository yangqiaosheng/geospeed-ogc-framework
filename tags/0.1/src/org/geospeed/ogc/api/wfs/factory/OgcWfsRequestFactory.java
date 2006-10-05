package org.geospeed.ogc.api.wfs.factory;

import java.io.IOException;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.IOgcRequest;
import org.geospeed.ogc.impl.wfs.request.OgcWfsDescribeFeatureTypeRequest;
import org.geospeed.ogc.impl.wfs.request.OgcWfsGetCapabilitiesRequest;
import org.geospeed.ogc.impl.wfs.request.OgcWfsGetFeatureRequest;
import org.geospeed.ogc.impl.wfs.request.OgcWfsGetGmlObjectRequest;
import org.geospeed.ogc.impl.wfs.request.OgcWfsLockFeatureRequest;
import org.geospeed.ogc.impl.wfs.request.OgcWfsTransactionRequest;


public class OgcWfsRequestFactory
{
    public static IOgcRequest createWfsRequest(IOgcMap params) throws IOException
    {
        String requestParameter = (String)params.get("REQUEST");
            
        if (requestParameter == null || requestParameter.equals(""))
            throw new IOException("No wfs request object could be created from the request parameter '" + requestParameter + "'");
        
        if (requestParameter.equalsIgnoreCase("GetCapabilities"))
            return new OgcWfsGetCapabilitiesRequest(params);
        
        if (requestParameter.equalsIgnoreCase("DescribeFeatureType"))
            return new OgcWfsDescribeFeatureTypeRequest(params);
        
        if (requestParameter.equalsIgnoreCase("GetFeature") || requestParameter.equalsIgnoreCase("GetFeatureWithLock"))
            return new OgcWfsGetFeatureRequest(params);
        
        if (requestParameter.equalsIgnoreCase("GetGmlObject"))
            return new OgcWfsGetGmlObjectRequest(params);
        
        if (requestParameter.equalsIgnoreCase("LockFeature"))
            return new OgcWfsLockFeatureRequest(params);

        if (requestParameter.equalsIgnoreCase("Transaction"))
            return new OgcWfsTransactionRequest(params);
        
        throw new IOException("No wfs request object could be created from the request parameter '" + requestParameter + "'");
    }
}
