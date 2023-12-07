import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//hi testing making sure this can work!
//it does work!!


public class MyWorld extends World
{
    private int score = 1;
    private Label scoreLabel;
    int level = 1;
    
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
        Label gameOverLabel = new Label("Game over! :( Try Again :)", 50);
        addObject(gameOverLabel, getWidth()/2, getHeight()/2);
        
    }
    
    public void increaseScore() {
        score++;
        scoreLabel.setValue(score);

        if(score % 5 == 0){
            level+= 1;
        }
    }
    
    
    public void spawnApple() {
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = 0;
        
        Apple apple = new Apple();
        addObject(apple, x, y);
        apple.setSpeed(level);
    }
}