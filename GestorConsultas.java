package gestor;

import modelo.Consulta;
import ui.FormularioConsulta;
import ui.ListagemConsultas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GestorConsultas extends JFrame {
    private List<Consulta> listaConsultas;
    private JButton botaoAdicionar;
    private JButton botaoListar;

    public GestorConsultas() {
        setTitle("Gestão de Consultas");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        listaConsultas = new ArrayList<>();

        JPanel painel = new JPanel();
        botaoAdicionar = new JButton("Adicionar Consulta");
        botaoListar = new JButton("Listar Consultas");

        painel.add(botaoAdicionar);
        painel.add(botaoListar);
        add(painel);

        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormularioConsulta formulario = new FormularioConsulta();
                formulario.setVisible(true);
            }
        });

        botaoListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listaConsultas.isEmpty()) {
                    JOptionPane.showMessageDialog(GestorConsultas.this, "Nenhuma consulta registada.");
                } else {
                    ListagemConsultas listagem = new ListagemConsultas(listaConsultas);
                    listagem.setVisible(true);
                }
            }
        });
    }

    public void adicionarConsulta(Consulta consulta) {
        listaConsultas.add(consulta);
    }

    public List<Consulta> getListaConsultas() {
        return listaConsultas;
    }
}