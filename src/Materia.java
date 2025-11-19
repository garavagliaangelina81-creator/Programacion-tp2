import java.util.Objects;

public class Materia {
    private String nombre;
    private String codigo;
    private int creditos;
    private double nota;
    private Profesor profesor;

    public Materia(String nombre, String codigo, int creditos,double nota, Profesor profesor) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.nota = nota;
        this.profesor = profesor;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }

    public double getNota(){ return nota;}
    public void setNota (double nota){ this.nota = nota; }

    public Profesor getProfesor() { return profesor; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }




    // equals() y hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materia materia = (Materia) o;
        return Objects.equals(codigo, materia.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }


@Override
    public String toString() {
        String nombreProfesor = (profesor != null)
                ? profesor.getNombre() + " " + profesor.getApellido()
                : "No asignado";

        return "Materia {" +
                "nombre='" + nombre + '\'' +
                ", código='" + codigo + '\'' +
                ", créditos=" + creditos +
                ", nota=" + nota +
                ", profesor=" + nombreProfesor +
                '}'; 
            }
        }



