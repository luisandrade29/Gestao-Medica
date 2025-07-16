package gestor;

import model.Exame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GestorExames extends JFrame {

    private ArrayList<Exame> exames = new ArrayList<>();

    public GestorExames() {
        super("Gestão de Exames");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));

        JButton btnAdicionar = new JButton("➕ Adicionar Exame");
        JButton btnEditar = new JButton("✏️ Editar Exame");
        JButton btnRemover = new JButton("❌ Remover Exame");
        JButton btnListar = new JButton("📋 Listar Exames");
        JButton btnVoltar = new JButton("Voltar");

        add(btnAdicionar);
        add(btnEditar);
        add(btnRemover);
        add(btnListar);
        add(btnVoltar);

        btnAdicionar.addActionListener(e -> abrirFormularioAdicionar());
        btnEditar.addActionListener(e -> abrirEditarExame());
        btnRemover.addActionListener(e -> abrirRemoverExame());
        btnListar.addActionListener(e -> abrirListarExames());
        btnVoltar.addActionListener(e -> dispose());
    }

    private void abrirFormularioAdicionar() {
        JOptionPane.showMessageDialog(this, "Abrir formulário para adicionar exame.");
    }

    private void abrirEditarExame() {
        JOptionPane.showMessageDialog(this, "Abrir formulário para editar exame.");
    }

    private void abrirRemoverExame() {
        JOptionPane.showMessageDialog(this, "Abrir formulário para remover exame.");
    }

    private void abrirListarExames() {
        if (exames.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum exame registrado.");
        } else {
            StringBuilder sb = new StringBuilder("Exames:\n");
            for (Exame e : exames) {
                sb.append(e.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        }
    }

    public void adicionarExame(Exame exame) {
        exames.add(exame);
    }
}