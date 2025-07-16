package modelo;

public class Medicamento {
    private String nome;
    private String dosagem;
    private String laboratorio;

    public Medicamento(String nome, String dosagem, String laboratorio) {
        this.nome = nome;
        this.dosagem = dosagem;
        this.laboratorio = laboratorio;
    }

    public String getNome() {
        return nome;
    }

    public String getDosagem() {
        return dosagem;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    @Override
    public String toString() {
        return nome + " - " + dosagem + " (" + laboratorio + ")";
    }
}