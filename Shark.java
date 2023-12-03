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
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    // GreenfootImage idle = new GreenfootImage("images/folderName/fileName.png");
    
    // Direction shark is facing
    String facing = "right";
    
    // Constructor
    public Shark() {
        //GreenfootImage image = getImage();
        //image.scale(100,100);
        
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("Pictures/Shark/idle" + i + ".png");
            idleRight[i].scale(100, 100);
        }
        
        for(int i = 0; i < idleLeft.length; i++) {
            idleLeft[i] = new GreenfootImage("Pictures/Shark/idle" + i + ".png");
            
            idleLeft[i].scale(100, 100);
        }
        
        // Initial shark image
        setImage(idleRight[0]);
    }
    
    
    // Animate the shark
    public void animateShark() {
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
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
        
        //animate shark
        animateShark();
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
