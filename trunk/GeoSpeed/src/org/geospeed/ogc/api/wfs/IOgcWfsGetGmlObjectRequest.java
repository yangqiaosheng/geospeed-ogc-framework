package org.geospeed.ogc.api.wfs;

public interface IOgcWfsGetGmlObjectRequest extends IOgcWfsRequest
{
    public String getTraverseXlinkDepth();
    
    public String getTraverseXlinkExpiry();
    
    public String getGmlObjectId();
}
