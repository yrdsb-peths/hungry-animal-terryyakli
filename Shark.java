import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wombat here.
 * 
 * @author Theresa Li 
 * @version Nov 24/23
 */
public class Shark extends Actor
{
    public Shark() {
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
        if (isTouching(Baby.class)){
            removeTouching(Baby.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
            world.increaseScore();
        }
    }
    
   
}
