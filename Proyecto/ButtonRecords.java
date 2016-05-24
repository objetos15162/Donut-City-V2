import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase ButtonRecords muestra los mejores puntajes obtenidos en la juego
 * 
 * @author Sandra García 
 * @author Cecilia Vazquez
 * @version Versión 2.0 / Abril 2016
 */
public class ButtonRecords extends  Button
{
    private Menu m; //Mundo actual
    private GreenfootImage recordsMouse; //Imagen que se pone cuando pone mouse
    private GreenfootImage recordsSinMouse; //Imagen normal

    /**
     * Constructor ButtonRecords
     */
    public ButtonRecords()
    {
        super();
        try 
        {
            recordsMouse = new GreenfootImage ("record2.png");
            recordsSinMouse= new GreenfootImage ("record.PNG");
            setImage(recordsSinMouse);
        }
        catch(Exception e)
        {
            System.out.println("Error al cargar la imagen  del boton records");
        }
    }

    /**
     * Act - Al hacer clic en el objeto se muestran los records del juego
     */
    public void act() 
    {
        mouseSobreBoton();
        if(Greenfoot.mouseClicked(this))
        {
            Records newWorld = new Records();
            Greenfoot.setWorld(newWorld);
        }    
    }

    /**
     * Al hacer contacto con la clase, se cambia imagen
     **/
    public void mouseSobreBoton()
    {
        if(Greenfoot.mouseMoved(this))
        {
            setImage(recordsMouse);
        }
        else if(Greenfoot.mouseMoved(m))
        {
            setImage(recordsSinMouse);
        }

    }
}
