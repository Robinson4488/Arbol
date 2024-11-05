import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.stream.Collectors;

public class FrmOrdenamiento extends JFrame {
    private JButton btnOrdenar, btnBuscar;
    private JComboBox<String> cmbCriterio;
    private JTextField txtBuscar;
    private JTable tblDocumentos;
    private ArbolBinario arbol;

    public FrmOrdenamiento() {
        arbol = new ArbolBinario();
        cargarDatos();

        setSize(600, 400);
        setTitle("Ordenamiento de Documentos");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JToolBar toolBar = new JToolBar();
        btnOrdenar = new JButton("Ordenar");
        btnBuscar = new JButton("Buscar");
        txtBuscar = new JTextField(10);
        cmbCriterio = new JComboBox<>(new String[]{"A-Z", "Z-A"});
        
        toolBar.add(btnOrdenar);
        toolBar.add(cmbCriterio);
        toolBar.add(txtBuscar);
        toolBar.add(btnBuscar);
        
        add(toolBar, BorderLayout.NORTH);
        
        btnOrdenar.addActionListener(this::ordenar);
        btnBuscar.addActionListener(this::buscar);
        
        tblDocumentos = new JTable();
        actualizarTabla(arbol.obtenerDocumentosEnOrden());
        
        JScrollPane scrollPane = new JScrollPane(tblDocumentos);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void cargarDatos() {
        List<Documento> documentos = Documento.cargarDatos("examen4-main/arbol/src/datos/Datos.csv");
        for (Documento doc : documentos) {
            arbol.insertar(doc);
        }
    }

    private void actualizarTabla(List<Documento> documentos) {
        String[] columnas = {"Apellido1", "Apellido2", "Nombre", "Documento"};
        String[][] data = new String[documentos.size()][4];
        
        for (int i = 0; i < documentos.size(); i++) {
            Documento doc = documentos.get(i);
            data[i][0] = doc.getApellido1();
            data[i][1] = doc.getApellido2();
            data[i][2] = doc.getNombre();
            data[i][3] = doc.getDocumento();
        }
        
        tblDocumentos.setModel(new DefaultTableModel(data, columnas));
    }

    private void ordenar(ActionEvent e) {
        List<Documento> documentos = arbol.obtenerDocumentosEnOrden();
        if (cmbCriterio.getSelectedItem().equals("Z-A")) {
            documentos.sort((d1, d2) -> d2.getNombreCompleto().compareTo(d1.getNombreCompleto()));
        }
        actualizarTabla(documentos);
    }

    private void buscar(ActionEvent e) {
        String texto = txtBuscar.getText().trim().toLowerCase();
        List<Documento> documentos = arbol.obtenerDocumentosEnOrden();
        List<Documento> filtrados = documentos.stream()
            .filter(doc -> doc.getNombreCompleto().toLowerCase().contains(texto))
            .collect(Collectors.toList());
        actualizarTabla(filtrados);
    }
}
