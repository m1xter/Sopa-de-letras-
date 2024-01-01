package ui;

import estadosdejuego.estadosdejuego;
import estadosdejuego.jugando;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import main.juego;

import util.load;
import util.reproductor;
/**
 * clase completado overlay   muestra  la vista de juego completado tanto como cuando hay un empate o hay un solo ganador
 * @author Admin
 */
public class completadoverlay {
    private jugando jugando;
    
    private BufferedImage img;
    private String cant_ruby,cant_diamante,min,seg;
    private int bgx,bgy,bgw,bgh;
    private urmboton1 menub ;
    private reproductor  repro ;
    
    public completadoverlay(jugando jugando) {
        this.jugando = jugando;
        
        intimg();
        intbotons();
        
    }

    private void intimg() {
        img = load.GetSpriteAtlas(load.COMPLETADO);
    }

    private void intbotons() {
          menub = new urmboton1(380,500,220,220,0);
          
    }
    
    public void update(){
        menub.update();
    }
    
    public void draw(Graphics g){
        g.drawImage(img, 0, 0, null);
        if(jugando.getjugador1size() > jugando.getjugador2size()){
            g.setFont( new Font( "Tahoma", Font.BOLD, 15 ) );
           g.setColor(Color.red);
           g.drawString("JUGADOR1", 440, 225);
           g.setColor(Color.black);
           g.drawString(Integer.toString(jugando.getjugador1size()), 500, 270);
        }
     
        
        if(jugando.getjugador1size() == jugando.getjugador2size()){
            
           g.setFont( new Font( "Tahoma", Font.BOLD, 30 ) );            
           g.setColor(Color.BLACK);
           g.drawString("EMPATE:", 200, 225); 
           
           
            g.setFont( new Font( "Tahoma", Font.BOLD, 25 ) );
           g.setColor(Color.red);
           g.drawString("JUGADOR1", 400, 225);
           g.setColor(Color.black);
           g.drawString(Integer.toString(jugando.getjugador1size()), 550, 225);
           
           
           g.setColor(Color.blue);
            g.drawString("JUGADOR2", 600, 225);
            g.setColor(Color.black);
            g.drawString(Integer.toString(jugando.getjugador2size()), 750, 225);
            
            g.setColor(Color.black);
            g.drawString("DESENPATANDO......", 200, 380);
            
            
            
            
            if(jugando.contarpalabras1() > jugando.contarpalabras2()){
                 g.setFont( new Font( "Tahoma", Font.BOLD, 25 ) );
                 g.setColor(Color.black);
                 
                 g.drawString("GANADOR JUGADOR1: ", 200, 400);     
                 g.drawString("Letras totales ", 600, 400);     
                 g.drawString(Integer.toString(jugando.contarpalabras1()), 500, 400);
            
            }
            
            if(jugando.contarpalabras2() > jugando.contarpalabras1()){
                 g.setFont( new Font( "Tahoma", Font.BOLD, 25 ) );
                 g.setColor(Color.black);
                 
                 g.drawString("GANADOR  JUGADOR2 : ", 200, 400);     
                 g.drawString(" Letras totales", 600, 400);     
                 
                 g.drawString(Integer.toString(jugando.contarpalabras1()), 500, 400);
            
            }
            
            
            
        }
     
        
        
        if(jugando.getjugador2size() > jugando.getjugador1size()){
            g.setFont( new Font( "Tahoma", Font.BOLD, 15 ) );
            g.setColor(Color.blue);
            g.drawString("JUGADOR2", 440, 225);
            g.setColor(Color.black);
            g.drawString(Integer.toString(jugando.getjugador2size()), 500, 270);
        }
        
        menub.draw(g);
        
    }
    
    
    
    
    
    
    
    
    private boolean isIn(urmboton1 b,MouseEvent e){
        return b.getBounds().contains(e.getX(),e.getY());
    }
    
    
    
    public void mousemoved(MouseEvent e){
       menub.setMouseover(false);
        
        if(isIn(menub,e)){
            menub.setMouseover(true);
        }
    }
    
    
    public void mousepresed(MouseEvent e){
               if(isIn(menub,e)){
            menub.setMousepresed(true); 
                repro = new reproductor();
                repro.cargarsonido("sounds/interface.wav");
                repro.reproducir();
        }
    }
    
    
    
    
    public void mousereleased(MouseEvent e){
        if(isIn(menub,e)){
                if(menub.isMousepresed()){
                    jugando.setCompletado(false);
                    estadosdejuego.estado = estadosdejuego.MENU;                    
                    jugando.resetall();
                }
            
            }
        menub.resetbools();
    }       
        
}
