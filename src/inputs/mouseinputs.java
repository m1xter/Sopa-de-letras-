package inputs;

import estadosdejuego.estadosdejuego;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import main.panel;

/**
 * la clase mouse inputs controla a que estado de juego se el asigna el listener de eventos de tipo mouse 
 * @author Admin
 */
public class mouseinputs implements MouseListener,MouseMotionListener {
    private panel panel;
    
    public mouseinputs(panel panel) {
        this.panel = panel;
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
     
    }

    @Override
    public void mousePressed(MouseEvent e) {
           switch(estadosdejuego.estado){
            case MENU:
                panel.getjuego().getmenu().mousepressed(e);
                break;
            
            case CREDITOS:
                panel.getjuego().getCreditos().mousepressed(e);
                break;
            case COMOJUGAR:
                panel.getjuego().getComojugar().mousepressed(e);
                break;
            case JUGAR:
                panel.getjuego().getJugando().mousepressed(e);
                break;
            default:                
                 break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
           switch(estadosdejuego.estado){
            case MENU:
                panel.getjuego().getmenu().mousereleased(e);
                break;
            
            case CREDITOS:
                panel.getjuego().getCreditos().mousereleased(e);
                break;
            case COMOJUGAR:
                panel.getjuego().getComojugar().mousereleased(e);
                break;
            case JUGAR:
                panel.getjuego().getJugando().mousereleased(e);
                break;
            default:                
                 break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        panel.getjuego().getJugando().mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
                 switch(estadosdejuego.estado){
            case MENU:
                panel.getjuego().getmenu().mousemoved(e);
                break;            
            case CREDITOS:
                panel.getjuego().getCreditos().mousemoved(e);
            case COMOJUGAR:
                panel.getjuego().getComojugar().mousemoved(e);
                break;
            case JUGAR:
                panel.getjuego().getJugando().mousemoved(e);
                break;
            default:                
                 break;
        }
    }
    
}
