import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for Wombat.
 * 
 * @author Theresa Li 
 * @version November 27/23
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        
        setLocation(getX(), getY() + 2);
        
        checkEdge(); 
         
    }
    public void checkEdge(){
        if(isAtEdge()){
            getWorld().removeObject(this); 
        }
    }
    
    
}
