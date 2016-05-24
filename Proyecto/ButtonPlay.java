import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase ButtonPlay, es un botón para indicar cuando debe inicial el juego
 * 
 *@author Sandra García 
 *@author Cecilia Vazquez
 *@version Versión 2.0 / Abril 2016
 */
public class ButtonPlay extends Button
{
    private GreenfootImage PlayMouse; //Imagen que se pone cuando pone mouse
    private GreenfootImage PlaySinMouse; //Imagen normal
    private Menu m; //Mundo actual
    //
    /**
     * Constructor ButtonPlay 
     */
    public ButtonPlay()
    {
        super();
        try 
        {
            PlayMouse = new GreenfootImage ("Control2.png");
            PlaySinMouse= new GreenfootImage ("contro.png");
            setImage(PlaySinMouse);
        }
        catch(Exception e)
        {
            System.out.println("Error al cargar la imagen  del boton play");
        }

    }

    /**
     * Act - Al hacer clic en el objeto se inicia el juego en el nivel
     */
    public void act() 
    {
        mouseSobreBoton();
        if(Greenfoot.mouseClicked(this))
        {
            Nivel newWorld = new Nivel();
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
            setImage(PlayMouse);
        }
        else if(Greenfoot.mouseMoved(m))
        {
            setImage(PlaySinMouse);
        }

    }

}    

