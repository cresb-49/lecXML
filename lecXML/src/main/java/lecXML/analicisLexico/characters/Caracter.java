package lecXML.analicisLexico.characters;

public class Caracter {
    private int linea;
    private int columna;
    private String caracter;
    private int codigoAscii;
    /**
     * CONSTRUCTOR CON PARAMETROS DE LA CLASE
     * @param linea
     * @param columna
     * @param caracter
     * @param codigoAscii 
     */
    public Caracter(int linea, int columna, String caracter, int codigoAscii) {
        this.linea = linea;
        this.columna = columna;
        this.caracter = caracter;
        this.codigoAscii = codigoAscii;
    }    
    /**
     * CONTRUCTOR POR DEFECTO
     */
    public Caracter() {
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

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public int getCodigoAscii() {
        return codigoAscii;
    }

    public void setCodigoAscii(int codigoAscii) {
        this.codigoAscii = codigoAscii;
    }
    
    @Override
    public String toString() {
        return "Caracter{" + "linea=" + linea + ", columna=" + columna + ", caracter=" + caracter + ", codigoAscii=" + codigoAscii + '}';
    }

    
}
