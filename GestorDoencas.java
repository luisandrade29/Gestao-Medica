package gestor;

import model.Doenca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GestorDoencas extends JFrame {

    private ArrayList<Doenca> doencas = new ArrayList<>();

    public GestorDoencas() {
        super("Gestão de Doenças");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnAdicionar = new JButton("➕ Adicionar Doença");
        JButton btnEditar = new JButton("✏️ Editar Doença");
        JButton btnRemover = new JButton("❌ Remover Doença");
        JButton btnListar = new JButton("📋 Listar Doenças");

        add(btnAdicionar);
        add(btnEditar);
        add(btnRemover);
        add(btnListar);

        btnAdicionar.addActionListener(e -> abrirFormularioDoenca(null));
        btnEditar.addActionListener(e -> editarDoenca());
        btnRemover.addActionListener(e -> removerDoenca());
        btnListar.addActionListener(e -> listarDoencas());
    }

    private void abrirFormularioDoenca(Doenca doenca) {
        FormularioDoenca formulario = new FormularioDoenca(this, this, doenca);
        formulario.setVisible(true);
    }

    public void adicionarDoenca(Doenca doenca) {
        doencas.add(doenca);
    }

    private void editarDoenca() {
        String idStr = JOptionPane.showInputDialog(this, "ID da doença para editar:");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                Doenca d = buscarDoencaPorId(id);
                if (d != null) {
                    abrirFormularioDoenca(d);
                } else {
                    JOptionPane.showMessageDialog(this, "Doença não encontrada!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido!");
            }
        }
    }

    private void removerDoenca() {
        String idStr = JOptionPane.showInputDialog(this, "ID da doença para remover:");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                Doenca d = buscarDoencaPorId(id);
                if (d != null) {
                    int confirm = JOptionPane.showConfirmDialog(this,
                            "Confirma remoção da doença: " + d.getNome() + "?",
                            "Confirmar Remoção", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        doencas.remove(d);
                        JOptionPane.showMessageDialog(this, "Doença removida com sucesso.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Doença não encontrada!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido!");
            }
        }
    }

    private void listarDoencas() {
        StringBuilder sb = new StringBuilder();
        if (doencas.isEmpty()) {
            sb.append("Nenhuma doença cadastrada.");
        } else {
            for (Doenca d : doencas) {
                sb.append("ID: ").append(d.getId()).append(" - Nome: ").append(d.getNome()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Lista de Doenças", JOptionPane.INFORMATION_MESSAGE);
    }

    private Doenca buscarDoencaPorId(int id) {
        for (Doenca d : doencas) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }
}