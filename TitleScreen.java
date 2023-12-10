import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title screen.
 * 
 * @author Theresa Li 
 * @version December 07/2023
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
        Label label = new Label ("Use \u2190 and \u2192 to Move", 40);
        addObject(label,220,257);
        label.setLocation(297,243);
        label.setLocation(305,240);
        Label label2 = new Label ("Press <space> to Start", 40);
        addObject(label2,249,331);
        label2.setLocation(326,319);
        label.setLocation(328,253);
        label2.setLocation(295,326);
        label.setLocation(278,251);
        elephant.setLocation(117,98);
        Apple apple = new Apple();
        addObject(apple,380,172);
        apple.setLocation(195,91);
        Apple apple2 = new Apple();
        addObject(apple2,436,149);
        apple2.setLocation(468,124);
        apple.setLocation(382,123);
        elephant.setLocation(160,134);
        Apple apple3 = new Apple();
        addObject(apple3,323,121);
        Apple apple4 = new Apple();
        addObject(apple4,285,151);
        apple4.setLocation(243,121);
        apple3.setLocation(309,124);
        apple.setLocation(385,122);
        apple3.setLocation(318,120);
        label.setLocation(350,270);
        label.setLocation(310,306);
        label.setLocation(316,280);
        apple2.setLocation(467,124);
        apple2.setLocation(585,152);
        removeObject(apple2);
        removeObject(apple);
        removeObject(apple3);
        apple4.setLocation(243,169);
        removeObject(apple4);
    }
    
}
