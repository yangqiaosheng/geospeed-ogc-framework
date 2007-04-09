package org.geospeed.ogc.api;

/********************************************************************************
 * 
 * @author Mike Abner
 * 
 * The IOgcResponse interface defines the methods needed by the web tier to send
 * responses generated by the application tier to the requestor.
 *
 ********************************************************************************/
public interface IOgcResponse 
{
	/**
	 * Get the length of the data to be returned to the requestor.
	 * 
	 * @return int - The number of bytes in the response.
	 */
	 public int getLength();
	    
	 /**
	  * Get the byte at a specific location in the data array.  This method is
	  * available for convienience.  The more desirable way to get at the data 
	  * is to use the getBytes() method.  The reason for this is that, unless
	  * data manipulation is needed, performance is better when sending the 
	  * entire byte array to the requestor instead of doing it a byte at a time.
	  * 
	  * @param i - The index into the data array.
	  * @return int - An integer representation of the byte at location i.
	  */
	 public int getByteAt(int i);
	    
	 /**
	  * Get the full data array.  This data array can contain a variety of types
	  * of data but will generally contain XML or IMAGE data as needed by the 
	  * various types of requests as specified by the OGC Specifications.
	  * 
	  * @return byte[] - An array containing all of the data to be returned to th
	  * requestor. 
	  */
	 public byte[] getBytes();
	 
	 /**
	  * Get the type of request this response object is in response too.  This 
	  * method is mainly for convienience for testing the wiring of the framework
	  * plugin classes.  The return value will not be used in forming the actual
	  * response to the requestor.
	  * 
	  * For example, to create on object to process WMS GetMap requests, a developer
	  * can first create a MyWmsGetMapRequestProcessor class and simply have it return
	  * an IOgcRespone object with the Response Type attribute set to "GetMap".  Running
	  * the com.fgm.jp.ogc.test.wms.SmokeTest class will then allow the developer to 
	  * determine whether or not their CLASSPATH and build time properties are set 
	  * correctly.  See the FGM OGC Framework Developers Guide for more information.
	  * 
	  * @return String - A string representing the type of response that is contained
	  * in the data array.
	  */
	 public String getResponseType();
}