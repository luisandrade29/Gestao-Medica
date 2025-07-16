import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import model.Fatura;

public class ListagemFaturas extends JDialog {

    public ListagemFaturas(JFrame parent, ArrayList<Fatura> faturas) {
        super(parent, "Lista de Faturas", true);
        setSize(800, 400);
        setLocationRelativeTo(parent);

        String[] colunas = {"ID", "Descrição", "Valor"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        for (Fatura f : faturas) {
            Object[] linha = {
                    f.getId(),
                    f.getDescricao(),
                    f.getValor()
            };
            model.addRow(linha);
        }

        JTable tabela = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose());
        JPanel painelSul = new JPanel();
        painelSul.add(btnFechar);
        add(painelSul, BorderLayout.SOUTH);
    }
}