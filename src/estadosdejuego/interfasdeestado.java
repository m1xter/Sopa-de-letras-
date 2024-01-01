
package estadosdejuego;


import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * interfas que implementan todas los estados de juego
 * @author Admin
 */
public interface interfasdeestado {
    
    
    public void update();
    public void draw(Graphics g);
    public void mouseclick(MouseEvent e);
    public void mousepressed(MouseEvent e);
    public void mousereleased(MouseEvent e);
    public void mousemoved(MouseEvent e);
    public void mouseDragged(MouseEvent e);
    public void keypreseed(KeyEvent e);
    public void keyreleased(KeyEvent e);
    
        
    
    
}
