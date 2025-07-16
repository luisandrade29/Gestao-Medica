package ui;

import modelo.Medicamento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListagemMedicamentos extends JFrame {
    private JTable tabelaMedicamentos;

    public ListagemMedicamentos(List<Medicamento> listaMedicamentos) {
        setTitle("Lista de Medicamentos");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] colunas = {"Nome", "Dosagem", "Laboratório"};
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);

        for (Medicamento m : listaMedicamentos) {
            Object[] linha = {
                    m.getNome(),
                    m.getDosagem(),
                    m.getLaboratorio()
            };
            modeloTabela.addRow(linha);
        }

        tabelaMedicamentos = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaMedicamentos);

        add(scrollPane, BorderLayout.CENTER);
    }
}