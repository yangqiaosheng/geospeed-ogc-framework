package org.geospeed.api;

import org.geospeed.keys.OgcProcessorsKey;


/********************************************************************************
 * 
 * @author Mike Abner
 * 
 * The IOgcRequestProcessor defines the behavior of the classes that respond to 
 * the various types of requests as defined by the OGC Specifications.  Each of 
 * these classes must implement the processRequest(IOgcRequest) method.  The 
 * implementing classes should then cast the IOgcRequest object to the appropriate
 * request type (e.x. IWmsGetCapabilitiesRequest for WMS GetCapabilities 
 * requests).  The implementing object must create an IOgcResponse object, fill it
 * with the appropriate data (again based on the OGC Specifications), and return
 * it to the calling method. 
 *
 ********************************************************************************/
public interface IOgcRequestProcessor 
{
	/**
	 * The processRequest method takes an IOgcRequest object, casts it to the
	 * appropriate IOgcRequest type, performs any necessary functions, and returns
	 * an IOgcResponse object that contains the data to be returned to the 
	 * requestor.
	 * 
	 * @param request - The IOgcRequest object that contains all of the parameters 
	 * passed from the requestor.
	 * @return IOgcResponse - The response to the specific request.  The contained
	 * in the IOgcResponse object should match what is defined in the OGC
	 * specifications for the particular request type (i.e. XML for WMS GetCapabilities
	 * requests, IMAGE data for WMS GetMap requests, etc.).
	 */
	public IOgcResponse processRequest(IOgcRequest request);
	
	/**
	 * Must return one of the keys defined in org.geospeed.keys.OgcProcessorsKey!
	 * 
	 * @return
	 */
	public OgcProcessorsKey getProcessorType();
}
