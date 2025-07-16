package gestor;

import model.Internamento;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListagemInternamentos extends JDialog {

    public ListagemInternamentos(JFrame parent, ArrayList<Internamento> internamentos) {
        super(parent, "Lista de Internamentos", true);
        setSize(500, 300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        String[] colunas = {"ID", "Paciente", "Data Entrada", "Data Saída"};
        String[][] dados = new String[internamentos.size()][4];

        for (int i = 0; i < internamentos.size(); i++) {
            Internamento iObj = internamentos.get(i);
            dados[i][0] = String.valueOf(iObj.getId());
            dados[i][1] = iObj.getPaciente();
            dados[i][2] = iObj.getDataEntrada();
            dados[i][3] = iObj.getDataSaida();
        }

        JTable tabela = new JTable(dados, colunas);
        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose());
        JPanel rodape = new JPanel();
        rodape.add(btnFechar);
        add(rodape, BorderLayout.SOUTH);
    }
}
