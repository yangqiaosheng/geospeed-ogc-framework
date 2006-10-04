package org.geospeed.ogc.impl.wcs;

import java.io.IOException;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.IOgcRequestProcessor;
import org.geospeed.ogc.api.IOgcResponse;
import org.geospeed.ogc.api.IOgcService;
import org.geospeed.ogc.api.wcs.IOgcWcsRequest;
import org.geospeed.ogc.api.wcs.factory.OgcWcsRequestFactory;
import org.geospeed.ogc.api.wcs.factory.OgcWcsRequestProcessorFactory;
import org.geospeed.ogc.impl.OgcResponse;

public class OgcWebCoverageService implements IOgcService
{
    public IOgcResponse executeRequest(IOgcMap params)
    {
        IOgcWcsRequest wcsRequest = null;
        
        try
        {
            wcsRequest = (IOgcWcsRequest)OgcWcsRequestFactory.createWcsRequest(params);    
        }
        catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
        
        //Create a processor to create the appropriate response content based on the request type
        IOgcRequestProcessor processor = null;
        OgcWcsRequestProcessorFactory processorFactory = OgcWcsRequestProcessorFactory.getInstance(); 
        
        try
        {
            processor = processorFactory.createProcessor(wcsRequest.getRequest());
        }
        catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
        
        //Process the request
        IOgcResponse wcsResponse = null;
        
        if (processor != null)
        {
            try
            {
                 wcsResponse = processor.processRequest(wcsRequest);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
            wcsResponse = new OgcResponse();
        
        return wcsResponse;
    }
}