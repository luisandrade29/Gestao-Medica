package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioMedico extends JFrame {
    private JTextField campoNome;
    private JTextField campoEspecialidade;
    private JTextField campoCrm;
    private JButton botaoSalvar;
    private JButton botaoCancelar;

    public FormularioMedico() {
        setTitle("Formulário de Médico");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel(new GridLayout(4, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        painel.add(new JLabel("Nome:"));
        campoNome = new JTextField();
        painel.add(campoNome);

        painel.add(new JLabel("Especialidade:"));
        campoEspecialidade = new JTextField();
        painel.add(campoEspecialidade);

        painel.add(new JLabel("CRM (ou Nº de inscrição):"));
        campoCrm = new JTextField();
        painel.add(campoCrm);

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
                String especialidade = campoEspecialidade.getText();
                String crm = campoCrm.getText();

                // Aqui podes guardar ou processar os dados
                System.out.println("Médico salvo: " + nome + ", " + especialidade + ", " + crm);
                JOptionPane.showMessageDialog(FormularioMedico.this, "Médico salvo com sucesso!");
                dispose();
            }
        });

        botaoCancelar.addActionListener(e -> dispose());
    }
}