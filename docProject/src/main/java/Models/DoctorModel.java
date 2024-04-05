package Models;

import Entitys.Doctor;
import Entitys.Speciality;

import javax.print.Doc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static Conection.DbConection.*;

public class DoctorModel implements IsCrudable <Doctor> {
    @Override
    public List<Doctor> getall() {
        openConnection();
        String query = "Select * from doctor";
        List<Doctor> listFounded = new ArrayList<Doctor>();
        try{
            pstm = dbConection.prepareStatement(query);
            ResultSet result = pstm.executeQuery();
            while (result.next()){
                Doctor tempDoctor = new Doctor();
                tempDoctor.setId_medico(result.getInt("id"));
                tempDoctor.setNombre(result.getString("nombre"));
                tempDoctor.setApellidos(result.getString("apellidos"));
                tempDoctor.setId_especialidad(result.getInt("id_especialidad"));
                listFounded.add(tempDoctor);
            }
            dbConection.close();
            return listFounded;
        }catch (Exception e){
            System.out.println("getting all problem: line 18: " + e.getMessage());
            return null;
        }
    }

    public List<Doctor> getallDSpeciality() {
        openConnection();
        String query = "Select *, speciality.nombre as speciality_name from doctor INNER JOIN speciality on doctor.id_especialidad = speciality.id ";
        List<Doctor> listFounded = new ArrayList<Doctor>();
        try{
            pstm = dbConection.prepareStatement(query);
            ResultSet result = pstm.executeQuery();
            while (result.next()){
                Doctor tempDoctor = new Doctor();
                Speciality tempSpeciality = new Speciality();
                tempDoctor.setId_especialidad(result.getInt("id"));
                tempDoctor.setNombre(result.getString("nombre"));
                tempDoctor.setApellidos(result.getString("apellidos"));
                tempDoctor.setId_especialidad(result.getInt("id_especialidad"));
                tempSpeciality.setId_especialidad(result.getInt("id_especialidad"));
                tempSpeciality.setNombre(result.getString("speciality_name"));
                tempSpeciality.setDescripcion(result.getString("descripcion"));
                tempDoctor.setSpeciality(tempSpeciality);
                listFounded.add(tempDoctor);
            }
            dbConection.close();
            return listFounded;
        }catch (Exception e){
            System.out.println("getting all problem: line 18: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Doctor getOne(int id) {
        openConnection();
        String query = "Select *, doctor.id as doc_id from doctor INNER JOIN speciality on doctor.id_especialidad = speciality.id  WHERE doctor.id = ?";
        try{
            pstm = dbConection.prepareStatement(query);
            pstm.setInt(1, id);
            ResultSet result = pstm.executeQuery();
            Speciality tempSpeciality = new Speciality();
            Doctor tempDoctor = new Doctor();
            while (result.next()){
                tempDoctor.setId_medico(result.getInt("doc_id"));
                tempDoctor.setNombre(result.getString("nombre"));
                tempDoctor.setApellidos(result.getString("apellidos"));
                tempDoctor.setId_especialidad(result.getInt("id_especialidad"));
                tempSpeciality.setId_especialidad(result.getInt("id_especialidad"));
                tempSpeciality.setNombre(result.getString("nombre"));
                tempSpeciality.setDescripcion(result.getString("descripcion"));
                tempDoctor.setSpeciality(tempSpeciality);
            }
            dbConection.close();
            return tempDoctor;
        }catch (Exception e){
            System.out.println("getting all problem: line 18: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        try{
            openConnection();
            String query = "DELETE FROM doctor WHERE id = ?";
            pstm = dbConection.prepareStatement(query);
            pstm.setInt(1, id);
            boolean execution = pstm.execute();
            dbConection.close();
            return  execution;
        }catch (Exception e){
            System.out.println("Error Deleting Doctor : Model DB Line 106"+ e.getMessage());
            return false;
        }
    }

    @Override
    public boolean insertOne(Doctor registro) {
        try {
            openConnection();
            String query = "INSERT INTO doctor(nombre, apellidos, id_especialidad) VALUES(?, ?, ?)";
            pstm = dbConection.prepareStatement(query);
            pstm.setString(1, registro.getNombre());
            pstm.setString(2, registro.getApellidos());
            pstm.setInt(3, registro.getId_especialidad());
            int rowAfected = pstm.executeUpdate();
            if(rowAfected>0){
                System.out.println("realizado " +  rowAfected);
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
    public boolean updateOne(Doctor registro) {
        try{
            openConnection();
            String query = "UPDATE doctor SET nombre = ? , apellidos = ?, id_especialidad = ?   WHERE id = ? ";
            pstm = dbConection.prepareStatement(query);
            pstm.setString(1, registro.getNombre());
            pstm.setString(2, registro.getApellidos());
            pstm.setInt(3, registro.getId_especialidad());
            pstm.setInt(4, registro.getId_medico() );
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
