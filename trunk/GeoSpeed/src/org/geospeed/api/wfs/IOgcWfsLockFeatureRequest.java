package org.geospeed.api.wfs;

import java.util.List;

public interface IOgcWfsLockFeatureRequest
{
	public List<String> getTypeName();
	
	public int getExpiry();
	
	public String getLockAction();
	
	public List<String> getFeatureId();
	
	public String getFilter();
	
	public String getBBox();
	
}
