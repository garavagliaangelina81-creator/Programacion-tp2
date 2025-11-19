public class Utilidades {
    // metodo: Ordenar estudiantes por apellido (Selection Sort)
public static Estudiante[] ordenarEstudiantesPorApellido(Estudiante[] estudiantes) {
    if (estudiantes == null || estudiantes.length == 0) return estudiantes;

    int n = estudiantes.length;

    for (int i = 0; i < n - 1; i++) {
        int indiceMinimo = i;

        // Buscar el estudiante con el apellido menor alfabéticamente
        for (int j = i + 1; j < n; j++) {
            if (estudiantes[j].getApellido().compareToIgnoreCase(estudiantes[indiceMinimo].getApellido()) < 0) {
                indiceMinimo = j;
            }
        }

        // Intercambiar si encontramos un apellido menor
        if (indiceMinimo != i) {
            Estudiante temp = estudiantes[i];
            estudiantes[i] = estudiantes[indiceMinimo];
            estudiantes[indiceMinimo] = temp;
        }
    }

    return estudiantes;
}

}