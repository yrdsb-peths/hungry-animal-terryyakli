import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wombat here.
 * 
 * @author Theresa Li 
 * @version Nov 24/23
 */
public class Wombat extends Actor
{
    /**
     * Act - do whatever the Wombat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        keys(); 
        
        eat();
        //checkApple();
    }
    public void keys(){
        if(Greenfoot.isKeyDown("a")){
            move(-5); 
        }
        if(Greenfoot.isKeyDown("d")){
            move(5); 
        }
    }
    
    
    // eats apple and spawns new apple if eaten.
    public void eat() {
        if(isTouching(Apple.class)) {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
        }
    }
    //public void checkApple(){
    //    Apple a = (Apple)getOneIntersectingObject(Apple.class); 
    //    if(a != null){
    //        getWorld().removeObject(a); 
    //    
    //}

}
