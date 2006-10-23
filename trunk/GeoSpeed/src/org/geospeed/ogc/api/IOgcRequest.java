package org.geospeed.ogc.api;

import java.util.Map;

/********************************************************************************
 * 
 * @author Mike Abner
 * 
 * The IOgcRequest interface is a tag interface to simply mark requests made to
 * servers that implement Open Geospatial Consortium (www.opengeospatial.org) 
 * specifications such as Web Mapping Service and Web Feature Service (WMS and 
 * WFS, respectively).  This allows the high level code to be implementation 
 * agnostic when dealing with the communication between the web tier an the 
 * application tier.
 *
 ********************************************************************************/
public interface IOgcRequest 
{
    /**
     * @return String - the VERSION passed by the requestor.
     */
    public String getVersion();
    
    /**
     * @return String - the REQUEST passed by the requestor.
     */
    public String getRequest();
    
    /**
     * @return String - the SERVICE passed by the requestor.
     */
    public String getService();
    
    public Map getVendorSpecificParams();    

}