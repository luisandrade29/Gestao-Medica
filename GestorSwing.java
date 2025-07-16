package gestor;

import javax.swing.*;
import java.awt.*;

public class GestorSwing extends JFrame {

    public GestorSwing() {
        super("Sistema de Gestão Médica");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(13, 1, 10, 10));

        JButton btnUtentes = new JButton("Gestão de Utentes");
        JButton btnMedicos = new JButton("Gestão de Médicos");
        JButton btnConsultas = new JButton("Gestão de Consultas");
        JButton btnMedicamentos = new JButton("Gestão de Medicamentos");
        JButton btnDoencas = new JButton("Gestão de Doenças");
        JButton btnAnalises = new JButton("Gestão de Análises");
        JButton btnExames = new JButton("Gestão de Exames");
        JButton btnInternamentos = new JButton("Gestão de Internamentos");
        JButton btnDepartamentos = new JButton("Gestão de Departamentos / Especialidades");
        JButton btnEquipamentos = new JButton("Gestão de Equipamentos Médicos");
        JButton btnFinanceiro = new JButton("Gestão Financeira / Faturação");
        JButton btnRelatorios = new JButton("Relatórios e Estatísticas");
        JButton btnSair = new JButton("Sair");

        add(btnUtentes);
        add(btnMedicos);
        add(btnConsultas);
        add(btnMedicamentos);
        add(btnDoencas);
        add(btnAnalises);
        add(btnExames);
        add(btnInternamentos);
        add(btnDepartamentos);
        add(btnEquipamentos);
        add(btnFinanceiro);
        add(btnRelatorios);
        add(btnSair);

        btnUtentes.addActionListener(e -> new GestorUtentes().setVisible(true));
        btnMedicos.addActionListener(e -> new GestorMedicos().setVisible(true));
        btnConsultas.addActionListener(e -> new GestorConsultas().setVisible(true));
        btnMedicamentos.addActionListener(e -> new GestorMedicamentos().setVisible(true));
        btnDoencas.addActionListener(e -> new GestorDoencas().setVisible(true));
        btnAnalises.addActionListener(e -> new GestorAnalises().setVisible(true));
        btnExames.addActionListener(e -> new GestorExames().setVisible(true));
        btnInternamentos.addActionListener(e -> new GestorInternamentos().setVisible(true));
        btnDepartamentos.addActionListener(e -> new GestorDepartamentos().setVisible(true));
        btnEquipamentos.addActionListener(e -> new GestorEquipamentos().setVisible(true));
        btnFinanceiro.addActionListener(e -> new GestorFinanceiro().setVisible(true));
        btnRelatorios.addActionListener(e -> new GestorRelatorios().setVisible(true));
        btnSair.addActionListener(e -> System.exit(0));
    }
}