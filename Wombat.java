import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wombat here.
 * 
 * @author Theresa Li 
 * @version Nov 24/23
 */
public class Wombat extends Actor
{
    public Wombat() {
        GreenfootImage image = getImage();
        image.scale(100,100);
        setImage(image);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("a")){
            move(-3);    
        }
        if(Greenfoot.isKeyDown("d")){
            move(3);
        }
        
        eat();
    }
    
    public void eat() {
        // Eat the apple
        if (isTouching(Apple.class)){
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
            world.increaseScore();
        }
    }
    
   
}
