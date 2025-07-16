package model;

public class Exame {
    private static int contador = 1;
    private int id;
    private int idUtente;
    private String tipo;
    private String resultado;

    public Exame(int idUtente, String tipo, String resultado) {
        this.id = contador++;
        this.idUtente = idUtente;
        this.tipo = tipo;
        this.resultado = resultado;
    }

    public int getId() {
        return id;
    }

    public int getIdUtente() {
        return idUtente;
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

    @Override
    public String toString() {
        return "Exame{" +
                "id=" + id +
                ", idUtente=" + idUtente +
                ", tipo='" + tipo + '\'' +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}