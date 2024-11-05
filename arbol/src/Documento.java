import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Documento {
    private String apellido1;
    private String apellido2;
    private String nombre;
    private String documento;

    public Documento(String apellido1, String apellido2, String nombre, String documento) {
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.documento = documento;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombreCompleto() {
        return apellido1 + " " + apellido2 + " " + nombre;
    }

    public static List<Documento> cargarDatos(String nombreArchivo) {
        List<Documento> documentos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            br.readLine(); // Saltar encabezados
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(";");
                documentos.add(new Documento(campos[0], campos[1], campos[2], campos[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return documentos;
    }
}
