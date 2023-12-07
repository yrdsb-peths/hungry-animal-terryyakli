import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title screen.
 * 
 * @author Theresa Li 
 * @version December 06/2023
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Nomnom Elephant", 55);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(titleLabel, getWidth()/2, getHeight()/2);
        prepare();
    }
    
    // Main world act loop
    public void act()
    {
        // Starts the game
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,447,117);
        elephant.setLocation(497,65);
        
        Label label = new Label ("Use <a> and <d> to move", 35);
        addObject(label,220,257);
        label.setLocation(297,243);
        label.setLocation(305,240);
        
        Label label2 = new Label ("Press <space> to Start", 35);
        addObject(label2,249,331);
        label2.setLocation(326,319);
        label.setLocation(328,253);
        label2.setLocation(295,326);
        label.setLocation(278,251);
    }
    
}
