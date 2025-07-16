import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GestorEnfermeiros extends JFrame {

    private ArrayList<Enfermeiro> enfermeiros = new ArrayList<>();

    public GestorEnfermeiros() {
        super("Gestão de Enfermeiros");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 1, 10, 10));

        JButton btnAdicionar = new JButton("➕ Adicionar Enfermeiro");
        JButton btnEditar = new JButton("✏️ Editar Enfermeiro");
        JButton btnRemover = new JButton("❌ Remover Enfermeiro");
        JButton btnListar = new JButton("📋 Listar Enfermeiros");
        JButton btnPesquisar = new JButton("🔍 Pesquisar Enfermeiro");
        JButton btnVoltar = new JButton("Voltar");

        add(btnAdicionar);
        add(btnEditar);
        add(btnRemover);
        add(btnListar);
        add(btnPesquisar);
        add(btnVoltar);

        btnAdicionar.addActionListener(e -> new FormularioEnfermeiro(this, null).setVisible(true));
        btnEditar.addActionListener(e -> editarEnfermeiro());
        btnRemover.addActionListener(e -> removerEnfermeiro());
        btnListar.addActionListener(e -> new ListagemEnfermeiros(this, enfermeiros).setVisible(true));
        btnPesquisar.addActionListener(e -> pesquisarEnfermeiro());
        btnVoltar.addActionListener(e -> dispose());
    }

    private void editarEnfermeiro() {
        String idStr = JOptionPane.showInputDialog(this, "ID do enfermeiro a editar:");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                Enfermeiro enf = buscarPorId(id);
                if (enf != null) {
                    new FormularioEnfermeiro(this, enf).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Enfermeiro não encontrado.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        }
    }

    private void removerEnfermeiro() {
        String idStr = JOptionPane.showInputDialog(this, "ID do enfermeiro a remover:");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                Enfermeiro enf = buscarPorId(id);
                if (enf != null) {
                    int confirm = JOptionPane.showConfirmDialog(this, "Confirmar remoção?", "Remover", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        enfermeiros.remove(enf);
                        JOptionPane.showMessageDialog(this, "Removido com sucesso.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Enfermeiro não encontrado.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        }
    }

    private void pesquisarEnfermeiro() {
        String termo = JOptionPane.showInputDialog(this, "Pesquisar por nome ou especialidade:");
        if (termo != null && !termo.trim().isEmpty()) {
            ArrayList<Enfermeiro> resultados = new ArrayList<>();
            for (Enfermeiro e : enfermeiros) {
                if (e.getNome().toLowerCase().contains(termo.toLowerCase()) ||
                        e.getEspecialidade().toLowerCase().contains(termo.toLowerCase())) {
                    resultados.add(e);
                }
            }
            new ListagemEnfermeiros(this, resultados).setVisible(true);
        }
    }

    private Enfermeiro buscarPorId(int id) {
        for (Enfermeiro e : enfermeiros) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    public void adicionarEnfermeiro(Enfermeiro e) {
        enfermeiros.add(e);
    }
}