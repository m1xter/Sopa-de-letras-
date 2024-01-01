
package estadosdejuego;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.Timer;
import ui.letras;
import util.load;
import static util.constantes.ui.sopa.*;
import  ui.completadoverlay;
import java.util.Random;


/**
 * en la clase jugando es donde esta todo la parte jugable 
 * @author Admin
 */
public class jugando extends estado  implements interfasdeestado {

    private BufferedImage dibujo;
    private BufferedImage bgimg;
    private Graphics2D  g2d;
    private Point curpoint = new Point();
    private boolean  j1,j2;
    private Timer Temporizador;
    private int min=0,seg=0,c,x,y,r=0;
    private ArrayList<letras> letras = new ArrayList();
    
    private ArrayList<String> A = new ArrayList();    
    private ArrayList<String> B = new ArrayList();    
    
    
    private ArrayList<String> jugador1 = new ArrayList();
    private ArrayList<String> jugador2 = new ArrayList(); 
   private boolean completado = false;
    
    private String palabra;
    
    private completadoverlay overlay;
          
     
    
    
    private int menux,menuy,menuw,menuh;
    private String le = null;
    
    
    public jugando(main.juego juego) {
        super(juego);
        initclases();
        dibujar();
        sopabg();
        letras();
    }

    public void initclases(){
        int numero = (int) (Math.random() * 2)+1;
       System.out.println(numero);
       
       
    
    if( numero ==2){
        j1= true;
        
    }
    
    if(numero ==1){
       j2=true;
        
    }
        Temporizador = new javax.swing.Timer(1000,new Tempo());
        overlay = new completadoverlay (this);
    }
    
    
    
    public void letras(){
        int c = 0;
        
        for (int i = 0; i < cordx.length; i++) {
            
            for (int j = 0; j < cordy.length; j++) {
                
                 letras.add(new letras(cordx[i],cordy[j],pa[j][i]));  
            }
                
        }
            
    }

    
public void jugar(){
    
    
     int numero = (int) (Math.random() * 2)+1;
       System.out.println(numero);
       
       
    
    if( numero ==2){
        jugador1();
        
    }
    
    if(numero ==1){
       jugador2();
        
    }
    
}


public void jugador1(){
    j1=true;
    j2=false;
    
}


public void jugador2(){
    j2= true;
    j1=false;
    
}


    private void dibujar(){
        
        bgimg = load.GetSpriteAtlas(load.FONDO2);        
        g2d = bgimg.createGraphics();
        g2d.setColor(Color.red);
        g2d.setStroke(new BasicStroke(20));
        
    }
    
    
    public void ganar(){
        
        int total = jugador1.size() + jugador2.size();
        if(total == 10){
            setCompletado(true);
        }
        
    }
    
    
    @Override
    public void update() {
        ganar();
        if(completado){
            overlay.update();
            Temporizador.stop();            
        }else{
            Temporizador.start();    
        }
        
        
    }
    
    @Override
    public void draw(Graphics g) {
    
        
        
        if(completado){
            overlay.draw(g);
        }else{
             g.drawImage(bgimg, 0, 0,menuw,menuh, null);
        
        //g.drawImage(dibujo,0 , 0, null);       
        //g.drawRoundRect(x, y, menuw, menuh, 10, 10);
        g.setColor(Color.white);
        g.fillRoundRect(30, 20, 450, 450, 20, 20);
        g.drawRoundRect(30, 20, 450, 450, 20, 20);
        
        
        g.setColor(Color.white);
        g.fillRoundRect(550, 20, 400, 450, 20, 20);
        g.drawRoundRect(550, 20, 400, 450, 20, 20);
        
        g.setFont( new Font( "Tahoma", Font.BOLD, 15 ) );
        g.setColor(Color.black);
        g.drawString(Integer.toString(seg), 780, 60);
        
        
            g.setFont( new Font( "Tahoma", Font.BOLD, 15 ) );
            g.setColor(Color.BLACK);
            g.drawString("TIEMPO: ", 700, 60);
        
            g.setFont( new Font( "Tahoma", Font.BOLD, 15 ) );
            g.setColor(Color.BLACK);
            g.drawString("TURNO DE : ", 600, 100);
        
        
        if(j2){
            g.setFont( new Font( "Tahoma", Font.BOLD, 15 ) );
            g.setColor(Color.BLUE);
            g.drawString("JUGADOR2", 700, 100);
        
        }
        
        if(j1){
            g.setFont( new Font( "Tahoma", Font.BOLD, 15 ) );
            g.setColor(Color.RED);
            g.drawString("JUGADOR1", 700, 100);
        
        }
        
            g.setFont( new Font( "Tahoma", Font.BOLD, 15 ) );
            g.setColor(Color.BLACK);
            g.drawString("Palabras encontradas por  : ", 590, 150);
        
            g.setFont( new Font( "Tahoma", Font.BOLD, 15 ) );
            g.setColor(Color.RED);
            g.drawString("JUGADOR1:  ", 600, 200);
        
            g.setFont( new Font( "Tahoma", Font.BOLD, 15 ) );
            g.setColor(Color.BLUE);
            g.drawString("JUGADOR2 :  ", 600, 250);
        
            g.setFont( new Font( "Tahoma", Font.BOLD, 15 ) );
            g.setColor(Color.black);
            g.drawString(Integer.toString(jugador1.size()), 700, 200);
        
            g.setFont( new Font( "Tahoma", Font.BOLD, 15 ) );
            g.setColor(Color.black);
            g.drawString(Integer.toString(jugador2.size()), 700, 250);
            
            g.setColor(Color.white);
            g.fillRoundRect(30, 520, 800, 30, 20, 20);
            g.drawRoundRect(30, 520, 800, 30, 20, 20);
        
            
            for (int i = 0; i < resultado.length; i++) {
                
                    g.setColor(Color.black);
                    g.drawString(resultado[i],recordx[i], 540);            
                
            }
            
            
           if(j1){
               for (int i = 0; i < resultado.length; i++) {
                    if(jugador1.contains(resultado[i])){
                        g.setColor(Color.red);
                        g.drawString(resultado[i],recordx[i], 540);            
                    }if(jugador2.contains(resultado[i])){
                        g.setColor(Color.blue);
                        g.drawString(resultado[i],recordx[i], 540);            
                    }
               }
           }
           
           
           if(j2){
               for (int i = 0; i < resultado.length; i++) {
                    if(jugador2.contains(resultado[i])){
                        g.setColor(Color.blue);
                        g.drawString(resultado[i],recordx[i], 540);            
                    }if(jugador1.contains(resultado[i])){
                        g.setColor(Color.red);
                        g.drawString(resultado[i],recordx[i], 540);            
                    }
               }
           }
        
        
        
            
        for(letras l : letras){
            l.draw(g);
        }
        
        }
        
        
        
        
    }
    
    
    public void sopabg(){
        
        menuw = (int)(bgimg.getWidth() );
        menuh = (int)(bgimg.getHeight() );
        menux = juego.GAME_WIDTH/2  - menuw /2;
        menuy = 0;
    
    }
    

    @Override
    public void mouseclick(MouseEvent e) {
        
    }

    @Override
    public void mousepressed(MouseEvent e) {
        if(completado){
            overlay.mousepresed(e);
            palabra ="";
        }else{
            curpoint.setLocation(e.getPoint());
        }
        
        
    }

    @Override
    public void mousereleased(MouseEvent e) {
        
        
        
        if(completado){
           
            overlay.mousereleased(e);
        
        }else{
           palabra = "";
        
            for (int j = 0; j <A.size()-1; j++) {
                
                String actual = A.get(j);
                String siguiente = A.get(j+1);
                
                
                if(!actual.equals(siguiente)){
                    
                    B.add(actual);
                }
                
                
        }
         int ultimo = A.size();
         
         if(B.size() != 0){
            B.add(A.get(ultimo-1));
         }
         
         
         
         for (int i = 0; i < B.size(); i++) {
            palabra += B.get(i);
            
        }
         
         for (int i = 0; i < resultado.length; i++) {
            
             
             if(j1){
                 
                 if(palabra.equals( resultado[i] )  && ! jugador2.contains(palabra)  && ! jugador1.contains(palabra)){
                    jugador1.add(palabra);
                    jugador2();
                 }                         
             }
             
             
                 
             if(j2){
                 
                 if(palabra.equals( resultado[i] )  && ! jugador1.contains(palabra) && ! jugador2.contains(palabra)){
                    jugador2.add(palabra);                    
                    jugador1();
                 }
             
         }
       
         B.clear();
        
        
        
        A.clear();
        for(letras l :letras){
            l.setMousepreesed(false);
        }
        
        }
        
    }
        
        
        
    }
    
    

    @Override
    public void mousemoved(MouseEvent e) {
        if(completado){
            overlay.mousemoved(e);
        }
    }

    @Override
    public void keypreseed(KeyEvent e) {
       
    }

    @Override
    public void keyreleased(KeyEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) { 
        
        
     if(!completado){
            if(j1){
        
       for(letras l :letras){
            if(isIn(e,l)){
                l.setMousepreesed(true);
                l.setJ2(false);
                l.setJ1(true);
                   A.add(l.getLetra());    
                
            }            
        }        
    
   
        }
        if(j2){
                
            for(letras l :letras){
            if(isIn(e,l)){
                l.setMousepreesed(true);
                l.setJ1(false);
                l.setJ2(true);
                   A.add(l.getLetra());    
                
            }
            
        }                
    }
     }
    
       }

    
    public int  contarpalabras1(){
        int  total = 0;
        for (int i = 0; i < jugador1.size(); i++) {
            total+=jugador1.get(i).length();
            
            
        }
        return total;
    }
    
    public int  contarpalabras2(){
        int  total = 0;
        for (int i = 0; i < jugador2.size(); i++) {
            total+=jugador2.get(i).length();
            
            
        }
        return total;
    }
    
    
    
    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
    
    public int  getjugador1size(){
        return jugador1.size();
    }
    
    public int  getjugador2size(){
        return jugador2.size();
    }

    public ArrayList<String> getJugador1() {
        return jugador1;
    }

    public ArrayList<String> getJugador2() {
        return jugador2;
    }
    
    public void resetall(){
        
        A.clear();
        B.clear();
        jugador1.clear();
        jugador2.clear();
        seg =0;
        min =0;
        
    }

    
    
    
  class Tempo implements ActionListener{
                public void actionPerformed(ActionEvent e) {
                        
                    seg = seg +1;
                    if(seg == 30){
                        jugar();
                        seg =0;
                        min = min +1;
                    }                    
                }
}
    
    
    
    
    
}
