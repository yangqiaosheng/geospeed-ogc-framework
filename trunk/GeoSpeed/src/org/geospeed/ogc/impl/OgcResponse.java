package org.geospeed.ogc.impl;

import org.geospeed.ogc.api.IOgcResponse;

public class OgcResponse implements IOgcResponse 
{
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

    public void setData(byte[] _data)
    {
        data = _data;
    }
    
    public byte[] getData()
    {
        return data;
    }
}
