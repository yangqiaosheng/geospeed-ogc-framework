package org.geospeed.ogc.impl;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class AbstractOgcImage
{
    private BufferedImage bi = null;
    
    public AbstractOgcImage()
    {
        
    }
    
    public AbstractOgcImage(int width, int height)
    {
        bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }
    
    public void drawPoint(int x, int y, int diameter, Color color)
    {
        Graphics2D g = bi.createGraphics();
        
        g.setColor(color);
        g.drawOval(x, y, diameter, diameter);
    }
    
    public BufferedImage getImage()
    {
        return bi;
    }
}
