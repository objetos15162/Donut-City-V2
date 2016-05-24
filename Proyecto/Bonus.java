import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase representa los 'bonus' o plus que adquiere el jugador a lo largo del 
 *juego
 * 
 * @author Sandra García 
 * @author Cecilia Vazquez
 * @version Mayo 2016
 */
public class Bonus extends Actor
{ 
    private int nivel;
    private int puntos;
    private int nB;
    private GreenfootImage lemon;
    private GreenfootImage onionone;
    private GreenfootImage oniontwo;

    /**
     * Constructor de Bonus
       */
    public Bonus(int numBonus)
    {
        super();
        nB = numBonus;
        try
        {
            lemon = new GreenfootImage ("limon.png");
            onionone = new GreenfootImage ("cebo1.png");
            oniontwo  = new GreenfootImage ("cebo2.png");
        }
        catch (Exception e)
        {
            System.out.println("No pudo carga Bonus");
        }
    }

    /**
     * Act - Comportamiento de Bonus
     */   
    public void act() 
    {
        switch (nB)
        {
            case 1 : setImage(lemon);
                break;
            case 2: setImage(onionone);
                break;
            case 3: setImage(oniontwo);
                break;
        }
        
       mueveBonus();
    }
    
    /**
     * Valida si se está tocando objeto, de lo contrario avanza.
       */
    public void mueveBonus()
    {
        Nivel mundo = (Nivel)getWorld();
        nivel = mundo.getNivel();
        if(isTouching(Jugador.class))
        {
            mundo.removeObject(this);
        }
        else
        {
            move(-11);  
            verificaPiso();
        }
    }

    /**
     *verifica la posición del objeto
     */
    public void verificaPiso()
    {
        int iY;
        Nivel mundo1 = (Nivel)getWorld();
        nivel = mundo1.getNivel();
        if(getX()<3)
        {
            mundo1.removeObject(this);
        }
    }
    
    public int getNumBonus()
    {
        return nB;
    }
     
}   
