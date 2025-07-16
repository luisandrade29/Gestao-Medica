import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListagemEnfermeiros extends JDialog {

    public ListagemEnfermeiros(JFrame parent, ArrayList<Enfermeiro> enfermeiros) {
        super(parent, "Lista de Enfermeiros", true);
        setSize(950, 400);
        setLocationRelativeTo(parent);

        String[] colunas = {
                "ID", "Nome", "Gênero", "Idade", "Especialidade", "Turno", "Contacto", "Observações"
        };

        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Enfermeiro e : enfermeiros) {
            Object[] linha = {
                    e.getId(), e.getNome(), e.getGenero(), e.getIdade(),
                    e.getEspecialidade(), e.getTurno(), e.getContacto(), e.getObservacoes()
            };
            model.addRow(linha);
        }

        JTable tabela = new JTable(model);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scroll = new JScrollPane(tabela);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose());

        JPanel panelSul = new JPanel();
        panelSul.add(btnFechar);

        add(scroll, BorderLayout.CENTER);
        add(panelSul, BorderLayout.SOUTH);
    }
}