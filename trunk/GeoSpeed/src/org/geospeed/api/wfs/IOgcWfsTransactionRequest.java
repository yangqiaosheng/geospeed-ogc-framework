package org.geospeed.api.wfs;

import java.util.List;

import org.geospeed.api.IOgcRequest;

public interface IOgcWfsTransactionRequest extends IOgcRequest
{
	public String getOperation();
	
	public List<String> getTypeName();
	
	public String getReleaseAction();
	
	public List<String> getFeatureId();
	
	public String getFilter();
	
	public String getBBox();
}
