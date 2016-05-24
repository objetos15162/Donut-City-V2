import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.UserInfo; 

/**
 * La clase Records va a guardar la puntuaciÃ³n del juegador y mostrará los rÃ©cords del menÃº las
 * puntuaciones mÃ¡s altas.
 * 
 * @author (Cerda Varela Ignacio) 
 * @version (2014.11.26)
 */
public class Record
{
    private UserInfo jugador;
    
    public Record() 
    { 
        if ((UserInfo.isStorageAvailable()) && (UserInfo.getMyInfo() != null)) {
          this.jugador = UserInfo.getMyInfo();
        }
    }
    
    public void guardaRecords(int puntos)
    {
         if((UserInfo.isStorageAvailable()) && (this.jugador != null) && ((puntos > this.jugador.getScore())) || (this.jugador.getInt(0))==0){ 
            this.jugador.setScore(puntos);
            this.jugador.setInt(0,1); 
            this.jugador.store();
        }
        
        if((UserInfo.isStorageAvailable()) && (this.jugador != null) && (puntos > this.jugador.getScore())){
            this.jugador.setScore(puntos);
            this.jugador.setInt(0,1); 
            this.jugador.store();
        }
    }
     
}
