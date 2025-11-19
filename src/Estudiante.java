public class Estudiante extends Persona implements miembroUniversidad {

    private String carrera;
    private double promedio;
    private ListaEnlazada<Materia> materias;   // cambio

    // Constructor
    public Estudiante(String nombre, String apellido, int edad, String documento,
                      String carrera, double promedio, ListaEnlazada<Materia> materias) {
        super(nombre, apellido, edad, documento);
        this.carrera = carrera;
        this.promedio = promedio;
        this.materias = materias;
    }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public double getPromedio() { return promedio; }
    public void setPromedio(double promedio) { this.promedio = promedio; }

    public ListaEnlazada<Materia> getMaterias() { return materias; }
    public void setMaterias(ListaEnlazada<Materia> materias) { this.materias = materias; }

    // Implementación de la interfaz
    @Override
    public String obtenerRol() {
        return "Estudiante";
    }

    @Override
    public String obtenerInformacionCompleta() {
        return "Rol: Estudiante\n" +
                "Nombre: " + getNombre() + " " + getApellido() + "\n" +
                "Edad: " + getEdad() + "\n" +
                "Documento: " + getDocumento() + "\n" +
                "Carrera: " + carrera + "\n" +
                "Promedio: " + promedio + "\n" +
                "Materias: " + materias.toString();
    }

    @Override
    public String toString() {
        return super.toString() + 
                " | Estudiante { carrera='" + carrera + '\'' +
                ", promedio=" + promedio +
                ", materias=" + materias +
                " }";
    }

    
    // PROMEDIO RECURSIVO USANDO LISTA ENLAZADA
    

    /**
     * Método recursivo que suma las notas comenzando desde un nodo.
     * @param nodo actual
     * @return suma de notas desde nodo hasta el final
     */
    private double sumarNotasRecursivo(Nodo<Materia> nodo) {
        if (nodo == null) {
            return 0.0;
        }
        return nodo.getDato().getNota() + sumarNotasRecursivo(nodo.getSiguiente());
    }

    public double obtenerPromedioRecursivo() {
        if (materias == null || materias.estaVacia()) 
            return 0.0;

        double suma = sumarNotasRecursivo(materias.getPrimero());
        return suma / materias.getTamanio();
    }

    
    //   PROMEDIO ITERATIVO
    

    public double calcularPromedioIterativo() {
        if (materias == null || materias.estaVacia()) {
            return 0.0;
        }

        double suma = 0;
        Nodo<Materia> actual = materias.getPrimero();
        while (actual != null) {
            suma += actual.getDato().getNota();
            actual = actual.getSiguiente();
        }

        return suma / materias.getTamanio();
    }
}
