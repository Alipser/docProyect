package Entitys;

public class Doctor {
    private int id_medico;
    private String nombre;
    private String apellidos;
    private int id_especialidad;

    private Speciality speciality;

    public Doctor() {
    }

    public Doctor(int id_medico, String nombre, String apellidos, int id_especialidad) {
        this.id_medico = id_medico;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.id_especialidad = id_especialidad;
    }

    public Doctor(String nombre, String apellidos, int id_especialidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.id_especialidad = id_especialidad;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
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

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    @Override
    public String toString() {

        var result = this.speciality != null ? speciality.getNombre() : "";
        return "Doctor{" +
                "id_medico=" + id_medico +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", id_especialidad=" + id_especialidad +
                ", speciality=" + result +
                '}';
    }
}
