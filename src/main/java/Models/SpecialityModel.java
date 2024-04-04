package Models;
import Entitys.Speciality;
import static  Conection.DbConection.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SpecialityModel implements IsCrudable<Speciality>{
    

    @Override
    public List<Speciality> getall() {
        openConnection();
        String query = "Select * from speciality";
        List<Speciality> listFounded = new ArrayList<>();
        try{
            pstm = dbConection.prepareStatement(query);
            ResultSet result = pstm.executeQuery();
            while (result.next()){
                Speciality tempSpeciality = new Speciality();
                tempSpeciality.setId_especialidad(result.getInt("id"));
                tempSpeciality.setNombre(result.getString("nombre"));
                tempSpeciality.setDescripcion(result.getString("descripcion"));
                listFounded.add(tempSpeciality);
            }
            dbConection.close();
            return listFounded;
        }catch (Exception e){
            System.out.println("getting all problem: line 18: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Speciality getOne(int id) {
        openConnection();
        String query = "Select * from speciality WHERE id = ?";
        try{
            pstm = dbConection.prepareStatement(query);
            pstm.setInt(1, id);
            ResultSet result = pstm.executeQuery();
            Speciality tempSpeciality = new Speciality();
            while (result.next()){
                tempSpeciality.setId_especialidad(result.getInt("id"));
                tempSpeciality.setNombre(result.getString("nombre"));
                tempSpeciality.setDescripcion(result.getString("descripcion"));
            }
            dbConection.close();
            return tempSpeciality;
        }catch (Exception e){
            System.out.println("getting all problem: line 18: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        try{
            openConnection();
            String query = "DELETE FROM speciality WHERE id = ?";
            pstm = dbConection.prepareStatement(query);
            pstm.setInt(1, id);
            boolean execution = pstm.execute();
            dbConection.close();
            return  execution;
        }catch (Exception e){
            System.out.println("Error Deleting speciality : Model DB Line 44"+ e.getMessage());
            return false;
        }
    }

    @Override
    public boolean insertOne(Speciality registro) {
        try {
            openConnection();
            String query = "INSERT INTO speciality(nombre, descripcion) VALUES(?, ?) ";
            pstm = dbConection.prepareStatement(query);
            pstm.setString(1, registro.getNombre());
            pstm.setString(2, registro.getDescripcion());
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

    @Override
    public boolean updateOne(Speciality registro) {
    try{
        openConnection();
        String query = "UPDATE speciality SET nombre = ? , descripcion = ?  WHERE id = ? ";
        pstm = dbConection.prepareStatement(query);
        pstm.setString(1, registro.getNombre());
        pstm.setString(2, registro.getDescripcion());
        pstm.setInt(3, registro.getId_especialidad());
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
