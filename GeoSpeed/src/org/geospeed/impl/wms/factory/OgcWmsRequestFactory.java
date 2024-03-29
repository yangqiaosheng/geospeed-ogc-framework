package org.geospeed.impl.wms.factory;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.geospeed.api.IOgcRequest;
import org.geospeed.impl.wms.request.OgcWmsDescribeLayerRequest;
import org.geospeed.impl.wms.request.OgcWmsGetCapabilitiesRequest;
import org.geospeed.impl.wms.request.OgcWmsGetFeatureInfoRequest;
import org.geospeed.impl.wms.request.OgcWmsGetLegendGraphicRequest;
import org.geospeed.impl.wms.request.OgcWmsGetMapRequest;
import org.geospeed.impl.wms.request.OgcWmsGetStylesRequest;
import org.geospeed.impl.wms.request.OgcWmsPutStylesRequest;
import org.geospeed.keys.OgcRequestKey;
import org.geospeed.keys.WebMappingServiceKey;


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
    private static Logger log = Logger.getLogger(OgcWmsRequestFactory.class);
    
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
	public static IOgcRequest createWmsRequest(Map<String, String> params) throws IOException
    {
        log.debug("Entering createWmsRequest(IOgcMap).");

        log.debug("Looking up the '" + OgcRequestKey.REQUEST.name() + "' parameter.");
        String requestParameter = (String)params.get(OgcRequestKey.REQUEST.name());
        log.debug("The '" + OgcRequestKey.REQUEST.name() + "' parameter value is '" + requestParameter + "'.");
        
        if (requestParameter == null || requestParameter.equals(""))
        {
            StringBuffer msg = new StringBuffer("The " + OgcRequestKey.REQUEST.name() + " parameter was null.");
            log.error(msg.toString());
            throw new IOException(msg.toString());
        }
        
        if (requestParameter.equalsIgnoreCase(WebMappingServiceKey.GETCAPABILITIES.name())
                || requestParameter.equalsIgnoreCase(WebMappingServiceKey.CAPABILITIES.name()))
        {
            log.debug("Exiting createWmsRequest(Map).  Returning an IOgcWmsGetCapabilitiesRequest");
            return new OgcWmsGetCapabilitiesRequest(params);
        }
        
        if (requestParameter.equalsIgnoreCase(WebMappingServiceKey.GETMAP.name())
                ||requestParameter.equalsIgnoreCase(WebMappingServiceKey.MAP.name()))
        {
            log.debug("Exiting createWmsRequest(Map).  Returning an IOgcWmsGetMapRequest.");
            return new OgcWmsGetMapRequest(params);
        }
        
        if (requestParameter.equalsIgnoreCase(WebMappingServiceKey.GETFEATUREINFO.name())
                || requestParameter.equalsIgnoreCase(WebMappingServiceKey.FEATUREINFO.name()))
        {
            log.debug("Exiting createWmsRequest(Map).  Returning an IOgcWmsGetFeatureInfoRequest.");
            return new OgcWmsGetFeatureInfoRequest(params);
        }
        
        if (requestParameter.equalsIgnoreCase(WebMappingServiceKey.DESCRIBELAYER.name()))
        {
            log.debug("Exiting createWmsRequest(Map).  Returning an IOgcWmsDescribeLayerRequest.");
            return new OgcWmsDescribeLayerRequest(params);
        }
        
        if (requestParameter.equalsIgnoreCase(WebMappingServiceKey.GETLEGENDGRAPHIC.name()))
        {
            log.debug("Exiting createWmsRequest(Map). Returning an IOgcWmsGetLegendGraphicRequest.");
            return new OgcWmsGetLegendGraphicRequest(params);
        }
        
        if (requestParameter.equalsIgnoreCase(WebMappingServiceKey.GETSYTLES.name()))
        {
            log.debug("Exiting createWmsRequest(Map). Returning an IOgcWmsGetStylesRequest.");
            return new OgcWmsGetStylesRequest(params);
        }
        
        if (requestParameter.equalsIgnoreCase(WebMappingServiceKey.PUTSTYLES.name()))
        {
            log.debug("Exiting createWmsRequest(Map). Returning an IOgcWmsPutStylesRequest.");
            return new OgcWmsPutStylesRequest(params);
        }
        
        String msg = "No IOgcWmsRequest object could be created from the REQUEST parameter '" + requestParameter + "'. "; 
        log.error(msg);
        log.debug("Exiting createWmsRequest(Map).");
        throw new IOException(msg);
    }
}
