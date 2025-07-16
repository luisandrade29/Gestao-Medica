package gestor;

import modelo.Medicamento;
import ui.FormularioMedicamento;
import ui.ListagemMedicamentos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GestorMedicamentos extends JFrame {
    private List<Medicamento> listaMedicamentos;
    private JButton botaoAdicionar;
    private JButton botaoListar;

    public GestorMedicamentos() {
        setTitle("Gestão de Medicamentos");
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
                    JOptionPane.showMessageDialog(GestorMedicamentos.this, "Nenhum medicamento registado.");
                } else {
                    ListagemMedicamentos listagem = new ListagemMedicamentos(listaMedicamentos);
                    listagem.setVisible(true);
                }
            }
        });
    }

    // Método opcional para adicionar medicamento externamente
    public void adicionarMedicamento(Medicamento medicamento) {
        listaMedicamentos.add(medicamento);
    }

    public List<Medicamento> getListaMedicamentos() {
        return listaMedicamentos;
    }
}