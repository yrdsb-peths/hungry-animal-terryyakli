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
        
    // Direction Elephant is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer(); 
    
    int speed = 1;
    int imageIndex = 0;
    
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
    
    
    public void act()
    {
        move();
        checkGameOver();
    }
    
    
    public void move() {
        if(Greenfoot.isKeyDown("a")||Greenfoot.isKeyDown("left"))
        {
            move(-2 - speed);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("d")||Greenfoot.isKeyDown("right"))
        {
            move(2 + speed);
            facing = "right";
        }
        
        // Remove app if elephant eats it
        eat();
        
        //Game over if the elephant touches the bomb
        bombing();
        
        //Keeps elephant within the screen margins
        bounding();
        
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
            if(speed < 25)
            {
                speed += 1;
            }
            ElephantEatSound.play();
        }
    }
    
    
    public void bombing() {
        if(isTouching(Bomb.class)) {
            explode();
        }
    }
    
    
    //Keep elephant within the game screen
    public void bounding()
    {
        if(getX()>550)
        {
            setLocation(550, getY());
        }
        else if(getX() < 50)
        {
            setLocation(50, getY());
        }

    }
    
    
    //Create explosion animation and method
    public void explode() {
        GreenfootImage[] explosionImages = new GreenfootImage[8];
        
        for (int i = 0; i < explosionImages.length; i++) {
            explosionImages[i] = new GreenfootImage("images/exp" + i + ".png");
            explosionImages[i].scale(100, 100);
        }
        
        for (int i = 0; i < explosionImages.length; i++) {
            setImage(explosionImages[i]);
            Greenfoot.delay(1);
            
            // Create a blank image
            GreenfootImage blankImage = new GreenfootImage(1, 1); 
            
            // Set a blank image to clear the previous frame
            setImage(blankImage); 
            Greenfoot.delay(1);
        }
        
        // After the explosion, remove the elephant & bomb
        getWorld().removeObject(this);

        removeTouching(Bomb.class);

        //Displays the game over screen
        checkGameOver();
    }    
    
    
    public void checkGameOver() {
        MyWorld world = (MyWorld) getWorld();
        if (world.getObjects(Elephant.class).isEmpty()) {
            world.onGameOver();
        }
    }
}
