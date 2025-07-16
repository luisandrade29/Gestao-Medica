package gestor;

import javax.swing.*;
import java.awt.*;

public class GestorFinanceiro extends JFrame {

    public GestorFinanceiro() {
        super("Gestão Financeira / Faturação");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnEmitirFatura = new JButton("🧾 Emitir Fatura");
        JButton btnListar = new JButton("📋 Listar Faturas");
        JButton btnRelatorio = new JButton("📊 Relatório Financeiro");
        JButton btnVoltar = new JButton("Voltar");

        add(btnEmitirFatura);
        add(btnListar);
        add(btnRelatorio);
        add(btnVoltar);

        btnEmitirFatura.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Funcionalidade de emitir fatura ainda não implementada."));
        btnListar.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Funcionalidade de listar ainda não implementada."));
        btnRelatorio.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Funcionalidade de relatório ainda não implementada."));
        btnVoltar.addActionListener(e -> dispose());
    }
}