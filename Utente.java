package model;

public class Utente {
    private static int contador = 1;

    private int id;
    private String nome;
    private String dataNascimento;
    private String genero;
    private String numeroUtente;
    private double altura;
    private double peso;
    private String grupoSanguineo;
    private String telefone;
    private String email;
    private String morada;
    private String observacoes;

    public Utente(String nome, String dataNascimento, String genero, String numeroUtente,
                  double altura, double peso, String grupoSanguineo, String telefone,
                  String email, String morada, String observacoes) {
        this.id = contador++;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.numeroUtente = numeroUtente;
        this.altura = altura;
        this.peso = peso;
        this.grupoSanguineo = grupoSanguineo;
        this.telefone = telefone;
        this.email = email;
        this.morada = morada;
        this.observacoes = observacoes;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getDataNascimento() { return dataNascimento; }
    public String getGenero() { return genero; }
    public String getNumeroUtente() { return numeroUtente; }
    public double getAltura() { return altura; }
    public double getPeso() { return peso; }
    public String getGrupoSanguineo() { return grupoSanguineo; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
    public String getMorada() { return morada; }
    public String getObservacoes() { return observacoes; }

    public void setNome(String nome) { this.nome = nome; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setNumeroUtente(String numeroUtente) { this.numeroUtente = numeroUtente; }
    public void setAltura(double altura) { this.altura = altura; }
    public void setPeso(double peso) { this.peso = peso; }
    public void setGrupoSanguineo(String grupoSanguineo) { this.grupoSanguineo = grupoSanguineo; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setEmail(String email) { this.email = email; }
    public void setMorada(String morada) { this.morada = morada; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    @Override
    public String toString() {
        return id + " - " + nome;
    }
}