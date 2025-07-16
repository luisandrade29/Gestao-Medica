package model;

public class Analise {
    private int idUtente;
    private String tipo;
    private String resultado;

    public Analise(int idUtente, String tipo, String resultado) {
        this.idUtente = idUtente;
        this.tipo = tipo;
        this.resultado = resultado;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}