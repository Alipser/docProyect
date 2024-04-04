package Entitys;

public class Patient {
    private int id_paciente;
    private String nombre;
    private String apellidos;
    private String fecha_nacimiento;
    private String documento_identidad;

    public Patient() {}

    public Patient(int id_paciente, String nombre, String apellidos, String fecha_nacimiento, String documento_identidad) {
        this.id_paciente = id_paciente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.documento_identidad = documento_identidad;
    }

    public Patient(String nombre, String apellidos, String fecha_nacimiento, String documento_identidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.documento_identidad = documento_identidad;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDocumento_identidad() {
        return documento_identidad;
    }

    public void setDocumento_identidad(String documento_identidad) {
        this.documento_identidad = documento_identidad;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id_paciente=" + id_paciente +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                ", documento_identidad='" + documento_identidad + '\'' +
                '}';
    }
}
