public class Universidad {

    private String nombre;
    private ListaEnlazada<miembroUniversidad> miembros;

    // Constructores
    public Universidad() {
        this.miembros = new ListaEnlazada<>();
    }

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.miembros = new ListaEnlazada<>();
    }

    // Getter del nombre
    public String getNombre() {
        return nombre;
    }

    // Agregar un miembro
    public void agregarMiembro(miembroUniversidad m) {
        miembros.insertar(m);
    }

    // Listar miembros (nombre + rol)
    public void listarMiembros() {
        Nodo<miembroUniversidad> actual = miembros.getPrimero();
        System.out.println("Miembros de la universidad " + nombre + ":");
        while (actual != null) {
            miembroUniversidad m = actual.getDato();
            Persona p = (Persona) m; // casteo para obtener nombre/apellido
            System.out.println("- " + m.obtenerRol() + ": " + p.getNombre() + " " + p.getApellido());
            actual = actual.getSiguiente();
        }
    }

    // Mostrar información completa de todos los miembros
    public void mostrarInformacionCompleta() {
        Nodo<miembroUniversidad> actual = miembros.getPrimero();
        System.out.println("Información completa de los miembros de " + nombre + ":");
        while (actual != null) {
            System.out.println("\n--------------------------");
            System.out.println(actual.getDato().obtenerInformacionCompleta());
            actual = actual.getSiguiente();
        }
    }

    // Contar estudiantes por carrera (recursivo)
    public int contarEstudiantesRecursivo(String carrera) {
        return contarEstudiantesRecursivoAux(miembros.getPrimero(), carrera);
    }

    private int contarEstudiantesRecursivoAux(Nodo<miembroUniversidad> nodo, String carrera) {
        if (nodo == null) return 0;

        int suma = 0;
        if (nodo.getDato() instanceof Estudiante) {
            Estudiante e = (Estudiante) nodo.getDato();
            if (e.getCarrera().equalsIgnoreCase(carrera)) {
                suma = 1;
            }
        }
        return suma + contarEstudiantesRecursivoAux(nodo.getSiguiente(), carrera);
    }

    // Contar estudiantes por carrera (iterativo)
    public int contarEstudiantesIterativo(String carrera) {
        int contador = 0;
        Nodo<miembroUniversidad> actual = miembros.getPrimero();

        while (actual != null) {
            if (actual.getDato() instanceof Estudiante) {
                Estudiante e = (Estudiante) actual.getDato();
                if (e.getCarrera().equalsIgnoreCase(carrera)) {
                    contador++;
                }
            }
            actual = actual.getSiguiente();
        }
        return contador;
    }

    // Buscar estudiante por documento (recursivo)
    public Estudiante buscarEstudianteRecursivo(String documento) {
        return buscarEstudianteRecursivoAux(miembros.getPrimero(), documento);
    }

    private Estudiante buscarEstudianteRecursivoAux(Nodo<miembroUniversidad> nodo, String documento) {
        if (nodo == null) return null;

        if (nodo.getDato() instanceof Estudiante) {
            Estudiante e = (Estudiante) nodo.getDato();
            if (e.getDocumento().equalsIgnoreCase(documento)) {
                return e;
            }
        }
        return buscarEstudianteRecursivoAux(nodo.getSiguiente(), documento);
    }

    // Buscar miembros por rol
    public ListaEnlazada<miembroUniversidad> buscarPorRol(String rol) {
        ListaEnlazada<miembroUniversidad> resultado = new ListaEnlazada<>();
        Nodo<miembroUniversidad> actual = miembros.getPrimero();

        while (actual != null) {
            miembroUniversidad m = actual.getDato();
            if (m.obtenerRol().equalsIgnoreCase(rol)) {
                resultado.insertar(m);
            }
            actual = actual.getSiguiente();
        }

        return resultado;
    }
}


