package org.geospeed.ogc.api;



/********************************************************************************
 * 
 * @author Mike Abner
 *
 * This interface defines the methods for all of the different types of OGC
 * services defined by their specifications.  Currently these are limited to Web
 * Mapping Service and Web Feature Service.
 * 
 ********************************************************************************/
public interface IOgcService 
{
	/**
	 * Each OGC service is invoked with this method.  It is abstracted from the Web
	 * tier to make testing of each service easier.
	 * 
	 * @param params - A Map containing all of the parameters passed by the requestor.
	 * @return IOgcRespones - An object that contains the appropriate data to return
	 * to the requestor as defined by the OGC specifications.
	 */
	public IOgcResponse executeRequest(IOgcMap params);
}
