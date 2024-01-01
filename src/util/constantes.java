
package util;

import main.juego;

/**
 * la clase constantes guarda  las constantes que son usadas repetidamente el  juego cosas como valores de botones 
 * o la sopa de letras y las coordenadas de las letras por pantalla 
 * @author Admin
 */

public class constantes {
    
    public static class ui{
        
        public static class botones{
            public static final int B_WIDTH_DEFAULT = 212;
            public static final int B_HEIGHT_DEFAULT = 47;
            public static final int B_WIDTH = (int)(B_WIDTH_DEFAULT );
            public static final int B_HEIGHT = (int)(B_HEIGHT_DEFAULT);
        }
        
        public static class letras{
            public static final int B_WIDTH_DEFAULT = 218;
            public static final int B_HEIGHT_DEFAULT = 185;
            public static final int B_WIDTH = (int)(B_WIDTH_DEFAULT );
            public static final int B_HEIGHT = (int)(B_HEIGHT_DEFAULT);
        }
        
        
        /**
         * guarda los de la sopa de letras
         */
        public static class sopa{
                public static final int [] cordx =  {50,100,150,200,250,300,350,400,450};
                public static final int [] cordy =  {50,100,150,200,250,300,350,400,450};
                public static final String [][] pa = { {"e","s","r","n","n","s","n","m","o"},
                                                                    {"s","o","o","s","o","o","c","s","a"},
                                                                    {"r","e","c","o","n","o","c","e","r"},
                                                                    {"y","o","c","m","d","j","z","u","a"},
                                                                    {"u","z","y","o","s","o","y","a","y"},
                                                                    {"d","a","r","s","l","u","z","l","a"},
                                                                    {"a","m","d","a","r","a","d","a","r"},
                                                                    {"l","u","z","a","z","u","l","y","o"},
                                                                    {"a","n","a","r","e","c","o","n","r"}
                                                                    };
                public static final String [] resultado = {"ana","oso","ojo","ala","somos","rayar","yosoy","radar","reconocer","luzazul"};
                public static final  int recordx[] = {50,120,190,260,330,400,470,540,610,700};

        }
    }
    
    
    
    
    
    
    
    
}
