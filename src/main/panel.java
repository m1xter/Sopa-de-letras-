
package main;


import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import inputs.mouseinputs;


 
    /**
     * Clase panel  que  hace de lienzo para el juego 
     * 
     */
public class panel  extends JPanel{

    private juego juego;
    private mouseinputs mouseinputs;
   /**
    *  el constructor del panel resive una clase de tipo juego y inicaliza los inputs del mouse
    * 
    */
    public panel(juego juego) {
        this.juego = juego;
        
        mouseinputs = new mouseinputs(this);              
        addMouseListener(mouseinputs);
        addMouseMotionListener(mouseinputs);
        setpanelsize();
        
    }
    
    
    
    
    private void setpanelsize(){
    
    Dimension size = new Dimension(1000,600);
    setPreferredSize(size);
    
        
    }
    
    
     public void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                juego.render(g);
                
            }

    
    
    public juego getjuego(){
            return juego;
        }

    
}
