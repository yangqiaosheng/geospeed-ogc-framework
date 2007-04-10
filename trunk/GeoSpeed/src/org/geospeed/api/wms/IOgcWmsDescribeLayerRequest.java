package org.geospeed.api.wms;

import java.util.List;

/********************************************************************************
 * 
 * @author Mike Abner
 * 
 * The IOgcWmsDescribeLayerRequest interface defines the methods for accessing
 * attributes contained in the WMS DescribeLayer request as defined by the OGC
 * WMS specification.
 *
 ********************************************************************************/
public interface IOgcWmsDescribeLayerRequest extends IOgcWmsRequest 
{
	/**
	 * @return List - The list of layers passed by the requestor. 
	 */
	public List<String> getLayers();
}
