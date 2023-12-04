import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int score = 0;
    private Label scoreLabel;
    
    public MyWorld()
    {    
        super(600, 400, 1, false);
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        spawnApple();
        
        scoreLabel = new Label(0, 70);
        addObject(scoreLabel, 50, 50);

    }
    
    public void onGameOver() {
        Label gameOverLabel = new Label("Game Over!", 70);
        addObject(gameOverLabel, getWidth()/2, getHeight()/2);
        
    }
    
    public void increaseScore() {
        score = score + 1;
        scoreLabel.setValue(score);
    }
    
    public void spawnApple() {
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        Apple apple = new Apple();
        addObject(apple, x, y);
    }
}