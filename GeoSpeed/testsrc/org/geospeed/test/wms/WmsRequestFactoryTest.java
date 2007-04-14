package org.geospeed.test.wms;


import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.geospeed.api.wms.IOgcWmsDescribeLayerRequest;
import org.geospeed.api.wms.IOgcWmsGetCapabilitiesRequest;
import org.geospeed.api.wms.IOgcWmsGetFeatureInfoRequest;
import org.geospeed.api.wms.IOgcWmsGetLegendGraphicRequest;
import org.geospeed.api.wms.IOgcWmsGetMapRequest;
import org.geospeed.api.wms.IOgcWmsGetStylesRequest;
import org.geospeed.api.wms.IOgcWmsPutStylesRequest;
import org.geospeed.impl.wms.factory.OgcWmsRequestFactory;
import org.geospeed.keys.ContentTypeKey;
import org.geospeed.keys.OgcRequestKey;
import org.geospeed.keys.WebMappingServiceKey;


public class WmsRequestFactoryTest extends TestCase
{
  
    public static void main(String[] args)
    {
        junit.textui.TestRunner.run(WmsRequestFactoryTest.class);
    }

    public final void testCreateWmsGetCapabilitiesRequest100() throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put(OgcRequestKey.REQUEST.name(), WebMappingServiceKey.CAPABILITIES.name());
        params.put(OgcRequestKey.WMTVER.name(), "1.0.0");
        params.put(WebMappingServiceKey.UPDATESEQUENCE.name(), "0");

        IOgcWmsGetCapabilitiesRequest wmsRequest = (IOgcWmsGetCapabilitiesRequest)OgcWmsRequestFactory.createWmsRequest(params);
   
        assertEquals(wmsRequest.getRequest(), WebMappingServiceKey.CAPABILITIES.name());
        assertEquals(wmsRequest.getVersion(), "1.0.0");
        assertTrue(wmsRequest.getService() == null || wmsRequest.getService().equals(""));
        assertEquals(wmsRequest.getUpdateSequence(), "0");
    }
    
    public final void testCreateWmsGetCapabilitiesRequest110() throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put(OgcRequestKey.REQUEST.name(), WebMappingServiceKey.GETCAPABILITIES.name());
        params.put(OgcRequestKey.VERSION.name(), "1.1.0");
        params.put(OgcRequestKey.SERVICE.name(), WebMappingServiceKey.SERVICE_NAME.name());
        params.put(WebMappingServiceKey.UPDATESEQUENCE.name(), "0");

        IOgcWmsGetCapabilitiesRequest wmsRequest = (IOgcWmsGetCapabilitiesRequest)OgcWmsRequestFactory.createWmsRequest(params);
   
        assertEquals(wmsRequest.getRequest(), WebMappingServiceKey.GETCAPABILITIES.name());
        assertEquals(wmsRequest.getVersion(), "1.1.0");
        assertEquals(wmsRequest.getService(), "WMS");
        assertEquals(wmsRequest.getUpdateSequence(), "0");
    }    
    
    public final void testCreateWmsGetCapabilitiesRequest111() throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put(OgcRequestKey.REQUEST.name(), WebMappingServiceKey.GETCAPABILITIES.name());
        params.put(OgcRequestKey.VERSION.name(), "1.1.1");
        params.put(OgcRequestKey.SERVICE.name(), WebMappingServiceKey.SERVICE_NAME.name());
        params.put(WebMappingServiceKey.UPDATESEQUENCE.name(), "0");

        IOgcWmsGetCapabilitiesRequest wmsRequest = (IOgcWmsGetCapabilitiesRequest)OgcWmsRequestFactory.createWmsRequest(params);
   
        assertEquals(wmsRequest.getRequest(), WebMappingServiceKey.GETCAPABILITIES.name());
        assertEquals(wmsRequest.getVersion(), "1.1.1");
        assertEquals(wmsRequest.getService(), "WMS");
        assertEquals(wmsRequest.getUpdateSequence(), "0");
    }
    
    public final void testCreateWmsGetCapabilitiesRequest130() throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put(OgcRequestKey.REQUEST.name(), WebMappingServiceKey.GETCAPABILITIES.name());
        params.put(OgcRequestKey.VERSION.name(), "1.3.0");
        params.put(OgcRequestKey.SERVICE.name(), WebMappingServiceKey.SERVICE_NAME.name());
        params.put(WebMappingServiceKey.FORMAT.name(), ContentTypeKey.TEXT_XML.name());
        params.put(WebMappingServiceKey.UPDATESEQUENCE.name(), "0");

        IOgcWmsGetCapabilitiesRequest wmsRequest = (IOgcWmsGetCapabilitiesRequest)OgcWmsRequestFactory.createWmsRequest(params);
   
        assertEquals(wmsRequest.getRequest(), WebMappingServiceKey.GETCAPABILITIES.name());
        assertEquals(wmsRequest.getVersion(), "1.3.0");
        assertEquals(wmsRequest.getService(), "WMS");
        assertEquals(wmsRequest.getFormat(), ContentTypeKey.TEXT_XML.name());
        assertEquals(wmsRequest.getUpdateSequence(), "0");
    }

    public final void testCreateWmsGetMapRequest100() throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("REQUEST", WebMappingServiceKey.MAP.name());
        params.put("WMTVER", "1.0.0");
        params.put("LAYERS", "layer1,layer2,layer3,layer4");
        params.put("STYLES", "style1,style2");
        params.put("SRS", "epsg:4326");
        params.put("BBOX", "-180.0,-90.0,180.0,90.0");
        params.put("WIDTH", "640");
        params.put("HEIGHT", "480");
        params.put("FORMAT", "PNG");
        params.put("TRANSPARENT", "true");
        params.put("BGCOLOR", "#000000");
        params.put("EXCEPTIONS", ContentTypeKey.TEXT_XML.name());
        
        IOgcWmsGetMapRequest wmsRequest = (IOgcWmsGetMapRequest)OgcWmsRequestFactory.createWmsRequest(params);
        
        assertEquals(wmsRequest.getRequest(), WebMappingServiceKey.MAP.name());
        assertEquals(wmsRequest.getVersion(), "1.0.0");
        assertTrue(wmsRequest.getLayers().size() == 4);
        assertTrue(wmsRequest.getStyles().size() == 2);
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
        assertEquals(wmsRequest.getExceptionFormat(), ContentTypeKey.TEXT_XML.name());
    }
    
    public final void testCreateWmsGetMapRequest110() throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("REQUEST", WebMappingServiceKey.GETMAP.name());
        params.put("VERSION", "1.1.0");
        params.put("LAYERS", "layer1,layer2,layer3,layer4");
        params.put("STYLES", "style1,style2");
        params.put("SRS", "epsg:4326");
        params.put("BBOX", "-180.0,-90.0,180.0,90.0");
        params.put("WIDTH", "640");
        params.put("HEIGHT", "480");
        params.put("FORMAT", "PNG");
        params.put("TRANSPARENT", "true");
        params.put("BGCOLOR", "#000000");
        params.put("EXCEPTIONS", ContentTypeKey.TEXT_XML.name());
        params.put("ELEVATION", "0");
        params.put("TIME", "2006-02-10");
        
        IOgcWmsGetMapRequest wmsRequest = (IOgcWmsGetMapRequest)OgcWmsRequestFactory.createWmsRequest(params);
        
        assertEquals(wmsRequest.getRequest(), WebMappingServiceKey.GETMAP.name());
        assertEquals(wmsRequest.getVersion(), "1.1.0");
        assertTrue(wmsRequest.getLayers().size() == 4);
        assertTrue(wmsRequest.getStyles().size() == 2);
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
        assertEquals(wmsRequest.getExceptionFormat(), ContentTypeKey.TEXT_XML.name());
        assertTrue(wmsRequest.getElevation() == 0);
        assertEquals(wmsRequest.getTime(), "2006-02-10");
    }
    
    public final void testCreateWmsGetMapRequest110WithSLDAndWFS() throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("REQUEST", WebMappingServiceKey.GETMAP.name());
        params.put("VERSION", "1.1.0");
        params.put("LAYERS", "layer1,layer2,layer3,layer4");
        params.put("STYLES", "style1,style2");
        params.put("SRS", "epsg:4326");
        params.put("BBOX", "-180.0,-90.0,180.0,90.0");
        params.put("WIDTH", "640");
        params.put("HEIGHT", "480");
        params.put("FORMAT", "PNG");
        params.put("TRANSPARENT", "true");
        params.put("BGCOLOR", "#000000");
        params.put("EXCEPTIONS", ContentTypeKey.TEXT_XML.name());
        params.put("ELEVATION", "0");
        params.put("TIME", "2006-02-10");
        params.put("SLD", "http://my.sld.file.com");
        params.put("WFS", "http://my.wfs.site.com");
        
        IOgcWmsGetMapRequest wmsRequest = (IOgcWmsGetMapRequest)OgcWmsRequestFactory.createWmsRequest(params);
        
        assertEquals(wmsRequest.getRequest(), WebMappingServiceKey.GETMAP.name());
        assertEquals(wmsRequest.getVersion(), "1.1.0");
        assertTrue(wmsRequest.getLayers().size() == 4);
        assertTrue(wmsRequest.getStyles().size() == 2);
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
        assertEquals(wmsRequest.getExceptionFormat(), ContentTypeKey.TEXT_XML.name());
        assertTrue(wmsRequest.getElevation() == 0);
        assertEquals(wmsRequest.getTime(), "2006-02-10");
        assertEquals(wmsRequest.getSLD(), "http://my.sld.file.com");
        assertEquals(wmsRequest.getWFS(), "http://my.wfs.site.com");
    }
    
    public final void testCreateWmsGetMapRequest111() throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("REQUEST", WebMappingServiceKey.GETMAP.name());
        params.put("VERSION", "1.1.1");
        params.put("LAYERS", "layer1,layer2,layer3,layer4");
        params.put("STYLES", "style1,style2");
        params.put("SRS", "epsg:4326");
        params.put("BBOX", "-180.0,-90.0,180.0,90.0");
        params.put("WIDTH", "640");
        params.put("HEIGHT", "480");
        params.put("FORMAT", "PNG");
        params.put("TRANSPARENT", "true");
        params.put("BGCOLOR", "#000000");
        params.put("EXCEPTIONS", ContentTypeKey.TEXT_XML.name());
        params.put("ELEVATION", "0");
        params.put("TIME", "2006-02-10");
        
        IOgcWmsGetMapRequest wmsRequest = (IOgcWmsGetMapRequest)OgcWmsRequestFactory.createWmsRequest(params);
        
        assertEquals(wmsRequest.getRequest(), WebMappingServiceKey.GETMAP.name());
        assertEquals(wmsRequest.getVersion(), "1.1.1");
        assertTrue(wmsRequest.getLayers().size() == 4);
        assertTrue(wmsRequest.getStyles().size() == 2);
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
        assertEquals(wmsRequest.getExceptionFormat(), ContentTypeKey.TEXT_XML.name());
        assertTrue(wmsRequest.getElevation() == 0);
        assertEquals(wmsRequest.getTime(), "2006-02-10");
    }
    
    public final void testCreateWmsGetMapRequest111WithSLDAndWFS() throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("REQUEST", WebMappingServiceKey.GETMAP.name());
        params.put("VERSION", "1.1.1");
        params.put("LAYERS", "layer1,layer2,layer3,layer4");
        params.put("STYLES", "style1,style2");
        params.put("SRS", "epsg:4326");
        params.put("BBOX", "-180.0,-90.0,180.0,90.0");
        params.put("WIDTH", "640");
        params.put("HEIGHT", "480");
        params.put("FORMAT", "PNG");
        params.put("TRANSPARENT", "true");
        params.put("BGCOLOR", "#000000");
        params.put("EXCEPTIONS", ContentTypeKey.TEXT_XML.name());
        params.put("ELEVATION", "0");
        params.put("TIME", "2006-02-10");
        params.put("SLD", "http://my.sld.file.com");
        params.put("WFS", "http://my.wfs.site.com");
        
        IOgcWmsGetMapRequest wmsRequest = (IOgcWmsGetMapRequest)OgcWmsRequestFactory.createWmsRequest(params);
        
        assertEquals(wmsRequest.getRequest(), WebMappingServiceKey.GETMAP.name());
        assertEquals(wmsRequest.getVersion(), "1.1.1");
        assertTrue(wmsRequest.getLayers().size() == 4);
        assertTrue(wmsRequest.getStyles().size() == 2);
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
        assertEquals(wmsRequest.getExceptionFormat(), ContentTypeKey.TEXT_XML.name());
        assertTrue(wmsRequest.getElevation() == 0);
        assertEquals(wmsRequest.getTime(), "2006-02-10");
        assertEquals(wmsRequest.getSLD(), "http://my.sld.file.com");
        assertEquals(wmsRequest.getWFS(), "http://my.wfs.site.com");
    }
    
    public final void testCreateWmsGetMapRequest130() throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("REQUEST", WebMappingServiceKey.GETMAP.name());
        params.put("VERSION", "1.3.0");
        params.put("LAYERS", "layer1,layer2,layer3,layer4");
        params.put("STYLES", "style1,style2");
        params.put("SLD", "<sld>woot</sld>");
        params.put("SLD_BODY", "<sld>woot</sld>");
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
        
        assertEquals(wmsRequest.getRequest(), WebMappingServiceKey.GETMAP.name());
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

    public final void testCreateWmsGetFeatureInfoRequest100() throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("REQUEST", WebMappingServiceKey.FEATUREINFO.name());
        params.put("VERSION", "1.0.0");
        params.put("QUERY_LAYERS", "layera, layerb");
        params.put("INFO_FORMAT", "XML");
        params.put("FEATURE_COUNT", "100");
        params.put("X", "75.0");
        params.put("Y", "55.5");
        
        IOgcWmsGetFeatureInfoRequest wmsRequest = (IOgcWmsGetFeatureInfoRequest)OgcWmsRequestFactory.createWmsRequest(params);
        
        assertEquals(wmsRequest.getRequest(), WebMappingServiceKey.FEATUREINFO.name());
        assertEquals(wmsRequest.getVersion(), "1.0.0");
        assertNull(wmsRequest.getService());
        assertEquals(wmsRequest.getQueryLayers().size(), 2);
        assertEquals(wmsRequest.getInfoFormat(), "XML");
        assertEquals(wmsRequest.getFeatureCount(), "100");
        assertEquals(wmsRequest.getX(), "75.0");
        assertEquals(wmsRequest.getY(), "55.5");
    }
    
    public final void testCreateWmsGetFeatureInfoRequest110() throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("REQUEST", WebMappingServiceKey.GETFEATUREINFO.name());
        params.put("VERSION", "1.1.0");
        params.put("QUERY_LAYERS", "layera, layerb");
        params.put("INFO_FORMAT", "XML");
        params.put("FEATURE_COUNT", "100");
        params.put("X", "75.0");
        params.put("Y", "55.5");
        params.put("EXCEPTIONS", "XML");
        
        IOgcWmsGetFeatureInfoRequest wmsRequest = (IOgcWmsGetFeatureInfoRequest)OgcWmsRequestFactory.createWmsRequest(params);
        
        assertEquals(wmsRequest.getRequest(), WebMappingServiceKey.GETFEATUREINFO.name());
        assertEquals(wmsRequest.getVersion(), "1.1.0");
        assertNull(wmsRequest.getService());
        assertEquals(wmsRequest.getQueryLayers().size(), 2);
        assertEquals(wmsRequest.getInfoFormat(), "XML");
        assertEquals(wmsRequest.getFeatureCount(), "100");
        assertEquals(wmsRequest.getX(), "75.0");
        assertEquals(wmsRequest.getY(), "55.5");
        assertEquals(wmsRequest.getExceptions(), "XML");
        
    }
    
    public final void testCreateWmsGetFeatureInfoRequest111() throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("REQUEST", WebMappingServiceKey.GETFEATUREINFO.name());
        params.put("VERSION", "1.1.1");
        params.put("QUERY_LAYERS", "layera, layerb");
        params.put("INFO_FORMAT", "XML");
        params.put("FEATURE_COUNT", "100");
        params.put("X", "75.0");
        params.put("Y", "55.5");
        params.put("EXCEPTIONS", "XML");
        
        IOgcWmsGetFeatureInfoRequest wmsRequest = (IOgcWmsGetFeatureInfoRequest)OgcWmsRequestFactory.createWmsRequest(params);
        
        assertEquals(wmsRequest.getRequest(), WebMappingServiceKey.GETFEATUREINFO.name());
        assertEquals(wmsRequest.getVersion(), "1.1.1");
        assertNull(wmsRequest.getService());
        assertEquals(wmsRequest.getQueryLayers().size(), 2);
        assertEquals(wmsRequest.getInfoFormat(), "XML");
        assertEquals(wmsRequest.getFeatureCount(), "100");
        assertEquals(wmsRequest.getX(), "75.0");
        assertEquals(wmsRequest.getY(), "55.5");
        assertEquals(wmsRequest.getExceptions(), "XML");
        
    }
    
    public final void testCreateWmsGetFeatureInfoRequest130() throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("REQUEST", WebMappingServiceKey.GETFEATUREINFO.name());
        params.put("VERSION", "1.3.0");
        params.put("SERVICE", "WMS");
        params.put("QUERY_LAYERS", "layera, layerb");
        params.put("INFO_FORMAT", "XML");
        params.put("FEATURE_COUNT", "100");
        params.put("I", "75.0");
        params.put("J", "55.5");
        params.put("EXCEPTIONS", "XML");
        
        IOgcWmsGetFeatureInfoRequest wmsRequest = (IOgcWmsGetFeatureInfoRequest)OgcWmsRequestFactory.createWmsRequest(params);
        
        assertEquals(wmsRequest.getRequest(), WebMappingServiceKey.GETFEATUREINFO.name());
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
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("REQUEST", WebMappingServiceKey.DESCRIBELAYER.name());
        params.put("VERSION", "1.3.0");
        params.put("SERVICE", "WMS");
        params.put("LAYER", "layer1, layer3, layer2");
        
        IOgcWmsDescribeLayerRequest wmsRequest = (IOgcWmsDescribeLayerRequest)OgcWmsRequestFactory.createWmsRequest(params);
        
        assertEquals(wmsRequest.getRequest(), WebMappingServiceKey.DESCRIBELAYER.name());
        assertEquals(wmsRequest.getVersion(), "1.3.0");
        assertEquals(wmsRequest.getService(), "WMS");
        assertEquals(wmsRequest.getLayers().size(), 3);
    }

    public final void testCreateGetLegendGraphicRequest() throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("REQUEST", WebMappingServiceKey.GETLEGENDGRAPHIC.name());
        params.put("VERSION", "1.3.0");
        params.put("LAYER", "layera");
        params.put("STYLE", "stylea");
        params.put("FEATURETYPE", "featurea");
        params.put("RULE", "rule");
        params.put("SCALE", "scale");
        params.put("SLD", "sld");
        params.put("FORMAT", ContentTypeKey.IMAGE_JPEG.name());
        params.put("WIDTH", "15");
        params.put("HEIGHT", "15");
        params.put("EXCEPTIONS", ContentTypeKey.TEXT_XML.name());
        
        IOgcWmsGetLegendGraphicRequest wmsRequest = (IOgcWmsGetLegendGraphicRequest)OgcWmsRequestFactory.createWmsRequest(params);
        
        assertEquals(wmsRequest.getRequest(), WebMappingServiceKey.GETLEGENDGRAPHIC.name());
        assertEquals(wmsRequest.getVersion(), "1.3.0");
        assertNull(wmsRequest.getService());
        assertEquals(wmsRequest.getLayer(), "layera");
        assertEquals(wmsRequest.getStyle(), "stylea");
        assertEquals(wmsRequest.getFeatureType(), "featurea");
        assertEquals(wmsRequest.getRule(), "rule");
        assertEquals(wmsRequest.getScale(), 0.0);
        assertEquals(wmsRequest.getSld(), "sld");
        assertEquals(wmsRequest.getFormat(), ContentTypeKey.IMAGE_JPEG.name());
        assertEquals(wmsRequest.getWidth(), 15);
        assertEquals(wmsRequest.getHeight(), 15);
        assertEquals(wmsRequest.getExceptions(), ContentTypeKey.TEXT_XML.name());
    }
    
    public final void testCreateGetStylesRequest() throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("VERSION", "1.3.0");
        params.put("REQUEST", "GetStyles");
        params.put("SLDVER", "1.0.24");
        params.put("LAYERS", "layera,layerb, layerc");
        
        IOgcWmsGetStylesRequest wmsRequest = (IOgcWmsGetStylesRequest)OgcWmsRequestFactory.createWmsRequest(params);
        
        assertEquals(wmsRequest.getVersion(), "1.3.0");
        assertEquals(wmsRequest.getRequest(), "GetStyles");
        assertNull(wmsRequest.getService());
        assertEquals(wmsRequest.getSldVer(), "1.0.24");
        assertEquals(wmsRequest.getLayers().size(), 3);
        
    }
    
    public final void testCreatePutStylesRequest() throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("VERSION", "1.3.0");
        params.put("REQUEST", "PutStyles");
        params.put("MODE", "InsertAndReplace");
        params.put("SLD", "sld");
        
        IOgcWmsPutStylesRequest wmsRequest = (IOgcWmsPutStylesRequest)OgcWmsRequestFactory.createWmsRequest(params);
        
        assertEquals(wmsRequest.getVersion(), "1.3.0");
        assertEquals(wmsRequest.getRequest(), "PutStyles");
        assertNull(wmsRequest.getService());
        assertEquals(wmsRequest.getMode(), "InsertAndReplace");
        assertEquals(wmsRequest.getSld(), "sld");        
    }
}
