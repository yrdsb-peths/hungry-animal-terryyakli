import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Elephant eats food. Elephant wins.
 * 
 * @author Theresa Li 
 * @version Nov 29/23
 */

public class Elephant extends Actor
{
    GreenfootSound ElephantEatSound = new GreenfootSound("nomnom.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    // GreenfootImage idle = new GreenfootImage("images/folderName/fileName.png");
    
    // Direction Elephant is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    // Constructor
    public Elephant() {
        //GreenfootImage image = getImage();
        //image.scale(100,100);
        
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("Pictures/Shark/idle" + i + ".png");
            idleRight[i].scale(100, 100);
        }
        
        for(int i = 0; i < idleLeft.length; i++) {
            idleLeft[i] = new GreenfootImage("Pictures/Shark/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }
        
        animationTimer.mark();
        
        // Initial Elephant image
        setImage(idleRight[0]);
    }
    
    
    // Animate the Elephant
    public void animateElephant() {
        if(animationTimer.millisElasped() < 200)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        
    }
    
    
    public void act()
    {
        if(Greenfoot.isKeyDown("a")){
            move(-3);
            facing = "left";
            
        }
        if(Greenfoot.isKeyDown("d")){
            move(3);
            facing = "right";
        }
        
        eat();
        
        //animate Elephant
        animateElephant();
    }
    
    
    public void eat() {
        // Eat the apple
        if (isTouching(Apple.class)){
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
            world.increaseScore();
            ElephantEatSound.play();
        }
    }
    
   
}
