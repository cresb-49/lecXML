package lecXML.analicisLexico;

import lecXML.analicisLexico.characters.Caracter;

public class Token {
    
    public static final String TOKEN_TAG_INIT="TAG_INIT";
    public static final String TOKEN_TAG_END="TAG_END";
    public static final String TOKEN_TEXT="TEXT";
    public static final String TOKEN_UNKNOWN="UNKNOWN";
    
    private String lexema;
    private String tipo;
    private int linea;
    
    /**
     * CONTRUCTOR POR DEFECTO
     */
    public Token(){
        
    }
    
    
    /**
     * CONTRUCTOR CON PARAMETROS
     * @param lexema
     * @param tipo
     * @param linea 
     */
    public Token(String lexema, String tipo, int linea) {
        this.lexema = lexema;
        this.tipo = tipo;
        this.linea = linea;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    @Override
    public String toString() {
        return "Token{" + "lexema=" + lexema + ", tipo=" + tipo + ", linea=" + linea + '}';
    }
}
