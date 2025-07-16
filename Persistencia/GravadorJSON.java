package persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

public class GravadorJSON {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void gravar(Object obj, String ficheiro) throws IOException {
        try (FileWriter writer = new FileWriter(ficheiro)) {
            gson.toJson(obj, writer);
        }
    }
}