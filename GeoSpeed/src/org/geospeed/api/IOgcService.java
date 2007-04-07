package org.geospeed.api;

import java.util.Map;

/********************************************************************************
 * 
 * @author Mike Abner
 *
 * This interface defines the integration point between the <b>Web</b> tier and the 
 * <b>Application</b> tier.  Implementors of this interface should perform the 
 * necessary operations for their respective OGC Service types (WMS, WFS, etc.) and
 * return a valid IOgcResponse object that can be returned to the request initiator.
 * 
 ********************************************************************************/
public interface IOgcService 
{
	/**
	 * Each OGC service is invoked with this method.  This allows for the separation
     * of the Web and Application tiers which makes various aspects of development
     * easier to perform (e.g. testing).
	 * 
	 * @param params - A Map containing all of the parameters passed by the request
     * initiator.
	 * @return IOgcRespones - An object that contains the appropriate data to return
	 * to the request initiator as defined by the OGC specifications.
	 */
	public IOgcResponse executeRequest(Map<String, String> params);
}
