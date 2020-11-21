package lecXML.analicisLexico;

public class DefinicionLenguaje {
    /**
     * CONTRUCTOR POR DEFECTO
     */
    public DefinicionLenguaje() {
        
    }
    
    /**
     * Realiza la validacion del caracter si es un numero
     * @param ascii
     * @return 
     */
    public boolean numeros(int ascii){
        if(ascii>=48&&ascii<=57){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Realiza la validacion del caracter si es una letra
     * @param ascii
     * @return 
     */
    public boolean letras(int ascii){
        if(ascii>=65&&ascii<=90){
            //Letras mayusculas
            return true;
        }else if(ascii>=97&&ascii<=122){
            //Letras minusculas
            return true;
        }else{
            return false;
        }
    }
    /**
     * Realiza la validacion del caracter si es un signo
     * @param ascii
     * @return 
     */
    public boolean signos(int ascii){
        if(ascii>=33&&ascii<=46){
            return true;
        }else if(ascii>=58&&ascii<=59){
            return true;
        }else if(ascii>=63&&ascii<=64){
            return true;
        }else if(ascii>=91&&ascii<=96){
            return true;
        }else if(ascii>=123&&ascii<=126){
            return true;
        }else{
            return false;
        }
    }
}
