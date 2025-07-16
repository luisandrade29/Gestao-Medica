package view;

import javax.swing.*;

public class UtilitariosSwing {

    public static int lerInt(String mensagem, JFrame frame) {
        while (true) {
            String input = JOptionPane.showInputDialog(frame, mensagem);
            if (input == null) return -1;
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Número inválido. Tenta novamente.");
            }
        }
    }

    public static String lerString(String mensagem, JFrame frame) {
        while (true) {
            String input = JOptionPane.showInputDialog(frame, mensagem);
            if (input == null) return null;
            if (!input.trim().isEmpty()) return input.trim();
            JOptionPane.showMessageDialog(frame, "Texto inválido. Tenta novamente.");
        }
    }
}