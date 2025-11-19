public class Profesor extends Persona implements miembroUniversidad {

    // Atributos
    private String especialidad;
    private int añosExperiencia;
    private ListaEnlazada<Materia> materiasAsignadas;  // cambio

    // Constructor
    public Profesor(String nombre, String apellido, int edad, String documento,
                    String especialidad, int añosExperiencia) {
        super(nombre, apellido, edad, documento);
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
        this.materiasAsignadas = new ListaEnlazada<>();   // Lista enlazada vacía
    }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public int getAñosExperiencia() { return añosExperiencia; }
    public void setAñosExperiencia(int añosExperiencia) { this.añosExperiencia = añosExperiencia; }

    public ListaEnlazada<Materia> getMateriasAsignadas() { return materiasAsignadas; }
    public void setMateriasAsignadas(ListaEnlazada<Materia> materiasAsignadas) { 
        this.materiasAsignadas = materiasAsignadas; 
    }

    // Método para asignar una nueva materia al profesor
    public void asignarMateria(Materia materia) {
        materiasAsignadas.insertar(materia);   // ahora se usa insertar()
    }

    @Override
    public String obtenerRol() {
        return "Profesor";
    }

    @Override
    public String obtenerInformacionCompleta() {
        return "Rol: Profesor\n" +
                "Nombre: " + getNombre() + " " + getApellido() + "\n" +
                "Edad: " + getEdad() + "\n" +
                "Documento: " + getDocumento() + "\n" +
                "Especialidad: " + especialidad + "\n" +
                "Años de experiencia: " + añosExperiencia + "\n" +
                "Materias asignadas: " + materiasAsignadas.toString();
    }

    @Override
    public String toString() {
        return super.toString() + " | Profesor {" +
                "especialidad='" + especialidad + '\'' +
                ", añosExperiencia=" + añosExperiencia +
                ", materiasAsignadas=" + materiasAsignadas +
                '}';
    }
}
