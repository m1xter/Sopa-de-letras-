
package main;

import estadosdejuego.estadosdejuego;
import java.awt.Graphics;
import estadosdejuego.menu;
import estadosdejuego.jugando;
import estadosdejuego.creditos;
import estadosdejuego.comojugar;


/**
 * Clase juego en donde corre el juego como tal  aqui se determina la cantidad de fps y ups a la que va el juego ademas
 * del cambio entre estados de juego
 * @author Admin
 */

public class juego  implements Runnable {

        public static final float SCALE = 1f;
        public static final int GAME_WIDTH = 1000;
        private Thread hilojuego;
        private final int FPS_SET =120;
        private final int UPS_SET = 200;
        
    
    
    
    private ventana ventanajuego;
    private panel  paneljuego;
    
    
    private menu menu;
    private jugando jugando;
    private creditos creditos;
    private comojugar comojugar;
    
    
    /**
     * el constructor de juego no resive nada y inicial
     */
    public juego() {
    
        
        initclases();
        paneljuego = new panel(this);
        ventanajuego = new ventana (paneljuego);
        
        
        paneljuego.setFocusable(true);
        paneljuego.requestFocus();         
        stargameloop();
    }

    
    /**
     * metodo initclases inicializa todos los estados de juego 
     */
       private void initclases(){
           menu = new menu(this);         
           jugando = new jugando(this);     
           creditos = new creditos(this);
           comojugar = new comojugar(this);
       }
    
    
    /**
     * metodo stargameloop inicia el loop  jugable 
     */
        private void stargameloop(){
            hilojuego = new Thread(this);
            hilojuego.start();
        }
        
        
        /**
         * el metodo render se encarga de pintar en el panel toda la parte grafica del juego dependiendo de en que estado de juego este 
         * @param g 
         */
        public void render(Graphics g){            
            
          switch(estadosdejuego.estado){                
                
              case MENU:
                    menu.draw(g);
                    break;
               
               case CREDITOS:
                   creditos.draw(g);
                   break;
               case COMOJUGAR:
                   comojugar.draw(g);
                   break;
              case JUGAR:
                      jugando.draw(g);
                    break;                                
                default:              
                    break;
}            
        }
        
        
        
        
        /**
         * metodo update se encarga de  actualizar la logica del juego dependiendo de en que estado de juego se encuentre 
         */
        private void update(){
            
            switch(estadosdejuego.estado){                
                
              case MENU:
                    menu.update();
                    break;
               
              case JUGAR:
                    jugando.update();
                    break;                              
              case COMOJUGAR:
               comojugar.update();
                  break;
              case CREDITOS:
                  creditos.update();
                  break;
              case SALIR:
                  System.exit(0);
                break;     
             default:         
                 break;
}
            
            
            
        }
        
        
        
        /**
         * el metodo run se encarga de crear   y establecer a cuantos fps y ups va el juego lo cual determina cada cuando tiempo se dibujara en pantalla
         * y actualizara el juego 
         */

    @Override
    public void run() {
        
         // esta variable nos dira cuantos nanosegundos debera durar cada frame
        double timeperframe = 1000000000.0 / FPS_SET;
        // esta variable nos dira cuando hay que acualizar el jpanel
        double timeperupdate = 1000000000.0 / UPS_SET;
        long previustime = System.nanoTime();
        
        
        
         int frames = 0 ;
         int updates =0;
        long lastcheck = System.currentTimeMillis();
        double deltau = 0;
        double deltaf =0; 
        
        while(true){
            
            long currentime = System.nanoTime();
            
            
            deltau += (currentime - previustime) / timeperupdate;
            deltaf += (currentime - previustime) / timeperframe;
            previustime = currentime;
            
            if(deltau >= 1){
                update();
                updates++;
                deltau--;
            }
                        
            if(deltaf >=  1){
                paneljuego.repaint();                
                frames++;
                deltaf--;
            }
                    
            if(System.currentTimeMillis() - lastcheck >= 1000){
                  lastcheck = System.currentTimeMillis();
                  //System.out.println("FPS "+frames  + "  | " +"UPS" + updates);
                  frames = 0;
                  updates =0;
             }
                
            
        }
       
        
        
    }




public menu getmenu(){
        return menu;
    }

public jugando getJugando() {
        return jugando;
    }

    public creditos getCreditos() {
        return creditos;
    }

    public comojugar getComojugar() {
        return comojugar;
    }
    



    
}
