import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bomb will end the game.
 * 
 * @author Theresa Li 
 * @version December 2023
 */
public class Bomb extends Actor
{
    int speed = 1;
    
    //constructor
    public Bomb()
    {
        GreenfootImage bomb = new GreenfootImage("bomb.png");
        bomb.scale(100,100);
        setImage(bomb);
    }
    
    
    public void act()
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.removeObject(this);
        }
    }
    

    public void setSpeed(int spd) {
        speed = spd;
    }
}
