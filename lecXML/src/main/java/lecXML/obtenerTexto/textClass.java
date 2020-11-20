package lecXML.obtenerTexto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class textClass {

    /**
     * CONTRUCTOR POR DEFECTO
     */
    public textClass() {

    }

    public String obtenerTexto(InputStream inputStream) throws IOException {
        String contenido = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String linea;
        while ((linea = bufferedReader.readLine()) != null) {
            contenido += "\n"+linea;
        }
        if (contenido.length() == 0) {
            contenido = null;
        }
        return contenido;
    }

}
