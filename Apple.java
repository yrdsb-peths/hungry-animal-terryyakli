import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for Wombat.
 * 
 * @author Theresa Li 
 * @version November 27/23
 */
public class Apple extends Actor
{
    private int speed = 1;

    public Apple()
    {
        GreenfootImage image = getImage();
        image.scale(30,30);
        setImage(image);
    }
    
    public void act()
    {
        setLocation(getX(), getY() + 2);
        MyWorld world = (MyWorld) getWorld();
        if(getY() > world.getHeight()) {
            world.onGameOver();
        }
    }

    public void setSpeed(int spd) {
        speed = spd;
    }




}
