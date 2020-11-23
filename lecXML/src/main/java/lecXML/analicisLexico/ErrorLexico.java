package lecXML.analicisLexico;

public class ErrorLexico {

    private int linea;
    private int columna;
    private String text;
    /**
     * CONTRUCTOR POR DEFECTO
     */
    public ErrorLexico() {
    }
    /**
     * CONSTRUCTOR CON PARAMETROS
     * @param linea
     * @param columna
     * @param text 
     */
    public ErrorLexico(int linea, int columna, String text) {
        this.linea = linea;
        this.columna = columna;
        this.text = text;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ErrorLexico{" + "linea=" + linea + ", columna=" + columna + ", text=" + text + '}';
    }
}
