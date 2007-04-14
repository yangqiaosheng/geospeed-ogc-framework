package org.geospeed.api.wms;

import java.util.List;

/********************************************************************************
 * 
 * @author Mike Abner
 * 
 * The IOgcWmsGetMapRequest interface defines the methods for accessing
 * attributes contained in the WMS GetMap request as defined by the OGC
 * WMS specification.
 *
 ********************************************************************************/
public interface IOgcWmsGetMapRequest extends IOgcWmsRequest 
{
    public List<String> getLayers();
    
	/**
	 * @return String - The SLD_BODY passed by the requestor.
	 */
    public String getSLD();
    
    /**
     * @return String - The WFS passed by the requestor (version 1.1.0 and 1.1.1).
     */
    public String getWFS();
    
    /**
     * @return List - the STYLES passed by the requestor.
     */
    public List<String> getStyles();
    
    /**
     * @return String - the CRS passed by the requestor.
     */
    public String getCRS();
    
    /**
     * @return double - the minx part of the BBOX passed by the requestor.
     */
    public double getMinX();
    
    /**
     * @return double - the maxx part of the BBOX passed by the requestor.
     */
    public double getMaxX();
    
    /**
     * @return double - the miny part of the BBOX passed by the requestor.
     */
    public double getMinY();
    
    /**
     * @return double - the maxy part of the BBOX passed by the requestor.
     */
    public double getMaxY();
    
    /**
     * @return int - the WIDTH passed by the requestor.
     */
    public int getWidth();
    
    /**
     * @return int - the HEIGHT passed by the requestor.
     */
    public int getHeight();
    
    /**
     * @return String - the FORMAT passed by the requestor.
     */
    public String getFormat();
    
    /**
     * @return String - the TRANSPARENT passed by the requestor.
     */
    public boolean getTransparent();
    
    /**
     * @return String - the BGCOLOR passed by the requestor.
     */
    public String getBackgroundColor();
    
    /**
     * @return String - the EXCEPTIONS passed by the requestor.
     */
    public String getExceptionFormat();
    
    /**
     * @return int - the ELEVATION passed by the requestor.
     */
    public int getElevation();
    
    /**
     * @return String - the TIME passed by the requestor.
     */
    public String getTime();
}
