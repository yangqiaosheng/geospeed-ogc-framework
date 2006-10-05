package org.geospeed.ogc.api.wfs;

import java.util.List;

public interface IOgcWfsDescribeFeatureTypeRequest extends IOgcWfsRequest
{
    public List getTypenames();
    
    public String getOutputFormat();
}
