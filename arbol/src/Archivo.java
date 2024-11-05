import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Archivo {
    public static BufferedReader abrirArchivo(String nombreArchivo) {
        try {
            return new BufferedReader(new FileReader(nombreArchivo));
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
