import gestor.GestorUtentes;
import gestor.GestorMedicos;
import gestor.GestorConsultas;
import gestor.GestorMedicamentos;
import gestor.GestorDoencas;
import gestor.GestorAnalises;
import gestor.GestorExames;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    public MenuPrincipal() {
        setTitle("Gestor Médico");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(0, 1, 10, 10));

        String[] opcoes = {
                "1. Gestão de Utentes",
                "2. Gestão de Médicos",
                "3. Gestão de Medicamentos",
                "4. Gestão de Consultas",
                "5. Gestão de Doenças",
                "6. Gestão de Análises",
                "7. Gestão de Exames",
                "8. Associar Doença ao Utente",
                "9. Associar Medicamento ao Utente",
                "10. Ver Histórico Médico do Utente",
                "11. Guardar Dados (JSON)",
                "12. Carregar Dados (JSON)",
                "13. Sair"
        };

        for (String opcao : opcoes) {
            JButton botao = new JButton(opcao);
            painel.add(botao);

            botao.addActionListener(e -> {
                switch (opcao) {
                    case "1. Gestão de Utentes":
                        JOptionPane.showMessageDialog(this, "Gestão de Utentes não implementada ainda.");
                        break;
                    case "2. Gestão de Médicos":
                        JOptionPane.showMessageDialog(this, "Gestão de Médicos não implementada ainda.");
                        break;
                    case "3. Gestão de Medicamentos":
                        JOptionPane.showMessageDialog(this, "Gestão de Medicamentos não implementada ainda.");
                        break;
                    case "4. Gestão de Consultas":
                        JOptionPane.showMessageDialog(this, "Gestão de Consultas não implementada ainda.");
                        break;
                    case "5. Gestão de Doenças":
                        JOptionPane.showMessageDialog(this, "Gestão de Doenças não implementada ainda.");
                        break;
                    case "6. Gestão de Análises":
                        JOptionPane.showMessageDialog(this, "Gestão de Análises não implementada ainda.");
                        break;
                    case "7. Gestão de Exames":
                        JOptionPane.showMessageDialog(this, "Gestão de Exames não implementada ainda.");
                        break;
                    case "8. Associar Doença ao Utente":
                        JOptionPane.showMessageDialog(this, "Associação de Doenças não implementada ainda.");
                        break;
                    case "9. Associar Medicamento ao Utente":
                        JOptionPane.showMessageDialog(this, "Associação de Medicamentos não implementada ainda.");
                        break;
                    case "10. Ver Histórico Médico do Utente":
                        JOptionPane.showMessageDialog(this, "Histórico não implementado ainda.");
                        break;
                    case "11. Guardar Dados (JSON)":
                        JOptionPane.showMessageDialog(this, "Funcionalidade de gravação ainda não implementada.");
                        break;
                    case "12. Carregar Dados (JSON)":
                        JOptionPane.showMessageDialog(this, "Funcionalidade de leitura ainda não implementada.");
                        break;
                    case "13. Sair":
                        System.exit(0);
                        break;
                }
            });
        }

        add(new JScrollPane(painel));
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuPrincipal::new);
    }
}