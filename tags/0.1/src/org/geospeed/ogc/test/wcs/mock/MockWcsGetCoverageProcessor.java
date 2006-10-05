package org.geospeed.ogc.test.wcs.mock;

import org.geospeed.ogc.api.IOgcRequest;
import org.geospeed.ogc.api.IOgcRequestProcessor;
import org.geospeed.ogc.api.IOgcResponse;
import org.geospeed.ogc.api.wcs.IOgcWcsRequest;
import org.geospeed.ogc.impl.OgcResponse;


public class MockWcsGetCoverageProcessor implements IOgcRequestProcessor
{
    public IOgcResponse processRequest(IOgcRequest request)
    {
        IOgcWcsRequest req = (IOgcWcsRequest)request;
        OgcResponse res = new OgcResponse();
        res.setResponseType(req.getRequest());
        return res;
    }
}
