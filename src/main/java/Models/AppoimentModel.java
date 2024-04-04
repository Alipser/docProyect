package Models;

import Entitys.Appoiment;
import Entitys.Doctor;
import Entitys.Patient;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static Conection.DbConection.*;

public class AppoimentModel implements IsCrudable<Appoiment>{
    @Override
    public List<Appoiment> getall() {
        openConnection();
        String query = "Select appoiment.id, patient_id, doctor_id, motivo, fecha, hora, doctor.id as doctor_id,doctor.nombre as doctor_name, doctor.apellidos as doctor_apellidos,doctor.id_especialidad, patient.nombre as patient_name, patient.apellidos as patient_apellidos, patient.nacimiento, patient.documento from appoiment INNER JOIN doctor on appoiment.doctor_id = doctor.id INNER JOIN patient on appoiment.patient_id =patient.id; ";
        List<Appoiment> listFounded = new ArrayList<>();
        try{
            pstm = dbConection.prepareStatement(query);
            ResultSet result = pstm.executeQuery();
            while (result.next()){
                Appoiment tempAppoimnet = new Appoiment();
                Doctor tempDoctor = new Doctor();
                Patient tempPatient = new Patient();

                tempPatient.setId_paciente(result.getInt("patient_id"));
                tempPatient.setNombre(result.getString("patient_name"));
                tempPatient.setApellidos(result.getString("patient_apellidos"));
                tempPatient.setDocumento_identidad(result.getString("documento"));
                tempPatient.setFecha_nacimiento(result.getString("nacimiento"));

                tempDoctor.setId_medico(result.getInt("doctor_id"));
                tempDoctor.setNombre(result.getString("doctor_name"));
                tempDoctor.setApellidos(result.getString("doctor_apellidos"));
                tempDoctor.setId_especialidad(result.getInt("id_especialidad"));

                tempAppoimnet.setId_paciente(result.getInt("patient_id"));
                tempAppoimnet.setId_medico(result.getInt("doctor_id"));
                tempAppoimnet.setMotivo(result.getString("motivo"));
                tempAppoimnet.setFecha_cita(LocalDate.parse(result.getString("fecha")));
                tempAppoimnet.setHora_cita(LocalTime.parse(result.getString("hora")));
                tempAppoimnet.setDoctor(tempDoctor);
                tempAppoimnet.setPatient(tempPatient);
                listFounded.add(tempAppoimnet);
            }
            dbConection.close();
            return listFounded;
        }catch (Exception e){
            System.out.println("getting all problem: line 18: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Appoiment getOne(int id) {
        openConnection();
        String query = "Select appoiment.id, patient_id, doctor_id, motivo, doctor.id as doctor_id,doctor.nombre as doctor_name, doctor.apellidos as doctor_apellidos,doctor.id_especialidad, patient.nombre as patient_name, patient.apellidos as patient_apellidos, patient.nacimiento, patient.documento from appoiment INNER JOIN doctor on appoiment.doctor_id = doctor.id INNER JOIN patient on appoiment.patient_id =patient.id; ";
        Appoiment tempAppoimnet = new Appoiment();
        try{
            pstm = dbConection.prepareStatement(query);
            ResultSet result = pstm.executeQuery();
            while (result.next()){

                Doctor tempDoctor = new Doctor();
                Patient tempPatient = new Patient();

                tempPatient.setId_paciente(result.getInt("patient_id"));
                tempPatient.setNombre(result.getString("patient_name"));
                tempPatient.setApellidos(result.getString("patient_apellidos"));
                tempPatient.setDocumento_identidad(result.getString("documento"));
                tempPatient.setFecha_nacimiento(result.getString("nacimiento"));

                tempDoctor.setId_medico(result.getInt("doctor_id"));
                tempDoctor.setNombre(result.getString("doctor_name"));
                tempDoctor.setApellidos(result.getString("doctor_apellidos"));
                tempDoctor.setId_especialidad(result.getInt("id_especialidad"));

                tempAppoimnet.setId_paciente(result.getInt("patient_id"));
                tempAppoimnet.setId_medico(result.getInt("doctor_id"));
                tempAppoimnet.setMotivo(result.getString("motivo"));
                tempAppoimnet.setFecha_cita(LocalDate.parse(result.getString("fecha")));
                tempAppoimnet.setHora_cita(LocalTime.parse(result.getString("hora")));
                tempAppoimnet.setDoctor(tempDoctor);
                tempAppoimnet.setPatient(tempPatient);
            }
            dbConection.close();
            return tempAppoimnet;
        }catch (Exception e){
            System.out.println("getting all problem: line 18: " + e.getMessage());
            return null;
        }

    }

    @Override
    public boolean delete(int id) {
        try{
            openConnection();
            String query = "DELETE FROM appoiment WHERE id = ?";
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
    public boolean insertOne(Appoiment registro) {
        try {
            openConnection();
            String query = "INSERT INTO appoiment(patient_id, doctor_id, motivo, fecha, hora) VALUES(?, ? , ?, ?, ?);";
            pstm = dbConection.prepareStatement(query);
            pstm.setInt(1, registro.getId_paciente());
            pstm.setInt(2, registro.getId_medico());
            pstm.setString(3, registro.getMotivo());
            pstm.setString(4,  registro.getFecha_cita().toString());
            pstm.setString(5, registro.getHora_cita().toString());
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
    public boolean updateOne(Appoiment registro) {
        try{
            openConnection();
            String query = "UPDATE appoiment SET(patient_id = ?, doctor_id = ?, motivo = ?, fecha = ?, hora = ?) WHERE id = ?;";
            pstm = dbConection.prepareStatement(query);
            pstm.setInt(1, registro.getId_paciente());
            pstm.setInt(2, registro.getId_medico());
            pstm.setString(3, registro.getMotivo());
            pstm.setString(4,  registro.getFecha_cita().toString());
            pstm.setString(5, registro.getHora_cita().toString());
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