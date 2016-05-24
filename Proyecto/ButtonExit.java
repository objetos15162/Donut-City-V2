import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ButtonExit here.
 * 
 * @author Sandra García
 * @author Cecilia Vazquez
 * @version Mayo 2016
 */
public class ButtonExit extends  Button
{
    private Menu m; //Mundo actual
    private GreenfootImage exitMouse; //Imagen que se pone cuando pone mouse
    private GreenfootImage exitSinMouse; //Imagen normal

    public  ButtonExit()
    {
        super();
        try 
        {
            exitMouse = new GreenfootImage ("salir2.png");
            exitSinMouse= new GreenfootImage ("salir.png");
            setImage(exitSinMouse);
        }
        catch(Exception e)
        {
            System.out.println("Error al cargar la imagen  del boton salir");
        }
    }

    /**
     * Act - Comportamiento del boton exit
     */
    public void act() 
    {
        mouseSobreBoton();
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.stop();
        }

    }    

    /**
     * Al hacer contacto con la clase, se cambia imagen
     **/
    public void mouseSobreBoton()
    {
        if(Greenfoot.mouseMoved(this))
        {
            setImage(exitMouse);
        }
        else if(Greenfoot.mouseMoved(m))
        {
            setImage(exitSinMouse);
        }

    }
}
