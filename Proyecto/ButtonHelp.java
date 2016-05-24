import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase ButtonHelp, butón que indica ayuda previa a inicial el juego
 * 
 * @author Sandra García 
 * @author Cecilia Vazquez
 * @version Versión 2.0 / Abril 2016
 */
public class ButtonHelp extends  Button
{
    private Menu m; //Mundo actual
    private GreenfootImage helpMouse; //Imagen que se pone cuando pone mouse
    private GreenfootImage helpSinMouse; //Imagen normal

    /**
     * Constructor ButtonHelp
     */
    public ButtonHelp()
    {
        super();
        try 
        {
            helpMouse = new GreenfootImage ("ayuda2.png");
            helpSinMouse= new GreenfootImage ("felp.png");
            setImage(helpSinMouse);
        }
        catch(Exception e)
        {
            System.out.println("Error al cargar la imagen  del boton ayuda");
        }
    }

    /**
     * Act - Al hacer clic en el objeto se muestra ayuda para entender el juego
     */
    public void act() 
    {
        mouseSobreBoton();
        if(Greenfoot.mouseClicked(this))
        {
            Help newWorld = new Help();
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
            setImage(helpMouse);
        }
        else if(Greenfoot.mouseMoved(m))
        {
            setImage(helpSinMouse);
        }

    }
}
