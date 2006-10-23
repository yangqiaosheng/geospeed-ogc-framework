package org.geospeed.ogc.test.wms.mock;

import org.geospeed.ogc.api.IOgcRequest;
import org.geospeed.ogc.api.IOgcRequestProcessor;
import org.geospeed.ogc.api.IOgcResponse;
import org.geospeed.ogc.api.wms.IOgcWmsRequest;
import org.geospeed.ogc.impl.OgcResponse;


public class MockWmsGetFeatureInfoProcessor implements IOgcRequestProcessor 
{
	public IOgcResponse processRequest(IOgcRequest request) 
	{
		IOgcWmsRequest req = (IOgcWmsRequest)request;
		OgcResponse res = new OgcResponse();
		res.setContentType(req.getRequest());
		return res;
	}
}
