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
            System.out.println(ioe.getMessage());
        }
        
        //Create a processor to create the appropriate response content based on the request type
        IOgcRequestProcessor processor = null;
        OgcWfsRequestProcessorFactory processorFactory = OgcWfsRequestProcessorFactory.getInstance(); 
        
        try
        {
            processor = processorFactory.createProcessor(wfsRequest.getRequest());
        }
        catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
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
                System.out.println(e.getMessage());
            }
        }
        else
            wfsResponse = new OgcResponse();
        
        return wfsResponse;
    }
}
