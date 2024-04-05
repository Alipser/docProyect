package Models;
import Entitys.Avion;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static  DBC.Conexion.*;

public class AvionModel implements IsCrudable<Avion> {


    @Override
    public List<Avion> getall() {
        openConnection();
        String query = "Select * from aviones";
        List<Avion> listFounded = new ArrayList<Avion>();
        try{
            pstm = dbConnection.prepareStatement(query);
            ResultSet result = pstm.executeQuery();
            while (result.next()){
                Avion tempAvion = new Avion();
                tempAvion.setId_avion(result.getInt("id_avion"));
                tempAvion.setCapacidad(result.getInt("capacidad"));
                tempAvion.setModelo(result.getNString("modelo"));
                listFounded.add(tempAvion);
            }
            dbConnection.close();
            dbConnection = null;
            return listFounded;
        }catch (Exception e){
            System.out.println("getting all Airplane problem: line 31: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Avion getOne(int id) {
        openConnection();
        String query = "Select * from aviones WHERE aviones.id_avion = ?";
        try{
            pstm = dbConnection.prepareStatement(query);
            pstm.setInt(1, id);
            ResultSet result = pstm.executeQuery();
            Avion tempAvion = new Avion();
            while (result.next()){
                tempAvion.setId_avion(result.getInt("id_avion"));
                tempAvion.setCapacidad(result.getInt("capacidad"));
                tempAvion.setModelo(result.getNString("modelo"));
            }
            closeConnection();
            return tempAvion;
        }catch (Exception e){
            System.out.println("getting one Airplane problem: line 53: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        openConnection();
        String query = "DELETE FROM aviones WHERE aviones.id_avion = ?";
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
    public boolean insertOne(Avion registro) {
        try {
            openConnection();
            String query = "INSERT INTO aviones( capacidad, modelo) VALUES( ?, ?)";
            pstm = dbConnection.prepareStatement(query);
            pstm.setInt(1, registro.getCapacidad());
            pstm.setString(2, registro.getModelo());
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
    public boolean updateOne(Avion registro) {
        try{
            openConnection();
            String query = "UPDATE aviones SET capacidad= ? , modelo = ?   WHERE aviones.id_avion = ? ";
            pstm = dbConnection.prepareStatement(query);
            pstm.setInt(1, registro.getCapacidad());
            pstm.setString(2, registro.getModelo());
            pstm.setInt(3, registro.getId_avion());
            int rowAffected = pstm.executeUpdate();
            if(rowAffected>0){
                System.out.println("realizado " +  rowAffected);
                closeConnection();
                return true;
            }else{
                throw new Exception("Jugando a tirar excepciones");
            }

        }catch (Exception e){
            System.out.println("Error Insering Speciality : Model DB line 58" + e.getMessage());
            return false;
        }
    }

}
