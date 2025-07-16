import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

// Importa a classe Doenca do pacote model
import model.Doenca;

public class ListagemDoencas extends JDialog {

    public ListagemDoencas(JFrame parent, ArrayList<Doenca> doencas) {
        super(parent, "Lista de Doenças", true);
        setSize(700, 400);
        setLocationRelativeTo(parent);

        String[] colunas = {"Nome", "Descrição"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        for (Doenca d : doencas) {
            Object[] linha = {
                    d.getNome(),
                    d.getDescricao()
            };
            model.addRow(linha);
        }

        JTable tabela = new JTable(model);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose());
        JPanel panelSul = new JPanel();
        panelSul.add(btnFechar);
        add(panelSul, BorderLayout.SOUTH);
    }
}