package lecXML.analicisLexico.Estados;

import lecXML.analicisLexico.DefinicionLenguaje;
import lecXML.analicisLexico.analicisDeEstados;
import lecXML.analicisLexico.characters.Caracter;

public class EstadoS1 {
    private DefinicionLenguaje lenguaje = new DefinicionLenguaje();
    public EstadoS1() {
    }
    public String transicion(Caracter caracter){
        int ascii = caracter.getCodigoAscii();
        if(lenguaje.letras(ascii)||lenguaje.numeros(ascii)){
            return analicisDeEstados.ESTADO_3;
        }else if(ascii==95||ascii==45){
            // _,-,
            return analicisDeEstados.ESTADO_3;
        }else if(ascii==47){
            // /
            return analicisDeEstados.ESTADO_2;
        }else{
            return "ERROR";
        }
    }
}
