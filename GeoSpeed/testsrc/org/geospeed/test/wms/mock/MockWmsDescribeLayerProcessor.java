package org.geospeed.test.wms.mock;

import org.geospeed.api.IOgcRequest;
import org.geospeed.api.IOgcRequestProcessor;
import org.geospeed.api.IOgcResponse;
import org.geospeed.api.wms.IOgcWmsRequest;
import org.geospeed.impl.OgcResponse;
import org.geospeed.keys.ContentTypeKey;
import org.geospeed.keys.WebMappingServiceKey;

public class MockWmsDescribeLayerProcessor implements IOgcRequestProcessor
{

    public IOgcResponse processRequest(IOgcRequest request)
    {
        IOgcWmsRequest req = (IOgcWmsRequest)request;
        OgcResponse res = new OgcResponse();
        res.setContentType(ContentTypeKey.TEXT_XML.name());
        res.setResponseType(WebMappingServiceKey.DESCRIBELAYER.name());
        return res;
    }

}
