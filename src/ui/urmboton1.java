package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import util.load;
import static util.constantes.ui.botones.*;

/**
 * clase que crea los botones para volver la menu principal
 * @author Admin
 */

public class urmboton1  extends pausebutton{
    
    private BufferedImage[]  imgs ;
    private int rowindex,index;
    private boolean mousepresed,mousereleased,mouseover;
    
    public urmboton1(int x, int y, int w, int h,int rowindex) {
        super(x, y, w, h);
        this.rowindex = rowindex;
        loadimg();
        
    }
    
    public void update(){
        index =0;
        if(mouseover){
            index =1;
        }
        if(mousepresed){
            index = 2;
        }
    }
    
    public void draw(Graphics g){
        g.drawImage(imgs[index], x, y, 300,50, null);
        
    }
    
    
    private void loadimg() {
        BufferedImage temp = load.GetSpriteAtlas(load.URMBOTON);
        imgs = new BufferedImage[3];
        for (int i = 0; i < imgs.length; i++) {
            imgs[i] = temp.getSubimage(i * B_WIDTH_DEFAULT, rowindex * B_HEIGHT_DEFAULT, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT);
        }
        
    }
    
    public void resetbools(){
        mouseover = false;
        mousepresed = false;
    }

    public boolean isMousepresed() {
        return mousepresed;
    }

    public void setMousepresed(boolean mousepresed) {
        this.mousepresed = mousepresed;
    }

    public boolean isMouseover() {
        return mouseover;
    }

    public void setMouseover(boolean mouseover) {
        this.mouseover = mouseover;
    }

    public void setMousereleased(boolean mousereleased) {
        this.mousereleased = mousereleased;
    }
    
    
    
    
    
    
    
}
