package estadosdejuego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import ui.botonmenu;
import util.load;
import util.reproductor;

/**
 * en esta clase se arma el menu  hereda de estado y implementa interfasestado
 * @author Admin
 */
public class menu extends estado implements interfasdeestado {

    private botonmenu[ ] boton = new botonmenu[4];
    private BufferedImage bgimg;
    private int menux,menuy,menuw,menuh;
    private reproductor  repro ;
    public menu(main.juego juego) {
        super(juego);
        
        loadbotons();
        loadbg();
    }
    private void loadbotons() {
        
        boton[0] = new botonmenu(juego.GAME_WIDTH/2,(int)(225 * juego.SCALE),3,estadosdejuego.JUGAR);
        boton[1] = new botonmenu(juego.GAME_WIDTH/2,(int)(295 * juego.SCALE),0,estadosdejuego.COMOJUGAR);
        boton[2] = new botonmenu(juego.GAME_WIDTH/2,(int)( 365* juego.SCALE),1,estadosdejuego.CREDITOS);
        boton[3] = new botonmenu(juego.GAME_WIDTH/2,(int)( 435* juego.SCALE),2,estadosdejuego.SALIR);                
    }
    
    
    private void loadbg() {
    
        bgimg = load.GetSpriteAtlas(load.MENUBG);
        menuw = (int)(bgimg.getWidth() );
        menuh = (int)(bgimg.getHeight() );
        menux = juego.GAME_WIDTH/2  - menuw /2;
        menuy = 0;
    }

    
    @Override
    public void update() {
        for(botonmenu mb : boton){
            mb.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(bgimg, menux, menuy,menuw,menuh, null);
        for(botonmenu mb : boton){
            mb.draw(g);
        }
        
    }

    @Override
    public void mouseclick(MouseEvent e) {
       
    }

    @Override
    public void mousepressed(MouseEvent e) {
        for(botonmenu mb : boton){
            if(isIn(e,mb)){
                mb.setMousepreesed(true);
                repro = new reproductor();
                repro.cargarsonido("sounds/interface.wav");
                repro.reproducir();
                break;
            }
        }
        
    }

    @Override
    public void mousereleased(MouseEvent e) {
            for(botonmenu mb : boton){
            if(isIn(e,mb)){
                if(mb.isMousepreesed()){
                    mb.aplicarestadodejuego();
                    break;
                }
            }
        }
        resetbotones();
    }

    @Override
    public void mousemoved(MouseEvent e) {
        for(botonmenu mb : boton){
            mb.setMouseover(false);
        }
        
        for(botonmenu mb : boton){
            if(isIn(e,mb)){
                mb.setMouseover(true);
            }
        }
        
        
    }

    @Override
    public void keypreseed(KeyEvent e) {
  
    }

    @Override
    public void keyreleased(KeyEvent e) {
        
    }

    private void resetbotones() {
          for(botonmenu mb : boton){
            mb.resetbools();
        }         
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
