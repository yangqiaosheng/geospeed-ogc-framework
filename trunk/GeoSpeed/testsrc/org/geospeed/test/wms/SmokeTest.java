package org.geospeed.test.wms;

import java.util.HashMap;
import java.util.Map;

import org.geospeed.api.IOgcResponse;
import org.geospeed.impl.wms.OgcWebMappingService;
import org.geospeed.keys.WebMappingServiceKey;


public class SmokeTest 
{
	public final void testWmsGetCapabilitiesRequest()
	{
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("REQUEST", WebMappingServiceKey.GETCAPABILITIES.name());
		
		OgcWebMappingService wms = new OgcWebMappingService();
		
		IOgcResponse ogcRes = wms.executeRequest(params);
		
		if (!ogcRes.getResponseType().equals(WebMappingServiceKey.GETCAPABILITIES.name()))
            System.err.println("!!!!!!! -- GetCapabilities (WMS) processor NOT FOUND!!!!!");
		else
			System.out.println("GetCapabilities (WMS) processor found");
	}

	public final void testWmsGetMapRequest()
	{
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("REQUEST", WebMappingServiceKey.GETMAP.name());
		
		OgcWebMappingService wms = new OgcWebMappingService();
		
		IOgcResponse ogcRes = wms.executeRequest(params);
		
		if (!ogcRes.getResponseType().equals(WebMappingServiceKey.GETMAP.name()))
            System.err.println("!!!!!!! -- GetMap processor NOT FOUND!!!!!");
		else
			System.out.println("GetMap processor found");	
	}
	
	public final void testWmsGetFeatureInfoRequest()
	{
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("REQUEST", WebMappingServiceKey.GETFEATUREINFO.name());
		
		OgcWebMappingService wms = new OgcWebMappingService();
		
		IOgcResponse ogcRes = wms.executeRequest(params);
		
		if (!ogcRes.getResponseType().equals(WebMappingServiceKey.GETFEATUREINFO.name()))
            System.err.println("!!!!!!! -- GetFeatureInfo processor NOT FOUND!!!!!");
		else
			System.out.println("GetFeatureInfo processor found");	
	}
	
	public final void testWmsDescribeLayerRequest()
	{
	    Map<String, String> params = new HashMap<String, String>();
		
		params.put("REQUEST", WebMappingServiceKey.DESCRIBELAYER.name());
		
		OgcWebMappingService wms = new OgcWebMappingService();
		
		IOgcResponse ogcRes = wms.executeRequest(params);
		
		if (!ogcRes.getResponseType().equals(WebMappingServiceKey.DESCRIBELAYER.name()))
            System.err.println("!!!!!!! -- DescribeLayer processor NOT FOUND!!!!!");
		else
			System.out.println("DescribeLayer processor found");
	}
	
    public final void testWmsGetLegendGraphicRequest()
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("REQUEST", WebMappingServiceKey.GETLEGENDGRAPHIC.name());
        
        OgcWebMappingService wms = new OgcWebMappingService();
        
        IOgcResponse ogcRes = wms.executeRequest(params);
        
        if (!ogcRes.getResponseType().equals(WebMappingServiceKey.GETLEGENDGRAPHIC.name()))
            System.err.println("!!!!!!! -- GetLegendGraphic processor NOT FOUND!!!!!");
        else
            System.out.println("getLegendGraphic processor found");
        
    }
    
    public final void testWmsGetStylesRequest()
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("REQUEST", WebMappingServiceKey.GETSYTLES.name());
        
        OgcWebMappingService wms = new OgcWebMappingService();
        
        IOgcResponse ogcRes = wms.executeRequest(params);
        
        if (!ogcRes.getResponseType().equals(WebMappingServiceKey.GETSYTLES.name()))
            System.err.println("!!!!!!! -- GetStyles processor NOT FOUND!!!!!");
        else
            System.out.println("GetStyles processor found");
    }
    
    public final void testWmsPutStylesRequest()
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("REQUEST", WebMappingServiceKey.PUTSTYLES.name());
        
        OgcWebMappingService wms = new OgcWebMappingService();
        
        IOgcResponse ogcRes = wms.executeRequest(params);
        
        if (!ogcRes.getResponseType().equals(WebMappingServiceKey.PUTSTYLES.name()))
            System.err.println("!!!!!!! -- PutStyles processor NOT FOUND!!!!!");
        else
            System.out.println("PutStyles processor found");
    }
    
	public static void main(String[] args)
	{
		SmokeTest test = new SmokeTest();
		
		test.testWmsGetCapabilitiesRequest();
		test.testWmsGetMapRequest();
		test.testWmsGetFeatureInfoRequest();
		test.testWmsDescribeLayerRequest();
        test.testWmsGetLegendGraphicRequest();
        test.testWmsGetStylesRequest();
        test.testWmsPutStylesRequest();
	}

}
