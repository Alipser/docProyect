package Models;

import Entitys.Avion;
import Entitys.Vuelo;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static DBC.Conexion.*;

public class VueloModel implements IsCrudable<Vuelo> {


    @Override
    public List<Vuelo> getall() {
        openConnection();
        String query = "Select *, vuelos.id_avion as idavion from vuelos Inner JOIN aviones On vuelos.id_avion = aviones.id_avion;";
        List<Vuelo> listFounded = new ArrayList<Vuelo>();
        try{
            pstm = dbConnection.prepareStatement(query);
            ResultSet result = pstm.executeQuery();
            while (result.next()){
                Vuelo tempVuelo = new Vuelo();
                tempVuelo.setId_vuelo(result.getInt("id_vuelo"));
                tempVuelo.setDestino(result.getString("destino"));
                tempVuelo.setFecha_salida(LocalDate.parse(result.getString("fecha_salida")));
                tempVuelo.setHora_salida(LocalTime.parse(result.getString("hora_salida")));
                tempVuelo.setId_avion(result.getInt("idavion"));
                Avion tempAvion = new Avion();
                tempVuelo.setId_avion(result.getInt("idavion"));
                tempAvion.setCapacidad(result.getInt("capacidad"));
                tempAvion.setModelo(result.getNString("modelo"));
                tempVuelo.setAvion(tempAvion);
                listFounded.add(tempVuelo);
            }
            closeConnection();
            return listFounded;
        }catch (Exception e){
            System.out.println("getting all Airplane problem: line 31: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Vuelo getOne(int id) {
        openConnection();
        String query = "Select *, vuelos.id_avion as idavion from vuelos Inner JOIN aviones On vuelos.id_avion = aviones.id_avion WHERE id_vuelo = ?;";
        Vuelo listFounded = new Vuelo();
        try {
            pstm = dbConnection.prepareStatement(query);
            pstm.setInt(1, id);
            ResultSet result = pstm.executeQuery();
            Vuelo tempVuelo = new Vuelo();
            while (result.next()) {
                tempVuelo.setId_vuelo(result.getInt("id_vuelo"));
                tempVuelo.setDestino(result.getString("destino"));
                tempVuelo.setFecha_salida(LocalDate.parse(result.getString("fecha_salida")));
                tempVuelo.setHora_salida(LocalTime.parse(result.getString("hora_salida")));
                tempVuelo.setId_avion(result.getInt("idavion"));
                Avion tempAvion = new Avion();
                tempVuelo.setId_avion(result.getInt("idavion"));
                tempAvion.setCapacidad(result.getInt("capacidad"));
                tempAvion.setModelo(result.getNString("modelo"));
                tempVuelo.setAvion(tempAvion);
            }
            closeConnection();
            return tempVuelo;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        openConnection();
        String query = "DELETE FROM vuelos WHERE vuelos.id_vuelos = ?";
        try{
            pstm = dbConnection.prepareStatement(query);
            pstm.setInt(1, id);
            boolean execution = pstm.execute();
            closeConnection();
            return  execution;
        }catch (Exception e){
            System.out.println("Error Deleting Airplane : Model DB Line 69 "+ e.getMessage());
            return false;
        }
    }

    @Override
    public boolean insertOne(Vuelo registro) {
        try {
            openConnection();
            String query = "INSERT INTO vuelos( destino, hora_salida, fecha_salida, id_avion) VALUES( ?, ?, ?, ?)";
            pstm = dbConnection.prepareStatement(query);
            pstm.setString(1, registro.getDestino());
            pstm.setString(2, registro.getHora_salida().toString());
            pstm.setString(3, registro.getFecha_salida().toString());
            pstm.setInt(4, registro.getId_avion());
            int rowAfected = pstm.executeUpdate();
            if(rowAfected>0){
                System.out.println("realizado " +  rowAfected);
                closeConnection();
                return true;
            }else{
                throw new Exception("There is no nothing in DB to update");
            }
        }catch (Exception e){
            System.out.println("Error Inserting Fly : Model DB line 91" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateOne(Vuelo registro) {
        try{
            openConnection();
            String query = "UPDATE vuelos SET destino = ?, hora_salida = ?, fecha_salida=?, id_avion=? WHERE id_vuelo = ?;";
            pstm = dbConnection.prepareStatement(query);
            pstm.setString(1, registro.getDestino());
            pstm.setString(2, registro.getHora_salida().toString());
            pstm.setString(3, registro.getFecha_salida().toString());
            pstm.setInt(4, registro.getId_avion());
            pstm.setInt(5, registro.getId_vuelo());
            int rowAffected = pstm.executeUpdate();
            if(rowAffected>0){
                System.out.println("realizado " +  rowAffected);
                closeConnection();
                return true;
            }else{
                throw new Exception("There is no nothing in DB to update");
            }

        }catch (Exception e){
            System.out.println("Error Inserting fly : Model DB line 58" + e.getMessage());
            return false;
        }
    }
}

