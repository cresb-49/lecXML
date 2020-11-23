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
    public static final String FIN = "FIN";
    public static final String ERROR = "ERROR";

    private List<Caracter> caracteres = new ArrayList<>();
    private List<Token> Tokens = new ArrayList<>();
    private List<ErrorLexico> errores = new ArrayList<>();
    // CONTROLADOR DE PEDIDA DE CARACTERES
    private int numeroCaracter = 0;
    private String tipoToken = "";
    private String buffer = "";
    private String lexema = "";
    //LINEA DE UBICACION DEL TOKEN ENCONTRADO
    private int lineaToken = 0;
    // ESTADO DE ANALISIS DE LA MAQUINA DETERMINISTA
    private String beforeState = "";
    private String currentState = this.ESTADO_0;
    // VARAIBLE DE ALMACENAMIENTO DE NOMBRE DE TOKEN
    private String nameToken = "";
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
            //System.out.println("Caracter: " + caracter.getCaracter() + " Estado: " + currentState + " Lexema: " + buffer);
            switch (this.currentState) {
                case ESTADO_0:
                    this.beforeState = this.currentState;
                    this.currentState = s0.transicion(caracter);
                    sumarCaracter(caracter);
                    this.lineaToken = caracter.getLinea();
                    break;
                case ESTADO_1:
                    this.beforeState = this.currentState;
                    this.currentState = s1.transicion(caracter);
                    sumarCaracter(caracter);
                    break;
                case ESTADO_2:
                    this.beforeState = this.currentState;
                    this.currentState = s2.transicion(caracter);
                    sumarCaracter(caracter);
                    if (!tipoToken.equals(Token.TOKEN_UNKNOWN)) {
                        this.tipoToken = Token.TOKEN_TAG_END;
                    }
                    break;
                case ESTADO_3:
                    this.beforeState = this.currentState;
                    this.currentState = s3.transicion(caracter);
                    sumarCaracter(caracter);
                    if (!tipoToken.equals(Token.TOKEN_TAG_END) && !tipoToken.equals(Token.TOKEN_UNKNOWN)) {
                        this.tipoToken = Token.TOKEN_TAG_INIT;
                    }
                    break;
                case ESTADO_4:
                    this.beforeState = this.currentState;
                    this.currentState = s4.transicion(caracter);
                    sumarCaracter(caracter);
                    break;
                case ESTADO_5:
                    this.beforeState = this.currentState;
                    this.currentState = s5.transicion(caracter);
                    sumarCaracter(caracter);
                    break;
                case ESTADO_6:
                    this.beforeState = this.currentState;
                    this.currentState = s6.transicion(caracter);
                    sumarCaracter(caracter);
                    break;
                case ESTADO_7:
                    this.beforeState = this.currentState;
                    this.currentState = s7.transicion(caracter);
                    sumarCaracter(caracter);
                    if (!tipoToken.equals(Token.TOKEN_UNKNOWN)) {
                        this.tipoToken = Token.TOKEN_TEXT;
                    }
                    break;
                case RESET_IGNORE:
                    currentState = ESTADO_0;
                    buffer = "";
                    break;
                case RESET:
                    lexema = buffer;
                    buffer = "";
                    Tokens.add(new Token(lexema, this.tipoToken, this.lineaToken));
                    lexema = "";
                    this.tipoToken = "";
                    this.currentState = ESTADO_0;
                    break;
                case FIN:
                    lexema = buffer;
                    buffer = "";
                    Tokens.add(new Token(lexema, this.tipoToken, this.lineaToken));
                    lexema = "";
                    this.currentState = ESTADO_0;
                    numeroCaracter = caracteres.size();
                    break;
                case "ERROR":
                    Caracter temp = caracteres.get(numeroCaracter - 1);
                    ErrorLexico error = new ErrorLexico(temp.getLinea(), temp.getColumna(), buffer);
                    System.out.println(error.toString());
                    errores.add(error);
                    this.currentState = this.beforeState;
                    this.tipoToken = Token.TOKEN_UNKNOWN;
                    break;
                default:
                    break;
            }
            //System.out.println("Siguiente estado: " + this.currentState);
        }
    }

    private void sumarCaracter(Caracter caracter) {
        if (!(currentState.equals(RESET) || currentState.equals(RESET_IGNORE) || currentState.equals(FIN))) {
            buffer += caracter.getCaracter();
            numeroCaracter++;
        }
    }
    /**
     * RETORNA LOS TOKENS ENCONTRADOS DEL ANALISIS LEXICO
     * @return 
     */
    public List<Token> getTokens() {
        return Tokens;
    }
    /**
     * RETORNA LOS ERRORES LEXICOS ENCONTRADOS EN TEXTO
     * @return 
     */
    public List<ErrorLexico> getErrores() {
        return errores;
    }
}
