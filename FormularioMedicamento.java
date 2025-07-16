package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioMedicamento extends JFrame {
    private JTextField campoNome;
    private JTextField campoDosagem;
    private JTextField campoLaboratorio;
    private JButton botaoSalvar;
    private JButton botaoCancelar;

    public FormularioMedicamento() {
        setTitle("Formulário de Medicamento");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel(new GridLayout(4, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        painel.add(new JLabel("Nome:"));
        campoNome = new JTextField();
        painel.add(campoNome);

        painel.add(new JLabel("Dosagem:"));
        campoDosagem = new JTextField();
        painel.add(campoDosagem);

        painel.add(new JLabel("Laboratório:"));
        campoLaboratorio = new JTextField();
        painel.add(campoLaboratorio);

        botaoSalvar = new JButton("Salvar");
        botaoCancelar = new JButton("Cancelar");

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoCancelar);

        add(painel, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        botaoSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                String dosagem = campoDosagem.getText();
                String laboratorio = campoLaboratorio.getText();

                System.out.println("Medicamento salvo: " + nome + ", " + dosagem + ", " + laboratorio);
                JOptionPane.showMessageDialog(FormularioMedicamento.this, "Medicamento salvo com sucesso!");
                dispose();
            }
        });

        botaoCancelar.addActionListener(e -> dispose());
    }
}