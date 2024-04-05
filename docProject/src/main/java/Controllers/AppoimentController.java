package Controllers;

import Entitys.Appoiment;
import Entitys.Doctor;
import Models.AppoimentModel;
import Models.DoctorModel;
import Models.PatientModel;


import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AppoimentController {
    public AppoimentModel appoimentModel = new AppoimentModel();
    public DoctorController doctorController = new DoctorController();
    public PatientController patientController = new PatientController();
    public void showLogs(){
        List<Appoiment> citas = appoimentModel.getall();
        String message = "";
        if(citas != null && !citas.isEmpty()){
            message = "Doctors List:  \n";
            for (Appoiment temp : citas) {
                message += temp.toString() + "\n";
            }
            JOptionPane.showMessageDialog(null, message);
        }else{
            message =  "There are no Appoiments to show";
            JOptionPane.showMessageDialog(null, message);
        }
    }

    public void delete(){
        showLogs();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to delete"));
        appoimentModel.delete(id);
        JOptionPane.showMessageDialog(null, "Deleted Succesfully");
    }

    public void update(){

        showLogs();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter appoiment id to update"));
        Appoiment gettedAppoiment = appoimentModel.getOne(id);

        doctorController.showLogs();
        int iddoc = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Doctor id to update"));
        patientController.showLogs();
        int idpat = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Patient id to update"));

        JPanel panel = new JPanel(new GridLayout(5, 2)); // 5 filas y 1 columna
        JTextField fecha = new JTextField();
        JTextField hora = new JTextField();
        JTextField motivo = new JTextField();

        // Añadimos los componentes al panel
        panel.add(new JLabel("Appoiment's Reason"));
        panel.add(motivo);
        motivo.setText(gettedAppoiment.getMotivo());
        panel.add(new JLabel("Appoiment's Date: "));
        panel.add(fecha);
        fecha.setText(gettedAppoiment.getHora_cita().toString());
        panel.add(new JLabel("Appoiment's Time: "));
        panel.add(hora);
        hora.setText(gettedAppoiment.getHora_cita().toString());

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Author's Data", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String fechaString = fecha.getText();
            String horaString = hora.getText();
            String motivoString = motivo.getText();


            Appoiment citaCreado = new Appoiment(gettedAppoiment.getId_cita(), idpat, iddoc, LocalDate.parse(fechaString), LocalTime.parse(horaString), gettedAppoiment.getMotivo());
            System.out.println(citaCreado.toString());

            appoimentModel.updateOne(citaCreado);
            JOptionPane.showMessageDialog(null, "Updated Correctly");
        }

    }

    public void create(){
        String[] option = {"Ok, Cancel, Show Speciality"};
        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna
        JTextField idDoc = new JTextField();
        JTextField idPatient = new JTextField();
        JTextField hora = new JTextField();
        JTextField fecha = new JTextField();
        JTextField motivo = new JTextField();


// Añadimos los componentes al panel
        panel.add(new JLabel("Doc's id: "));
        panel.add(idDoc);
        panel.add(new JLabel("patient's id: "));
        panel.add(idPatient);
        panel.add(new JLabel("Reason: "));
        panel.add(motivo);
        panel.add(new JLabel("Date - YYYY-MM-DD"));
        panel.add(fecha);
        panel.add(new Label("Time hh:mm:ss"));
        panel.add(hora);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Author's Data", JOptionPane.OK_CANCEL_OPTION);
        /*JOptionPane.showMessageDialog(null, "asdas", "asdasd", JOptionPane.DEFAULT_OPTION, panel, null, option, option[0]);*/


        if (result == JOptionPane.OK_OPTION) {
            String idDocString = idDoc.getText();
            String idPatientString = idPatient.getText();
            String fechaString = fecha.getText();
            String horaString = hora.getText();
            String motivoString = motivo.getText();
            Appoiment appoimentCreado = new Appoiment(Integer.parseInt(idPatientString), Integer.parseInt(idDocString), LocalDate.parse(fechaString), LocalTime.parse(horaString), motivoString);
            System.out.println(appoimentCreado.toString());
            appoimentModel.insertOne(appoimentCreado);
            JOptionPane.showMessageDialog(null, "Created Correctly");
        }
    }






}
