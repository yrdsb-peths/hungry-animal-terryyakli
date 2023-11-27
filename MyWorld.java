import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
     
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Wombat wombat = new Wombat();
        addObject(wombat, 300, 300);
        
        //create a label
        Label scoreLabel = new Label(0, 80); 
        addObject(scoreLabel, 40, 50);
        
        //spawns the apple into the world
        spawnApple();
        
        
    }

    //End game and say "Game Over"
    public void gameOver(){
        Label gameOverLabel = new Label("GAME OVER", 100);
        addObject(gameOver, 300, 200);
    }
    
    
    
    // Increase score by 1 if apple eaten
    public void increaseScore() {
        score++;
        scoreLabel.setValue(score);
    }
    
    
    
    
    
    public void spawnApple() {
            Apple apple = new Apple();
            int x = Greenfoot.getRandomNumber(600);
            int y = 0;
            addObject(apple, x, y);
    }
    
    
    
}

