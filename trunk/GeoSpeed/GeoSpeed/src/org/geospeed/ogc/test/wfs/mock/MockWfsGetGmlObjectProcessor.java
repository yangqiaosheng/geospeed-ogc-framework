package org.geospeed.ogc.test.wfs.mock;

import org.geospeed.ogc.api.IOgcRequest;
import org.geospeed.ogc.api.IOgcRequestProcessor;
import org.geospeed.ogc.api.IOgcResponse;
import org.geospeed.ogc.api.wfs.IOgcWfsRequest;
import org.geospeed.ogc.impl.OgcResponse;


public class MockWfsGetGmlObjectProcessor implements IOgcRequestProcessor
{
    public IOgcResponse processRequest(IOgcRequest request)
    {
        IOgcWfsRequest req = (IOgcWfsRequest)request;
        OgcResponse res = new OgcResponse();
        res.setResponseType(req.getRequest());
        return res;
    }
}
