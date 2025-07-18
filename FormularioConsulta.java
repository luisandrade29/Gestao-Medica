package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Medico;
import modelo.Consulta;

public class FormularioConsulta extends JFrame {
    private JTextField campoDescricao;
    private JTextField campoData;
    private JComboBox<Medico> comboMedicos;
    private JButton botaoSalvar;
    private JButton botaoCancelar;

    public FormularioConsulta() {
        this(new ArrayList<>()); 
    }

    public FormularioConsulta(List<Medico> listaMedicos) {
        setTitle("Formulário de Consulta");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel(new GridLayout(4, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        painel.add(new JLabel("Médico:"));
        comboMedicos = new JComboBox<>();
        for (Medico m : listaMedicos) {
            comboMedicos.addItem(m);
        }
        painel.add(comboMedicos);

        painel.add(new JLabel("Data (dd/MM/yyyy):"));
        campoData = new JTextField(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        painel.add(campoData);

        painel.add(new JLabel("Descrição:"));
        campoDescricao = new JTextField();
        painel.add(campoDescricao);

        botaoSalvar = new JButton("Salvar");
        botaoCancelar = new JButton("Cancelar");

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoCancelar);

        add(painel, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        botaoSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Medico medicoSelecionado = (Medico) comboMedicos.getSelectedItem();
                String dataTexto = campoData.getText();
                String descricao = campoDescricao.getText();

                try {
                    Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
                    Consulta consulta = new Consulta(medicoSelecionado, data, descricao);
                    JOptionPane.showMessageDialog(FormularioConsulta.this, "Consulta salva com sucesso!");
                    dispose();
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(FormularioConsulta.this, "Data inválida. Use o formato dd/MM/yyyy.");
                }
            }
        });

        botaoCancelar.addActionListener(e -> dispose());
    }
}
