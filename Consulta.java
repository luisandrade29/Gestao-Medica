package modelo;

import modelo.Medico;
import java.util.Date;

public class Consulta {
    private Medico medico;
    private Date data;
    private String descricao;

    public Consulta(Medico medico, Date data, String descricao) {
        this.medico = medico;
        this.data = data;
        this.descricao = descricao;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Consulta agendada com " + medico.getNome() + " em " + data + ": " + descricao;
    }
}