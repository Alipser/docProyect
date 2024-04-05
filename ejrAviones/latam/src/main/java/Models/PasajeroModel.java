package Models;
import Entitys.Avion;
import Entitys.Pasajero;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static DBC.Conexion.*;

public class PasajeroModel implements IsCrudable<Pasajero>{
    @Override
    public List<Pasajero> getall() {
        openConnection();
        String query = "Select * from pasajeros";
        List<Pasajero> listFounded = new ArrayList<Pasajero>();
        try{
            pstm = dbConnection.prepareStatement(query);
            ResultSet result = pstm.executeQuery();
            while (result.next()){
                Pasajero tempPasajero  = new Pasajero();
                tempPasajero.setId_pasajero(result.getInt("id_pasajero"));
                tempPasajero.setNombre(result.getString("nombre"));
                tempPasajero.setApellido(result.getString("apellido"));
                tempPasajero.setDocumento_identidad(result.getString("documento_identidad"));
                listFounded.add(tempPasajero);
            }
            closeConnection();
            return listFounded;
        }catch (Exception e){
            System.out.println("getting all Passenger problem: line 31: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Pasajero getOne(int id) {
        openConnection();
        String query = "Select * FROM pasajeros WHERE pasajeros.id_pasajero = ?";
        try{
            pstm = dbConnection.prepareStatement(query);
            pstm.setInt(1, id);
            ResultSet result = pstm.executeQuery();
            Pasajero tempPasajero  = new Pasajero();
            while (result.next()){
                tempPasajero.setId_pasajero(result.getInt("id_pasajero"));
                tempPasajero.setNombre(result.getString("nombre"));
                tempPasajero.setApellido(result.getString("apellido"));
                tempPasajero.setDocumento_identidad(result.getString("documento_identidad"));
            }
            closeConnection();
            return tempPasajero;
        }catch (Exception e){
            System.out.println("getting one Airplane problem: line 53: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        openConnection();
        String query = "DELETE FROM pasajeros WHERE pasajeros.id = ?";
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
    public boolean insertOne(Pasajero registro) {
        try {
            openConnection();
            String query = "INSERT INTO pasajeros( nombre, apellido, documento_identidad) VALUES( ?, ?,?)";
            pstm = dbConnection.prepareStatement(query);
            pstm.setString(1, registro.getNombre());
            pstm.setString(2, registro.getApellido());
            pstm.setString(3, registro.getDocumento_identidad());
            int rowAfected = pstm.executeUpdate();
            if(rowAfected>0){
                System.out.println("realizado " +  rowAfected);
                closeConnection();
                return true;
            }else{
                throw new Exception("There is no nothing in DB to update");
            }
        }catch (Exception e){
            System.out.println("Error Inserting Passenger: Model DB line 94" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateOne(Pasajero registro) {
        try{
            openConnection();
            String query = "UPDATE pasajeros SET nombre= ? , apellido = ?, documento_identidad=? WHERE id_pasajero= ? ";
            pstm = dbConnection.prepareStatement(query);
            pstm.setString(1, registro.getNombre());
            pstm.setString(2, registro.getApellido());
            pstm.setString(3, registro.getDocumento_identidad());
            pstm.setInt(4, registro.getId_pasajero());
            int rowAffected = pstm.executeUpdate();
            if(rowAffected>0){
                System.out.println("realizado " +  rowAffected);
                closeConnection();
                return true;
            }else{
                throw new Exception("There is no nothing in DB to update");
            }
        }catch (Exception e){
            System.out.println("Error Insering Speciality : Model DB line 58" + e.getMessage());
            return false;
        }
    }
}
