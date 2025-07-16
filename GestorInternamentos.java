package gestor;

import model.Internamento;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GestorInternamentos extends JFrame {

    private ArrayList<Internamento> internamentos = new ArrayList<>();

    public GestorInternamentos() {
        super("Gestão de Internamentos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnAdicionar = new JButton("➕ Adicionar Internamento");
        JButton btnListar = new JButton("📋 Listar Internamentos");
        JButton btnRemover = new JButton("❌ Remover Internamento");
        JButton btnVoltar = new JButton("Voltar");

        add(btnAdicionar);
        add(btnListar);
        add(btnRemover);
        add(btnVoltar);

        btnAdicionar.addActionListener(e -> {
            FormularioInternamento form = new FormularioInternamento(this, null);
            form.setVisible(true);
        });

        btnListar.addActionListener(e -> {
            ListagemInternamentos listagem = new ListagemInternamentos(this, internamentos);
            listagem.setVisible(true);
        });

        btnRemover.addActionListener(e -> {
            String idStr = JOptionPane.showInputDialog(this, "ID do Internamento a remover:");
            try {
                int id = Integer.parseInt(idStr);
                Internamento i = buscarPorId(id);
                if (i != null) {
                    internamentos.remove(i);
                    JOptionPane.showMessageDialog(this, "Removido com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(this, "Internamento não encontrado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        });

        btnVoltar.addActionListener(e -> dispose());
    }

    public void adicionarInternamento(Internamento i) {
        internamentos.add(i);
    }

    public Internamento buscarPorId(int id) {
        for (Internamento i : internamentos) {
            if (i.getId() == id) return i;
        }
        return null;
    }
}
