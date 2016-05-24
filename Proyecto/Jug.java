
/**
 * Representa información del jugador
 * 
 * @author Sandra García
 * @author Cecilia Vazquez
 * @version (Mayo 2015)
 */
public class Jug  
{
    /*La Clase jugador es una clase externa de las SUPERCLASES ACTOR Y WORLD puesto que esta solo representa el
     jugador y su Informacion esencia para la dinamica del jugador*/
    
    /*VARIABLES DE INSTANCIA*/ 
    private int score;//PUNTUACION DEL JUGADOR
    private String name;//NOMBRE DEL JUGADOR

    /**
     * Constructor para objetos de clase Jugador.
     */
    public Jug()//Costructor de la Clase 
    {
        score=0;//Inicializa el score con 0
        name="Paco el taco";//Inicializa con un nombre por dafault
    }
    
    /**
     * pone el valor del score
     * 
     * @param unScore el valor del score
     */
    public void setScore(int unScore)//Pone un valor a score el parametro es un valor entero
    {
        score=unScore;
    }
    
    
    /**
     * pone el nombre del jugador
     * 
     * @param unNombre el nombre del jugador
     */
    public void setName(String unNombre)
    {
        name=unNombre;
    }
    
    /**
     * devuelve el valor del score
     * 
     * @return te devuleve el valor del score
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * devuelve el nombre
     * 
     * @return devuelve el nombre
     */
    public String getNombre()
    {
        return name;
    }
}
