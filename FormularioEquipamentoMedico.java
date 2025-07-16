package gestor;

import model.EquipamentoMedico;

import javax.swing.*;
import java.awt.*;

public class FormularioEquipamentoMedico extends JDialog {

    private JTextField tfNumeroSerie, tfNome, tfDescricao;
    private GestorEquipamentos parent;
    private EquipamentoMedico equipamentoEditar;

    public FormularioEquipamentoMedico(GestorEquipamentos parent, EquipamentoMedico equipamento) {
        super((Frame) null, "Formulário Equipamento Médico", true);

        this.parent = parent;
        this.equipamentoEditar = equipamento;

        setSize(400, 250);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel painel = new JPanel(new GridLayout(3, 2, 10, 10));

        painel.add(new JLabel("Número de Série:"));
        tfNumeroSerie = new JTextField();
        painel.add(tfNumeroSerie);

        painel.add(new JLabel("Nome:"));
        tfNome = new JTextField();
        painel.add(tfNome);

        painel.add(new JLabel("Descrição:"));
        tfDescricao = new JTextField();
        painel.add(tfDescricao);

        add(painel, BorderLayout.CENTER);

        JPanel botoes = new JPanel();
        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");
        botoes.add(btnSalvar);
        botoes.add(btnCancelar);
        add(botoes, BorderLayout.SOUTH);

        if (equipamentoEditar != null) carregarDados();

        btnSalvar.addActionListener(e -> salvar());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void carregarDados() {
        tfNumeroSerie.setText(equipamentoEditar.getCodigo());
        tfNome.setText(equipamentoEditar.getNome());
        tfDescricao.setText(equipamentoEditar.getDescricao());
    }

    private void salvar() {
        String numeroSerie = tfNumeroSerie.getText().trim();
        String nome = tfNome.getText().trim();
        String descricao = tfDescricao.getText().trim();

        if (numeroSerie.isEmpty() || nome.isEmpty() || descricao.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
            return;
        }

        if (equipamentoEditar == null) {
            EquipamentoMedico novo = new EquipamentoMedico(numeroSerie, nome, descricao);
            parent.adicionarEquipamento(novo);
            JOptionPane.showMessageDialog(this, "Equipamento adicionado com sucesso.");
        } else {
            equipamentoEditar.setCodigo(numeroSerie);
            equipamentoEditar.setNome(nome);
            equipamentoEditar.setDescricao(descricao);
            JOptionPane.showMessageDialog(this, "Equipamento atualizado com sucesso.");
        }

        dispose();
    }
}