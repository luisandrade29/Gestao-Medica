package persistencia;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

public class LeitorJSON {
    private static final Gson gson = new Gson();

    public static <T> T ler(String ficheiro, Class<T> classe) throws IOException {
        try (FileReader reader = new FileReader(ficheiro)) {
            return gson.fromJson(reader, classe);
        }
    }
}