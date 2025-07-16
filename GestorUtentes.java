package gestor;

import model.Utente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GestorUtentes extends JFrame {

    private ArrayList<Utente> utentes = new ArrayList<>();

    public GestorUtentes() {
        super("Gestão de Utentes");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 1, 10, 10));

        JButton btnAdicionar = new JButton("➕ Adicionar Utente");
        JButton btnEditar = new JButton("✏️ Editar Utente");
        JButton btnRemover = new JButton("❌ Remover Utente");
        JButton btnListar = new JButton("📋 Listar Todos os Utentes");
        JButton btnPesquisar = new JButton("🔍 Pesquisar Utente");
        JButton btnVoltar = new JButton("Voltar");

        add(btnAdicionar);
        add(btnEditar);
        add(btnRemover);
        add(btnListar);
        add(btnPesquisar);
        add(btnVoltar);

        btnAdicionar.addActionListener(e -> abrirFormularioAdicionar());
        btnEditar.addActionListener(e -> abrirEditarUtente());
        btnRemover.addActionListener(e -> abrirRemoverUtente());
        btnListar.addActionListener(e -> abrirListarUtentes());
        btnPesquisar.addActionListener(e -> abrirPesquisarUtente());
        btnVoltar.addActionListener(e -> dispose());
    }

    private void abrirFormularioAdicionar() {
        FormularioUtente formulario = new FormularioUtente(this, null);
        formulario.setVisible(true);
    }

    private void abrirEditarUtente() {
        String idStr = JOptionPane.showInputDialog(this, "Insira o ID do Utente para editar:");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                Utente u = buscarUtentePorId(id);
                if (u != null) {
                    FormularioUtente formulario = new FormularioUtente(this, u);
                    formulario.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Utente não encontrado!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido!");
            }
        }
    }

    private void abrirRemoverUtente() {
        String idStr = JOptionPane.showInputDialog(this, "Insira o ID do Utente para remover:");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                Utente u = buscarUtentePorId(id);
                if (u != null) {
                    int confirm = JOptionPane.showConfirmDialog(this,
                            "Confirma remoção do utente: " + u.getNome() + "?",
                            "Confirmar Remoção", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        utentes.remove(u);
                        JOptionPane.showMessageDialog(this, "Utente removido com sucesso.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Utente não encontrado!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido!");
            }
        }
    }

    private void abrirListarUtentes() {
        ListagemUtentes listagem = new ListagemUtentes(this, utentes);
        listagem.setVisible(true);
    }

    private void abrirPesquisarUtente() {
        String busca = JOptionPane.showInputDialog(this, "Pesquisar por Nome ou Nº Utente:");
        if (busca != null && !busca.trim().isEmpty()) {
            ArrayList<Utente> resultados = new ArrayList<>();
            for (Utente u : utentes) {
                if (u.getNome().toLowerCase().contains(busca.toLowerCase())
                        || u.getNumeroUtente().toLowerCase().contains(busca.toLowerCase())) {
                    resultados.add(u);
                }
            }
            if (resultados.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum utente encontrado.");
            } else {
                ListagemUtentes listagem = new ListagemUtentes(this, resultados);
                listagem.setVisible(true);
            }
        }
    }

    public void adicionarUtente(Utente u) {
        utentes.add(u);
    }

    private Utente buscarUtentePorId(int id) {
        for (Utente u : utentes) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }
}