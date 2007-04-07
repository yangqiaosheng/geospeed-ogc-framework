package org.geospeed.impl;

import org.geospeed.api.IOgcResponse;

public class OgcResponse implements IOgcResponse 
{
	private String contentType = "";
    private String responseType = "";
    private byte[] data = new byte[1]; 

    public OgcResponse()
    {
        
    }
    
    public OgcResponse(byte[] _data)
    {
        data = _data;
    }
    
	public int getLength() 
	{
		return data.length;
	}

	public int getByteAt(int i) 
	{
		return data[i];
	}

	public byte[] getBytes() 
	{
		return data;
	}

    public String getResponseType()
    {
        return responseType;
    }
    
    public void setResponseType(String _responseType)
    {
        responseType = _responseType;
    }
    
	public String getContentType() 
	{
		return contentType;
	}
	
	public void setContentType(String _contentType)
	{
		contentType = _contentType;
	}

    public void setData(byte[] _data)
    {
        data = _data;
    }
    
    public byte[] getData()
    {
        return data;
    }
}
