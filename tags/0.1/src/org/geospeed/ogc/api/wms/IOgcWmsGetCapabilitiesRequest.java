package org.geospeed.ogc.api.wms;

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
    public String getUpdateSequence();
}
