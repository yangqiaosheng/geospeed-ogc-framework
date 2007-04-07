package org.geospeed.keys;

public class Key
{
    private String name;
    
    protected Key(String _name)
    {
        name = _name;
    }
    
    public String name()
    {
        return name;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Key)
        {
          Key key = (Key)obj;
        
          return name.equals(key.name());
        }
        
        return false;
    }
    
    public String toString()
    {
        return name;
    }
    
    public int hashCode()
    {
        return name.hashCode();
    }

}
