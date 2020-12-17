package lecXML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import lecXML.analicisLexico.ErrorLexico;
import lecXML.analicisLexico.Token;
import lecXML.analicisLexico.analicisDeEstados;
import lecXML.analicisLexico.characters.Caracter;
import lecXML.analicisLexico.characters.ObtenerCarcateres;
import lecXML.obtenerTexto.textClass;

public class App 
{
    
    public static void main( String[] args ) throws FileNotFoundException, IOException
    {
        
        textClass textClass1 = new textClass();
        File file = new File("C:\\Users\\carlo\\OneDrive\\Documentos\\PROGRAMACION JAVA\\lecXML\\ENTRADA (copia).xml");
        InputStream data = new FileInputStream(file);
        System.out.println("Nombre: "+file.getName());
        System.out.println("Datos: "+file.getParent());
        System.out.println(data.toString());
        
        String texto="";
        
        texto = textClass1.obtenerTexto(data);
        ObtenerCarcateres obtenerCarcateres = new ObtenerCarcateres();
        List<Caracter> caracteres = obtenerCarcateres.obtenerCaracteres(texto);
        analicisDeEstados analisis = new analicisDeEstados(caracteres);
        analisis.realizarAnalicis();
        
        List<Token> tokens = analisis.getTokens();
        List<ErrorLexico> errores = analisis.getErrores();
        
        
        System.out.println("Errores encontrados: "+errores.size());
        for (ErrorLexico errore : errores) {
            System.out.println(errore.toString());
        }
        if(errores.size()==0){
            System.out.println("Tokens encontrados: "+tokens.size());
            for (Token tok:tokens) {
                System.out.println(tok.toString());
            }
        }
        
        
        
    }
}
