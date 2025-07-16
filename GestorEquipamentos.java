package gestor;

import model.EquipamentoMedico;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GestorEquipamentos extends JFrame {

    private ArrayList<EquipamentoMedico> equipamentos = new ArrayList<>();

    public GestorEquipamentos() {
        super("Gestão de Equipamentos Médicos");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));

        JButton btnAdicionar = new JButton("➕ Adicionar Equipamento");
        JButton btnEditar = new JButton("✏️ Editar Equipamento");
        JButton btnRemover = new JButton("❌ Remover Equipamento");
        JButton btnListar = new JButton("📋 Listar Equipamentos");
        JButton btnVoltar = new JButton("Voltar");

        add(btnAdicionar);
        add(btnEditar);
        add(btnRemover);
        add(btnListar);
        add(btnVoltar);

        btnAdicionar.addActionListener(e -> abrirFormularioAdicionar());
        btnEditar.addActionListener(e -> abrirEditarEquipamento());
        btnRemover.addActionListener(e -> abrirRemoverEquipamento());
        btnListar.addActionListener(e -> abrirListarEquipamentos());
        btnVoltar.addActionListener(e -> dispose());
    }

    private void abrirFormularioAdicionar() {
        FormularioEquipamentoMedico formulario = new FormularioEquipamentoMedico(this, null);
        formulario.setVisible(true);
    }

    private void abrirEditarEquipamento() {
        String codigo = JOptionPane.showInputDialog(this, "Insira o código do equipamento para editar:");
        if (codigo != null) {
            EquipamentoMedico equipamento = buscarEquipamentoPorCodigo(codigo);
            if (equipamento != null) {
                FormularioEquipamentoMedico formulario = new FormularioEquipamentoMedico(this, equipamento);
                formulario.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Equipamento não encontrado!");
            }
        }
    }

    private void abrirRemoverEquipamento() {
        String codigo = JOptionPane.showInputDialog(this, "Insira o código do equipamento para remover:");
        if (codigo != null) {
            EquipamentoMedico equipamento = buscarEquipamentoPorCodigo(codigo);
            if (equipamento != null) {
                int confirm = JOptionPane.showConfirmDialog(this,
                        "Confirma remoção do equipamento: " + equipamento.getDescricao() + "?",
                        "Confirmar Remoção", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    equipamentos.remove(equipamento);
                    JOptionPane.showMessageDialog(this, "Equipamento removido com sucesso.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Equipamento não encontrado!");
            }
        }
    }

    private void abrirListarEquipamentos() {
        ListagemEquipamentosMedicos listagem = new ListagemEquipamentosMedicos(this, equipamentos);
        listagem.setVisible(true);
    }

    public void adicionarEquipamento(EquipamentoMedico equipamento) {
        equipamentos.add(equipamento);
    }

    private EquipamentoMedico buscarEquipamentoPorCodigo(String codigo) {
        for (EquipamentoMedico eq : equipamentos) {
            if (eq.getCodigo().equals(codigo)) {
                return eq;
            }
        }
        return null;
    }
}