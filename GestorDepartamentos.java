package gestor;

import model.Departamento;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GestorDepartamentos extends JFrame {

    private ArrayList<Departamento> departamentos = new ArrayList<>();

    public GestorDepartamentos() {
        super("Gestão de Departamentos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnAdicionar = new JButton("➕ Adicionar Departamento");
        JButton btnListar = new JButton("📋 Listar Departamentos");
        JButton btnRemover = new JButton("❌ Remover Departamento");
        JButton btnVoltar = new JButton("Voltar");

        add(btnAdicionar);
        add(btnListar);
        add(btnRemover);
        add(btnVoltar);

        btnAdicionar.addActionListener(e -> {
            FormularioDepartamento form = new FormularioDepartamento(this, null);
            form.setVisible(true);
        });

        btnListar.addActionListener(e -> {
            ListagemDepartamentos listagem = new ListagemDepartamentos(this, departamentos);
            listagem.setVisible(true);
        });

        btnRemover.addActionListener(e -> {
            String idStr = JOptionPane.showInputDialog(this, "ID do Departamento a remover:");
            try {
                int id = Integer.parseInt(idStr);
                Departamento d = buscarPorId(id);
                if (d != null) {
                    departamentos.remove(d);
                    JOptionPane.showMessageDialog(this, "Removido com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(this, "Departamento não encontrado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        });

        btnVoltar.addActionListener(e -> dispose());
    }

    public void adicionarDepartamento(Departamento d) {
        departamentos.add(d);
    }

    public Departamento buscarPorId(int id) {
        for (Departamento d : departamentos) {
            if (d.getId() == id) return d;
        }
        return null;
    }
}