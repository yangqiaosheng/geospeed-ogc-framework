package org.geospeed.impl;

import java.util.ServiceLoader;

import org.apache.log4j.Logger;
import org.geospeed.api.IOgcRequestProcessor;
import org.geospeed.keys.OgcProcessorsKey;

public abstract class OgcRequestProcessorFactory
{
	private Logger log = Logger.getLogger(this.getClass());
	
    protected IOgcRequestProcessor createProcessor(OgcProcessorsKey key)
    {
    	log.debug("createProcessor::enter.");
    	
    	log.debug("loading services...");
    	ServiceLoader<IOgcRequestProcessor> sl = ServiceLoader.load(IOgcRequestProcessor.class);
    	log.debug("Complete.");
    	
    	log.debug("Searching for service '" + key.name() + "'.");
    	for (IOgcRequestProcessor rp : sl)
    	{
    		log.debug("Examining IOgcRequestProcessor " + rp.getProcessorType().name());
    		if (rp.getProcessorType().equals(key))
    		{
    			log.debug("Service '" + rp.getProcessorType().name() + "' found!");
    		
    			return rp;
    		}
    	}
    	
    	log.debug("Could not find service with name '" + key.name() + "'.");
    	return null;
    }
}
