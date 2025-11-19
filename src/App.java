
public class App {
    public static void main(String[] args) throws Exception { 
        Universidad uni = new Universidad("UNVIME ");

        Profesor profesor1 = new Profesor("Angelina", "Garavaglia", 45, "22222", "Programacion", 21);
        Materia materia1 = new Materia("Programacion 1", "PROG1", 4, 7.5, profesor1);
        Materia materia2 = new Materia("Matematica 1", "MAT1", 4, 10, profesor1);
        
       
        Estudiante estudiante1 = new Estudiante("Maia", "Bulacio", 24, "44333222", "Programador Universitario", 0, null);
        Estudiante estudiante2 = new Estudiante("Jennifer", "frigo", 20, "39994444", "Marketing Cultural", 0, null);
        Estudiante estudiante3 = new Estudiante("Zoe", "Gomez", 23, "48555444", "Bioingenieria", 0, null);

        Estudiante estudiante4 = new Estudiante("Walter", "Carrera", 20, "41000111", "Programador Universitario", 0, null);

     // Agregar materias a los estudiantes
estudiante1.agregarMateria(materia1);
estudiante1.agregarMateria(materia2);
estudiante4.agregarMateria(materia1);

// Calcular promedio recursivo de estudiante1
double promedioAlex = estudiante1.obtenerPromedioRecursivo();
System.out.println("Promedio recursivo de Alex: " + promedioAlex);

// Agregar miembros a la universidad
uni.agregarMiembro(estudiante1);
uni.agregarMiembro(profesor1);
uni.agregarMiembro(estudiante2);
uni.agregarMiembro(estudiante3);
uni.agregarMiembro(estudiante4);

// Listar miembros
System.out.println("LISTADO DE MIEMBROS : \n");
uni.listarMiembros();

// Ordenamiento de estudiantes por apellido
System.out.println("\nOrdenando Estudiantes por Apellido...");

// Obtener solo estudiantes en forma de array para ordenar
Estudiante[] estudiantesParaOrdenar = uni.getSoloEstudiantes(); // asumimos que este método devuelve Estudiante[]

// Ordenar por apellido
uni.ordenarEstudiantesPorApellido(estudiantesParaOrdenar);

System.out.println("Lista ordenada de estudiantes:\n");
for (Estudiante e : estudiantesParaOrdenar) {
    System.out.println(e.getApellido() + ", " + e.getNombre());
}

//  Búsqueda por documento
System.out.println("\n--Busqueda por documento---\n");
Persona encontrada = uni.buscarPorDocumento("44333222"); // asumimos que este método busca en toda la lista
if(encontrada != null){
    System.out.println("Persona encontrada: " + encontrada.obtenerInformacionCompleta());
}else {
    System.out.println("No se encontró la persona con ese documento.");
}

//  Búsqueda binaria por apellido 
System.out.println("\nBusqueda Binaria por Apellido: 'Gomez'");
Estudiante clave = uni.busquedaBinariaEstudiantes(estudiantesParaOrdenar, "Gomez"); // retorna Estudiante o null
if(clave != null){
    System.out.println("Estudiante encontrado: " + clave.getNombre() + " " + clave.getApellido());
} else {
    System.out.println("No se encontró el estudiante con ese apellido.");
}
    }
}

