import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for Wombat.
 * 
 * @author Theresa Li 
 * @version November 27/23
 */
public class Baby extends Actor
{
    public void act()
    {
        setLocation(getX(), getY() + 2);
        MyWorld world = (MyWorld) getWorld();
        if(getY() > world.getHeight()) {
            world.onGameOver();
        }
    }
}
