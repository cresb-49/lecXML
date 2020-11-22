package lecXML.analicisLexico.Estados;

import lecXML.analicisLexico.analicisDeEstados;
import lecXML.analicisLexico.characters.Caracter;

public class EstadoS4 {
    
    public EstadoS4() {
    }
    public String transicion(Caracter caracter){
        int ascii = caracter.getCodigoAscii();
        
        switch (ascii) {
            case -1:
                return analicisDeEstados.FIN;
            case 62:
                return analicisDeEstados.ESTADO_5;
            case 9:
            case 10:
            case 32:
                // tabulador, nueva linea, espacio
                return analicisDeEstados.ESTADO_4;
            default:
                return "ERROR";
        }
    }
}
