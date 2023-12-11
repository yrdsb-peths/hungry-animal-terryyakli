import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for Wombat.
 * 
 * @author Theresa Li 
 * @version December 2023
 */
public class Apple extends Actor
{
    int speed = 2;

    public Apple()
    {
        GreenfootImage image = getImage();
        image.scale(30,30);
        setImage(image);
    }
    

    public void act()
    {
        // Add your action code here.
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        if(getX()>550)
        {
            setLocation(550, getY());
        }
        else if(getX() < 50)
        {
            setLocation(50, getY());
        }
        
        // Remove apple and draw game over when apple gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.onGameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }


}
