package Entitys;

public class Pasajero {

   private int id_pasajero;

    private String nombre;
    private String apellido;

    private String documento_identidad;

    public Pasajero(String nombre, String apellido, String documento_identidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento_identidad = documento_identidad;

    }

    public Pasajero(int id_pasajero, String nombre, String apellido, String documento_identidad) {
        this.id_pasajero = id_pasajero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento_identidad = documento_identidad;
    }

    public Pasajero() {
    }

    public int getId_pasajero() {
        return id_pasajero;
    }

    public void setId_pasajero(int id_pasajero) {
        this.id_pasajero = id_pasajero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento_identidad() {
        return documento_identidad;
    }

    public void setDocumento_identidad(String documento_identidad) {
        this.documento_identidad = documento_identidad;
    }

    @Override
    public String toString() {
        return "Pasajero " + id_pasajero +
                "{ nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", documento_identidad='" + documento_identidad + '\'' +
                '}';
    }
}
