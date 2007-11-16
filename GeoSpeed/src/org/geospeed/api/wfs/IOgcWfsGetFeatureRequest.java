package org.geospeed.api.wfs;

import java.util.List;

import org.geospeed.api.IOgcRequest;

public interface IOgcWfsGetFeatureRequest extends IOgcRequest
{
	public String getPropertyName();
	
	public String getFeatureVersion();
	
	public int getMaxFeatures();
	
	public List<String> getTypeName();
	
	public List<String> getFeatureId();
	
	public String getFilter();
	
	public String getBBox();
	
	
}
