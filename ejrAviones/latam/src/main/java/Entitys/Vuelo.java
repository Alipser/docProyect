package Entitys;

import java.time.LocalDate;
import java.time.LocalTime;


public class Vuelo {


    private int id_vuelo;
    private String destino;
    private LocalDate fecha_salida;
    private LocalTime hora_salida;
    private int id_avion;

    private Avion avion;

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Vuelo(int id_vuelo, String destino, LocalDate fecha_salida, LocalTime hora_salida, int id_avion) {
        this.id_vuelo = id_vuelo;
        this.destino = destino;
        this.fecha_salida = fecha_salida;
        this.hora_salida = hora_salida;
        this.id_avion = id_avion;
    }

    public Vuelo(String destino, LocalDate fecha_salida, LocalTime hora_salida, int id_avion) {
        this.destino = destino;
        this.fecha_salida = fecha_salida;
        this.hora_salida = hora_salida;
        this.id_avion = id_avion;
    }


    public Vuelo() {
    }

    public int getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(int id_vuelo) {
        this.id_vuelo = id_vuelo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(LocalDate fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public LocalTime getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(LocalTime hora_salida) {
        this.hora_salida = hora_salida;
    }

    public int getId_avion() {
        return id_avion;
    }

    public void setId_avion(int id_avion) {
        this.id_avion = id_avion;
    }

    @Override
    public String toString() {
        String toStringAvion = this.avion != null ? ", avion=" + avion : "";
        return "Vuelo{" +
                "id_vuelo=" + id_vuelo +
                ", destino='" + destino + '\'' +
                ", fecha_salida=" + fecha_salida +
                ", hora_salida=" + hora_salida +
                ", id_avion=" + id_avion +
                '}';
    }
}
