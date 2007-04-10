package org.geospeed.impl.wms.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.geospeed.api.IOgcRequestProcessor;
import org.geospeed.keys.OgcProcessorsKey;
import org.geospeed.keys.WebMappingServiceKey;


/********************************************************************************
 * 
 * @author Mike Abner
 *
 * The OgcWmsRequestProcessorFactory creates IOgcRequestProcessors based on the
 * entries in the processors.properties file that must be on the CLASSPATH of the
 * application.  This file contains the fully qualified class names (i.e. 
 * this.is.my.pkg.ThisIsMyClass) of the classes that implement the 
 * IOgcRequestProcessor for the various types of WMS requests specified in the 
 * OGC specifications.
 * 
 * While it is possible for all of the request types to be handled by one class, 
 * it is strongly discouraged as it breaks the design principles of Seperation of
 * Concerns, couhesion and coupling, etc.  Instead, the developer should create
 * independant classes that handle the various request types.
 * 
 * An example IOgcRequestProcessor is below:
 * 
 * <code>
 *  package com.fgm.jp.ogc.test.wms.mock;

    import com.fgm.jp.ogc.api.IOgcRequest;
    import com.fgm.jp.ogc.api.IOgcResponse;
    import com.fgm.jp.ogc.api.wms.IOgcRequestProcessor;
    import com.fgm.jp.ogc.api.wms.IOgcWmsRequest;
    import com.fgm.jp.ogc.impl.wms.response.OgcWmsResponse;
    
    public class MockWmsGetCapabilitiesProcessor implements IOgcRequestProcessor 
    {
    
        public IOgcResponse processRequest(IOgcRequest request) 
        {
            IOgcWmsRequest req = (IOgcWmsRequest)request;
            OgcWmsResponse res = new OgcWmsResponse();
            res.setResponseType(req.getRequest());
            return res;
        }
    
    }
    </code>
 *
 * This code simply creates an IOgcResponse object, fills the ResponseType 
 * attribute with the type of request, and returns.  
 * 
 * To wire this class into the framework, the processor.properties file should
 * contain the entry: 
 * "WmsGetCapabilitiesProcessor=com.fgm.jp.ogc.test.wms.mock.MockWmsGetCapabilitiesProcessor"
 * 
 * This tells the OgcWmsRequestProcessorFactory to create a MockWmsGetCapabilitiesProcessor
 * in response to any Wms GetCapabilities request issued by the requestor.
 * 
 * Once the skeleton code above and the entry in the processors.properties file
 * are made, and both the skeleton class file and the processor.properties file
 * are included on the CLASSPATH, the developer can run the 
 * com.fgm.jp.ogc.test.wms.SmokeTest class to see if the wiring was successful.
 * 
 ********************************************************************************/
public class OgcWmsRequestProcessorFactory
{	
	private static OgcWmsRequestProcessorFactory me;
	private static Logger log = Logger.getLogger(OgcWmsRequestProcessorFactory.class);
    private Properties processors = new Properties();
	private boolean loaded = false;
    private String msgPart1 = "An error occured loading the ";
    private String msgPart2 = " class.  Either the class was not specified in the processor.properties " +
            "file or the class that was specified in the processor.properties file could not be found.";
	
	private OgcWmsRequestProcessorFactory()
	{
	}

    /**
     * This returns a singleton instance of the factory.  This should not be used by 
     * classes outside of the framework.
     * 
     * @return an OgcWmsRequestProcessorFactory object.
     */
	public static OgcWmsRequestProcessorFactory getInstance()
	{
        log.debug("Entering getInstance().");
        
		if (me == null)
        {
            log.debug("Creating an OgcWmsRequestProcessorFactory.");
            me = new OgcWmsRequestProcessorFactory();       
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
        
		if (!me.loaded)
		{
            log.debug("Opening the processor.properties file from the classpath.");
			InputStream is = me.getClass().getClassLoader().getResourceAsStream("processors.properties");
            
            if (is == null)
            {
                log.error("Could not find the processor.properties file on the classpath.");
                throw new IOException("Could not find the processor.properties file.  Check to make sure the" +
                        "processor.properties file (or the folder that contains that file) is on the classpath of your application");
            }
            
			me.processors.load(is);
			me.loaded = true;
		}
		
		
		
        log.debug("Creating an IOgcRequestProcessor based on the REQUEST parameter '" + requestParameter + "'");
        
        if (requestParameter.equalsIgnoreCase(WebMappingServiceKey.GETCAPABILITIES.name())
                || requestParameter.equalsIgnoreCase(WebMappingServiceKey.CAPABILITIES.name()))
        {
            return createProcessor(OgcProcessorsKey.WMSGETCAPABILITIES);        	
        }
        
        if (requestParameter.equalsIgnoreCase(WebMappingServiceKey.GETMAP.name())
                || requestParameter.equalsIgnoreCase(WebMappingServiceKey.MAP.name()))
        {
        	return createProcessor(OgcProcessorsKey.WMSGETMAP);
    	}
        
        if (requestParameter.equalsIgnoreCase(WebMappingServiceKey.GETFEATUREINFO.name())
                || requestParameter.equalsIgnoreCase(WebMappingServiceKey.FEATUREINFO.name()))
        {	
        	return createProcessor(OgcProcessorsKey.WMSGETFEATUREINFO);
    	}
        
        if (requestParameter.equalsIgnoreCase(WebMappingServiceKey.DESCRIBELAYER.name()))
        {
        	return createProcessor(OgcProcessorsKey.WMSDESCRIBELAYER);
        }
        
        if (requestParameter.equalsIgnoreCase(WebMappingServiceKey.GETLEGENDGRAPHIC.name()))
        {
            return createProcessor(OgcProcessorsKey.WMSGETLEGENDGRAPHIC);
        }
        
        if (requestParameter.equalsIgnoreCase(WebMappingServiceKey.GETSYTLES.name()))
        {
            return createProcessor(OgcProcessorsKey.WMSGETSTYLES);
        }
        
        if (requestParameter.equalsIgnoreCase(WebMappingServiceKey.PUTSTYLES.name()))
        {
            return createProcessor(OgcProcessorsKey.WMSPUTSTYLES);
        }
        
        log.error("Could not create an IOgcRequestProcessor from the specified REQUEST parameter.");
        log.debug("Exiting createProcessor(String).");
        throw new IOException("No wms request processor object could be created from the request parameter '" + requestParameter + "'");
    }
    
    private IOgcRequestProcessor createProcessor(OgcProcessorsKey key) throws IOException
    {
        Class processor;
        
        try
        {
            processor = Class.forName(processors.getProperty(key.name()));
            log.debug("Exiting createProcessor(String).  Returning " + key.name() + ".");
            return (IOgcRequestProcessor)processor.newInstance();
        }
        catch (Exception e)
        {
            log.error("Could not create a " + key.name() + ".");
            throw new IOException(msgPart1 + key.name() + msgPart2);
        }
    }
}
