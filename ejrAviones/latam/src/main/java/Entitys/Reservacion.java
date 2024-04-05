package Entitys;

import java.time.LocalDate;
import java.util.Date;

public class Reservacion {

    private int id_reservacion;
    private int id_pasajero;
    private int id_vuelo;
    private LocalDate fecha_reservacion;
    private String asiento;

    private Vuelo vuelo;

    private Pasajero pasajero;

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Reservacion(int id_reservacion, int id_pasajero, int id_vuelo, LocalDate fecha_reservacion, String asiento) {
        this.id_reservacion = id_reservacion;
        this.id_pasajero = id_pasajero;
        this.id_vuelo = id_vuelo;
        this.fecha_reservacion = fecha_reservacion;
        this.asiento = asiento;
    }

    public Reservacion(int id_pasajero, int id_vuelo, LocalDate fecha_reservacion, String asiento) {
        this.id_pasajero = id_pasajero;
        this.id_vuelo = id_vuelo;
        this.fecha_reservacion = fecha_reservacion;
        this.asiento = asiento;
    }

    public Reservacion() {
    }

    public int getId_reservacion() {
        return id_reservacion;
    }

    public void setId_reservacion(int id_reservacion) {
        this.id_reservacion = id_reservacion;
    }

    public int getId_pasajero() {
        return id_pasajero;
    }

    public void setId_pasajero(int id_pasajero) {
        this.id_pasajero = id_pasajero;
    }

    public int getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(int id_vuelo) {
        this.id_vuelo = id_vuelo;
    }

    public LocalDate getFecha_reservacion() {
        return fecha_reservacion;
    }

    public void setFecha_reservacion(LocalDate fecha_reservacion) {
        this.fecha_reservacion = fecha_reservacion;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    @Override
    public String toString() {

         String toStringVuelo = this.vuelo != null ? ", vuelo=" + vuelo.toString() : "";
         String toStringPasajero = this.pasajero != null?  ", pasajero=" + pasajero.toString():"";
        return "Reservacion{" +
                "id_reservacion=" + id_reservacion +
                ", id_pasajero=" + id_pasajero +
                ", id_vuelo=" + id_vuelo +
                ", fecha_reservacion=" + fecha_reservacion +
                ", asiento='" + asiento + '\'' +
                toStringPasajero + toStringVuelo +
                '}';
    }
}
