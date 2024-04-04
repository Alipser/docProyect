package Controllers;

import Entitys.Doctor;
import Entitys.Patient;
import Models.PatientModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PatientController {

    public PatientModel PatientModel = new PatientModel();
    public void showLogs(){
        List<Patient> patients = PatientModel.getall();
        String message = "";
        if(patients != null && !patients.isEmpty()){
            message = "Patients List:  \n";
            for (Patient temp : patients) {
                message += temp.toString() + "\n";
            }
            JOptionPane.showMessageDialog(null, message);
        }else{
            message =  "There are no Patients to show";
            JOptionPane.showMessageDialog(null, message);
        }
    }

    public void delete() {
        showLogs();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to find"));
        PatientModel.delete(id);
        JOptionPane.showMessageDialog(null, "Deleted Succesfully");

    }


    public void create(){
        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna
        JTextField name = new JTextField();
        JTextField apellidos = new JTextField();
        JTextField nacimiento = new JTextField();
        JTextField documento = new JTextField();

    // Añadimos los componentes al panel
        panel.add(new JLabel("Pattient's name: "));
        panel.add(name);
        panel.add(new JLabel("Pattient's Lastnames: "));
        panel.add(apellidos);
        panel.add(new JLabel("Birth Date: "));
        panel.add(nacimiento);
        panel.add(new JLabel("ID Document"));
        panel.add(documento);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Author's Data", JOptionPane.OK_CANCEL_OPTION);
        /*JOptionPane.showMessageDialog(null, "asdas", "asdasd", JOptionPane.DEFAULT_OPTION, panel, null, option, option[0]);*/

        if (result == JOptionPane.OK_OPTION) {
            String nameString = name.getText();
            String apellidosString = apellidos.getText();
            String nacimientoString= nacimiento.getText();
            String documentoString= documento.getText();
            Patient patientCreado = new Patient( nameString, apellidosString, nacimientoString, documentoString);
            System.out.println(patientCreado.toString());
            JOptionPane.showMessageDialog(null, "Created Correctly");
            PatientModel.insertOne(patientCreado);
        }
    }

    public void update(){

        showLogs();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to find"));
        Patient gettedPattient = PatientModel.getOne(id);
        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna
        JTextField name = new JTextField();
        JTextField apellidos = new JTextField();
        JTextField nacimiento = new JTextField();
        JTextField documento = new JTextField();

        // Añadimos los componentes al panel
        panel.add(new JLabel("Patient's name: "));
        panel.add(name);
        panel.add(new JLabel("Patient's Lastnames: "));
        panel.add(apellidos);
        panel.add(new JLabel("Birth Date: "));
        panel.add(nacimiento);
        panel.add(new JLabel("ID Document"));
        panel.add(documento);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Author's Data", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String nameString = name.getText();
            String apellidosString = apellidos.getText();
            String nacimientoString= nacimiento.getText();
            String documentoString= documento.getText();
            Patient patientCreado = new Patient( gettedPattient.getId_paciente() ,nameString, apellidosString, nacimientoString, documentoString);
            System.out.println(gettedPattient.toString());
            PatientModel.updateOne(patientCreado);
            JOptionPane.showMessageDialog(null, "Updated Correctly");
        }

    }

}
