package lecXML.analicisLexico.Estados;

import lecXML.analicisLexico.characters.Caracter;

public class EstadoS5 {
    public EstadoS5() {
    }
    public String transicion(Caracter caracter){
        return "RESET";
    }
}
