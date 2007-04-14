package org.geospeed.api.wms;

/********************************************************************************
 * 
 * @author Mike Abner
 * 
 * The IOgcWmsGetCapabilitiesrRequest interface defines the methods for accessing
 * attributes contained in the WMS GetCapabilities request as defined by the OGC
 * WMS specification.
 *
 ********************************************************************************/
public interface IOgcWmsGetCapabilitiesRequest extends IOgcWmsRequest 
{
    /**
     * @return String - Output format of service metadata.
     */
    public String getFormat();
    
    /**
     * @return String - The optional UPDATESEQUENCE parameter is for maintaining cache consistency.
     */
    public String getUpdateSequence();
}
