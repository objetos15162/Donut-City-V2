import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Soda, Objeto que arroja la clase EvilSoda
 * 
 * @author Sandra García
 * @author Cecilia Vazquez
 * @version Mayo 2016
 */
public class Soda extends Actor
{
    private int speed;
    
    /**
     * Constructor de la clase Soda
       */
    public Soda()
    {
        super();
        speed=Greenfoot.getRandomNumber(40)+1;
    }

    /**
     * Act - Comportamiento de la clase Soda
     */
    public void act() 
    {
        setLocation(getX(),getY()+speed);
        Nivel mundo1 = (Nivel)getWorld();
        if(getY()>350||isTouching(Jugador.class) )
        {
            mundo1.removeObject(this);
        }      
    }    
}
