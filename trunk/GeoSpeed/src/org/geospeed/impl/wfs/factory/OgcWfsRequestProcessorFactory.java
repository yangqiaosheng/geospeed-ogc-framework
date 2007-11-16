package org.geospeed.impl.wfs.factory;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.geospeed.api.IOgcRequestProcessor;
import org.geospeed.impl.OgcRequestProcessorFactory;
import org.geospeed.keys.OgcProcessorsKey;
import org.geospeed.keys.WebFeatureServiceKey;

public class OgcWfsRequestProcessorFactory extends OgcRequestProcessorFactory
{
	private static OgcWfsRequestProcessorFactory me;
	private static Logger log = Logger.getLogger(OgcWfsRequestProcessorFactory.class);
	
	private OgcWfsRequestProcessorFactory()
	{
	}

    /**
     * This returns a singleton instance of the factory.  This should not be used by 
     * classes outside of the framework.
     * 
     * @return an OgcWmsRequestProcessorFactory object.
     */
	public static OgcWfsRequestProcessorFactory getInstance()
	{
        log.debug("Entering getInstance().");
        
		if (me == null)
        {
            log.debug("Creating an OgcWmsRequestProcessorFactory.");
            me = new OgcWfsRequestProcessorFactory();       
        }
        
        log.debug("Exiting getInstance().");        
		return me;
	}
	
    /**
     * Creates the appropriate IOgcRequestProcessor based on the type of request as
     * specified in the requestParameter and based on the definitions found in the
     * processor.properties file.
     * 
     * @param requestParameter - The type of WMS request (e.g. GetCapabilities, GetMap, etc.)
     * @return IOgcRequestProcessor - A request processor that can handle the type of request
     * indicated by the requestParameter as specified in the processor.properties file.
     * @throws IOException - If the processor.properties file can not be found OR if the class
     * files corresponding to the entries in the processor.properties can not be found.
     */
	public IOgcRequestProcessor createProcessor(String requestParameter) throws IOException
    {	
        log.debug("Entering createProcessor(String).");
		
        log.debug("Creating an IOgcRequestProcessor based on the REQUEST parameter '" + requestParameter + "'.");
        
        if (requestParameter.equalsIgnoreCase(WebFeatureServiceKey.GETCAPABILITIES.name()))
        {
            return createProcessor(OgcProcessorsKey.WFSGETCAPABILITIES);        	
        }
        if (requestParameter.equalsIgnoreCase(WebFeatureServiceKey.DESCRIBEFEATURETYPE.name()))
        {
            return createProcessor(OgcProcessorsKey.WFSDESCRIBEFEATURETYPE);        	
        }
        if (requestParameter.equalsIgnoreCase(WebFeatureServiceKey.GETFEATURE.name()))
        {
            return createProcessor(OgcProcessorsKey.WFSGETFEATURE);        	
        }
        if (requestParameter.equalsIgnoreCase(WebFeatureServiceKey.GETGMLOBJECT.name()))
        {
            return createProcessor(OgcProcessorsKey.WFSGETGMLOBJECT);        	
        }
        if (requestParameter.equalsIgnoreCase(WebFeatureServiceKey.LOCKFEATURE.name()))
        {
            return createProcessor(OgcProcessorsKey.WFSLOCKFEATURE);        	
        }
        if (requestParameter.equalsIgnoreCase(WebFeatureServiceKey.TRANSACTION.name()))
        {
            return createProcessor(OgcProcessorsKey.WFSTRANSACTION);        	
        }
        
        String msg = "No wfs request processor object could be created from the request parameter '" + requestParameter + "'";
        log.error(msg);
        log.debug("Exiting createProcessor(String).");
        throw new IOException(msg);
    }
}
