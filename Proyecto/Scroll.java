import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *Esta clase se encarga del movimiento independiente de los objetos
 * 
 * @author Sandra García 
 * @author Cecilia Vazquez
 * @version 2.0 // 26 Abril 2016
 */
public abstract class Scroll extends Actor
{
    public int nivel;
    private int imageNum;
    
    /**
     * Constructor Scroll, recibe el número de nivel 
     * @param imageNum número de objeto a pintar
     */
    public Scroll ( int imageNum)
    {
        super();
    }
    
    /**
     * Clase abstracta que controla el movimiento de los objetos del escenario
     */
    public abstract void movObje();

    /**
     * verifica la posición en x 
     */
    public void verifica()
    {  
        if(getX()<1)
        {
            move(750);
        }
    }

    /**
     * @return nivel
       */
    public int getN()
    {
        Nivel mundo = (Nivel)getWorld();
        nivel = mundo.getNivel(); 
        return nivel;
    }

}

