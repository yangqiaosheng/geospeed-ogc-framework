package org.geospeed.ogc.impl.wms;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.IOgcRequestProcessor;
import org.geospeed.ogc.api.IOgcResponse;
import org.geospeed.ogc.api.IOgcService;
import org.geospeed.ogc.api.wms.IOgcWmsRequest;
import org.geospeed.ogc.api.wms.factory.OgcWmsRequestFactory;
import org.geospeed.ogc.api.wms.factory.OgcWmsRequestProcessorFactory;
import org.geospeed.ogc.impl.OgcResponse;


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
    Logger log = Logger.getLogger(OgcWebMappingService.class);
    
	public IOgcResponse executeRequest(IOgcMap params)
	{
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
            wmsRequest = (IOgcWmsRequest)OgcWmsRequestFactory.createWmsRequest(params);    
        }
        catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
        
        if (wmsRequest == null)
            return new OgcResponse();
        
        /*
         * Create an IOgcRequestProcessor object based on the value of the REQUEST entry
         * in the IOgcWmsRequest object.
         */
        IOgcRequestProcessor processor = null;
        OgcWmsRequestProcessorFactory processorFactory = OgcWmsRequestProcessorFactory.getInstance(); 
        
        try
        {
            processor = processorFactory.createProcessor(wmsRequest.getRequest());
        }
        catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
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
                 wmsResponse = processor.processRequest(wmsRequest);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
            wmsResponse = new OgcResponse();
        
        return wmsResponse;
    }
}
