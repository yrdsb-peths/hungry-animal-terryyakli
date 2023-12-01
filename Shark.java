import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shark eats food. Shark wins.
 * 
 * @author Theresa Li 
 * @version Nov 29/23
 */

public class Shark extends Actor
{
    GreenfootSound sharkEatSound = new GreenfootSound("nomnom.mp3");
    GreenfootImage idle = new GreenfootImage();
    
    
    
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
            world.spawnBaby();
            world.increaseScore();
            sharkEatSound.play();
        }
    }
    
   
}
