package gestor;

import model.EquipamentoMedico;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListagemEquipamentosMedicos extends JDialog {

    public ListagemEquipamentosMedicos(JFrame parent, ArrayList<EquipamentoMedico> equipamentos) {
        super(parent, "Lista de Equipamentos Médicos", true);
        setSize(900, 400);
        setLocationRelativeTo(parent);

        String[] colunas = {"Código", "Nome", "Descrição"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        for (EquipamentoMedico eq : equipamentos) {
            Object[] linha = {
                    eq.getCodigo(),
                    eq.getNome(),
                    eq.getDescricao()
            };
            model.addRow(linha);
        }

        JTable tabela = new JTable(model);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose());
        JPanel panelSul = new JPanel();
        panelSul.add(btnFechar);
        add(panelSul, BorderLayout.SOUTH);
    }
}