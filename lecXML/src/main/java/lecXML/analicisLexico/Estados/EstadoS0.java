package lecXML.analicisLexico.Estados;

import lecXML.analicisLexico.DefinicionLenguaje;
import lecXML.analicisLexico.analicisDeEstados;
import lecXML.analicisLexico.characters.Caracter;

public class EstadoS0 {
    private DefinicionLenguaje lenguaje = new DefinicionLenguaje();
    public EstadoS0() {
        
    }
    
    public String transicion(Caracter caracter){
        int ascii = caracter.getCodigoAscii();
        if(ascii==-1){
            return analicisDeEstados.FIN;
        }else if (ascii==60){
            //carcter igual a <
            return analicisDeEstados.ESTADO_1;
        }else if(ascii==9||ascii==10||ascii==32){
            //tabulador, nueva linea, espacio
            return analicisDeEstados.ESTADO_6;
        }else if(lenguaje.letras(ascii)||lenguaje.numeros(ascii)||lenguaje.signos(ascii)){
            return analicisDeEstados.ESTADO_7;
        }else if(ascii==95||ascii==45||ascii==47||ascii==38||ascii==61||ascii==34){
            // _,-,/,&,=,"
            return analicisDeEstados.ESTADO_7;
        }else{
            return analicisDeEstados.ERROR;
        }
    }
}
