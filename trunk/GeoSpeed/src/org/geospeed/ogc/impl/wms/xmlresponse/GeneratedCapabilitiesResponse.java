package org.geospeed.ogc.impl.wms.xmlresponse;

import java.math.BigInteger;

import org.geospeed.ogc.api.IOgcContentType;
import org.geospeed.ogc.impl.OgcProperties;
import org.geospeed.ogc.impl.OgcResponse;
import org.geospeed.ogc.impl.wms.xml.v1_3_0.ContactAddress;
import org.geospeed.ogc.impl.wms.xml.v1_3_0.ContactInformation;
import org.geospeed.ogc.impl.wms.xml.v1_3_0.ContactPersonPrimary;
import org.geospeed.ogc.impl.wms.xml.v1_3_0.Keyword;
import org.geospeed.ogc.impl.wms.xml.v1_3_0.KeywordList;
import org.geospeed.ogc.impl.wms.xml.v1_3_0.ObjectFactory;
import org.geospeed.ogc.impl.wms.xml.v1_3_0.OnlineResource;
import org.geospeed.ogc.impl.wms.xml.v1_3_0.Service;
import org.geospeed.ogc.impl.wms.xml.v1_3_0.WMSCapabilities;

public class GeneratedCapabilitiesResponse extends OgcResponse
{
    private WMSCapabilities capabilitiesDoc;
    ObjectFactory objFac;
    
    public GeneratedCapabilitiesResponse()
    {
        objFac = new ObjectFactory();
        
        capabilitiesDoc = objFac.createWMSCapabilities();
    }
    
    public GeneratedCapabilitiesResponse(OgcProperties properties)
    {
        objFac = new ObjectFactory();
        capabilitiesDoc = objFac.createWMSCapabilities();
        
        capabilitiesDoc.setService(createServiceTag(properties));
        
        
        super.setContentType(IOgcContentType.XML);
        super.setData(capabilitiesDoc.toString().getBytes());
    }
    
    private Service createServiceTag(OgcProperties p)
    {
        Service svc = objFac.createService();
        svc.setName(p.getProperty("WmsServiceName"));
        svc.setTitle(p.getProperty("WmsServiceTitle"));
        svc.setAbstract(p.getProperty("WmsAbstract"));
        
        String keywordsString = p.getProperty("WmsKeywords");
        String[] keywords = new String[0];
        
        if (keywordsString != null && keywordsString != "")
        {
            keywords = keywordsString.split(",");
        }
        
        KeywordList kwList = objFac.createKeywordList();
        
        for (int i = 0; i < keywords.length; i++)
        {
            Keyword kw = objFac.createKeyword();
            kw.setValue(keywords[i]);
        }
        
        svc.setKeywordList(kwList);
        
        OnlineResource or = objFac.createOnlineResource();
        or.setHref(p.getProperty("WmsOnlineResource"));
        svc.setOnlineResource(or);
        
        svc.setContactInformation(createContactInformationTag(p));
        svc.setFees(p.getProperty("Fees"));
        svc.setAccessConstraints(p.getProperty("AccessConstraints"));
        if (p.getProperty("LayerLimit") != null && !p.getProperty("LayerLimit").equals(""))
            svc.setLayerLimit(new BigInteger(p.getProperty("LayerLimit")));
        if (p.getProperty("MaxHeight") != null && !p.getProperty("MaxHeight").equals(""))
            svc.setMaxHeight(new BigInteger(p.getProperty("MaxHeight")));
        if (p.getProperty("MaxWidth") != null && !p.getProperty("MaxWidth").equals(""))
            svc.setMaxWidth(new BigInteger(p.getProperty("MaxWidth")));
        
        return svc;
    }
    
    private ContactInformation createContactInformationTag(OgcProperties p)
    {
        ContactInformation ci = objFac.createContactInformation();
        
        ci.setContactPersonPrimary(createContactPersonPrimaryTag(p));
        ci.setContactPosition(p.getProperty("ContactPosition"));
        ci.setContactAddress(createContactAddressTag(p));
        ci.setContactVoiceTelephone(p.getProperty("ContactPhone"));
        ci.setContactFacsimileTelephone(p.getProperty("ContactFax"));
        ci.setContactElectronicMailAddress(p.getProperty("ContactEmail"));
        
        return ci;
    }
    
    private ContactPersonPrimary createContactPersonPrimaryTag(OgcProperties p)
    {
        ContactPersonPrimary cpp = objFac.createContactPersonPrimary();
        
        cpp.setContactPerson(p.getProperty("ContactPerson"));
        cpp.setContactOrganization(p.getProperty("ContactOrg"));
        
        return cpp;
    }

    private ContactAddress createContactAddressTag(OgcProperties p)
    {
        ContactAddress addr = objFac.createContactAddress();
        
        addr.setAddressType(p.getProperty("ContactAddressType"));
        addr.setAddress(p.getProperty("ContactAddress"));
        addr.setCity(p.getProperty("ContactCity"));
        addr.setStateOrProvince(p.getProperty("ContactStateOrProvince"));
        addr.setPostCode(p.getProperty("ContactPostCode"));
        addr.setCountry(p.getProperty("ContactCountry"));
        
        return addr;
    }
}
