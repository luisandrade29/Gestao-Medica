package gestor;

import model.Departamento;

import javax.swing.*;
import java.awt.*;

public class FormularioDepartamento extends JDialog {

    private JTextField tfId, tfNome, tfEspecialidade;
    private Departamento departamentoEditar;
    private GestorDepartamentos parent;

    public FormularioDepartamento(GestorDepartamentos parent, Departamento depto) {
        super(parent, "Formulário Departamento", true);
        this.parent = parent;
        this.departamentoEditar = depto;

        setSize(400, 250);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel painel = new JPanel(new GridLayout(3, 2, 10, 10));
        tfId = new JTextField();
        tfNome = new JTextField();
        tfEspecialidade = new JTextField();

        painel.add(new JLabel("ID:"));
        painel.add(tfId);
        painel.add(new JLabel("Nome:"));
        painel.add(tfNome);
        painel.add(new JLabel("Especialidade:"));
        painel.add(tfEspecialidade);

        if (departamentoEditar != null) carregarDados();

        JPanel botoes = new JPanel();
        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");

        botoes.add(btnSalvar);
        botoes.add(btnCancelar);

        add(painel, BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        btnSalvar.addActionListener(e -> salvar());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void carregarDados() {
        tfId.setText(String.valueOf(departamentoEditar.getId()));
        tfId.setEnabled(false); 
        tfNome.setText(departamentoEditar.getNome());
        tfEspecialidade.setText(departamentoEditar.getEspecialidade());
    }

    private void salvar() {
        try {
            int id = Integer.parseInt(tfId.getText().trim());
            String nome = tfNome.getText().trim();
            String esp = tfEspecialidade.getText().trim();

            if (nome.isEmpty() || esp.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
                return;
            }

            if (departamentoEditar == null) {
                Departamento novo = new Departamento(id, nome, esp);
                parent.adicionarDepartamento(novo);
                JOptionPane.showMessageDialog(this, "Departamento adicionado.");
            } else {
                departamentoEditar.setNome(nome);
                departamentoEditar.setEspecialidade(esp);
                JOptionPane.showMessageDialog(this, "Departamento atualizado.");
            }

            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido!");
        }
    }
}
