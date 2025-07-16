package utils;

public class Validador {

    public static boolean validarNome(String nome) {
        return nome != null && nome.matches("[A-Za-zÀ-ú ]{2,}");
    }

    public static boolean validarIdade(int idade) {
        return idade > 0 && idade < 130;
    }

    public static boolean validarGenero(String genero) {
        return genero.equalsIgnoreCase("M") || genero.equalsIgnoreCase("F") || genero.equalsIgnoreCase("Outro");
    }

    public static boolean validarNumeroUtente(String numero) {
        return numero != null && numero.matches("\\d{4,10}");
    }

    public static boolean validarTelefone(String telefone) {
        return telefone != null && telefone.matches("\\d{9}");
    }

    public static boolean validarEmail(String email) {
        return email != null && email.matches("^[\\w\\.-]+@[\\w\\.-]+\\.[a-z]{2,}$");
    }

    public static boolean validarData(String data) {
        return data.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    public static boolean validarHora(String hora) {
        return hora.matches("\\d{2}:\\d{2}");
    }
}