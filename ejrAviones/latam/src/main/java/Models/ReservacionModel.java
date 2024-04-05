package Models;

import Entitys.Avion;
import Entitys.Pasajero;
import Entitys.Reservacion;
import Entitys.Vuelo;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static DBC.Conexion.*;

public class ReservacionModel implements IsCrudable<Reservacion> {

    @Override
    public List<Reservacion> getall() {
        openConnection();
        String query = "Select *, pasajeros.id_pasajero as pasajeroid, aviones.id_avion as avionid, reservaciones.id_reservacion as reservacionid, vuelos.id_vuelo as vuelosid  from reservaciones inner JOIN pasajeros on reservaciones.id_pasajero = pasajeros.id_pasajero INNER JOIN vuelos on  reservaciones.id_vuelo = vuelos.id_vuelo inner Join aviones on vuelos.id_avion = aviones.id_avion;";
        List<Reservacion> listFounded = new ArrayList<Reservacion>();
        try{
            pstm = dbConnection.prepareStatement(query);
            ResultSet result = pstm.executeQuery();
            while (result.next()){
                Reservacion temReser = new Reservacion();
                temReser.setId_reservacion(result.getInt("reservacionid"));
                temReser.setId_pasajero(result.getInt("pasajeroid"));
                temReser.setId_vuelo(result.getInt("vuelosid"));
                temReser.setAsiento(result.getString("asiento"));
                temReser.setFecha_reservacion(LocalDate.parse(result.getString("fecha_reservacion")));


                Vuelo tempVuelo = new Vuelo();
                tempVuelo.setId_vuelo(result.getInt("id_vuelo"));
                tempVuelo.setDestino(result.getString("destino"));
                tempVuelo.setFecha_salida(LocalDate.parse(result.getString("fecha_salida")));
                tempVuelo.setHora_salida(LocalTime.parse(result.getString("hora_salida")));
                tempVuelo.setId_avion(result.getInt("avionid"));

                Pasajero tempPasajero  = new Pasajero();
                tempPasajero.setId_pasajero(result.getInt("pasajeroid"));
                tempPasajero.setNombre(result.getString("nombre"));
                tempPasajero.setApellido(result.getString("apellido"));
                tempPasajero.setDocumento_identidad("documento_identidad");


                Avion tempAvion = new Avion();
                tempAvion.setId_avion(result.getInt("avionid"));
                tempAvion.setCapacidad(result.getInt("capacidad"));
                tempAvion.setModelo(result.getNString("modelo"));


                tempVuelo.setAvion(tempAvion);
                temReser.setVuelo(tempVuelo);
                temReser.setPasajero(tempPasajero);
                listFounded.add(temReser);
            }
            closeConnection();
            return listFounded;
        }catch (Exception e){
            System.out.println("getting all Reservations problem: line 61: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Reservacion getOne(int id) {
        openConnection();
        String query = "Select *, pasajeros.id_pasajero as pasajeroid, aviones.id_avion as avionid, reservaciones.id_reservacion as reservacionid, vuelos.id_vuelo as vuelosid  from reservaciones inner JOIN pasajeros on reservaciones.id_pasajero = pasajeros.id_pasajero INNER JOIN vuelos on  reservaciones.id_vuelo = vuelos.id_vuelo inner Join aviones on vuelos.id_avion = aviones.id_avion WHERE reservaciones.id_reservacion = ?;";
        Reservacion temReser = new Reservacion();
        try{
            pstm = dbConnection.prepareStatement(query);
            ResultSet result = pstm.executeQuery();
            while (result.next()){

                temReser.setId_reservacion(result.getInt("reservacionid"));
                temReser.setId_pasajero(result.getInt("pasajeroid"));
                temReser.setId_vuelo(result.getInt("vuelosid"));
                temReser.setAsiento(result.getString("asiento"));
                temReser.setFecha_reservacion(LocalDate.parse(result.getString("fecha_reservacion")));


                Vuelo tempVuelo = new Vuelo();
                tempVuelo.setId_vuelo(result.getInt("id_vuelo"));
                tempVuelo.setDestino(result.getString("destino"));
                tempVuelo.setFecha_salida(LocalDate.parse(result.getString("fecha_salida")));
                tempVuelo.setHora_salida(LocalTime.parse(result.getString("hora_salida")));
                tempVuelo.setId_avion(result.getInt("idavion"));

                Pasajero tempPasajero  = new Pasajero();
                tempPasajero.setId_pasajero(result.getInt("pasajeroid"));
                tempPasajero.setNombre(result.getString("nombre"));
                tempPasajero.setApellido(result.getString("apellido"));
                tempPasajero.setDocumento_identidad("documento_identidad");


                Avion tempAvion = new Avion();
                tempAvion.setId_avion(result.getInt("avionid"));
                tempAvion.setCapacidad(result.getInt("capacidad"));
                tempAvion.setModelo(result.getNString("modelo"));


                tempVuelo.setAvion(tempAvion);
                temReser.setVuelo(tempVuelo);
                temReser.setPasajero(tempPasajero);

            }
            closeConnection();
            return temReser;
        }catch (Exception e){
            System.out.println("getting all Reservations problem: line 61: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        openConnection();
        String query = "DELETE FROM reservaciones WHERE reservaciones.id_reservacion = ?";
        try{
            pstm = dbConnection.prepareStatement(query);
            pstm.setInt(1, id);
            boolean execution = pstm.execute();
            dbConnection.close();
            return  execution;
        }catch (Exception e){
            System.out.println("Error Deleting Booking : Model DB Line 129 "+ e.getMessage());
            return false;
        }

    }

    @Override
    public boolean insertOne(Reservacion registro) {
        try {
            openConnection();
            String query = "INSERT INTO reservaciones ( id_pasajero, id_vuelo, fecha_reservacion, asiento) VALUES(?,?,?,?);";
            pstm = dbConnection.prepareStatement(query);
            pstm.setInt(1, registro.getId_pasajero());
            pstm.setInt(2, registro.getId_vuelo());
            pstm.setString(3, registro.getFecha_reservacion().toString());
            pstm.setString(4, registro.getAsiento());
            int rowAfected = pstm.executeUpdate();
            if(rowAfected>0){
                System.out.println("realizado " +  rowAfected);
                closeConnection();
                return true;
            }else{
                throw new Exception("There is no nothing in DB to update");
            }
        }catch (Exception e){
            System.out.println("Error Inserting Airplane : Model DB line 91" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateOne(Reservacion registro) {
        try{
            openConnection();
            String query = "UPDATE reservaciones SET id_pasajero = ?, id_vuelo = ?, fecha_reservacion = ?, asiento = ? WHERE id_reservacion = ?;";
            pstm = dbConnection.prepareStatement(query);
            pstm.setInt(1, registro.getId_pasajero());
            pstm.setInt(2, registro.getId_vuelo());
            pstm.setString(3, registro.getFecha_reservacion().toString());
            pstm.setString(4, registro.getAsiento());
            pstm.setInt(5, registro.getId_reservacion());
            int rowAffected = pstm.executeUpdate();
            if(rowAffected>0){
                System.out.println("realizado " +  rowAffected);
                closeConnection();
                return true;
            }else{
                throw new Exception("Jugando a tirar excepciones");
            }

        }catch (Exception e){
            System.out.println("Error updating Pasajero : Model DB line 58" + e.getMessage());
            return false;
        }
    }


    public int getNumberOfSitsReserved(int vuelo_id){
        openConnection();
        int numberSitsOcupped = 0;
        try {
            String query = "SELECT COUNT(*) as sillasOcupadas  FROM reservaciones  WHERE id_vuelo = ?;";
            pstm = dbConnection.prepareStatement(query);
            pstm.setInt(1, vuelo_id);
            ResultSet res = pstm.executeQuery();
            while (res.next()){
               numberSitsOcupped =  res.getInt("sillasOcupadas");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());            ;

        }
        return numberSitsOcupped;
    }
}
