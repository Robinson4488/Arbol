public class NodoArbol {
    Documento documento;
    NodoArbol izquierdo, derecho;

    public NodoArbol(Documento documento) {
        this.documento = documento;
        izquierdo = derecho = null;
    }
}
