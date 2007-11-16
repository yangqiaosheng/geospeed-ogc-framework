package org.geospeed.impl;

import java.util.ServiceLoader;

import org.geospeed.api.IOgcRequestProcessor;
import org.geospeed.keys.OgcProcessorsKey;

public abstract class OgcRequestProcessorFactory
{
    protected IOgcRequestProcessor createProcessor(OgcProcessorsKey key)
    {
    	ServiceLoader<IOgcRequestProcessor> sl = ServiceLoader.load(IOgcRequestProcessor.class);
    	
    	for (IOgcRequestProcessor rp : sl)
    	{
    		if (rp.getProcessorType().equals(key))
    			return rp;
    	}
    	
    	return null;
    }
}
