package org.geospeed.test.wms;

import java.util.HashMap;
import java.util.Map;

import org.geospeed.api.IOgcResponse;
import org.geospeed.impl.wms.OgcWebMappingService;


public class SmokeTest 
{
	public final void testWmsGetCapabilitiesRequest()
	{
		Map<String, String> params = new HashMap<String, String>();
		
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
		Map<String, String> params = new HashMap<String, String>();
		
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
		Map<String, String> params = new HashMap<String, String>();
		
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
	    Map<String, String> params = new HashMap<String, String>();
		
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
