package gestor;

import model.Departamento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListagemDepartamentos extends JDialog {

    public ListagemDepartamentos(JFrame parent, ArrayList<Departamento> departamentos) {
        super(parent, "Lista de Departamentos", true);
        setSize(600, 300);
        setLocationRelativeTo(parent);

        String[] colunas = {"ID", "Nome", "Especialidade"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (Departamento d : departamentos) {
            Object[] linha = {
                    d.getId(),
                    d.getNome(),
                    d.getEspecialidade()
            };
            modelo.addRow(linha);
        }

        JTable tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose());
        JPanel painelSul = new JPanel();
        painelSul.add(btnFechar);
        add(painelSul, BorderLayout.SOUTH);
    }
}
