import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mundo correspondiente al nivel del juego
 * 
 * @author Sandra García 
 * @author Cecilia Vazquez
 * @version Versión 2.0 / Abril 2016
 */
public class Nivel extends World
{
    /***
     *Variables iniciales
     */
    private Label jugador; 
    private String jug;
    private Counter  puntuaje;
    private Counter timerDisplay;
    private SimpleTimer timer;
    private int nivel=1;
    private int numPolice;
    private int life=5;
    private int lemon=0;
    private int onion1=0;
    private int onion2=0;
    private int muro=0;
    private int hoyo=0;
    private int time=0;
    private int x=0;
    private Counter  puntos;
    private Counter lifes;
    private Counter niveld;

    /**
     * Constructor de clase Nivel.
     * Se inicializan las variables  y se añaden los objetos  que forman parte del
     * nivel como las nubes, flores, enemigos (policias donas) y jugador.
     * También se añade el nombre del jugador y el tiempo.
     * 
     */
    public Nivel()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        //Tiempo
        timerDisplay = new Counter ("Time: ");
        addObject(timerDisplay,177,16);
        timer = new SimpleTimer(); 
        //Nombree del jugador y contador de vidas
        lifes= new Counter("Paco taco: ");
        addObject(lifes,61,16);
        puntos= new Counter("Puntos:");
        addObject(puntos,275,16); 
        //Jugador (Taco)
        Jugador jug = new Jugador ();
        addObject(jug,240,225);
        /**Añade nubes al escenario  **/
        CieloObj nube = new CieloObj (1, 1);
        addObject(nube, 500, 60);
        CieloObj nube1 = new CieloObj (1,2);
        addObject(nube1, 450, 50);
        CieloObj nube2 = new CieloObj (1,1);
        addObject (nube2, 255, 55);
        CieloObj nube3 = new CieloObj (1,2);
        addObject(nube3, 111, 45);
        CieloObj nube4 = new CieloObj (1,1);
        addObject (nube4, 50, 65);

        /**Añade flores al escenario  **/
        SueloObj q = new SueloObj(1);
        addObject(q, 200, 370);
        SueloObj sue = new SueloObj (2); 
        addObject (sue, 250, 365); 
        SueloObj su = new SueloObj (2);
        addObject(su, 425, 365);
        SueloObj suelo = new SueloObj(1);
        addObject(suelo, 600, 370);       
        SueloObj s = new SueloObj(1);
        addObject(s, 100, 365);

        /**Añade Policias al escenario**/
        Police p1= new Police(1);
        addObject(p1, 60,100);
        Police p2= new Police(2);
        addObject(p2, 100,165);
        Police p3= new Police(1);
        addObject(p3, 55,230);
        Police p4= new Police(2);
        addObject(p4, 90,295);
        
        EvilSoda soda = new EvilSoda();
        addObject(soda,530 ,50);

    }

    /**
     * En este método corre el tiempo del timer
     * Controla la aparicion de bonus y enemigos en cierto tiempo
     */
    public void act()
    {
        //le aumenta el contador de cada objeto
        if(timer.millisElapsed()>1000)
        {
            incrementaVariables();
        }

        if(lemon==11)
        { 
            agregaBonus(1);
        }

        if(onion1==22)
        {
            agregaBonus(2); 
        }

        if(onion2==33)
        {
            agregaBonus(3);
        }

        if(muro==4)
        {
            int y=Greenfoot.getRandomNumber(350);
            if(y>100 & y<330)
            {  
               
                 agregaObstaculos ((Greenfoot.getRandomNumber(1)+1), y);
                
            }
            muro=0;
        }
        
        
        
        cambiaNivel(nivel);
    }

    /**
     * agregaObstaculos -- agrega objetos al escenario 
     * @param numObstaculo -> número del bonus que se desea agregar (1 Muro, 2 Hoyo)
     */
    public void agregaObstaculos (int numObstaculo, int y)
    {
        if (numObstaculo ==1)
        {
            addObject( new Obstaculo(Greenfoot.getRandomNumber(2)+1),590,y);
            muro=0;
        }

        else if (numObstaculo == 2)
        {
            addObject( new Obstaculo(Greenfoot.getRandomNumber(3)),590,y);
            hoyo=0; 
        }
    }

    /**
     * agregaBonus -- agrega objetos al escenario 
     * @param nummBonus -> número del bonus que se desea agregar (1 Lemon, 2 OnionOne, 3 Onion two)
     */
    public void agregaBonus(int numBonus)
    {
        switch (numBonus)
        {
            case 1: addObject( new Bonus(numBonus),590,300);
            lemon=0;
            break;
            case 2: addObject( new Bonus(numBonus),590,211);
            onion1=0;
            break;
            case 3: addObject( new Bonus(numBonus),590,111);
            onion2=0;
            break;
        }
    }
    

    /**
     * Incrementa las variables con respecto al timer
     **/
    public void incrementaVariables()
    {
        timerDisplay.add(1);
        timer.mark();
        lemon++;           
        onion1++;
        onion2++;
        muro++;
        hoyo++;
        x++;
    }

    /**
     * Este método regresa el número de nivel del juego
     * @return nivel, valor entero que inidica en que nivel se encuentra el 
     * jugador, inicialmente vale 1
     */
    public int getNivel()
    {
        return nivel;
    }

    /**
     * Regresa el valor de los puntos
     * @return puntos
     */
    public Counter getpuntos()
    {
        return puntos;
    }

    /**
     * Regresa el valor de las vidas
     * @return lifes, vidas
     */
    public Counter getLifes()
    { 
        return lifes ;
    }

    /**
     * Este método cambia de nivel cuando se junta cierta cantidad de puntos
     *@param n, número de nivel
     */
    public void cambiaNivel(int n)
    {
        //convierte puntos en punto Counter--  int
        int punto= puntos.getValue();
        switch(n)
        {
            case 1: 
            if(punto>=30)
            {
                setBackground("nivel2.jpg");
                nivel=2;
                Jugador j = new Jugador();
                j.validaNivel();
                getNivel();
            }
            break;

            case 2:
            if( punto>=50 )// || punto>80)
            {
                setBackground("nivela.png");

                nivel=3;
                getNivel(); 

                Meta q = new Meta ();
                addObject(q, 560, 96);
            }
            break;
            case 3:
            if( punto>=70)
            {
                setBackground("sss.PNG");
                nivel=4; 
                getNivel();
            }
            break;
        }

    }
}

