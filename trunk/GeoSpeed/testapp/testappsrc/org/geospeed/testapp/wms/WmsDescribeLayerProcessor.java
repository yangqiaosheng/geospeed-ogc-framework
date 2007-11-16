package org.geospeed.testapp.wms;

import org.geospeed.api.IOgcRequest;
import org.geospeed.api.IOgcRequestProcessor;
import org.geospeed.api.IOgcResponse;
import org.geospeed.impl.OgcResponse;
import org.geospeed.keys.ContentTypeKey;
import org.geospeed.keys.OgcProcessorsKey;

public class WmsDescribeLayerProcessor implements IOgcRequestProcessor
{

    @Override
	public OgcProcessorsKey getProcessorType()
	{
		return OgcProcessorsKey.WMSDESCRIBELAYER;
	}

	public IOgcResponse processRequest(IOgcRequest request)
    {
        return new OgcResponse("WmsDescribeLayerProcessor created successfully.".getBytes(), ContentTypeKey.TEXT_PLAIN.name());
    }

}
