package estadosdejuego;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import ui.urmboton1;

import util.load;
import util.reproductor;

/**
 * esta clase muestra las instrucciones de como jugar el juego
 * heredando de la clase estado y implementa la interfas interfasestado
 * @author Admin
 */
public class comojugar extends estado implements interfasdeestado{
    
    private BufferedImage bgimg;
    private int menux,menuy,menuw,menuh;
    private urmboton1 menub;
    private reproductor  repro ;
    public comojugar(main.juego juego) {
        super(juego);
        loadimg();
        loadbton();
    }
    
    /**
     * este metodo carga la imagen de fondo de la clase
     */
    private void loadimg() {
         bgimg = load.GetSpriteAtlas(load.COMOJUGAR);
        
    }

    /**
     * este metodo inicializa el boton de volver al menu
     */
    private void loadbton() {
          
        menub = new urmboton1(350,350,300,50,0);
    }
    
    
    
    
    /**
     * el metodo update  actualiza el estado del boton
     */
    @Override
    public void update() {
        menub.update();
    }
/**
 * el metodo draw dibuja el fondo y el boton de la clase
 * @param g 
 */
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
    
    /**
     * este metodo revisa si el mouse esta dentro del boton
     * @param e
     * @param mb
     * @return 
     */
    public boolean isIn(MouseEvent e,urmboton1 mb){
        return mb.getBounds().contains(e.getX(),e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }
    


}
