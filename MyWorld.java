import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int random;
    private int counter = 0; 
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
        
    }
    public void act(){
        if(counter == 0){
            spawnApple();
            counter = 30; 
        }
        else{
            counter--; 
        }
    }

    public void spawnApple() {
            random = Greenfoot.getRandomNumber(5); 
            Apple apple = new Apple();
            if(random == 0){
                addObject(apple, 100, 0);
            }
            if(random == 1){
                addObject(apple, 200, 0);
            }
            if(random == 2){
                addObject(apple, 500, 0); 
            }
            if(random == 3){
                addObject(apple, 750, 0);
            }
            if(random == 4){
                addObject(apple, 900, 0);
            }
            if(random == 5){
                addObject(apple, 1000, 0);
            }
    }
    
    
}

