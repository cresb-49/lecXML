package lecXML.analicisLexico;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import lecXML.analicisLexico.Estados.*;
import lecXML.analicisLexico.characters.Caracter;

public class analicisDeEstados {
    
    public static final String ESTADO_0 = "S0";
    public static final String ESTADO_1 = "S1";
    public static final String ESTADO_2 = "S2";
    public static final String ESTADO_3 = "S3";
    public static final String ESTADO_4 = "S4";
    public static final String ESTADO_5 = "S5";
    public static final String ESTADO_6 = "S6";
    public static final String ESTADO_7 = "S7";
    
    private List<Caracter> caracteres = new ArrayList<>();
    private List<Token> Tokens = new ArrayList<>();
    //CONTROLADOR DE PEDIDA DE CARACTERES
    private int numeroCaracter=0;
    private String tipoToken="";
    private String buffer="";
    //ESTADOS DE LA MAQUINA FINITA DETERMINISTA
    private EstadoS0 s0 = new EstadoS0();
    private EstadoS1 s1 = new EstadoS1();
    private EstadoS2 s2 = new EstadoS2();
    private EstadoS3 s3 = new EstadoS3();
    private EstadoS4 s4 = new EstadoS4();
    private EstadoS5 s5 = new EstadoS5();
    private EstadoS6 s6 = new EstadoS6();
    private EstadoS7 s7 = new EstadoS7();
    
    /**
     * CONSTRUCTOR POR DEFECTO DE LA ENTIDAD
     */
    public analicisDeEstados(List<Caracter> caracteres){
        this.caracteres=caracteres;
    }
    
    public void realizarAnalicis(){
        
        while (numeroCaracter != caracteres.size()) {            
            System.out.println(caracteres.get(numeroCaracter));
            numeroCaracter++;
        }
    }
    
    
    
}
