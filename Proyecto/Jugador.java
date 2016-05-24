import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Jugador, representa el comportamiento del taco (jugador)
 * 
 * @author Sandra García 
 * @author Cecilia Vazquez
 * @version Versión 2.0 / Abril 2016
 */
public class Jugador extends Actor
{
    private int puntos;
    private int nivel;
    private int lifes;
    private GreenfootImage image1;
    private GreenfootImage image2;
    private GreenfootImage pierde;
    private GreenfootImage over;
    private GreenfootImage winner;
    private int NIVELUNO;
    private int NIVELDOS;
    private int NIVELTRES;

    /**
     *  Contructos de clase 'Jugador' se encarga de inicializar las variables de tipo GreenfootImage
     *  Utiliza un try -catch por si llegase a haber errores al cargar la imagen
     */
    public Jugador ()
    {
        super();
        lifes=3;
        NIVELUNO = 30;
        NIVELDOS = 50; 
        NIVELTRES = 70;
        try{
            image1= new GreenfootImage("taco1.png");
            image2 = new GreenfootImage("taco2.png");
            pierde = new GreenfootImage("tacoPierde.png");
            over = new GreenfootImage("losergame.png");
            winner =  new GreenfootImage ("nivel1winner.png");
            setImage(image1); 
        } 
        catch(Exception e)
        {
            System.out.println("No pudo cargar la imagen Taco");
        } 

    }  

    /**
     * Act - Se encarga del movimiento del jugador
     */
    public void act() 
    {
        World mundo = getWorld();
        Nivel myWorld=(Nivel)mundo;
        nivel=myWorld.getNivel();
        myWorld.getLifes().setValue(lifes);

        /**Cambio de imagenes**/
        if(getImage()==image1)
        {
            setImage(image2);
            Greenfoot.delay(1);
        }
        else
        { 
            setImage(image1);
            Greenfoot.delay(1);
        }

        /**Movimientos**/
        if(Greenfoot.isKeyDown("up"))
        {           
            moveUp();
        }

        if(Greenfoot.isKeyDown("down"))
        {
            moveDown();
        }

        /**Al tocar objetos*/
        if(isTouching(Police.class) )
        {
            tocaPolice();
        }

        if(isTouching(Obstaculo.class))
        {
            tocaObstaculo();   
        }

        if(isTouching(Bonus.class))
        {
            tocaBonus();
        }

        if (isTouching(Soda.class))
        { 
            tocaSoda();
        }

        if(lifes == 0)
        {
            //System.out.println("Ya perdiste");
            sinVidas();
        }

    }

    public void sinVidas()
    {
        Greenfoot.playSound("GameOver.mp3");
        //setImage(pierde);
        Greenfoot.delay(70);
        setImage(over);
        Greenfoot.delay(100);
        Menu newWorld = new Menu();
        Greenfoot.setWorld(newWorld);
        //setLocation(340,225);
    }

    /**
     * Al tocar obstaculo se valida la posición en y, para indicar hacia donde se desplaza el objeto
     */
    public void tocaObstaculo()
    {
        if(getY()>299)
        {
            setLocation(getX()+50, getY()+70);
        }
        else
        {
            setLocation(getX()-50,getY()+70);
        }
        if(puntos > 10)
        { 
            World mundoc = getWorld();
            Nivel myW = (Nivel) mundoc; 
            puntos = puntos -30;
        }   
        else
        {
            tocaPolice();
        }
    }

    /**Valida posición y puntaje para indicar cambio de nivel**/
    public void validaNivel()
    {
        if(nivel ==1 )
        {
            if (getX()>550  || puntos>NIVELUNO )
            {
                System.out.println("validanivel");
                setLocation(354,125); 
                //setImage("nivel1winner.png"); 
                Greenfoot.delay(10000);
                World mundoc = getWorld();
                Nivel myW = (Nivel) mundoc; 
                nivel++;
                myW.getNivel();
                myW.cambiaNivel(nivel);
                Greenfoot.delay(70);
                setImage(winner);
                Greenfoot.delay(100);
            }
        }
        else if(nivel == 2)
        {
            if (getX()>550  || puntos>NIVELDOS )
            {
                setLocation(354,125); 
               // setImage("nivel1winner.png"); 
                Greenfoot.delay(10000);
                World mundoc = getWorld();
                Nivel myW = (Nivel) mundoc; 
                nivel++;
                myW.getNivel();
                myW.cambiaNivel(nivel);
                Greenfoot.delay(70);
                setImage(winner);
                Greenfoot.delay(100);
            }
        }
        else if(nivel == 3)
        {
            if (getX()>550  || puntos>NIVELTRES )
            {
                setLocation(354,125); 
                //setImage("nivel1winner.png"); 
                Greenfoot.delay(10000);
                World mundoc = getWorld();
                Nivel myW = (Nivel) mundoc; 
                nivel++;
                myW.getNivel();
                myW.cambiaNivel(nivel);
                Greenfoot.delay(70);
                setImage(winner);
                Greenfoot.delay(100);
            }
        }
    }

    /**
     * Al tocar algún objeto de la clase Bonus, se incrementa el puntaje
     */
    public void tocaBonus()
    {
        Greenfoot.playSound("come.mp3");
        move(20);
        World mundo1= getWorld();
        Nivel myWorld1=(Nivel)mundo1;

        puntos= puntos+10;
        myWorld1.getpuntos().setValue(puntos);
    }

    /***
     * Al tocar Soda, se restan vidas
     */
    public void tocaSoda()
    {
        World mundo1 = getWorld();
        Nivel myWorld1=(Nivel)mundo1;
        puntos= puntos-20;
        myWorld1.getpuntos().setValue(puntos);
    }

    /**
     * Al tocar algún objeto de la clase Police,se restan vidas. 
     */
    public void tocaPolice()
    {
        Greenfoot.playSound("GameOver.mp3");
        setImage(pierde);
        World mundo1 = getWorld();
        Nivel myWorld1=(Nivel)mundo1;
        lifes=lifes-1;
        puntos= 0;
        myWorld1.getLifes().setValue(lifes);
        myWorld1.getpuntos().setValue(puntos);
        Greenfoot.delay(70);
        setLocation(340,225);
    }

    /***
     * verificaPosicion, corrobora posición en y del objeto para determinar hacia donde se debe mover el objeto cuando es tocado por otro
     * y así no se salga de rango
     */
    public void verificaPosicion()
    {
        if(getY()>290)
        {
            setLocation(getX()+50, getY()+70);
        }
        else
        {
            setLocation(getX()-50,getY()+70);
        }
    }

    /**
     *  moveDown modifica la posición en Y del objeto
     */
    public void moveDown()
    {
        if(getY()<290)
        {  
            setLocation(getX(), getY()+10);
        }
    }

    /** 
     * moveUp modifica la posición en Y del objeto
     **/

    public void moveUp()
    {
        if(getY()>120)
        {  //Delimita para que no se salga del escenario
            setLocation(getX(), getY()-10);
        }
    }

}
