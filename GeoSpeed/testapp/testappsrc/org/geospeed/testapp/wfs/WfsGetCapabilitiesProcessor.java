package org.geospeed.testapp.wfs;

import java.io.InputStream;

import org.geospeed.api.IOgcRequest;
import org.geospeed.api.IOgcRequestProcessor;
import org.geospeed.api.IOgcResponse;
import org.geospeed.api.wfs.IOgcWfsGetCapabilitiesRequest;
import org.geospeed.impl.OgcResponse;
import org.geospeed.keys.ContentTypeKey;
import org.geospeed.keys.OgcProcessorsKey;
import org.geospeed.keys.WebFeatureServiceKey;

public class WfsGetCapabilitiesProcessor implements IOgcRequestProcessor
{

    public IOgcResponse processRequest(IOgcRequest request)
    {
        IOgcWfsGetCapabilitiesRequest wfsRequest = (IOgcWfsGetCapabilitiesRequest)request;
        
        String file;
        String prefix = "wfs_capabilities_";
        
        if (wfsRequest.getVersion().equals(WebFeatureServiceKey.V1_0))
            file = prefix + "1_0.xml";
        else //if (wmsRequest.getVersion().equals(WebFeatureServiceKey.V1_1.name()))
            file = prefix + "1_1.xml";
        
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(file);
        
        StringBuffer xml = new StringBuffer();
        
        try
        {
            int in;
            
            while ((in = is.read()) >= 0)
            {
                xml.append((char)in);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println("Couldn't find the WFS capabilities file!");
        }
        
        OgcResponse res = new OgcResponse();
        
        res.setContentType(ContentTypeKey.TEXT_XML.name());
        res.setData(xml.toString().getBytes());
        
        return res;
    }

	public OgcProcessorsKey getProcessorType()
	{
		return OgcProcessorsKey.WFSGETCAPABILITIES;
	}
    
    
}
