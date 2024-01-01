
package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import javax.imageio.ImageIO;
/**
 * la clase load se encarga de cargar las imagenes necesarias para  el juego 
 * @author Admin
 */

public class load {
    
    public static final String  MENUBG = "menubg_sopa.png";
    public static final String  BOTONES_MENU = "botones.png";    
    public static final String  SOPA = "sopa.png";
    public static final String  LETRAS = "letras.png";
    public static final String  FONDO2 = "fondo2.png";
    public static final String  COMPLETADO = "completado.png";
    public static final String  CREDITOS = "creditos.png";
    public static final String  COMOJUGAR = "comojugar.png";
    public static final String  URMBOTON = "urmboton.png";
    
    /**
     * el metodo getspriteatlas  se encarga de buscar la imagen correspondiente al nombre que se le pase por argumento
     * @param fileName
     * @return 
     */
    public static BufferedImage GetSpriteAtlas(String fileName) {
		BufferedImage img = null;
                                    
		InputStream is = load.class.getResourceAsStream("/" + fileName);
		try {
			img = ImageIO.read(is);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return img;
	}
    
    
    
}
