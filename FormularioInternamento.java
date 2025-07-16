package gestor;

import model.Internamento;

import javax.swing.*;
import java.awt.*;

public class FormularioInternamento extends JDialog {

    private JTextField tfId, tfPaciente, tfEntrada, tfSaida;
    private Internamento internamentoEditar;
    private GestorInternamentos parent;

    public FormularioInternamento(GestorInternamentos parent, Internamento i) {
        super(parent, "Formulário de Internamento", true);
        this.parent = parent;
        this.internamentoEditar = i;

        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel painel = new JPanel(new GridLayout(4, 2, 10, 10));
        tfId = new JTextField();
        tfPaciente = new JTextField();
        tfEntrada = new JTextField();
        tfSaida = new JTextField();

        painel.add(new JLabel("ID:"));
        painel.add(tfId);
        painel.add(new JLabel("Paciente:"));
        painel.add(tfPaciente);
        painel.add(new JLabel("Data Entrada:"));
        painel.add(tfEntrada);
        painel.add(new JLabel("Data Saída:"));
        painel.add(tfSaida);

        if (internamentoEditar != null) carregarDados();

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
        tfId.setText(String.valueOf(internamentoEditar.getId()));
        tfId.setEnabled(false);
        tfPaciente.setText(internamentoEditar.getPaciente());
        tfEntrada.setText(internamentoEditar.getDataEntrada());
        tfSaida.setText(internamentoEditar.getDataSaida());
    }

    private void salvar() {
        try {
            int id = Integer.parseInt(tfId.getText().trim());
            String paciente = tfPaciente.getText().trim();
            String entrada = tfEntrada.getText().trim();
            String saida = tfSaida.getText().trim();

            if (paciente.isEmpty() || entrada.isEmpty() || saida.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
                return;
            }

            if (internamentoEditar == null) {
                Internamento novo = new Internamento(id, paciente, entrada, saida);
                parent.adicionarInternamento(novo);
                JOptionPane.showMessageDialog(this, "Internamento adicionado.");
            } else {
                internamentoEditar.setPaciente(paciente);
                internamentoEditar.setDataEntrada(entrada);
                internamentoEditar.setDataSaida(saida);
                JOptionPane.showMessageDialog(this, "Internamento atualizado.");
            }

            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
        }
    }
}