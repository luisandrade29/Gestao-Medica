package model;

public class Internamento {
    private int id;
    private String paciente;
    private String dataEntrada;
    private String dataSaida;

    public Internamento(int id, String paciente, String dataEntrada, String dataSaida) {
        this.id = id;
        this.paciente = paciente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public int getId() {
        return id;
    }

    public String getPaciente() {
        return paciente;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }
}