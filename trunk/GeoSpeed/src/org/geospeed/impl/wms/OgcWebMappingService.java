package org.geospeed.impl.wms;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.geospeed.api.IOgcRequestProcessor;
import org.geospeed.api.IOgcResponse;
import org.geospeed.api.IOgcService;
import org.geospeed.api.wms.IOgcWmsRequest;
import org.geospeed.impl.OgcResponse;
import org.geospeed.impl.wms.factory.OgcWmsRequestFactory;
import org.geospeed.impl.wms.factory.OgcWmsRequestProcessorFactory;
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
public class OgcWebMappingService implements IOgcService 
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
		IOgcWmsRequest wmsRequest = null;
        
        try
        {
            log.debug("Attempting to create an IOgcWmsRequest from the specified parameters.");
            wmsRequest = (IOgcWmsRequest)OgcWmsRequestFactory.createWmsRequest(params);    
            log.debug("Successfully created an IOgcWmsRequest from the specified parameters.");
        }
        catch (IOException ioe)
        {
            String msg = "Caught an IOException while trying to create the IOgcWmsRequest from the specified parameters. ";
            
            log.error(msg);
            ioe.printStackTrace();
            return new OgcResponse((msg + ioe.getLocalizedMessage()).getBytes(), ContentTypeKey.TEXT_PLAIN.name());
        }
        
        if (wmsRequest == null)
        {
            String msg = "An IOgcWmsRequest could not be created from the specified parameters. ";
            log.error(msg);
            return new OgcResponse(msg.getBytes(), ContentTypeKey.TEXT_PLAIN.name());
        }
        
        /*
         * Create an IOgcRequestProcessor object based on the value of the REQUEST entry
         * in the IOgcWmsRequest object.
         */
        IOgcRequestProcessor processor = null;
        OgcWmsRequestProcessorFactory processorFactory = OgcWmsRequestProcessorFactory.getInstance(); 
        
        try
        {
            log.debug("Attempting to create an IOgcRequestProcessor from the IOgcWmsRequest.");
            processor = processorFactory.createProcessor(wmsRequest.getRequest());
            log.debug("Successfully created an IOgcRequestProcessor from the IOgcWmsRequest.");
        }
        catch (IOException ioe)
        {
            String msg = "Caught an IOException while trying to create an IOgcRequestProcessor for the REQUEST parameter '" + wmsRequest.getRequest() + "'. "; 
            log.error(msg);
            ioe.printStackTrace();
            return new OgcResponse((msg + ioe.getLocalizedMessage()).getBytes(), ContentTypeKey.TEXT_PLAIN.name());
        }
        
        /*
         * Process the request using the IOgcRequestProcessor and the IOgcWmsRequest
         * created above.  The processor will return an IOgcResponse object that contains
         * the data to be returned to the caller.  This data should be in the proper format
         * for the type of request being processed.  For instance, a GetCapabilities request 
         * should return an xml file.  A GetMap request should return a type of image.  Etc.
         */
        IOgcResponse wmsResponse = null;
        
        if (processor != null)
        {
            try
            {
                log.debug("Attempting to process the IOgcWmsRequest.");
                wmsResponse = processor.processRequest(wmsRequest);
                log.debug("Successfully processed the IOgcWmsRequest.");
            }
            catch (Exception e)
            {
                String msg = "An error occured while processing the IOgcWmsRequest. ";
                log.error(msg);
                e.printStackTrace();
                return new OgcResponse((msg + e.getLocalizedMessage()).getBytes());
            }
        }
        else
        {
            String msg = "An IOgcRequestProcessor could not be created from the REQUEST paramenter '" + wmsRequest.getRequest() + "'. ";
            log.error(msg);
            wmsResponse = new OgcResponse(msg.getBytes(), ContentTypeKey.TEXT_PLAIN.name());
        }
        
        log.debug("Exiting executeRequest(IOgcMap).");
        return wmsResponse;
    }
}
