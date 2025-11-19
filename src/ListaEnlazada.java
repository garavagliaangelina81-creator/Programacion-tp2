public class ListaEnlazada<T> {

    private Nodo<T> primero;
    private int tamanio;

    public ListaEnlazada() {
        primero = null;
        tamanio = 0;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public void insertar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(primero);
        primero = nuevo;
        tamanio++;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public int getTamanio() {
        return tamanio;
    }

    
    // Convertir a Array

    @SuppressWarnings("unchecked")
public T[] convertirAArray() {
    T[] array = (T[]) new Object[tamanio];
    Nodo<T> actual = primero;
    int i = 0;

    while (actual != null) {
        array[i++] = actual.getDato();
        actual = actual.getSiguiente();
    }

    return array;
}


    // Convertir Array a Lista

    public static <T> ListaEnlazada<T> convertirArrayALista(T[] array) {
        ListaEnlazada<T> lista = new ListaEnlazada<>();
        for (T elem : array) {
            lista.insertar(elem);
        }
        return lista;
    }
}
