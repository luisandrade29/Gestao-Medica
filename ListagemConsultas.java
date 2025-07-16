package ui;

import modelo.Consulta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListagemConsultas extends JFrame {
    private JTable tabelaConsultas;

    public ListagemConsultas(List<Consulta> listaConsultas) {
        setTitle("Lista de Consultas");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] colunas = {"Médico", "Data", "Descrição"};
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);

        for (Consulta c : listaConsultas) {
            Object[] linha = {
                    c.getMedico().getNome(),
                    c.getData(),
                    c.getDescricao()
            };
            modeloTabela.addRow(linha);
        }

        tabelaConsultas = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaConsultas);

        add(scrollPane, BorderLayout.CENTER);
    }
}