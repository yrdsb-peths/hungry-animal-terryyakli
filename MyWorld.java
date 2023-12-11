import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//hi testing making sure this can work!
//it does work!!


public class MyWorld extends World
{
    private int score = 0;
    private boolean isGameOver = false;
    private Label scoreLabel;
    int level = 1;
    
    int appleCounter = 0;
    

    Label gameOverLabel = new Label("Game over! :( Try Again :)", 50);
    public MyWorld()
    {    
        super(600, 400, 1, false);
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 350);
        
        scoreLabel = new Label(0, 70);
        addObject(scoreLabel, 50, 50);
        
        spawnApple();
        spawnBomb();
    }
    
    
    public void onGameOver() {
        isGameOver = true;
        gameOverLabel.setValue("Game over! :( Try again to \nbeat your current score :)");
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
        Apple apple = new Apple();
        if(level < 25)
        {
            apple.setSpeed(level);
        }
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
        appleCounter++;
        spawnBomb();
    }
    
    
    public void spawnBomb() {
        Bomb bomb = new Bomb();
        bomb.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        if(appleCounter % 4 == 0)
        {
            addObject(bomb, x, y);
            appleCounter = 0;
        }
    }
    
}