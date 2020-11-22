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

    public static final String RESET_IGNORE = "RESET_INGNORE";
    public static final String RESET = "RESET";
    public static final String FIN ="FIN";

    private List<Caracter> caracteres = new ArrayList<>();
    private List<Token> Tokens = new ArrayList<>();
    // CONTROLADOR DE PEDIDA DE CARACTERES
    private int numeroCaracter = 0;
    private String tipoToken = "";
    private String buffer = "";
    private String lexema="";
    // ESTADO DE ANALISIS DE LA MAQUINA DETERMINISTA
    private String currentState = this.ESTADO_0;
    // ESTADOS DE LA MAQUINA FINITA DETERMINISTA
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
    public analicisDeEstados(List<Caracter> caracteres) {
        this.caracteres = caracteres;
    }

    public void realizarAnalicis() {
        Caracter caracter;
        while (numeroCaracter < caracteres.size()) {
            caracter = this.caracteres.get(numeroCaracter);
            System.out.println("Caracter: "+caracter.getCaracter()+" Estado: "+currentState+" Lexema: "+buffer);
            switch (this.currentState) {
                case ESTADO_0:
                    this.currentState=s0.transicion(caracter);
                    sumarCaracter(caracter);
                    break;
                case ESTADO_1:
                    this.currentState=s1.transicion(caracter);
                    sumarCaracter(caracter);
                    break;
                case ESTADO_2:
                    this.currentState=s2.transicion(caracter);
                    sumarCaracter(caracter);
                    break;
                case ESTADO_3:
                    this.currentState=s3.transicion(caracter);
                    sumarCaracter(caracter);
                    break;
                case ESTADO_4:
                    this.currentState=s4.transicion(caracter);
                    sumarCaracter(caracter);
                    break;
                case ESTADO_5:
                    this.currentState=s5.transicion(caracter);
                    sumarCaracter(caracter);
                    break;
                case ESTADO_6:
                    this.currentState=s6.transicion(caracter);
                    sumarCaracter(caracter);
                    break;
                case ESTADO_7:
                    this.currentState=s7.transicion(caracter);
                    sumarCaracter(caracter);
                    break;
                case RESET_IGNORE:
                    currentState=ESTADO_0;
                    buffer="";
                    break;
                case RESET:
                    lexema = buffer;
                    buffer="";
                    Tokens.add(new Token(lexema, "tipo_NULL", 0));
                    lexema="";
                    this.currentState=ESTADO_0;
                    break;
                case FIN:
                    lexema = buffer;
                    buffer="";
                    System.out.println("Agrego el ultimo token con lexema: "+lexema);
                    Tokens.add(new Token(lexema, "tipo_NULL", 0));
                    lexema="";
                    this.currentState=ESTADO_0;
                    numeroCaracter=caracteres.size();
                    break;
                default:
                    break;
            }
        }
        System.out.println("Impresion de los token");
        System.out.println("Tokens encontrados: "+Tokens.size());
        for(Token token:Tokens){
            System.out.println(token.toString());
        }
    }
    private void sumarCaracter(Caracter caracter){
        if(!(currentState.equals(RESET)||currentState.equals(RESET_IGNORE)||currentState.equals(FIN))){
            buffer+=caracter.getCaracter();
            numeroCaracter++;
        }
    }

}
