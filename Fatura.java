package model;

public class Fatura {
    private int id;
    private String descricao;
    private double valor;
    private String data;
    private String paciente;

    public Fatura(int id, String descricao, double valor, String data, String paciente) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.paciente = paciente;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }
}