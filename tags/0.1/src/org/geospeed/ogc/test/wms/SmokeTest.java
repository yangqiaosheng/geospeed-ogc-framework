package org.geospeed.ogc.test.wms;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.IOgcResponse;
import org.geospeed.ogc.impl.OgcHashMap;
import org.geospeed.ogc.impl.wms.OgcWebMappingService;


public class SmokeTest 
{
	public final void testWmsGetCapabilitiesRequest()
	{
		IOgcMap params = new OgcHashMap();
		
		params.put("REQUEST", "GetCapabilities");
		
		OgcWebMappingService wms = new OgcWebMappingService();
		
		IOgcResponse ogcRes = wms.executeRequest(params);
		
		if (!ogcRes.getResponseType().equals("GetCapabilities"))
            System.out.println("!!!!!!! -- GetCapabilities (WMS) processor NOT FOUND!!!!!");
		else
			System.out.println("GetCapabilities (WMS) processor found");
	}

	public final void testWmsGetMapRequest()
	{
		IOgcMap params = new OgcHashMap();
		
		params.put("REQUEST", "GetMap");
		
		OgcWebMappingService wms = new OgcWebMappingService();
		
		IOgcResponse ogcRes = wms.executeRequest(params);
		
		if (!ogcRes.getResponseType().equals("GetMap"))
            System.out.println("!!!!!!! -- GetMap processor NOT FOUND!!!!!");
		else
			System.out.println("GetMap processor found");	
	}
	
	public final void testWmsGetFeatureInfoRequest()
	{
		IOgcMap params = new OgcHashMap();
		
		params.put("REQUEST", "GetFeatureInfo");
		
		OgcWebMappingService wms = new OgcWebMappingService();
		
		IOgcResponse ogcRes = wms.executeRequest(params);
		
		if (!ogcRes.getResponseType().equals("GetFeatureInfo"))
            System.out.println("!!!!!!! -- GetFeatureInfo processor NOT FOUND!!!!!");
		else
			System.out.println("GetFeatureInfo processor found");	
	}
	
	public final void testWmsDescribeLayerRequest()
	{
	    IOgcMap params = new OgcHashMap();
		
		params.put("REQUEST", "DescribeLayer");
		
		OgcWebMappingService wms = new OgcWebMappingService();
		
		IOgcResponse ogcRes = wms.executeRequest(params);
		
		if (!ogcRes.getResponseType().equals("DescribeLayer"))
            System.out.println("!!!!!!! -- DescribeLayer processor NOT FOUND!!!!!");
		else
			System.out.println("DescribeLayer processor found");
	}
	
	public static void main(String[] args)
	{
		SmokeTest test = new SmokeTest();
		
		test.testWmsGetCapabilitiesRequest();
		test.testWmsGetMapRequest();
		test.testWmsGetFeatureInfoRequest();
		test.testWmsDescribeLayerRequest();
	}

}
