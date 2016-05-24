import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase representa un enemigo
 * 
 * @author Sandra García 
 * @author Cecilia Vazquez
 * @version Mayo 2016
 */
public class EvilSoda extends Actor
{
    private  int s=0;

    private GreenfootImage image1;
    private GreenfootImage image2;

    /**
     *Constructor de la clase EvilSoda
     */
    public EvilSoda ()
    {
        super();
        try{
            image1= new GreenfootImage("refri0.png");
            image2 = new GreenfootImage("refri1.png");

            setImage(image2); 
        } 
        catch(Exception e)
        {
            System.out.println("No pudo cargar la imagen de soda");
        } 
    }  

    /**
     * Act - Comportamiento de la EvilSoda
     */
    public void act() 
    {

        if(getImage()==image1){
            setImage(image2);
            Greenfoot.delay(2);
        }
        else{ 
            setImage(image1);
            Greenfoot.delay(2);
        }

        move(-4);
        if(getX()<3)
        {
            move(590);
        }

        s=s+1;

        if (s==25)
        {
            soda();
            s=0;
        }
    }

    /**
     * Regresa el v
     */  
    public void soda() 
    {

        Nivel mundo = (Nivel)getWorld();
        Greenfoot.delay(5);
        mundo.addObject(new Soda(), getX(), 44);

    }    
}

  