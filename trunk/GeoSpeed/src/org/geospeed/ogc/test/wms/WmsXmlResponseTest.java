package org.geospeed.ogc.test.wms;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.geospeed.ogc.impl.wms.xmlresponse.OgcWmsGetCapabilitiesLayer130;
import org.geospeed.ogc.impl.wms.xmlresponse.OgcWmsGetCapabilitiesResponse130;

public class WmsXmlResponseTest extends TestCase
{
    private OgcWmsGetCapabilitiesLayer130 getTestLayer()
    {
        OgcWmsGetCapabilitiesLayer130 layer = new OgcWmsGetCapabilitiesLayer130();

        layer.setLayerCrs("EPSG:4326");
        layer.setLayerName("Test layer name");
        layer.setLayerTitle("test layer title");

        return layer;
    }
    
    public void testWmsGetCapabilitiesLayer130()
    {
        OgcWmsGetCapabilitiesLayer130 layer = getTestLayer();
        
        String xml = layer.getXml();

        assertEquals(xml, "<Layer><Name>Test layer name</Name><Title>test layer title</Title><CRS>EPSG:4326</CRS></Layer>");

    }

    public void testWmsGetCapabilitiesResponse130()
    {
        OgcWmsGetCapabilitiesResponse130 cap = new OgcWmsGetCapabilitiesResponse130();

        cap.setAccessConstraints("none");
        cap.setContactAddr("test address");
        cap.setContactAddrType("postal");
        cap.setContactCity("somecity");
        cap.setContactCountry("somecountry");
        cap.setContactEmail("john@doe.com");
        cap.setContactFax("867-5309");
        cap.setContactOrg("ogc");
        cap.setContactPerson("john doe");
        cap.setContactPhone("867-5309");
        cap.setContactPos("the boss");
        cap.setContactPostCode("00000");
        cap.setContactState("somestate");
        List dlFormat = new ArrayList();
        dlFormat.add("application/vnd.ogc.wms_xml");
        cap.setDescribeLayerFormat(dlFormat);
        List efFormat = new ArrayList();
        efFormat.add("INIMAGE");
        cap.setExceptionFormat(efFormat);
        List fiFormat = new ArrayList();
        fiFormat.add("text/xml");
        cap.setFeatureInfoFormat(fiFormat);
        cap.setFees("none");
        cap.setGetCapFormat(fiFormat);
        cap.setGetCapLocation("http://www.someurl.com");
        cap.setGetDescribeLayerLocation("http://www.someurl.com");
        cap.setGetFeatureInfoLocation("http://www.someurl.com");
        List mapFormat = new ArrayList();
        mapFormat.add("image/png");
        cap.setGetMapFormat(mapFormat);
        cap.setGetMapLocation("http://www.someurl.com");
        cap.setOnlineResource("http://www.someurl.com");
        cap.setRemoteWfs("0");
        cap.setServiceName("Test WMS Server");
        cap.setServiceTitle("A test wms");
        cap.setSupportSLD("0");
        cap.setUserLayer("0");
        cap.setUserStyle("0");
        List layers = new ArrayList();
        layers.add(getTestLayer());
        cap.setLayers(layers);
        
        String xml = cap.getXml();
        
        assertEquals(xml, "<?xml version='1.0' encoding='UTF-8'?> <WMS_Capabilities version='1.3.0' xmlns='http://www.opengis.net/wms'><Service><Name>WMS</Name><Title>A test wms</Title><OnlineResource xmlns:xlink='http://www.w3.org/1999/xlink' xlink:type='simple' xlink:href='http://www.someurl.com'/><ContactInformation><ContactPersonPrimary><ContactPerson>john doe</ContactPerson><ContactOrganization>ogc</ContactOrganization></ContactPersonPrimary><ContactPosition>the boss</ContactPosition><ContactAddress><AddressType>postal</AddressType><Address>test address</Address><City>somecity</City><StateOrProvince>somestate</StateOrProvince><PostCode>00000</PostCode><Country>somecountry</Country></ContactAddress><ContactVoiceTelephone>867-5309</ContactVoiceTelephone><ContactFacsimileTelephone>867-5309</ContactFacsimileTelephone><ContactElectronicMailAddress>john@doe.com</ContactElectronicMailAddress></ContactInformation><Fees>none</Fees><AccessConstraints>none</AccessConstraints></Service><Capability><Request><GetCapabilities><Format>text/xml</Format><DCPType><HTTP><Get><OnlineResource xmlns:xlink='http://www.w3.org/1999/xlink' xlink:type='simple' xlink:href='http://www.someurl.com'/></Get></HTTP></DCPType></GetCapabilities><GetMap><Format>image/png</Format><DCPType><HTTP><Get><OnlineResource xmlns:xlink='http://www.w3.org/1999/xlink' xlink:type='simple' xlink:href='http://www.someurl.com'/></Get></HTTP></DCPType></GetMap><GetFeatureInfo><Format>text/xml</Format><DCPType><HTTP><Get><OnlineResource xmlns:xlink='http://www.w3.org/1999/xlink' xlink:type='simple' xlink:href='http://www.someurl.com'/></Get></HTTP></DCPType></GetFeatureInfo><DescribeLayer><Format>application/vnd.ogc.wms_xml</Format><DCPType><HTTP><Get><OnlineResource xmlns:xlink='http://www.w3.org/1999/xlink' xlink:type='simple' xlink:href='http://www.someurl.com'/></Get></HTTP></DCPType></DescribeLayer></Request><Exception><Format>INIMAGE</Format></Exception><UserDefinedSymbolization SupportSLD='0' UserLayer='0' UserStyle='0' RemoteWFS='0'/><Layer><Name>Test layer name</Name><Title>test layer title</Title><CRS>EPSG:4326</CRS></Layer></Capability></WMS_Capabilities>");
    }

    public static void main(String[] args)
    {
        junit.textui.TestRunner.run(WmsXmlResponseTest.class);
    }

}
