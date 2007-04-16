package org.geospeed.testapp.wms;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.geospeed.api.IOgcRequest;
import org.geospeed.api.IOgcRequestProcessor;
import org.geospeed.api.IOgcResponse;
import org.geospeed.api.wms.IOgcWmsGetMapRequest;
import org.geospeed.impl.OgcResponse;
import org.geospeed.keys.ContentTypeKey;

public class WmsGetMapProcessor implements IOgcRequestProcessor
{

    public IOgcResponse processRequest(IOgcRequest request)
    {
        IOgcWmsGetMapRequest wmsRequest = (IOgcWmsGetMapRequest)request;
        
        List<String> layers = wmsRequest.getLayers();
        
        boolean show = false;
        
        for (String layerName : layers)
        {
            if (layerName.equals("red_check"))
                show = true;
        }
        
        if (show)
        {
            String file = "wms";
            String postfix;
            
            if (wmsRequest.getFormat().equals(ContentTypeKey.IMAGE_GIF.name()))
                postfix = ".gif";
            else if (wmsRequest.getFormat().equals(ContentTypeKey.IMAGE_JPEG.name()))
                postfix = ".jpg";
            else //if (wmsRequest.getFormat().equals(ContentTypeKey.IMAGE_PNG.name()))
                postfix = ".png";
            
            file = file + postfix;
            
            List<Byte> b = new ArrayList<Byte>();
            byte[] img = new byte[1];
            
            try
            {
                InputStream is = this.getClass().getClassLoader().getResourceAsStream(file);
                int in;
                
                while ((in = is.read()) >= 0)
                {
                    b.add(new Byte((byte)in));
                    
                }
                
                img = new byte[b.size()];
                
                for (int i = 0; i < b.size(); i++)
                {
                    img[i] = ((Byte)b.get(i)).byteValue();
                }
                
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.err.println("Could not find or read the image file!");
            }
            
            OgcResponse res = new OgcResponse();
            res.setContentType(wmsRequest.getFormat());
            res.setData(img);
    
            return res;
        }
        
        return new OgcResponse();
    }
}
