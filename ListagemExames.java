package gestor; // se estiveres a usar pacote gestor, senão tira esta linha

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import model.Exame;

public class ListagemExames extends JDialog {

    public ListagemExames(JFrame parent, ArrayList<Exame> exames) {
        super(parent, "Lista de Exames", true);
        setSize(700, 300);
        setLocationRelativeTo(parent);

        String[] colunas = {"ID", "ID Utente", "Tipo", "Resultado"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Exame e : exames) {
            Object[] linha = {
                    e.getId(),
                    e.getIdUtente(),
                    e.getTipo(),
                    e.getResultado()
            };
            model.addRow(linha);
        }

        JTable tabela = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose());

        JPanel panelSul = new JPanel();
        panelSul.add(btnFechar);
        add(panelSul, BorderLayout.SOUTH);
    }
}