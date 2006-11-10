package org.geospeed.ogc.impl.wms.xmlresponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.geospeed.ogc.api.IOgcContentType;
import org.geospeed.ogc.impl.OgcResponse;

public class StaticFileCapabilitiesResponse extends OgcResponse
{
    public StaticFileCapabilitiesResponse(File capabilitiesFile) throws FileNotFoundException, IOException
    {
        if (!capabilitiesFile.exists())
            throw new FileNotFoundException("Could not locate the file '" + capabilitiesFile.getAbsolutePath() + "'.");
     
        BufferedReader br = new BufferedReader(new FileReader(capabilitiesFile));
        
        StringBuffer buffer = new StringBuffer();
        String str;
        
        while ((str = br.readLine()) != null)
            buffer.append(str);
        
        super.setContentType(IOgcContentType.XML);
        super.setData(buffer.toString().getBytes());
    }
    
    
}
