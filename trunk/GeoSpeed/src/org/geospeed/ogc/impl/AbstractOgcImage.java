package org.geospeed.ogc.impl;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

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
        g.fillOval(x, y, diameter, diameter);
    }
    
    public BufferedImage getImage()
    {
        return bi;
    }

    public ByteArrayOutputStream writeImage(String format)
    {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        
        try
        {
            ImageIO.write(bi, format, os);
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        
        return os;
    }
}
