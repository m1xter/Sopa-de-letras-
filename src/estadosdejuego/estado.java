package estadosdejuego;

//import java.awt.event.MouseEvent;
import java.awt.event.MouseEvent;
import main.juego;
import ui.botonmenu;

import ui.letras;
//import ui.boton_seleccion;
//import ui.botonmenu;

/**
 * clase padre de los estados de juego 
 * @author Admin
 */
public class estado {

    protected juego juego;
    
    public estado(juego juego) {
        this.juego = juego;
    }
    
    
    /**
     * metodo Isin determina si el raton esta dentro del un boton de tipo menu
     * @param e
     * @param mb
     * @return 
     */
    public boolean isIn(MouseEvent e,botonmenu mb){
        return mb.getBounds().contains(e.getX(),e.getY());
    }
    
    
    /**
     * metodo isIn determina si el raton esta dentro de una letra
     * @param e
     * @param l
     * @return 
     */
    
    public boolean isIn(MouseEvent e,letras l){
        return l.getBounds().contains(e.getX(),e.getY());
    }
    
    
    
    public boolean isout(MouseEvent e,letras l){
        
        
        return l.getBounds().contains(e.getX(),e.getY()) == false ;
        
    }
    
    
    
  
    public juego getjuego(){
        return juego;
    }
    
    
    
}
