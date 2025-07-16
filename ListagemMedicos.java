package ui;

import modelo.Medico;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListagemMedicos extends JFrame {
    private JTable tabelaMedicos;

    public ListagemMedicos(List<Medico> listaMedicos) {
        setTitle("Lista de Médicos");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] colunas = {"Nome", "Especialidade", "CRM"};
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);

        for (Medico m : listaMedicos) {
            Object[] linha = {
                    m.getNome(),
                    m.getEspecialidade(),
                    m.getCrm()
            };
            modeloTabela.addRow(linha);
        }

        tabelaMedicos = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaMedicos);

        add(scrollPane, BorderLayout.CENTER);
    }
}