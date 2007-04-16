package org.geospeed.testapp.wms;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;

import org.geospeed.api.IOgcRequest;
import org.geospeed.api.IOgcRequestProcessor;
import org.geospeed.api.IOgcResponse;
import org.geospeed.api.wms.IOgcWmsGetCapabilitiesRequest;
import org.geospeed.impl.OgcResponse;
import org.geospeed.keys.ContentTypeKey;
import org.geospeed.keys.WebMappingServiceKey;

public class WmsGetCapabilitiesProcessor implements IOgcRequestProcessor
{

    public IOgcResponse processRequest(IOgcRequest request)
    {
        IOgcWmsGetCapabilitiesRequest wmsRequest = (IOgcWmsGetCapabilitiesRequest)request;
        
        String file;
        String prefix = "wms_capabilities_";
        
        if (wmsRequest.getVersion().equals(WebMappingServiceKey.V1_0.name())
                || wmsRequest.getVersion().equals(WebMappingServiceKey.V1_0_0.name()))
            file = prefix + "1_0_0.xml";
        else if (wmsRequest.getVersion().equals(WebMappingServiceKey.V1_1_0.name()))
            file = prefix + "1_1_0.xml";
        else if (wmsRequest.getVersion().equals(WebMappingServiceKey.V1_1_1.name()))
            file = prefix + "1_1_1.xml";
        else //(wmsRequest.getVersion().equals(WebMappingServiceKey.V1_3_0.name()))
            file = prefix + "1_3_0.xml";
        
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
            System.err.println("Couldn't find the WMS capabilities file!");
        }
        
        OgcResponse res = new OgcResponse();
        
        res.setContentType(ContentTypeKey.TEXT_XML.name());
        res.setData(xml.toString().getBytes());
        
        return res;
    }
}
