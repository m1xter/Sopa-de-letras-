
package util;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *  la clase reproductor se encarga de buscar  y reproducir los sonidos agragados al juego 
 * @author Admin
 */

public class reproductor {
    
    private Clip clip ;
    public static final String  SONIDO1 = "interface.wav";
    
    
    public void cargarsonido(String ruta){
        
        
        try{
            File archivosonido = new File(ruta);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivosonido);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void reproducir (){
        if(clip != null){
            clip.setFramePosition(0);
            clip.start();
        }
    }
    
    public void detener(){
        if(clip != null && clip.isRunning()){
            clip.stop();
        }
    }
    
    
    
    
}
