package org.geospeed.api.wfs;

import java.util.List;

import org.geospeed.api.IOgcRequest;

public interface IOgcWfsDescribeFeatureTypeRequest extends IOgcRequest
{
	public List<String> getTypeName();
	
	public String getOutputFormat();
}
