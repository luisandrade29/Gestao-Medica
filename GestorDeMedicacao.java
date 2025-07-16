package gestor;

import modelo.Medicamento;
import ui.FormularioMedicamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GestorDeMedicacao extends JFrame {
    private List<Medicamento> listaMedicamentos;
    private JButton botaoAdicionar;
    private JButton botaoListar;

    public GestorDeMedicacao() {
        setTitle("Gestão de Medicação");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        listaMedicamentos = new ArrayList<>();

        JPanel painel = new JPanel();
        botaoAdicionar = new JButton("Adicionar Medicamento");
        botaoListar = new JButton("Listar Medicamentos");

        painel.add(botaoAdicionar);
        painel.add(botaoListar);
        add(painel);

        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormularioMedicamento formulario = new FormularioMedicamento();
                formulario.setVisible(true);
            }
        });

        botaoListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listaMedicamentos.isEmpty()) {
                    JOptionPane.showMessageDialog(GestorDeMedicacao.this, "Nenhum medicamento registado.");
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (Medicamento m : listaMedicamentos) {
                        sb.append(m.getNome()).append(" - ").append(m.getDosagem()).append("\n");
                    }
                    JOptionPane.showMessageDialog(GestorDeMedicacao.this, sb.toString(), "Lista de Medicamentos", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}