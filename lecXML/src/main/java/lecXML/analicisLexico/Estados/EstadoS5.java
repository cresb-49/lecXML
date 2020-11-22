package lecXML.analicisLexico.Estados;

import lecXML.analicisLexico.analicisDeEstados;
import lecXML.analicisLexico.characters.Caracter;

public class EstadoS5 {
    public EstadoS5() {
    }
    public String transicion(Caracter caracter){
        if(caracter.getCodigoAscii()==-1){
            return analicisDeEstados.FIN;
        }else {
            return analicisDeEstados.RESET;
        }
    }
}
