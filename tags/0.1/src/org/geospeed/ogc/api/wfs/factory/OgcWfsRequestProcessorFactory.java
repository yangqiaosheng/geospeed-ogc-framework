package org.geospeed.ogc.api.wfs.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.geospeed.ogc.api.IOgcRequestProcessor;


public class OgcWfsRequestProcessorFactory
{
    private static OgcWfsRequestProcessorFactory me;
    private Properties processors = new Properties();
    private boolean loaded = false;
    private String msgPart1 = "An error occured loading the ";
    private String msgPart2 = " class.  Either the class was not specified in the processor.properties " +
            "file or the class that was specified in the processor.properties file could not be found.";
    
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
        if (me == null)
            me = new OgcWfsRequestProcessorFactory();
        
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
        if (!me.loaded)
        {
            InputStream is = me.getClass().getClassLoader().getResourceAsStream("processors.properties");
            
            if (is == null)
            {
                throw new IOException("Could not find the processor.properties file.  Check to make sure the" +
                        "processor.properties file (or the folder that contains that file) is on the classpath of your application");
            }
            
            me.processors.load(is);
            me.loaded = true;
        }
        
        Class processor;
        if (requestParameter.equalsIgnoreCase("GetCapabilities"))
        {
            try
            {
                processor = Class.forName(processors.getProperty("WfsGetCapabilitiesProcessor"));
                return (IOgcRequestProcessor)processor.newInstance();
            }
            catch (Exception e)
            {
                throw new IOException(msgPart1 + "WfsGetCapabilitiesProcessor" + msgPart2);
            }
        }
        
        if (requestParameter.equalsIgnoreCase("DescribeFeatureType"))
        {
            try
            {
                processor = Class.forName(processors.getProperty("WfsDescribeFeatureTypeProcessor"));
                return (IOgcRequestProcessor)processor.newInstance();
            }
            catch (Exception e)
            {
                throw new IOException(msgPart1 + "WfsDescribeFeatureTypeProcessor" + msgPart2);
            }
        }
        
        if (requestParameter.equalsIgnoreCase("GetFeature") || requestParameter.equalsIgnoreCase("GetFeatureWithLock"))
        {   
            try
            {
                processor = Class.forName(processors.getProperty("WfsGetFeatureProcessor"));
                return (IOgcRequestProcessor)processor.newInstance();
            }
            catch (Exception e)
            {
                throw new IOException(msgPart1 + "WfsGetFeatureProcessor" + msgPart2);
            }
        }
        
        if (requestParameter.equalsIgnoreCase("GetGmlObject"))
        {
            try
            {
                processor = Class.forName(processors.getProperty("WfsGetGmlObjectProcessor"));
                return (IOgcRequestProcessor)processor.newInstance();
            }
            catch (Exception e)
            {
                throw new IOException(msgPart1 + "WfsGetGmlObjectProcessor" + msgPart2);
            }
        }
        
        if (requestParameter.equalsIgnoreCase("LockFeature"))
        {
            try
            {
                processor = Class.forName(processors.getProperty("WfsLockFeatureProcessor"));
                return (IOgcRequestProcessor)processor.newInstance();
            }
            catch (Exception e)
            {
                throw new IOException(msgPart1 + "WfsLockFeatureProcessor" + msgPart2);
            }
        }
        
        if (requestParameter.equalsIgnoreCase("Transaction"))
        {
            try
            {
                processor = Class.forName(processors.getProperty("WfsTransactionProcessor"));
                return (IOgcRequestProcessor)processor.newInstance();
            }
            catch (Exception e)
            {
                
                throw new IOException(msgPart1 + "WfsTransactionProcessor" + msgPart2);
            }
        }
        
        throw new IOException("No wfs request processor object could be created from the request parameter '" + requestParameter + "'");
    }
}
