package lecXML.analicisLexico.Estados;

import lecXML.analicisLexico.DefinicionLenguaje;
import lecXML.analicisLexico.analicisDeEstados;
import lecXML.analicisLexico.characters.Caracter;

public class EstadoS2 {
    private DefinicionLenguaje lenguaje = new DefinicionLenguaje();
    public EstadoS2() {
    }
    
    public String transicion(Caracter caracter){
        int ascii = caracter.getCodigoAscii();
        if(ascii==-1){
            return analicisDeEstados.FIN;
        }else if(lenguaje.letras(ascii)||lenguaje.numeros(ascii)){
            return analicisDeEstados.ESTADO_3;
        }else if(ascii==95||ascii==45){
            // _,-,
            return analicisDeEstados.ESTADO_3;
        }else {
            return "ERROR";
        }
    }
}
