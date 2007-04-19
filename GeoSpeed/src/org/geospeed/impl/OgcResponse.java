package org.geospeed.impl;

import java.util.HashMap;
import java.util.Map;

import org.geospeed.api.IOgcResponse;
import org.geospeed.keys.ContentTypeKey;

/**
 * 
 * @author Mike Abner
 * 
 * OgcResponse is an implementation of the IOgcResponse interface.  It simply wraps
 * a byte array of the data that will be returned to the request initiator.  setBytes()
 * and setContentType() should both be called before returning an instance of this object
 * to the web tier. 
 *
 */
public class OgcResponse implements IOgcResponse 
{
	private String contentType = "";
    private String responseType = "";
    private byte[] data = new byte[1];
    private int status = 0;
    private Map<String, Long> dateHeaders = new HashMap<String, Long>();
    private Map<String, String> headers = new HashMap<String, String>();
    private Map<String, Integer> intHeaders = new HashMap<String, Integer>();

    /**
     * Create an empty instance of the OgcResponse object.
     */
    public OgcResponse()
    {
        
    }
    
    /**
     * Create an instance of the OgcResponse object with the supplied byte array. 
     * @param _data
     */
    public OgcResponse(byte[] _data)
    {
        data = _data;
    }
    
    /**
     * Create an instance of the OgcResponse object with the supplied byte array
     * and ContentTypeKey.
     * @param _data
     * @param _key
     */
    public OgcResponse(byte[] _data, ContentTypeKey _key)
    {
        data = _data;
        contentType = _key.name();
    }
    
    /**
     * Create an instance of the OgcResponse object with the supplied byte array
     * and the content type String.
     * @param _data
     * @param _contentType
     */
    public OgcResponse(byte[] _data, String _contentType)
    {
        data = _data;
        contentType = _contentType;
    }
    
    /**
     * @return int - the length of the data array.
     */
	public int getLength() 
	{
		return data.length;
	}

    /**
     * @return int - the value in the data array at index i.
     */
	public int getByteAt(int i) 
	{
		return data[i];
	}

    /**
     * @return byte[] - the entire data array.
     */
	public byte[] getBytes() 
	{
		return data;
	}

    /**
     * @return String - the response type of this object (Intended to ease testing.
     * Should be set to one of the request types in the org.geospeed.keys.WebMappingServiceKey class).
     */
    public String getResponseType()
    {
        return responseType;
    }
    
    /**
     * Sets the response type of this object.
     * @param _responseType - Intended to ease testing.
     * Should be set to one of the request types in the org.geospeed.keys.WebMappingServiceKey class.
     */
    public void setResponseType(String _responseType)
    {
        responseType = _responseType;
    }
    
    /**
     * @return String - the HTTP content type of this response.  Typically a value from the 
     * org.geospeed.keys.ContentTypeKey class.
     */
	public String getContentType() 
	{
		return contentType;
	}
	
    /**
     * Set the HTTP content type of this response.  Typically a value from the
     * org.geospeed.keys.ContentTypeKey class.
     * @param _contentType String 
     */
	public void setContentType(String _contentType)
	{
		contentType = _contentType;
	}

    /**
     * Set the data to be returned to the request initiator.
     * @param _data
     */
    public void setData(byte[] _data)
    {
        data = _data;
    }
    
    /**
     * @return byte[] - the entire array of data to be returned to the request initiator. 
     */
    public byte[] getData()
    {
        return data;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int _status)
    {
        status = _status;
    }
    
    public Map<String, Long> getDateHeader()
    {
        return dateHeaders;
    }

    public void addDateHeader(String name, long date)
    {
        dateHeaders.put(name, new Long(date));
    }
    
    public Map<String, String> getHeaders()
    {
        return headers;
    }

    public void addHeader(String name, String value)
    {
        headers.put(name, value);
    }
    
    public Map<String, Integer> getIntHeaders()
    {
        return intHeaders;
    }
    
    public void addIntHeader(String name, Integer value)
    {
        intHeaders.put(name, value);
    }
}
