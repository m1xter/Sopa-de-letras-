package estadosdejuego;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import ui.urmboton1;

import util.load;
import util.reproductor;

/**
 * la clase creditos es igual a la clase comojugar solo cambia el fondo con la informacion que muestra
 * @author Admin
 */
public class creditos extends estado implements interfasdeestado{
    
    private BufferedImage bgimg;
    private int menux,menuy,menuw,menuh;
    private urmboton1 menub;
    private reproductor  repro ;
    
    public creditos(main.juego juego) {
        super(juego);
        loadimg();
        loadbton();
    }
    
    
    private void loadimg() {
         bgimg = load.GetSpriteAtlas(load.CREDITOS);
        menuw = (int)(bgimg.getWidth() * juego.SCALE);
        menuh = (int)(bgimg.getHeight() * juego.SCALE);
        menux = juego.GAME_WIDTH/2  - menuw /2;
        menuy = (int)(-60*juego.SCALE);
    }

    private void loadbton() {
        int menubx = (int) (400 * juego.SCALE);        
        int y = (int) (350 * juego.SCALE);                
        menub = new urmboton1(350,300,300,50,0);
    }
    
    
    
    
    
    @Override
    public void update() {
        menub.update();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(bgimg, 0, 0, null);
        menub.draw(g);
    }

    @Override
    public void mouseclick(MouseEvent e) {
        
    }

    @Override
    public void mousepressed(MouseEvent e) {
        if(isIn(e,menub)){
            menub.setMousepresed(true);
                repro = new reproductor();
                repro.cargarsonido("sounds/interface.wav");
                repro.reproducir();
        }
    }

    @Override
    public void mousereleased(MouseEvent e) {
        if(isIn(e,menub)){
            if(menub.isMousepresed()){
                estadosdejuego.estado = estadosdejuego.MENU;
            }
        }
        
        menub.resetbools();
    }

    @Override
    public void mousemoved(MouseEvent e) {
        menub.setMouseover(false);
          if(isIn(e,menub)){
              menub.setMouseover(true);
          }
          
    }

    @Override
    public void keypreseed(KeyEvent e) {
        
    }

    @Override
    public void keyreleased(KeyEvent e) {
        
    }
    
    public boolean isIn(MouseEvent e,urmboton1 mb){
        return mb.getBounds().contains(e.getX(),e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       
    }
    


}
