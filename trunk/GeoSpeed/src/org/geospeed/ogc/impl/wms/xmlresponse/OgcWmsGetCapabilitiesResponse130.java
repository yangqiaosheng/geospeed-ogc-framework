package org.geospeed.ogc.impl.wms.xmlresponse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.geospeed.ogc.api.IOgcXmlResponse;
import org.geospeed.ogc.impl.OgcProperties;



public class OgcWmsGetCapabilitiesResponse130 implements IOgcXmlResponse
{
    private String serviceName = null;
    private String serviceTitle = null;
    private String onlineResource = null;
    private String contactPerson = null;
    private String contactOrg = null;
    private String contactPos = null;
    private String contactAddrType = null;
    private String contactAddr = null;
    private String contactCity = null;
    private String contactState = null;
    private String contactPostCode = null;
    private String contactCountry = null;
    private String contactPhone = null;
    private String contactFax = null;
    private String contactEmail = null;
    private String fees = null;
    private String accessConstraints = null;
    private List getCapFormat = new ArrayList();
    private String getCapLocation = null;
    private List getMapFormat = new ArrayList();
    private String getMapLocation = null;
    private List featureInfoFormat = new ArrayList();
    private String getFeatureInfoLocation = null;
    private List describeLayerFormat = new ArrayList();
    private String getDescribeLayerLocation = null;
    private List exceptionFormat = new ArrayList();
    private String supportSLD = null;
    private String userLayer = null;
    private String userStyle = null;
    private String remoteWfs = null;
    private List layers = new ArrayList();
    
    private OgcProperties props = null;
    private String xml = null;
    
    public OgcWmsGetCapabilitiesResponse130()
    {
        
    }
    
    public OgcWmsGetCapabilitiesResponse130(OgcProperties properties)
    {
        props = properties;
        fillProps();
    }
    
    public String getAccessConstraints()
    {
        return accessConstraints;
    }

    public void setAccessConstraints(String accessConstraints)
    {
        this.accessConstraints = accessConstraints;
    }

    public String getContactAddr()
    {
        return contactAddr;
    }

    public void setContactAddr(String contactAddr)
    {
        this.contactAddr = contactAddr;
    }

    public String getContactAddrType()
    {
        return contactAddrType;
    }

    public void setContactAddrType(String contactAddrType)
    {
        this.contactAddrType = contactAddrType;
    }

    public String getContactCity()
    {
        return contactCity;
    }

    public void setContactCity(String contactCity)
    {
        this.contactCity = contactCity;
    }

    public String getContactCountry()
    {
        return contactCountry;
    }

    public void setContactCountry(String contactCountry)
    {
        this.contactCountry = contactCountry;
    }

    public String getContactEmail()
    {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail)
    {
        this.contactEmail = contactEmail;
    }

    public String getContactFax()
    {
        return contactFax;
    }

    public void setContactFax(String contactFax)
    {
        this.contactFax = contactFax;
    }

    public String getContactOrg()
    {
        return contactOrg;
    }

    public void setContactOrg(String contactOrg)
    {
        this.contactOrg = contactOrg;
    }

    public String getContactPerson()
    {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson)
    {
        this.contactPerson = contactPerson;
    }

    public String getContactPhone()
    {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone)
    {
        this.contactPhone = contactPhone;
    }

    public String getContactPos()
    {
        return contactPos;
    }

    public void setContactPos(String contactPos)
    {
        this.contactPos = contactPos;
    }

    public String getContactPostCode()
    {
        return contactPostCode;
    }

    public void setContactPostCode(String contactPostCode)
    {
        this.contactPostCode = contactPostCode;
    }

    public String getContactState()
    {
        return contactState;
    }

    public void setContactState(String contactState)
    {
        this.contactState = contactState;
    }

    public List getExceptionFormat()
    {
        return exceptionFormat;
    }

    public void setExceptionFormat(List exceptionFormat)
    {
        this.exceptionFormat = exceptionFormat;
    }

    public String getFees()
    {
        return fees;
    }

    public void setFees(String fees)
    {
        this.fees = fees;
    }

    public String getGetCapLocation()
    {
        return getCapLocation;
    }

    public void setGetCapLocation(String getCapLocation)
    {
        this.getCapLocation = getCapLocation;
    }

    public String getGetDescribeLayerLocation()
    {
        return getDescribeLayerLocation;
    }

    public void setGetDescribeLayerLocation(String getDescribeLayerLocation)
    {
        this.getDescribeLayerLocation = getDescribeLayerLocation;
    }

    public String getGetFeatureInfoLocation()
    {
        return getFeatureInfoLocation;
    }

    public void setGetFeatureInfoLocation(String getFeatureInfoLocation)
    {
        this.getFeatureInfoLocation = getFeatureInfoLocation;
    }

    public String getGetMapLocation()
    {
        return getMapLocation;
    }

    public void setGetMapLocation(String getMapLocation)
    {
        this.getMapLocation = getMapLocation;
    }

    public List getLayers()
    {
        return layers;
    }

    public void setLayers(List layers)
    {
        this.layers = layers;
    }

    public String getRemoteWfs()
    {
        return remoteWfs;
    }

    public void setRemoteWfs(String remoteWfs)
    {
        this.remoteWfs = remoteWfs;
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }

    public String getServiceTitle()
    {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle)
    {
        this.serviceTitle = serviceTitle;
    }

    public String getSupportSLD()
    {
        return supportSLD;
    }

    public void setSupportSLD(String supportSLD)
    {
        this.supportSLD = supportSLD;
    }

    public String getUserLayer()
    {
        return userLayer;
    }

    public void setUserLayer(String userLayer)
    {
        this.userLayer = userLayer;
    }

    public String getUserStyle()
    {
        return userStyle;
    }

    public void setUserStyle(String userStyle)
    {
        this.userStyle = userStyle;
    }

    public List getGetCapFormat()
    {
        return getCapFormat;
    }

    public void setGetCapFormat(List getCapFormat)
    {
        this.getCapFormat = getCapFormat;
    }

    public List getDescribeLayerFormat()
    {
        return describeLayerFormat;
    }

    public void setDescribeLayerFormat(List describeLayerFormat)
    {
        this.describeLayerFormat = describeLayerFormat;
    }

    public List getFeatureInfoFormat()
    {
        return featureInfoFormat;
    }

    public void setFeatureInfoFormat(List featureInfoFormat)
    {
        this.featureInfoFormat = featureInfoFormat;
    }

    public List getGetMapFormat()
    {
        return getMapFormat;
    }

    public void setGetMapFormat(List getMapFormat)
    {
        this.getMapFormat = getMapFormat;
    }

    public String getOnlineResource()
    {
        return onlineResource;
    }

    public void setOnlineResource(String onlineResource)
    {
        this.onlineResource = onlineResource;
    }

    public String getXml()
    {
        xml = new String();
        
        xml = "<?xml version='1.0' encoding='UTF-8'?> " +
        "<WMS_Capabilities version='1.3.0' xmlns='http://www.opengis.net/wms'>" +
        "<Service><Name>WMS</Name><Title>" + serviceTitle + "</Title>" +
        "<OnlineResource xmlns:xlink='http://www.w3.org/1999/xlink' xlink:type='simple' xlink:href='" + onlineResource + "'/>" +
        "<ContactInformation><ContactPersonPrimary><ContactPerson>" + contactPerson + "</ContactPerson>" +
        "<ContactOrganization>" + contactOrg + "</ContactOrganization></ContactPersonPrimary>" +
        "<ContactPosition>" + contactPos + "</ContactPosition>" +
        "<ContactAddress><AddressType>" + contactAddrType + "</AddressType><Address>" + contactAddr + "</Address>" +
        "<City>" + contactCity + "</City><StateOrProvince>" + contactState + "</StateOrProvince>" +
        "<PostCode>" + contactPostCode + "</PostCode>" +
        "<Country>" + contactCountry + "</Country></ContactAddress>" +
        "<ContactVoiceTelephone>" + contactPhone + "</ContactVoiceTelephone>" +
        "<ContactFacsimileTelephone>" + contactFax + "</ContactFacsimileTelephone>" +
        "<ContactElectronicMailAddress>" + contactEmail + "</ContactElectronicMailAddress></ContactInformation>" +
        "<Fees>" + fees + "</Fees><AccessConstraints>" + accessConstraints + "</AccessConstraints></Service>" +
        "<Capability><Request><GetCapabilities>";
        
        for (Iterator i = getCapFormat.iterator(); i.hasNext();)
            xml = xml + "<Format>" + (String)i.next() + "</Format>";
        
        xml = xml + "<DCPType><HTTP><Get><OnlineResource xmlns:xlink='http://www.w3.org/1999/xlink' xlink:type='simple' xlink:href='" + getCapLocation + "'/></Get>" +
        "<Post><OnlineResource xmlns:xlink='http://www.w3.org/1999/xlink' xlink:type='simple' xlink:href='" + getCapLocation + "'/></Post></HTTP></DCPType></GetCapabilities>" +
        "<GetMap>";
        
        for (Iterator i = getMapFormat.iterator(); i.hasNext();)
            xml = xml + "<Format>" + (String)i.next() + "</Format>";
        
        xml = xml + "<DCPType><HTTP><Get><OnlineResource xmlns:xlink='http://www.w3.org/1999/xlink' xlink:type='simple' xlink:href='" + getMapLocation + "'/></Get>" +
        "<Post><OnlineResource xmlns:xlink='http://www.w3.org/1999/xlink' xlink:type='simple' xlink:href='" + getMapLocation + "'/></Post></HTTP></DCPType></GetMap>" +
        "<GetFeatureInfo>";
        
        for (Iterator i = featureInfoFormat.iterator(); i.hasNext();)
            xml = xml + "<Format>" + (String)i.next() + "</Format>";
        
        xml = xml + "<DCPType><HTTP><Get><OnlineResource xmlns:xlink='http://www.w3.org/1999/xlink' xlink:type='simple' xlink:href='" + getFeatureInfoLocation + "'/></Get>" +
        "<Post><OnlineResource xmlns:xlink='http://www.w3.org/1999/xlink' xlink:type='simple' xlink:href='" + getFeatureInfoLocation + "'/></Post></HTTP></DCPType></GetFeatureInfo>" +
        "<DescribeLayer>";
        
        for (Iterator i = describeLayerFormat.iterator(); i.hasNext();)
            xml = xml + "<Format>" + (String)i.next() + "</Format>";

        xml = xml + "<DCPType><HTTP><Get><OnlineResource xmlns:xlink='http://www.w3.org/1999/xlink' xlink:type='simple' xlink:href='" + getDescribeLayerLocation + "'/></Get>" +
        "<Post><OnlineResource xmlns:xlink='http://www.w3.org/1999/xlink' xlink:type='simple' xlink:href='" + getDescribeLayerLocation + "'/></Post></HTTP></DCPType></DescribeLayer></Request>" +
        "<Exception>";
        
        for (Iterator i = getExceptionFormat().iterator(); i.hasNext();)
            xml = xml + "<Format>" + (String)i.next() + "</Format>";
        
        xml = xml + "</Exception>" +
        "<UserDefinedSymbolization SupportSLD='" + supportSLD + "'" +
                " UserLayer='" + userLayer + "' UserStyle='" + userStyle + "' RemoteWFS='" + remoteWfs +"'/>"; 
        
        for (Iterator i = layers.iterator(); i.hasNext();)
        {
            OgcWmsGetCapabilitiesLayer130 l = (OgcWmsGetCapabilitiesLayer130)i.next();
            xml = xml + l.getXml();
        }
        
        xml = xml + "</Capability></WMS_Capabilities>";
        
        return xml;
    }

    private void fillProps()
    {
        serviceName = props.getProperty("WmsServiceName");
        serviceTitle = props.getProperty("WmsServiceTitle");
        onlineResource = props.getProperty("OnlineResource");
        contactPerson = props.getProperty("ContactPerson");
        contactOrg = props.getProperty("ContactOrg");
        contactPos = props.getProperty("ContactPosition");
        contactAddrType = props.getProperty("ContactAddressType");
        contactAddr = props.getProperty("ContactAddress");
        contactCity = props.getProperty("ContactCity");
        contactState = props.getProperty("ContactStateOrProvince");
        contactPostCode = props.getProperty("ContactPostCode");
        contactCountry = props.getProperty("ContactCountry");
        contactPhone = props.getProperty("ContactPhone");
        contactFax = props.getProperty("ContactFax");
        contactEmail = props.getProperty("ContactEmail");
        fees = props.getProperty("Fees");
        accessConstraints = props.getProperty("AccessConstraints");
        
        String capFormat = props.getProperty("WmsGetCapabilitiesFormat");
        String[] tmp = capFormat.split(",");
        
        for (int i = 0; i < tmp.length; i++)
            getCapFormat.add(tmp[i]);
        
        getCapLocation = props.getProperty("WmsGetCapabilitiesLocation");
        
        String mapFormat = props.getProperty("WmsGetMapFormat");
        tmp = mapFormat.split(",");
        
        for (int i = 0; i < tmp.length; i++)
            getMapFormat.add(tmp[i]);
        
        getMapLocation = props.getProperty("WmsGetMapLocation");
        
        String fiFormat = props.getProperty("WmsGetFeatureInfoFormat");
        tmp = fiFormat.split(",");
        
        for (int i = 0; i < tmp.length; i++)
            featureInfoFormat.add(tmp[i]);
        
        getFeatureInfoLocation = props.getProperty("WmsGetFeatureInfoLocation");
        
        String dlFormat = props.getProperty("WmsDescribeLayerFormat");
        tmp = dlFormat.split(",");
        
        for (int i = 0; i < tmp.length; i++)
            describeLayerFormat.add(tmp[i]);
        
        getDescribeLayerLocation = props.getProperty("WmsDescribeLayerLocation");
        String exFormat = props.getProperty("ExceptionFormat");
        
        exceptionFormat = new ArrayList();
        tmp = exFormat.split(",");
               
        for (int i = 0; i < tmp.length; i++)
            exceptionFormat.add(tmp[i]);
        
        supportSLD = props.getProperty("SupportSLD");
        userLayer = props.getProperty("UserLayer");                    
        userStyle = props.getProperty("UserStyle");
        remoteWfs = props.getProperty("ReoteWFS");

    }
    
}
