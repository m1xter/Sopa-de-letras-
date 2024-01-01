package ui;

import estadosdejuego.estadosdejuego;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import main.juego;
import util.load;
import static util.constantes.ui.letras.*;


/**
 * clase que crea las letras que se ven por pantalla 
 * @author Admin
 */

public class letras {
    private int x,y;
    private estadosdejuego estado;
    private BufferedImage[] imgs;
    private int xoffsetcenter = 30 / 2;
    private boolean  mouseover,mousepreesed;
    private Rectangle bounds;
    protected Rectangle2D.Float  hitbox;
    private String letra;
    private boolean j1,j2;

    public void setJ1(boolean j1) {
        this.j1 = j1;
    }

    public void setJ2(boolean j2) {
        this.j2 = j2;
    }
    
    
    public letras(int x,int y,String letra){
    this.x =x;
    this.letra = letra;
    this.y = y;
    
    intbounds();
    
    }
    
    public letras(){
        letra = "!";
    }
    
    
    
    public Rectangle getBounds(){
        return bounds;
    }

    private void intbounds() {
        
        bounds = new Rectangle(x-7 ,y-23,30,30);
        
        
    }
    
    
    public void draw(Graphics g){
        g.setFont( new Font( "Tahoma", Font.BOLD, 30 ) );
        g.setColor(Color.black);
        if(mousepreesed){
            
            if(j1){
                g.setColor(Color.red);    
            }
            if(j2){
                g.setColor(Color.blue);    
            }
            
        }else{
            g.setColor(Color.black);
        }
        
        g.drawString(letra, x, y);
        
        
        
        //g.setColor(Color.red);
        //g.drawRect(bounds.x, bounds.y, 30, 30);
        
    }
    
    
    
    public void update(){
        
        if(mouseover){
            
        }
        if(mousepreesed){
            
        }
    }

    public boolean isMouseover() {
        return mouseover;
    }

    public void setMouseover(boolean mouseover) {
        this.mouseover = mouseover;
    }

    public boolean isMousepreesed() {
        return mousepreesed;
    }

    public void setMousepreesed(boolean mousepreesed) {
        this.mousepreesed = mousepreesed;
    }

    public void aplicarestadodejuego(){
        estadosdejuego.estado = estado;
    }
    
    public void resetbools(){
        mouseover = false;
        mousepreesed = false;
    }

    public String getLetra() {
        return letra;
    }
    
    

    



    
}
