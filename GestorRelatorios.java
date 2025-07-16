package gestor;

import javax.swing.*;
import java.awt.*;

public class GestorRelatorios extends JFrame {

    public GestorRelatorios() {
        super("Relatórios e Estatísticas");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnRelatorioUtentes = new JButton("📈 Relatório de Utentes");
        JButton btnRelatorioConsultas = new JButton("📊 Relatório de Consultas");
        JButton btnEstatisticas = new JButton("📉 Estatísticas Gerais");
        JButton btnVoltar = new JButton("Voltar");

        add(btnRelatorioUtentes);
        add(btnRelatorioConsultas);
        add(btnEstatisticas);
        add(btnVoltar);

        btnRelatorioUtentes.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Relatório de utentes ainda não implementado."));
        btnRelatorioConsultas.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Relatório de consultas ainda não implementado."));
        btnEstatisticas.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Estatísticas ainda não implementadas."));
        btnVoltar.addActionListener(e -> dispose());
    }
}