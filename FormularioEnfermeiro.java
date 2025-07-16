import javax.swing.*;
import java.awt.*;

public class FormularioEnfermeiro extends JDialog {

    private JTextField tfNome, tfGenero, tfIdade, tfEspecialidade, tfTurno, tfContacto;
    private JTextArea taObservacoes;
    private Enfermeiro enfermeiroEditar;
    private GestorEnfermeiros parent;

    public FormularioEnfermeiro(GestorEnfermeiros parent, Enfermeiro enfermeiro) {
        super(parent, "Formulário Enfermeiro", true);
        this.parent = parent;
        this.enfermeiroEditar = enfermeiro;

        setSize(450, 400);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel painel = new JPanel(new GridLayout(7, 2, 5, 5));
        tfNome = new JTextField(); tfGenero = new JTextField(); tfIdade = new JTextField();
        tfEspecialidade = new JTextField(); tfTurno = new JTextField(); tfContacto = new JTextField();
        taObservacoes = new JTextArea(2, 20);

        painel.add(new JLabel("Nome:")); painel.add(tfNome);
        painel.add(new JLabel("Gênero:")); painel.add(tfGenero);
        painel.add(new JLabel("Idade:")); painel.add(tfIdade);
        painel.add(new JLabel("Especialidade:")); painel.add(tfEspecialidade);
        painel.add(new JLabel("Turno:")); painel.add(tfTurno);
        painel.add(new JLabel("Contacto:")); painel.add(tfContacto);
        painel.add(new JLabel("Observações:")); painel.add(new JScrollPane(taObservacoes));

        add(painel, BorderLayout.CENTER);

        JPanel botoes = new JPanel();
        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");
        botoes.add(btnSalvar); botoes.add(btnCancelar);
        add(botoes, BorderLayout.SOUTH);

        if (enfermeiroEditar != null) carregarDados();

        btnSalvar.addActionListener(e -> salvar());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void carregarDados() {
        tfNome.setText(enfermeiroEditar.getNome());
        tfGenero.setText(enfermeiroEditar.getGenero());
        tfIdade.setText(String.valueOf(enfermeiroEditar.getIdade()));
        tfEspecialidade.setText(enfermeiroEditar.getEspecialidade());
        tfTurno.setText(enfermeiroEditar.getTurno());
        tfContacto.setText(enfermeiroEditar.getContacto());
        taObservacoes.setText(enfermeiroEditar.getObservacoes());
    }

    private void salvar() {
        try {
            String nome = tfNome.getText().trim();
            String genero = tfGenero.getText().trim();
            int idade = Integer.parseInt(tfIdade.getText().trim());
            String especialidade = tfEspecialidade.getText().trim();
            String turno = tfTurno.getText().trim();
            String contacto = tfContacto.getText().trim();
            String observacoes = taObservacoes.getText().trim();

            if (nome.isEmpty() || especialidade.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nome e Especialidade são obrigatórios.");
                return;
            }

            if (enfermeiroEditar == null) {
                Enfermeiro novo = new Enfermeiro(nome, genero, idade, especialidade, turno, contacto, observacoes);
                parent.adicionarEnfermeiro(novo);
                JOptionPane.showMessageDialog(this, "Enfermeiro adicionado com sucesso.");
            } else {
                enfermeiroEditar.setNome(nome);
                enfermeiroEditar.setGenero(genero);
                enfermeiroEditar.setIdade(idade);
                enfermeiroEditar.setEspecialidade(especialidade);
                enfermeiroEditar.setTurno(turno);
                enfermeiroEditar.setContacto(contacto);
                enfermeiroEditar.setObservacoes(observacoes);
                JOptionPane.showMessageDialog(this, "Enfermeiro atualizado com sucesso.");
            }

            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Idade inválida.");
        }
    }
}