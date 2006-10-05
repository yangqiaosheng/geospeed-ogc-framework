package org.geospeed.ogc.impl.wfs;

import java.io.IOException;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.IOgcRequestProcessor;
import org.geospeed.ogc.api.IOgcResponse;
import org.geospeed.ogc.api.IOgcService;
import org.geospeed.ogc.api.wfs.IOgcWfsRequest;
import org.geospeed.ogc.api.wfs.factory.OgcWfsRequestFactory;
import org.geospeed.ogc.api.wfs.factory.OgcWfsRequestProcessorFactory;
import org.geospeed.ogc.impl.OgcResponse;


public class OgcWebFeatureService implements IOgcService
{
    public IOgcResponse executeRequest(IOgcMap params)
    {
        IOgcWfsRequest wfsRequest = null;
        
        try
        {
            wfsRequest = (IOgcWfsRequest)OgcWfsRequestFactory.createWfsRequest(params);    
        }
        catch (IOException ioe)
        {
            return new OgcResponse(ioe.getLocalizedMessage().getBytes());
        }
        
        if (wfsRequest == null)
            return new OgcResponse("There was an error creating the WFS request object.".getBytes());
        
        //Create a processor to create the appropriate response content based on the request type
        IOgcRequestProcessor processor = null;
        OgcWfsRequestProcessorFactory processorFactory = OgcWfsRequestProcessorFactory.getInstance(); 
        
        try
        {
            processor = processorFactory.createProcessor(wfsRequest.getRequest());
        }
        catch (IOException ioe)
        {
            return new OgcResponse(ioe.getLocalizedMessage().getBytes());
        }
        
        //Process the request
        IOgcResponse wfsResponse = null;
        
        if (processor != null)
        {
            try
            {
                 wfsResponse = processor.processRequest(wfsRequest);
            }
            catch (Exception e)
            {
                return new OgcResponse(e.getLocalizedMessage().getBytes());
            }
        }
        else
            wfsResponse = new OgcResponse();
        
        return wfsResponse;
    }
}
