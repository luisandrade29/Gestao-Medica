package gestor;

import model.Fatura;

import javax.swing.*;
import java.awt.*;

public class FormularioFatura extends JDialog {

    private JTextField tfId, tfDescricao, tfValor, tfData, tfPaciente;
    private GestorFaturacao parent;
    private Fatura faturaEditar;

    public FormularioFatura(GestorFaturacao parent, Fatura fatura) {
        super((Frame) null, "Formulário de Fatura", true);
        this.parent = parent;
        this.faturaEditar = fatura;

        setSize(450, 300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel painel = new JPanel(new GridLayout(5, 2, 10, 10));
        tfId = new JTextField();
        tfDescricao = new JTextField();
        tfValor = new JTextField();
        tfData = new JTextField();
        tfPaciente = new JTextField();

        painel.add(new JLabel("ID:"));
        painel.add(tfId);
        painel.add(new JLabel("Descrição:"));
        painel.add(tfDescricao);
        painel.add(new JLabel("Valor (€):"));
        painel.add(tfValor);
        painel.add(new JLabel("Data (dd/mm/aaaa):"));
        painel.add(tfData);
        painel.add(new JLabel("Paciente:"));
        painel.add(tfPaciente);

        add(painel, BorderLayout.CENTER);

        JPanel botoes = new JPanel();
        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");
        botoes.add(btnSalvar);
        botoes.add(btnCancelar);
        add(botoes, BorderLayout.SOUTH);

        if (faturaEditar != null) carregarDados();

        btnSalvar.addActionListener(e -> salvar());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void carregarDados() {
        tfId.setText(String.valueOf(faturaEditar.getId()));
        tfDescricao.setText(faturaEditar.getDescricao());
        tfValor.setText(String.valueOf(faturaEditar.getValor()));
        tfData.setText(faturaEditar.getData());
        tfPaciente.setText(faturaEditar.getPaciente());
    }

    private void salvar() {
        try {
            int id = Integer.parseInt(tfId.getText().trim());
            String descricao = tfDescricao.getText().trim();
            double valor = Double.parseDouble(tfValor.getText().trim());
            String data = tfData.getText().trim();
            String paciente = tfPaciente.getText().trim();

            if (descricao.isEmpty() || data.isEmpty() || paciente.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.");
                return;
            }

            if (faturaEditar == null) {
                Fatura nova = new Fatura(id, descricao, valor, data, paciente);
                parent.adicionarFatura(nova);
            } else {
                faturaEditar.setDescricao(descricao);
                faturaEditar.setValor(valor);
                faturaEditar.setData(data);
                faturaEditar.setPaciente(paciente);
                JOptionPane.showMessageDialog(this, "Fatura atualizada com sucesso.");
            }

            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID ou Valor inválido.");
        }
    }
}