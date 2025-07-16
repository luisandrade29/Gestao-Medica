package gestor;

import model.Utente;
import javax.swing.*;
import java.awt.*;

public class FormularioUtente extends JDialog {

    private JTextField tfNome, tfDataNascimento, tfGenero, tfNumeroUtente,
            tfAltura, tfPeso, tfGrupoSanguineo, tfTelefone, tfEmail, tfMorada, tfObservacoes;
    private GestorUtentes parent;
    private Utente utenteEditar;

    public FormularioUtente(GestorUtentes parent, Utente utente) {
        super(parent, "Formulário de Utente", true);
        this.parent = parent;
        this.utenteEditar = utente;

        setSize(400, 500);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(12, 2, 5, 5));

        add(new JLabel("Nome:"));
        tfNome = new JTextField();
        add(tfNome);

        add(new JLabel("Data Nasc.:"));
        tfDataNascimento = new JTextField();
        add(tfDataNascimento);

        add(new JLabel("Gênero:"));
        tfGenero = new JTextField();
        add(tfGenero);

        add(new JLabel("Nº Utente:"));
        tfNumeroUtente = new JTextField();
        add(tfNumeroUtente);

        add(new JLabel("Altura (m):"));
        tfAltura = new JTextField();
        add(tfAltura);

        add(new JLabel("Peso (kg):"));
        tfPeso = new JTextField();
        add(tfPeso);

        add(new JLabel("Grupo Sanguíneo:"));
        tfGrupoSanguineo = new JTextField();
        add(tfGrupoSanguineo);

        add(new JLabel("Telefone:"));
        tfTelefone = new JTextField();
        add(tfTelefone);

        add(new JLabel("Email:"));
        tfEmail = new JTextField();
        add(tfEmail);

        add(new JLabel("Morada:"));
        tfMorada = new JTextField();
        add(tfMorada);

        add(new JLabel("Observações:"));
        tfObservacoes = new JTextField();
        add(tfObservacoes);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");

        btnSalvar.addActionListener(e -> salvar());
        btnCancelar.addActionListener(e -> dispose());

        add(btnSalvar);
        add(btnCancelar);

        if (utenteEditar != null) carregarDados();
    }

    private void carregarDados() {
        tfNome.setText(utenteEditar.getNome());
        tfDataNascimento.setText(utenteEditar.getDataNascimento());
        tfGenero.setText(utenteEditar.getGenero());
        tfNumeroUtente.setText(utenteEditar.getNumeroUtente());
        tfAltura.setText(String.valueOf(utenteEditar.getAltura()));
        tfPeso.setText(String.valueOf(utenteEditar.getPeso()));
        tfGrupoSanguineo.setText(utenteEditar.getGrupoSanguineo());
        tfTelefone.setText(utenteEditar.getTelefone());
        tfEmail.setText(utenteEditar.getEmail());
        tfMorada.setText(utenteEditar.getMorada());
        tfObservacoes.setText(utenteEditar.getObservacoes());
    }

    private void salvar() {
        try {
            String nome = tfNome.getText().trim();
            String dataNasc = tfDataNascimento.getText().trim();
            String genero = tfGenero.getText().trim();
            String numeroUtente = tfNumeroUtente.getText().trim();
            double altura = Double.parseDouble(tfAltura.getText().trim());
            double peso = Double.parseDouble(tfPeso.getText().trim());
            String grupoSanguineo = tfGrupoSanguineo.getText().trim();
            String telefone = tfTelefone.getText().trim();
            String email = tfEmail.getText().trim();
            String morada = tfMorada.getText().trim();
            String observacoes = tfObservacoes.getText().trim();

            if (nome.isEmpty() || dataNasc.isEmpty() || genero.isEmpty() || numeroUtente.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.");
                return;
            }

            if (utenteEditar == null) {
                Utente novo = new Utente(nome, dataNasc, genero, numeroUtente, altura, peso,
                        grupoSanguineo, telefone, email, morada, observacoes);
                parent.adicionarUtente(novo);
                JOptionPane.showMessageDialog(this, "Utente adicionado com sucesso!");
            } else {
                utenteEditar.setNome(nome);
                utenteEditar.setDataNascimento(dataNasc);
                utenteEditar.setGenero(genero);
                utenteEditar.setNumeroUtente(numeroUtente);
                utenteEditar.setAltura(altura);
                utenteEditar.setPeso(peso);
                utenteEditar.setGrupoSanguineo(grupoSanguineo);
                utenteEditar.setTelefone(telefone);
                utenteEditar.setEmail(email);
                utenteEditar.setMorada(morada);
                utenteEditar.setObservacoes(observacoes);
                JOptionPane.showMessageDialog(this, "Utente atualizado com sucesso!");
            }
            dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Valores numéricos inválidos para altura ou peso.");
        }
    }
}