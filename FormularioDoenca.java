package gestor;

import model.Doenca;
import javax.swing.*;
import java.awt.*;

public class FormularioDoenca extends JDialog {

    private JTextField tfNome, tfDescricao;
    private GestorDoencas gestorDoencas;
    private Doenca doencaEditar;

    
    public FormularioDoenca(Frame parentFrame, GestorDoencas gestorDoencas, Doenca doenca) {
        super(parentFrame, "Formulário de Doença", true);
        this.gestorDoencas = gestorDoencas;
        this.doencaEditar = doenca;

        setSize(400, 200);
        setLocationRelativeTo(parentFrame);
        setLayout(new BorderLayout());

        JPanel painel = new JPanel(new GridLayout(2, 2, 10, 10));

        tfNome = new JTextField();
        tfDescricao = new JTextField();

        painel.add(new JLabel("Nome:"));
        painel.add(tfNome);
        painel.add(new JLabel("Descrição:"));
        painel.add(tfDescricao);

        add(painel, BorderLayout.CENTER);

        JPanel botoes = new JPanel();
        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");
        botoes.add(btnSalvar);
        botoes.add(btnCancelar);
        add(botoes, BorderLayout.SOUTH);

        if (doencaEditar != null) carregarDados();

        btnSalvar.addActionListener(e -> salvar());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void carregarDados() {
        tfNome.setText(doencaEditar.getNome());
        tfDescricao.setText(doencaEditar.getDescricao());
    }

    private void salvar() {
        String nome = tfNome.getText().trim();
        String descricao = tfDescricao.getText().trim();

        if (nome.isEmpty() || descricao.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.");
            return;
        }

        if (doencaEditar == null) {
            Doenca novaDoenca = new Doenca(nome, descricao);
            gestorDoencas.adicionarDoenca(novaDoenca);
            JOptionPane.showMessageDialog(this, "Doença adicionada com sucesso.");
        } else {
            doencaEditar.setNome(nome);
            doencaEditar.setDescricao(descricao);
            JOptionPane.showMessageDialog(this, "Doença atualizada com sucesso.");
        }
        dispose();
    }
}
