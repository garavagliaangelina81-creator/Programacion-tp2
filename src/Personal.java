import java.time.LocalDate;

public class Personal extends Persona implements miembroUniversidad {
    private String departamento;
    private String puesto;
    private LocalDate fechaIngreso; 

    public Personal(String nombre, String apellido, int edad, String documento, String departamento, 
    String puesto, LocalDate fechaIngreso){
        super(nombre, apellido, edad, documento);
       this.departamento = departamento;
        this.puesto = puesto;
        this.fechaIngreso = fechaIngreso;
    }

    
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
    
    public LocalDate getFechaIngreso(){ return fechaIngreso; }
    public void setFechaIngreso(LocalDate fechaIngreso) { this.fechaIngreso = fechaIngreso; }

     // Implementación de la interfaz
    @Override
    public String obtenerRol() {
        return "Personal Administrativo";
    }

    @Override
    public String obtenerInformacionCompleta() {
        return "Rol: Personal Administrativo\n" +
                "Nombre: " + getNombre() + " " + getApellido() + "\n" +
                "Edad: " + getEdad() + "\n" +
                "Documento: " + getDocumento() + "\n" +
                "Departamento: " + departamento + "\n" +
                "Puesto: " + puesto + "\n" +
                "Fecha de ingreso: " + fechaIngreso;
    }




    @Override
    public String toString(){
        return super.toString() + "| Personal {" + 
        "departamento=´" + departamento + '\'' +
        ", puesto='" + puesto + '\'' +
        ", fechaIngreso=" +  fechaIngreso +
         '}';

    }
    
}

