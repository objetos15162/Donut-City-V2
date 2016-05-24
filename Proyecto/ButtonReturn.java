import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Botón usado en el menú para indicar que se desea regresar a este
 * 
 * @author Sandra García 
 * @author Cecilia Vazquez
 * @version Mayo 2016
 */
public class ButtonReturn extends  Button
{
    private Menu m; //Mundo actual
    private GreenfootImage returnMouse; //Imagen que se pone cuando pone mouse
    private GreenfootImage returnSinMouse; //Imagen normal

    public ButtonReturn()
    {
        super();
        try 
        {
            returnMouse = new GreenfootImage ("Regresar2.png");
            returnSinMouse= new GreenfootImage ("Regresar.png");
            setImage(returnSinMouse);
        }
        catch(Exception e)
        {
            System.out.println("Error al cargar la imagen  del boton return");
        }
    }

    /**
     * Act - Comportamiento del botón return
     */
    public void act() 
    {
        mouseSobreBoton();
        if(Greenfoot.mouseClicked(this))
        {
            Menu newWorld = new Menu();
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
            setImage(returnMouse);
        }
        else if(Greenfoot.mouseMoved(m))
        {
            setImage(returnSinMouse);
        }
    }

}
