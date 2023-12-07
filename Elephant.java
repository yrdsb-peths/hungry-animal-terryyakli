import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Elephant eats food. Elephant wins.
 * 
 * @author Theresa Li 
 * @version DEc 5/23
 */

public class Elephant extends Actor
{
    GreenfootSound ElephantEatSound = new GreenfootSound("nomnom.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    // ^^ GreenfootImage idle = new GreenfootImage("images/folderName/fileName.png");
    
    // Direction Elephant is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer(); 
    
    // Constructor
    public Elephant()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100, 100);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }
        
        animationTimer.mark();
        
        // Initial elephant image
        setImage(idleRight[0]);
    }
    
    int imageIndex = 0;
    // Not sure. int animationTimer = 0;
    
    // Animate the Elephant
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 200)
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
    
    int speed = 1;
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("a"))
        {
            move(-3 - speed);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            move(3 + speed);
            facing = "right";
        }
        
        // Remove app if ele eats it
        eat();
        
        //Animate the elephant
        animateElephant();
    }
    
    
    public void eat() {
        // Eat the apple and speed up if eaten
        if (isTouching(Apple.class)){
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
            world.increaseScore();
            speed += 1;
            ElephantEatSound.play();
        }
    }
    
   
}
