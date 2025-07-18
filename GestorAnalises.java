package gestor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import model.Analise;

import gestor.FormularioExame;

public class GestorAnalises extends JFrame {

    private ArrayList<Analise> analises = new ArrayList<>();

    public GestorAnalises() {
        super("Gestão de Análises");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnAdicionar = new JButton("➕ Adicionar Análise");
        JButton btnListar = new JButton("📋 Listar Análises");
        JButton btnVoltar = new JButton("Voltar");

        add(btnAdicionar);
        add(btnListar);
        add(btnVoltar);

        btnAdicionar.addActionListener(e -> abrirFormularioAdicionar());
        btnListar.addActionListener(e -> listarAnalises());
        btnVoltar.addActionListener(e -> dispose());
    }

    private void abrirFormularioAdicionar() {
        FormularioExame formulario = new FormularioExame(this, null);
        formulario.setVisible(true);
    }

    private void listarAnalises() {
        StringBuilder sb = new StringBuilder();
        if (analises.isEmpty()) {
            sb.append("Nenhuma análise registada.");
        } else {
            for (Analise a : analises) {
                sb.append(a.toString()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Lista de Análises", JOptionPane.INFORMATION_MESSAGE);
    }

    public void adicionarAnalise(Analise analise) {
        analises.add(analise);
    }
}
