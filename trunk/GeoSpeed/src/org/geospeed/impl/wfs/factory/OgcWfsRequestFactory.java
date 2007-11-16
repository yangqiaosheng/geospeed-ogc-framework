package org.geospeed.impl.wfs.factory;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.geospeed.api.IOgcRequest;
import org.geospeed.impl.wfs.request.OgcWfsGetCapabilitiesRequest;
import org.geospeed.keys.OgcRequestKey;
import org.geospeed.keys.WebFeatureServiceKey;


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
public class OgcWfsRequestFactory 
{
    private static Logger log = Logger.getLogger(OgcWfsRequestFactory.class);
    
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
	public static IOgcRequest createWfsRequest(Map<String, String> params) throws IOException
    {
        log.debug("Entering createWfsRequest(IOgcMap).");

        log.debug("Looking up the '" + OgcRequestKey.REQUEST.name() + "' parameter.");
        String requestParameter = (String)params.get(OgcRequestKey.REQUEST.name());
        log.debug("The '" + OgcRequestKey.REQUEST.name() + "' parameter value is '" + requestParameter + "'.");
        
        if (requestParameter == null || requestParameter.equals(""))
        {
            StringBuffer msg = new StringBuffer("The " + OgcRequestKey.REQUEST.name() + " parameter was null.");
            log.error(msg.toString());
            throw new IOException(msg.toString());
        }

        if (requestParameter.equalsIgnoreCase(WebFeatureServiceKey.GETCAPABILITIES.name()))
        {
            log.debug("Exiting createWfsRequest(Map).  Returning an IOgcWfsGetCapabilitiesRequest");
            return new OgcWfsGetCapabilitiesRequest(params);
        }
        
        String msg = "No IOgcWfsRequest object could be created from the REQUEST parameter '" + requestParameter + "'. "; 
        log.error(msg);
        log.debug("Exiting createWmsRequest(Map).");
        throw new IOException(msg);
    }
}
