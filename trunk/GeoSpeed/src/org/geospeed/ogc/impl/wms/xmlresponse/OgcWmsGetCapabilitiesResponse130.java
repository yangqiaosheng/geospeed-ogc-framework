package org.geospeed.ogc.impl.wms.xmlresponse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.geospeed.ogc.api.IOgcXmlResponse;
import org.geospeed.ogc.impl.OgcProperties;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.output.XMLOutputter;



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
    private String describeLayerLocation = null;
    private List exceptionFormat = new ArrayList();
    private String supportSLD = null;
    private String userLayer = null;
    private String userStyle = null;
    private String remoteWfs = null;
    private List layers = new ArrayList();
    
    private boolean useGetCapabilitiesPost;
    private boolean useGetMapPost;
    private boolean useGetFeatureInfoPost;
    private boolean useDescribeLayerPost;
    
    private OgcProperties props = null;
    private Document xmlDoc = null;
    private String xml = null;
    
    public OgcWmsGetCapabilitiesResponse130()
    {
        
    }
    
    public OgcWmsGetCapabilitiesResponse130(OgcProperties properties)
    {
        props = properties;
        fillProps();
        createXmlDoc();
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

    public String getDescribeLayerLocation()
    {
        return describeLayerLocation;
    }

    public void setDescribeLayerLocation(String getDescribeLayerLocation)
    {
        this.describeLayerLocation = getDescribeLayerLocation;
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

    public boolean getUseGetCapabilitiesPost()
    {
        return useGetCapabilitiesPost;
    }
    
    public void setUseGetCapabilitiesPost(boolean usePost)
    {
        useGetCapabilitiesPost = usePost;
    }
    
    public boolean getUseGetMapPost()
    {
        return useGetMapPost;
    }
    
    public void setUseMapPost(boolean usePost)
    {
        useGetMapPost = usePost;
    }
    
    public boolean getUseGetFeatureInfoPost()
    {
        return useGetFeatureInfoPost;
    }
    
    public void setUseFeatureInfoPost(boolean usePost)
    {
        useGetFeatureInfoPost = usePost;
    }
    
    public boolean getUseDescribeLayerPost()
    {
        return useDescribeLayerPost;
    }
    
    public void setUseDescrbeLayerPost(boolean usePost)
    {
        useDescribeLayerPost = usePost;
    }
    
    public String getXml()
    {
        xml = "";
        
        createXmlDoc();
       
        XMLOutputter xmlOut = new XMLOutputter();
        xml = xmlOut.outputString(xmlDoc);
            
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
        
        describeLayerLocation = props.getProperty("WmsDescribeLayerLocation");
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

    private void createXmlDoc()
    {
        xmlDoc = new Document();
        try
        {
            Element root = new Element("WMS_Capabilities");
            root.setAttribute("version", "1.3.0");
            root.setNamespace(Namespace.getNamespace("http://www.opengis.net/wms"));
            xmlDoc.setRootElement(root);
            
            root.addContent(createServiceTag());
            
            root.addContent(createCapabilityTag());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private Element createServiceTag()
    {
        Element service = new Element("Service");
        
        Element name = new Element("Name");
        name.setText(serviceName);
        Element title = new Element("Title");
        title.setText(serviceTitle);
        
        service.addContent(name);
        service.addContent(title);
        service.addContent(createOnlineResourceTag(onlineResource));
        
        service.addContent(createContactInfoTag());

        Element feesTag = new Element("Fees");
        feesTag.setText(fees);
        Element accessConstraintsTag = new Element("AccessConstraints");
        accessConstraintsTag.setText(accessConstraints);
        
        service.addContent(feesTag);
        service.addContent(accessConstraintsTag);
        
        return service;
    }

    private Element createCapabilityTag()
    {
        Element capability = new Element("Capability");
        
        capability.addContent(createRequestTag());
        capability.addContent(createExceptionTag());
        capability.addContent(createUserDefinedSymblizationTag());
        capability.addContent(createLayerTag());
        
        return capability;
    }
    
    private Element createContactInfoTag()
    {
        Element contactInformation = new Element("ContactInformation");
        
        Element contactPersonPrimary = new Element("ContactPersonPrimary");
        Element contactPersonTag = new Element("ContactPerson");
        contactPersonTag.setText(contactPerson);
        Element contactOrgTag = new Element("ContactOrganization");
        contactOrgTag.setText(contactOrg);
        
        contactPersonPrimary.addContent(contactPersonTag);
        contactPersonPrimary.addContent(contactOrgTag);

        contactInformation.addContent(contactPersonPrimary);
        
        Element contactPosition = new Element("ContactPosition");
        contactPosition.setText(contactPos);
        
        contactInformation.addContent(contactPosition);
        
        Element contactAddress = new Element("ContactAddress");
        Element addressType = new Element("AddressType");
        addressType.setText(contactAddrType);
        Element address = new Element("Address");
        address.setText(contactAddr);
        Element city = new Element("City");
        city.setText(contactCity);
        Element state = new Element("StateOrProvince");
        state.setText(contactState);
        Element postCode = new Element("PostCode");
        postCode.setText(contactPostCode);
        Element country = new Element("Country");
        country.setText(contactCountry);
        
        contactAddress.addContent(addressType);
        contactAddress.addContent(address);
        contactAddress.addContent(city);
        contactAddress.addContent(state);
        contactAddress.addContent(postCode);
        contactAddress.addContent(country);
        
        contactInformation.addContent(contactAddress);
        
        Element contactPhoneTag = new Element("ContactVoiceTelephone");
        contactPhoneTag.setText(contactPhone);
        Element contactFaxTag = new Element("ContactFacsimileTelephone");
        contactFaxTag.setText(contactFax);
        Element contactEmailTag = new Element("ContactElectronicMailAddress");
        contactEmailTag.setText(contactEmail);
        
        contactInformation.addContent(contactPhoneTag);
        contactInformation.addContent(contactFaxTag);
        contactInformation.addContent(contactEmailTag);
        
        return contactInformation;
    }

    private Element createRequestTag()
    {
        Element request = new Element("Request");
        request.addContent(createGetCapabilitiesTag());
        request.addContent(createGetMapTag());
        request.addContent(createGetFeatureInfoTag());
        request.addContent(createDescribeLayerTag());
        
        return request;
    }
    
    private Element createGetCapabilitiesTag()
    {
        Element getCap = new Element("GetCapabilities");
        
        List formatList = new ArrayList();
        for (Iterator i = getCapFormat.iterator(); i.hasNext();)
        {
            Element format = new Element("Format");
            format.setText((String)i.next());
            formatList.add(format);
        }
        getCap.addContent(formatList);
        
        getCap.addContent(createDCPTypeTag(getCapLocation, useGetCapabilitiesPost));
   
        return getCap;
    }
    
    private Element createGetMapTag()
    {
        Element getMap = new Element("GetMap");
        
        List formatList = new ArrayList();
        for (Iterator i = getMapFormat.iterator(); i.hasNext();)
        {
            Element format = new Element("Format");
            format.setText((String)i.next());
            formatList.add(format);
        }
        getMap.addContent(formatList);
        
        getMap.addContent(createDCPTypeTag(getMapLocation, useGetMapPost));
        
        return getMap;
    }
    
    private Element createGetFeatureInfoTag()
    {
        Element getFI = new Element("FeatureInfo");
        
        List formatList = new ArrayList();
        for (Iterator i = getFeatureInfoFormat().iterator(); i.hasNext();)
        {
            Element format = new Element("Format");
            format.setText((String)i.next());
            formatList.add(format);
        }
        getFI.addContent(formatList);
        
        getFI.addContent(createDCPTypeTag(getFeatureInfoLocation, useGetFeatureInfoPost));
        
        return getFI;
    }
    
    private Element createDescribeLayerTag()
    {
        Element dl = new Element("DescribeLayer");
        
        List formatList = new ArrayList();
        for (Iterator i = describeLayerFormat.iterator(); i.hasNext();)
        {
            Element format = new Element("Format");
            format.setText((String)i.next());
            formatList.add(format);
        }
        dl.addContent(formatList);
        
        dl.addContent(createDCPTypeTag(describeLayerLocation, useDescribeLayerPost));
        
        return dl;
    }
    
    private Element createDCPTypeTag(String url, boolean usePost)
    {
        Element dcpType = new Element("DCPType");
        Element http = new Element("HTTP");
        Element get = new Element("Get");
        get.addContent(createOnlineResourceTag(url));
        Element post = new Element("Post");
        post.addContent(createOnlineResourceTag(url));
        
        http.addContent(get);
        if (usePost)
            http.addContent(post);
        
        dcpType.addContent(http);
        
        return dcpType;        
    }
    
    private Element createOnlineResourceTag(String url)
    {
        Element onlineResourceTag = new Element("OnlineResource");
        onlineResourceTag.setAttribute("xlink", "http://www.w3.org/1999/xlink", Namespace.getNamespace("xlink", "http://www.w3.org/1999/xlink"));
        onlineResourceTag.setAttribute("type", "simple", Namespace.getNamespace("xlink", "http://www.w3.org/1999/xlink"));
        onlineResourceTag.setAttribute("href", url, Namespace.getNamespace("xlink", "http://www.w3.org/1999/xlink"));
        
        return onlineResourceTag;
    }
    
    private Element createExceptionTag()
    {
        Element exception = new Element("Exception");
        
        List formatList = new ArrayList();
        for (Iterator i = exceptionFormat.iterator(); i.hasNext();)
        {
            Element format = new Element("Format");
            format.setText((String)i.next());
            formatList.add(format);
        }
        exception.addContent(formatList);
        
        return exception;
    }

    private Element createUserDefinedSymblizationTag()
    {
        Element u = new Element("UserDefinedSymbolization"); 
        u.setAttribute("SupportSLD", supportSLD);
        u.setAttribute("UserLayer", userLayer);
        u.setAttribute("UserStyle", userStyle);
        u.setAttribute("RemoteWFS", remoteWfs);
        
        return u;               
    }

    private List createLayerTag()
    {
        List layerTags = new ArrayList();
        
        for (Iterator i = layers.iterator(); i.hasNext();)
        {
            OgcWmsGetCapabilitiesLayer130 layer = (OgcWmsGetCapabilitiesLayer130)i.next();
            layerTags.add(layer.getTag());
        }
        
        return layerTags;
        
    }
}


