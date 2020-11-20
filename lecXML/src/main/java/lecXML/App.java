package lecXML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import lecXML.obtenerTexto.textClass;

public class App 
{
    
    public static void main( String[] args ) throws FileNotFoundException, IOException
    {
        
        textClass textClass1 = new textClass();
        File file = new File("/home/benjamin/Documentos/PROYECTOS_PERSONALES/ENTRADA.xml");
        InputStream data = new FileInputStream(file);
        System.out.println("Nombre: "+file.getName());
        System.out.println("Datos: "+file.getParent());
        System.out.println(data.toString());
        
        String texto="";
        
        texto = textClass1.obtenerTexto(data);
        
        System.out.println("Texto recuperado");
        System.out.println(texto);
        
    }
}
