import java.time.LocalDate;

public class Sintoma {
    private String descricao;
    private LocalDate data;
    private int gravidade;  // escala de 1 a 10

    public Sintoma(String descricao, LocalDate data, int gravidade) {
        this.descricao = descricao;
        this.data = data;
        this.gravidade = gravidade;
    }

    // Getters

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public int getGravidade() {
        return gravidade;
    }

    @Override
    public String toString() {
        return "Sintoma{" +
                "descricao='" + descricao + '\'' +
                ", data=" + data +
                ", gravidade=" + gravidade +
                '}';
    }
}
