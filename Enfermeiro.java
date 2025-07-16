public class Enfermeiro {
    private static int contadorId = 1;
    private int id;
    private String nome;
    private String genero;
    private int idade;
    private String especialidade;
    private String turno;
    private String contacto;
    private String observacoes;

    public Enfermeiro(String nome, String genero, int idade, String especialidade,
                      String turno, String contacto, String observacoes) {
        this.id = contadorId++;
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
        this.especialidade = especialidade;
        this.turno = turno;
        this.contacto = contacto;
        this.observacoes = observacoes;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public int getIdade() {
        return idade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getTurno() {
        return turno;
    }

    public String getContacto() {
        return contacto;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}