package gestor;

import model.Fatura;
import javax.swing.*;
import java.util.ArrayList;

public class GestorFaturacao extends JFrame {

    private ArrayList<Fatura> faturas = new ArrayList<>();

    public GestorFaturacao() {
        super("Gestão de Faturação");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Exemplo simples: só um botão para listar faturas
        JButton btnListar = new JButton("Listar Faturas");
        btnListar.addActionListener(e -> listarFaturas());

        add(btnListar);
    }

    public void adicionarFatura(Fatura f) {
        faturas.add(f);
    }

    private void listarFaturas() {
        if (faturas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhuma fatura cadastrada.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Fatura f : faturas) {
                sb.append(f.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        }
    }
}