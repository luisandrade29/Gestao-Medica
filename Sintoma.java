import java.time.LocalDate;

public class Sintoma {
    private String descricao;
    private LocalDate data;
    private int gravidade;  

    public Sintoma(String descricao, LocalDate data, int gravidade) {
        this.descricao = descricao;
        this.data = data;
        this.gravidade = gravidade;
    }


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
