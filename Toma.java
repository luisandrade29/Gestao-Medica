import java.time.LocalDateTime;

public class Toma {
    private String nomeMedicamento;
    private LocalDateTime dataHoraToma;
    private boolean tomado;
    private String observacoes;
    private String numeroUtente;

    public Toma(String nomeMedicamento, LocalDateTime dataHoraToma, boolean tomado,
                String observacoes, String numeroUtente) {
        this.nomeMedicamento = nomeMedicamento;
        this.dataHoraToma = dataHoraToma;
        this.tomado = tomado;
        this.observacoes = observacoes;
        this.numeroUtente = numeroUtente;
    }

    // Getters e setters

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public LocalDateTime getDataHoraToma() {
        return dataHoraToma;
    }

    public boolean isTomado() {
        return tomado;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public String getNumeroUtente() {
        return numeroUtente;
    }

    public void setTomado(boolean tomado) {
        this.tomado = tomado;
    }

    @Override
    public String toString() {
        return "Toma{" +
                "nomeMedicamento='" + nomeMedicamento + '\'' +
                ", dataHoraToma=" + dataHoraToma +
                ", tomado=" + tomado +
                ", observacoes='" + observacoes + '\'' +
                ", numeroUtente='" + numeroUtente + '\'' +
                '}';
    }
}
