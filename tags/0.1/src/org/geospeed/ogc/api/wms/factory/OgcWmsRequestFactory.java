package org.geospeed.ogc.api.wms.factory;

import java.io.IOException;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.IOgcRequest;
import org.geospeed.ogc.impl.wms.request.OgcWmsDescribeLayerRequest;
import org.geospeed.ogc.impl.wms.request.OgcWmsGetCapabilitiesRequest;
import org.geospeed.ogc.impl.wms.request.OgcWmsGetFeatureInfoRequest;
import org.geospeed.ogc.impl.wms.request.OgcWmsGetMapRequest;


/********************************************************************************
 * 
 * @author Mike Abner
 * 
 * The OgcWmsRequestFactory examines the value of the "REQUEST" parameter as passed
 * by the requestor and creates an IOgcRequest object that corresponds to that
 * value.  Developers of IOgcRequestProcessors should cast the IOgcRequest object
 * that is passed to them into the appropriate request type to access the attributes
 * of the object that is created here.
 *
 ********************************************************************************/
public class OgcWmsRequestFactory 
{
    /**
     * Given a Map that contains a key of "REQUEST", create the appropriate
     * IOgcRequest to expose the attributes passed by the requestor.
     * 
     * @param params - Map that contains all of the attributes passed by the requestor.
     * @return IOgcRequest - an IOgcWmsRequest that has been "filled out" with the
     * parameters from the params Map.
     * @throws IOException Is thrown when no REQUEST key is available in the params Map 
     * OR when the value returned with the REQUEST key does not match any valid WMS
     * request types. 
     */
	public static IOgcRequest createWmsRequest(IOgcMap params) throws IOException
    {
        String requestParameter = (String)params.get("REQUEST");
            
        if (requestParameter == null || requestParameter.equals(""))
            throw new IOException("The wms request parameter was null.");
        
        if (requestParameter.equalsIgnoreCase("GetCapabilities"))
            return new OgcWmsGetCapabilitiesRequest(params);
        
        if (requestParameter.equalsIgnoreCase("GetMap"))
            return new OgcWmsGetMapRequest(params);
        
        if (requestParameter.equalsIgnoreCase("GetFeatureInfo"))
            return new OgcWmsGetFeatureInfoRequest(params);
        
        if (requestParameter.equalsIgnoreCase("DescribeLayer"))
            return new OgcWmsDescribeLayerRequest(params);
        
        throw new IOException("No wms request object could be created from the request parameter '" + requestParameter + "'");
    }
}
