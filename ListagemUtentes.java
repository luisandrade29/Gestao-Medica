package gestor;  // Ajusta conforme a tua estrutura de pacotes

import model.Utente;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListagemUtentes extends JDialog {

    public ListagemUtentes(JFrame parent, ArrayList<Utente> utentes) {
        super(parent, "Lista de Utentes", true);
        setSize(900, 400);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        // Colunas da tabela
        String[] colunas = {"ID", "Nome", "Data Nasc.", "Gênero", "Nº Utente", "Altura", "Peso",
                "Grupo Sanguíneo", "Telefone", "Email", "Morada", "Observações"};

        // Modelo da tabela
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        // Preencher linhas com dados dos utentes
        for (Utente u : utentes) {
            Object[] linha = {
                    u.getId(),
                    u.getNome(),
                    u.getDataNascimento(),
                    u.getGenero(),
                    u.getNumeroUtente(),
                    u.getAltura(),
                    u.getPeso(),
                    u.getGrupoSanguineo(),
                    u.getTelefone(),
                    u.getEmail(),
                    u.getMorada(),
                    u.getObservacoes()
            };
            model.addRow(linha);
        }

        JTable tabela = new JTable(model);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);

        // Botão Fechar
        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose());

        JPanel panelSul = new JPanel();
        panelSul.add(btnFechar);
        add(panelSul, BorderLayout.SOUTH);
    }
}