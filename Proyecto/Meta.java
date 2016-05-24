import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase Meta, al hacer contacto con ella, se termina el juego.
 * 
 * @author Sandra García    
 * @author Cecilia Vázquez
 * @version 5.0 Mayo 2016
 */
public class Meta extends Actor
{
    GreenfootImage ganaste;

    /**
     * Constructor de Meta
     */
    public Meta()
    {
        super();
        try 
        {
            ganaste = new GreenfootImage ("g.png");
        }
        catch(Exception e)
        {
            System.out.println("Error al abrir torre");
        }
    }

    /**
     * Act - Comportamiento de la meta
     */
    public void act() 
    {
        if(isTouching(Jugador.class) )
        {
            
            setImage(ganaste);
            setLocation(350,200);
            Greenfoot.delay(70);
           // Greenfoot.stop();
            Menu newWorld = new Menu();
            Greenfoot.setWorld(newWorld);
        }
    }    
}

