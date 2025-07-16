package gestor;

import modelo.Medico;
import ui.FormularioMedico;
import ui.ListagemMedicos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GestorMedicos extends JFrame {
    private List<Medico> listaMedicos;
    private JButton botaoAdicionar;
    private JButton botaoListar;

    public GestorMedicos() {
        setTitle("Gestão de Médicos");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        listaMedicos = new ArrayList<>();

        JPanel painel = new JPanel();
        botaoAdicionar = new JButton("Adicionar Médico");
        botaoListar = new JButton("Listar Médicos");

        painel.add(botaoAdicionar);
        painel.add(botaoListar);
        add(painel);

        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormularioMedico formulario = new FormularioMedico();
                formulario.setVisible(true);
            }
        });

        botaoListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listaMedicos.isEmpty()) {
                    JOptionPane.showMessageDialog(GestorMedicos.this, "Nenhum médico registado.");
                } else {
                    ListagemMedicos listagem = new ListagemMedicos(listaMedicos);
                    listagem.setVisible(true);
                }
            }
        });
    }

    public void adicionarMedico(Medico medico) {
        listaMedicos.add(medico);
    }

    public List<Medico> getListaMedicos() {
        return listaMedicos;
    }
}

