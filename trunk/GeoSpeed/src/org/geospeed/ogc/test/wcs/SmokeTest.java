package org.geospeed.ogc.test.wcs;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.IOgcResponse;
import org.geospeed.ogc.impl.OgcHashMap;
import org.geospeed.ogc.impl.wcs.OgcWebCoverageService;


public class SmokeTest
{
    public final void testWcsGetCapabilitiesRequest()
    {
        IOgcMap params = new OgcHashMap();
        
        params.put("REQUEST", "GetCapabilities");
        
        OgcWebCoverageService wcs = new OgcWebCoverageService();
        
        IOgcResponse ogcRes = wcs.executeRequest(params);
        
        if (!ogcRes.getResponseType().equals("GetCapabilities"))
            System.out.println("!!!!!!! -- GetCapabilities (WCS) processor NOT FOUND!!!!!");
        else
            System.out.println("GetCapabilities (WCS) processor found");
    }

    public final void testWcsDescribeCoverageRequest()
    {
        IOgcMap params = new OgcHashMap();
        
        params.put("REQUEST", "DescribeCoverage");
        
        OgcWebCoverageService wcs = new OgcWebCoverageService();
        
        IOgcResponse ogcRes = wcs.executeRequest(params);
        
        if (!ogcRes.getResponseType().equals("DescribeCoverage"))
            System.out.println("!!!!!!! -- DescribeCoverage processor NOT FOUND!!!!!");
        else
            System.out.println("DescribeCoverage processor found");
    }
    
    public final void testWcsGetCoverageRequest()
    {
        IOgcMap params = new OgcHashMap();
        
        params.put("REQUEST", "GetCoverage");
        
        OgcWebCoverageService wcs = new OgcWebCoverageService();
        
        IOgcResponse ogcRes = wcs.executeRequest(params);
        
        if (!ogcRes.getResponseType().equals("GetCoverage"))
            System.out.println("!!!!!!! -- GetCoverage processor NOT FOUND!!!!!");
        else
            System.out.println("GetCoverage processor found");
    }
    
    public static void main(String[] args)
    {
        SmokeTest test = new SmokeTest();
        
        test.testWcsGetCapabilitiesRequest();
        test.testWcsDescribeCoverageRequest();
        test.testWcsGetCoverageRequest(); 
    }

}
