package org.geospeed.ogc.api.wcs;

public interface IOgcWcsGetCapabilitiesRequest extends IOgcWcsRequest
{
    public String getSection();
    
    public String getUpdateSequence();
}
