package gestor;

import javax.swing.*;
import java.awt.*;
import model.Analise;

public class FormularioExame extends JDialog {

    private JTextField tfIdUtente, tfTipo, tfResultado;
    private GestorAnalises parent;
    private Analise exameEditar;

    public FormularioExame(GestorAnalises parent, Analise exame) {
        super(parent, "Formulário de Exame", true);
        this.parent = parent;
        this.exameEditar = exame;

        setSize(450, 250);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel painel = new JPanel(new GridLayout(3, 2, 10, 10));
        tfIdUtente = new JTextField();
        tfTipo = new JTextField();
        tfResultado = new JTextField();

        painel.add(new JLabel("ID do Utente:"));
        painel.add(tfIdUtente);
        painel.add(new JLabel("Tipo de Exame:"));
        painel.add(tfTipo);
        painel.add(new JLabel("Resultado:"));
        painel.add(tfResultado);

        add(painel, BorderLayout.CENTER);

        JPanel botoes = new JPanel();
        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");
        botoes.add(btnSalvar);
        botoes.add(btnCancelar);
        add(botoes, BorderLayout.SOUTH);

        if (exameEditar != null) carregarDados();

        btnSalvar.addActionListener(e -> salvar());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void carregarDados() {
        tfIdUtente.setText(String.valueOf(exameEditar.getIdUtente()));
        tfTipo.setText(exameEditar.getTipo());
        tfResultado.setText(exameEditar.getResultado());
    }

    private void salvar() {
        try {
            int idUtente = Integer.parseInt(tfIdUtente.getText().trim());
            String tipo = tfTipo.getText().trim();
            String resultado = tfResultado.getText().trim();

            if (tipo.isEmpty() || resultado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.");
                return;
            }

            if (exameEditar == null) {
                Analise novo = new Analise(idUtente, tipo, resultado);
                parent.adicionarAnalise(novo);
                JOptionPane.showMessageDialog(this, "Exame adicionado com sucesso.");
            } else {
                exameEditar.setTipo(tipo);
                exameEditar.setResultado(resultado);
                JOptionPane.showMessageDialog(this, "Exame atualizado com sucesso.");
            }

            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID do utente inválido.");
        }
    }
}