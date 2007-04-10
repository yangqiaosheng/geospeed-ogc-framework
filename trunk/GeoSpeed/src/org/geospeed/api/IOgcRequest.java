package org.geospeed.api;

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
     * @return String - The VERSION parameter specifies the protocol version number.
     */
    public String getVersion();
    
    /**
     * @return String - The REQUEST parameter indicates which service operation is being invoked.
     */
    public String getRequest();
    
    /**
     * @return String - The mandatory SERVICE parameter indicates which of the available service 
     * types at a particular server is being invoked.
     */
    public String getService();
    
    public Map<String, String> getVendorSpecificParams();    

}