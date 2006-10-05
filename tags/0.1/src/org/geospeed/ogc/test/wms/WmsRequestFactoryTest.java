package org.geospeed.ogc.test.wms;

import org.geospeed.ogc.api.IOgcMap;
import org.geospeed.ogc.api.wms.IOgcWmsDescribeLayerRequest;
import org.geospeed.ogc.api.wms.IOgcWmsGetCapabilitiesRequest;
import org.geospeed.ogc.api.wms.IOgcWmsGetFeatureInfoRequest;
import org.geospeed.ogc.api.wms.IOgcWmsGetMapRequest;
import org.geospeed.ogc.api.wms.factory.OgcWmsRequestFactory;
import org.geospeed.ogc.impl.OgcHashMap;

import junit.framework.TestCase;


public class WmsRequestFactoryTest extends TestCase
{
    private final String GETCAPABILITIES = "GetCapabilities";
    private final String GETMAP = "GetMap";
    private final String GETFEATUREINFO = "GetFeatureInfo";
    private final String DESCRIBELAYER = "DescribeLayer";
    
    public static void main(String[] args)
    {
        junit.textui.TestRunner.run(WmsRequestFactoryTest.class);
    }

    public final void testCreateWmsGetCapabilitiesRequest() throws Exception
    {
        IOgcMap params = new OgcHashMap();
        
        params.put("REQUEST", GETCAPABILITIES);
        params.put("VERSION", "1.3.0");
        params.put("SERVICE", "WMS");
        params.put("UPDATESEQUENCE", "0");

        IOgcWmsGetCapabilitiesRequest wmsRequest = (IOgcWmsGetCapabilitiesRequest)OgcWmsRequestFactory.createWmsRequest(params);
   
        assertEquals(wmsRequest.getClass().toString(), "class com.fgm.jp.ogc.impl.wms.request.OgcWmsGetCapabilitiesRequest");
        assertEquals(wmsRequest.getRequest(), GETCAPABILITIES);
        assertEquals(wmsRequest.getVersion(), "1.3.0");
        assertEquals(wmsRequest.getService(), "WMS");
        assertEquals(wmsRequest.getUpdateSequence(), "0");
    }

    public final void testCreateWmsGetMapRequest() throws Exception
    {
        IOgcMap params = new OgcHashMap();
        
        params.put("REQUEST", GETMAP);
        params.put("VERSION", "1.3.0");
        params.put("LAYERS", "layer1,layer2,layer3,layer4");
        params.put("STYLES", "style1,style2");
        params.put("SLD", "<sld>woot</sld>");
        params.put("CRS", "epsg:4326");
        params.put("BBOX", "-180.0,-90.0,180.0,90.0");
        params.put("WIDTH", "640");
        params.put("HEIGHT", "480");
        params.put("FORMAT", "PNG");
        params.put("TRANSPARENT", "true");
        params.put("BGCOLOR", "#000000");
        params.put("EXCEPTIONS", "XML");
        params.put("ELEVATION", "0");
        params.put("TIME", "2006-02-10");
        
        IOgcWmsGetMapRequest wmsRequest = (IOgcWmsGetMapRequest)OgcWmsRequestFactory.createWmsRequest(params);
        assertEquals(wmsRequest.getClass().toString(), "class com.fgm.jp.ogc.impl.wms.request.OgcWmsGetMapRequest");
        assertEquals(wmsRequest.getRequest(), GETMAP);
        assertEquals(wmsRequest.getVersion(), "1.3.0");
        assertTrue(wmsRequest.getLayers().size() == 4);
        assertTrue(wmsRequest.getStyles().size() == 2);
        assertEquals(wmsRequest.getSLD(), "<sld>woot</sld>");
        assertEquals(wmsRequest.getCRS(), "epsg:4326");
        assertTrue(wmsRequest.getMinX() == -180.0);
        assertTrue(wmsRequest.getMinY() == -90.0);
        assertTrue(wmsRequest.getMaxX() == 180.0);
        assertTrue(wmsRequest.getMaxY() == 90.0);
        assertTrue(wmsRequest.getWidth() == 640);
        assertTrue(wmsRequest.getHeight() == 480);
        assertEquals(wmsRequest.getFormat(), "PNG");
        assertTrue(wmsRequest.getTransparent());
        assertEquals(wmsRequest.getBackgroundColor(), "#000000");
        assertEquals(wmsRequest.getExceptionFormat(), "XML");
        assertTrue(wmsRequest.getElevation() == 0);
        assertEquals(wmsRequest.getTime(), "2006-02-10");
    }

    public final void testCreateWmsGetFeatureInfoRequest() throws Exception
    {
        IOgcMap params = new OgcHashMap();
        
        params.put("REQUEST", GETFEATUREINFO);
        params.put("VERSION", "1.3.0");
        params.put("SERVICE", "WMS");
        params.put("QUERY_LAYERS", "layera, layerb");
        params.put("INFO_FORMAT", "XML");
        params.put("FEATURE_COUNT", "100");
        params.put("I", "75.0");
        params.put("J", "55.5");
        params.put("EXCEPTIONS", "XML");
        
        IOgcWmsGetFeatureInfoRequest wmsRequest = (IOgcWmsGetFeatureInfoRequest)OgcWmsRequestFactory.createWmsRequest(params);
        
        assertEquals(wmsRequest.getRequest(), GETFEATUREINFO);
        assertEquals(wmsRequest.getVersion(), "1.3.0");
        assertEquals(wmsRequest.getService(), "WMS");
        assertEquals(wmsRequest.getQueryLayers().size(), 2);
        assertEquals(wmsRequest.getInfoFormat(), "XML");
        assertEquals(wmsRequest.getFeatureCount(), "100");
        assertEquals(wmsRequest.getI(), "75.0");
        assertEquals(wmsRequest.getJ(), "55.5");
        assertEquals(wmsRequest.getExceptions(), "XML");
        
    }
    
    public final void testCreateWmsDescribeLayerRequest() throws Exception
    {
        IOgcMap params = new OgcHashMap();
        
        params.put("REQUEST", DESCRIBELAYER);
        params.put("VERSION", "1.3.0");
        params.put("SERVICE", "WMS");
        params.put("LAYER", "layer1, layer3, layer2");
        
        IOgcWmsDescribeLayerRequest wmsRequest = (IOgcWmsDescribeLayerRequest)OgcWmsRequestFactory.createWmsRequest(params);
        
        assertEquals(wmsRequest.getRequest(), DESCRIBELAYER);
        assertEquals(wmsRequest.getVersion(), "1.3.0");
        assertEquals(wmsRequest.getService(), "WMS");
        assertEquals(wmsRequest.getLayers().size(), 3);
    }
}
