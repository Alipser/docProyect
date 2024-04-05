package Models;

import Entitys.Doctor;
import Entitys.Patient;
import Entitys.Speciality;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static Conection.DbConection.*;

public class PatientModel implements IsCrudable<Patient> {
    @Override
    public List<Patient> getall() {
        openConnection();
        String query = "Select * from patient;";
        List<Patient> listFounded = new ArrayList<>();
        try{
            pstm = dbConection.prepareStatement(query);
            ResultSet result = pstm.executeQuery();
            while (result.next()){
                Patient tempPatient = new Patient();
                tempPatient.setNombre(result.getString("nombre"));
                tempPatient.setApellidos(result.getString("apellidos"));
                tempPatient.setFecha_nacimiento(result.getString("nacimiento"));
                tempPatient.setDocumento_identidad(result.getString("documento"));
                listFounded.add(tempPatient);
            }
            dbConection.close();
            return listFounded;
        }catch (Exception e){
            System.out.println("getting all problem: line 18: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Patient getOne(int id) {
        openConnection();
        String query = "Select * from patient WHERE id = ?";
        try {
            pstm = dbConection.prepareStatement(query);
            pstm.setInt(1, id);
            ResultSet result = pstm.executeQuery();
            Speciality tempSpeciality = new Speciality();
            Patient tempPatient = new Patient();
            while (result.next()) {
                tempPatient.setNombre(result.getString("nombre"));
                tempPatient.setApellidos(result.getString("apellidos"));
                tempPatient.setDocumento_identidad(result.getString("id_especialidad"));
                tempPatient.setFecha_nacimiento(result.getString("nacimiento"));
            }
            dbConection.close();
            return tempPatient;
        } catch (Exception e) {
            System.out.println("getting all problem: line 18: " + e.getMessage());
            return null;

        }
    }

    @Override
    public boolean delete(int id) {
        try{
            openConnection();
            String query = "DELETE FROM patient WHERE id = ?";
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
    public boolean insertOne(Patient registro) {
        try {
            openConnection();
            String query = "INSERT INTO patient(nombre, apellidos, nacimiento) VALUES(?, ?, ?) ";
            pstm = dbConection.prepareStatement(query);
            pstm.setString(1, registro.getNombre());
            pstm.setString(2, registro.getApellidos());
            pstm.setString(3, registro.getFecha_nacimiento());
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
    public boolean updateOne(Patient registro) {
        try {
            openConnection();
            String query = "UPDATE patient SET nombre = ? , apellidos = ? , nacimiento= ? WHERE id = ? ";
            pstm = dbConection.prepareStatement(query);
            pstm.setString(1, registro.getNombre());
            pstm.setString(2, registro.getApellidos());
            pstm.setString(3, registro.getFecha_nacimiento());
            pstm.setInt(4, registro.getId_paciente());
            int rowAffected = pstm.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("realizado " + rowAffected);
                closeConnection();
                return true;
            } else {
                throw new Exception("Jugando a tirar excepciones");
            }

        } catch (Exception e) {
            System.out.println("Error Insering Speciality : Model DB line 58" + e.getMessage());
            return false;
        }
    }

}
