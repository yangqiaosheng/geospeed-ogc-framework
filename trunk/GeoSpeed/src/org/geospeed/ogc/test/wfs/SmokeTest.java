package org.geospeed.ogc.test.wfs;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.IOgcResponse;
import org.geospeed.ogc.impl.OgcHashMap;
import org.geospeed.ogc.impl.wfs.OgcWebFeatureService;


public class SmokeTest
{
    public final void testWfsGetCapabilitiesRequest()
    {
        IOgcMap params = new OgcHashMap();
        
        params.put("REQUEST", "GetCapabilities");
        
        OgcWebFeatureService wfs = new OgcWebFeatureService();
        
        IOgcResponse ogcRes = wfs.executeRequest(params);
        
        if (!ogcRes.getResponseType().equals("GetCapabilities"))
            System.out.println("!!!!!!! -- GetCapabilities (WFS) processor NOT FOUND!!!!!");
        else
            System.out.println("GetCapabilities (WFS) processor found");
    }

    public final void testWfsDescribeFeatureTypeRequest()
    {
        IOgcMap params = new OgcHashMap();
        
        params.put("REQUEST", "DescribeFeatureType");
        
        OgcWebFeatureService wfs = new OgcWebFeatureService();
        
        IOgcResponse ogcRes = wfs.executeRequest(params);
        
        if (!ogcRes.getResponseType().equals("DescribeFeatureType"))
            System.out.println("!!!!!!! -- DescribeFeatureType processor NOT FOUND!!!!!");
        else
            System.out.println("DescribeFeatureType processor found");
    }
    
    public final void testWfsGetFeatureRequest()
    {
        IOgcMap params = new OgcHashMap();
        
        params.put("REQUEST", "GetFeature");
        
        OgcWebFeatureService wfs = new OgcWebFeatureService();
        
        IOgcResponse ogcRes = wfs.executeRequest(params);
        
        if (!ogcRes.getResponseType().equals("GetFeature"))
            System.out.println("!!!!!!! -- GetFeature processor NOT FOUND!!!!!");
        else
            System.out.println("GetFeature processor found");
    }
    
    public final void testWfsGetGmlObjectRequest()
    {
        IOgcMap params = new OgcHashMap();
        
        params.put("REQUEST", "GetGmlObject");
        
        OgcWebFeatureService wfs = new OgcWebFeatureService();
        
        IOgcResponse ogcRes = wfs.executeRequest(params);
        
        if (!ogcRes.getResponseType().equals("GetGmlObject"))
            System.out.println("!!!!!!! -- GetGmlObject processor NOT FOUND!!!!!");
        else
            System.out.println("GetGmlObject processor found");
    }
    
    public final void testWfsLockFeatureRequest()
    {
        IOgcMap params = new OgcHashMap();
        
        params.put("REQUEST", "LockFeature");
        
        OgcWebFeatureService wfs = new OgcWebFeatureService();
        
        IOgcResponse ogcRes = wfs.executeRequest(params);
        
        if (!ogcRes.getResponseType().equals("LockFeature"))
            System.out.println("!!!!!!! -- LockFeature processor NOT FOUND!!!!!");
        else
            System.out.println("LockFeature processor found");
    }
    
    public final void testWfsTransactionRequest()
    {
        IOgcMap params = new OgcHashMap();
        
        params.put("REQUEST", "Transaction");
        
        OgcWebFeatureService wfs = new OgcWebFeatureService();
        
        IOgcResponse ogcRes = wfs.executeRequest(params);
        
        if (!ogcRes.getResponseType().equals("Transaction"))
            System.out.println("!!!!!!! -- Transaction processor NOT FOUND!!!!!");
        else
            System.out.println("Transaction processor found");
    }
    
    public static void main(String[] args)
    {
        SmokeTest test = new SmokeTest();
        
        test.testWfsGetCapabilitiesRequest();
        test.testWfsDescribeFeatureTypeRequest();
        test.testWfsGetFeatureRequest();
        test.testWfsGetGmlObjectRequest();
        test.testWfsLockFeatureRequest();
        test.testWfsTransactionRequest(); 
    }

}
