
package main;

import javax.swing.JFrame;
/**
     * Clase ventana  base para el  juego 
     *
     */
public class ventana  {
    
    private JFrame jframe;
    
	public ventana(panel panel) {            
                            jframe = new JFrame();
                            jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                                        
                            jframe.add(panel);                            
                            jframe.setResizable(false);
                            jframe.pack();
                            jframe.setLocationRelativeTo(null);
                            jframe.setVisible(true);                         
                            
	}
        
}
