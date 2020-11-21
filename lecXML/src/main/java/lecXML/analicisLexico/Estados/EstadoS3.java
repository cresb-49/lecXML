package lecXML.analicisLexico.Estados;

import lecXML.analicisLexico.DefinicionLenguaje;
import lecXML.analicisLexico.analicisDeEstados;
import lecXML.analicisLexico.characters.Caracter;

public class EstadoS3 {
    DefinicionLenguaje lenguaje = new DefinicionLenguaje();
    public EstadoS3() {
    }
    public String transicion(Caracter caracter){
        int ascii = caracter.getCodigoAscii();
        
        if(lenguaje.letras(ascii)||lenguaje.numeros(ascii)){
            return analicisDeEstados.ESTADO_3;
        }else if(ascii==95||ascii==45){
            // _,-,
            return analicisDeEstados.ESTADO_3;
        }else if(ascii==62){
            // >
            return analicisDeEstados.ESTADO_5;
        }else if(ascii==9||ascii==10||ascii==32){
            // tabulador, nueva linea, espacio
            return analicisDeEstados.ESTADO_4;
        }else{
            return "ERROR";
        }
    }
}
