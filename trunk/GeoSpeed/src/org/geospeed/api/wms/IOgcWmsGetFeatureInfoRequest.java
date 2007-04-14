package org.geospeed.api.wms;

import java.util.List;

/********************************************************************************
 * 
 * @author Mike Abner
 * 
 * The IOgcWmsGetFeatureInfoRequest interface defines the methods for accessing
 * attributes contained in the WMS GetFeatureInfo request as defined by the OGC
 * WMS specification.
 *
 ********************************************************************************/
public interface IOgcWmsGetFeatureInfoRequest extends IOgcWmsRequest 
{
	/**
	 * @return IOgcWmsGetMapRequest - the GetMap request passed by the requestor.
	 */
	public IOgcWmsGetMapRequest getMapRequest();
	
	/**
	 * @return List - the list of QUERY_LAYERS passed by the requestor.
	 */
	public List<String> getQueryLayers();
	
	/**
	 * @return String - the INFO_FORMAT passed by the requestor.
	 */
	public String getInfoFormat();
	
	/**
	 * @return String - the FEATURE_COUNT passed by the requestor.
	 */
	public String getFeatureCount();
	
	/**
	 * @return String - The I passed by the requestor.
	 */
	public String getI();
	
	/**
	 * @return String - The J passed by the requestor.
	 */
	public String getJ();
	
    /**
     * @return String - The X passed by the requestor (version pre-1.3.0).
     */
    public String getX();
    
    /**
     * @return String - The Y passed by the requestor (version pre-1.3.0).
     */
    public String getY();
    
	/**
	 * @return String the EXCEPTIONS passed by the requestor.
	 */
	public String getExceptions();
}
