package lecXML.analicisLexico.Estados;

import lecXML.analicisLexico.DefinicionLenguaje;
import lecXML.analicisLexico.analicisDeEstados;
import lecXML.analicisLexico.characters.Caracter;

public class EstadoS7 {
    DefinicionLenguaje lenguaje = new DefinicionLenguaje();
    public EstadoS7() {
    }
    public String transicion(Caracter caracter){
        int ascii = caracter.getCodigoAscii();
        
        if(lenguaje.letras(ascii)||lenguaje.numeros(ascii)||lenguaje.signos(ascii)){
            return analicisDeEstados.ESTADO_7;
        }else if(ascii==95||ascii==45){
            // _,-,
            return analicisDeEstados.ESTADO_7;
        }else if(ascii==47||ascii==38||ascii==61||ascii==34){
            // / , &  , =  ,  "
            return analicisDeEstados.ESTADO_7;
        }else if(ascii==9||ascii==10||ascii==32){
            // tabulador, nueva linea, espacio
            return analicisDeEstados.ESTADO_7;
        }else{
            return "ERROR";
        }
    }
}
