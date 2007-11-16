package org.geospeed.impl.wfs;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.geospeed.api.IOgcRequestProcessor;
import org.geospeed.api.IOgcResponse;
import org.geospeed.api.IOgcService;
import org.geospeed.api.wfs.IOgcWfsRequest;
import org.geospeed.impl.OgcResponse;
import org.geospeed.impl.wfs.factory.OgcWfsRequestFactory;
import org.geospeed.impl.wfs.factory.OgcWfsRequestProcessorFactory;
import org.geospeed.keys.ContentTypeKey;

/**
 * This class is the entry point for the WMS.  It uses the parameters
 * passed to it to create the appropriate IOgcWmsRequest object, gets
 * the appropriate IOgcRequestProcessor to use to process the request, 
 * and then instructs the processor to do its thing with the request, 
 * after which it simply returns the response generated in the processor
 * object to the caller for handling.
 *  
 * @author Mike Abner
 *
 */
public class OgcWebFeatureService implements IOgcService 
{
    private Logger log = Logger.getLogger(this.getClass());
    
	public IOgcResponse executeRequest(Map<String, String> params)
	{
        log.debug("Entering executeRequest(IOgcMap).");
        /*
         * Create an IOgcWmsRequest object based on the REQUEST
         * entry in the params Map.  When REQUEST == GetCapabilities, the
         * IOgcWmsRequest will actually contain an IOgcWmsGetCapabilitiesRequest.
         * Likewise, when REQUEST == GetMap, the IOgcWmsRequest will actually contain
         * and IOgcWmsGetMapRequest.  Each IOgcRequestProcessor should then 
         * cast the passed in IOgcWmsRequest object to the appropriate type for
         * that processor to have access to all of the fields necessary to perform
         * its functions.
         */
		IOgcWfsRequest wfsRequest = null;
        
        try
        {
            log.debug("Attempting to create an IOgcWfsRequest from the specified parameters.");
            wfsRequest = (IOgcWfsRequest)OgcWfsRequestFactory.createWfsRequest(params);    
            log.debug("Successfully created an IOgcWfsRequest from the specified parameters.");
        }
        catch (IOException ioe)
        {
            String msg = "Caught an IOException while trying to create the IOgcWfsRequest from the specified parameters. ";
            
            log.error(msg);
            ioe.printStackTrace();
            return new OgcResponse((msg + ioe.getLocalizedMessage()).getBytes(), ContentTypeKey.TEXT_PLAIN.name());
        }
        
        if (wfsRequest == null)
        {
            String msg = "An IOgcWfsRequest could not be created from the specified parameters. ";
            log.error(msg);
            return new OgcResponse(msg.getBytes(), ContentTypeKey.TEXT_PLAIN.name());
        }
        
        /*
         * Create an IOgcRequestProcessor object based on the value of the REQUEST entry
         * in the IOgcWfsRequest object.
         */
        IOgcRequestProcessor processor = null;
        OgcWfsRequestProcessorFactory processorFactory = OgcWfsRequestProcessorFactory.getInstance(); 
        
        try
        {
            log.debug("Attempting to create an IOgcRequestProcessor from the IOgcWfsRequest.");
            processor = processorFactory.createProcessor(wfsRequest.getRequest());
            log.debug("Successfully created an IOgcRequestProcessor from the IOgcWfsRequest.");
        }
        catch (IOException ioe)
        {
            String msg = "Caught an IOException while trying to create an IOgcRequestProcessor for the REQUEST parameter '" + wfsRequest.getRequest() + "'. "; 
            log.error(msg);
            ioe.printStackTrace();
            return new OgcResponse((msg + ioe.getLocalizedMessage()).getBytes(), ContentTypeKey.TEXT_PLAIN.name());
        }
        
        /*
         * Process the request using the IOgcRequestProcessor and the IOgcWfsRequest
         * created above.  The processor will return an IOgcResponse object that contains
         * the data to be returned to the caller.  This data should be in the proper format
         * for the type of request being processed.  For instance, a GetCapabilities request 
         * should return an xml file.  A GetMap request should return a type of image.  Etc.
         */
        IOgcResponse wfsResponse = null;
        
        if (processor != null)
        {
            try
            {
                log.debug("Attempting to process the IOgcWfsRequest.");
                wfsResponse = processor.processRequest(wfsRequest);
                log.debug("Successfully processed the IOgcWfsRequest.");
            }
            catch (Exception e)
            {
                String msg = "An error occured while processing the IOgcWfsRequest. ";
                log.error(msg);
                e.printStackTrace();
                return new OgcResponse((msg + e.getLocalizedMessage()).getBytes());
            }
        }
        else
        {
            String msg = "An IOgcRequestProcessor could not be created from the REQUEST paramenter '" + wfsRequest.getRequest() + "'. ";
            log.error(msg);
            wfsResponse = new OgcResponse(msg.getBytes(), ContentTypeKey.TEXT_PLAIN.name());
        }
        
        log.debug("Exiting executeRequest(IOgcMap).");
        return wfsResponse;
    }
}
