package lecXML.analicisLexico.characters;

import java.util.ArrayList;
import java.util.List;

public class ObtenerCarcateres {
    private List<Caracter> caracteres = new ArrayList<>();

    public ObtenerCarcateres() {
    }
    /**
     * Se recibe texto en formato string y devuelve los caracteres que componene el String
     * @param texto
     * @return 
     */
    public List<Caracter> obtenerCaracteres(String texto){
        int columna = 1;
        int linea =1;
        for (int i = 1; i < texto.length(); i++) {
            String caracter = texto.substring(i,i+1);
            char letra = caracter.charAt(0);
            int ascii = (int)letra;
            caracteres.add(new Caracter(linea, columna, caracter,ascii));
            if(caracter.equals("\n")){
                linea++;
                columna=0;
            }
            columna++;
        }
        caracteres.add(new Caracter(linea, columna, "$", -1));
        return this.caracteres;
    }
}
