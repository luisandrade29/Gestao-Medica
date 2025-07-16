import gestor.GestorUtentes;
import gestor.GestorMedicos;

import javax.swing.SwingUtilities;

public class SistemaDeGestao {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestorUtentes gestorUtentes = new GestorUtentes();
            gestorUtentes.setVisible(true);
            // Se quiseres, podes abrir outras janelas aqui, ex GestorMedicos
        });
    }
}