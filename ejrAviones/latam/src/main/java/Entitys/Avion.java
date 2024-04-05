package Entitys;

public class Avion {

    private int id_avion;
    private String modelo;
    private int capacidad;

    public Avion(String modelo, int capacidad) {
        this.modelo = modelo;
        this.capacidad = capacidad;

    }

    public Avion(int id_avion, String modelo, int capacidad) {
        this.id_avion = id_avion;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    public Avion() {
    }

    public int getId_avion() {
        return id_avion;
    }

    public void setId_avion(int id_avion) {
        this.id_avion = id_avion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Avion" + id_avion +
                " { modelo='" + modelo + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
