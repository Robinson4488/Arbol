import java.util.ArrayList;
import java.util.List;

public class ArbolBinario {
    private NodoArbol raiz;

    public void insertar(Documento documento) {
        raiz = insertarRecursivo(raiz, documento);
    }

    private NodoArbol insertarRecursivo(NodoArbol actual, Documento documento) {
        if (actual == null) {
            return new NodoArbol(documento);
        }
        if (documento.getNombreCompleto().compareTo(actual.documento.getNombreCompleto()) < 0) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, documento);
        } else {
            actual.derecho = insertarRecursivo(actual.derecho, documento);
        }
        return actual;
    }

    public List<Documento> obtenerDocumentosEnOrden() {
        List<Documento> documentos = new ArrayList<>();
        enOrden(raiz, documentos);
        return documentos;
    }

    private void enOrden(NodoArbol nodo, List<Documento> documentos) {
        if (nodo != null) {
            enOrden(nodo.izquierdo, documentos);
            documentos.add(nodo.documento);
            enOrden(nodo.derecho, documentos);
        }
    }
}
