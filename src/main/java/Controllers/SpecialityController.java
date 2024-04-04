package Controllers;

import Entitys.Patient;
import Entitys.Speciality;
import Models.SpecialityModel;
import jdk.jfr.Description;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SpecialityController {

    public SpecialityModel specialityModel = new SpecialityModel();
    public void showLogs(){
        List<Speciality> specialities = specialityModel.getall();
        String message = "";
        if(specialities != null && !specialities.isEmpty()){
            message = "Authors List:  \n";
            for (Speciality temp : specialities) {
                message += temp.toString() + "\n";
            }
            JOptionPane.showMessageDialog(null, message);
        }else{
            message =  "There are no Autors to show";
            JOptionPane.showMessageDialog(null, message);
        }




    }

    public void delete(){
        showLogs();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to find"));
        specialityModel.delete(id);
        JOptionPane.showMessageDialog(null, "Deleted Succesfully");
    }

    public void create(){
        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna
        JTextField name = new JTextField();
        JTextField descripcion = new JTextField();

        // Añadimos los componentes al panel
        panel.add(new JLabel("Speciality's name: "));
        panel.add(name);
        panel.add(new JLabel("Speciality's description: "));
        panel.add(descripcion);


        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Author's Data", JOptionPane.OK_CANCEL_OPTION);
        /*JOptionPane.showMessageDialog(null, "asdas", "asdasd", JOptionPane.DEFAULT_OPTION, panel, null, option, option[0]);*/

        if (result == JOptionPane.OK_OPTION) {
            String nameString = name.getText();
            String descriptionString = descripcion.getText();
            Speciality patientCreado = new Speciality(nameString, descriptionString);
            System.out.println(patientCreado.toString());
            JOptionPane.showMessageDialog(null, "Created Correctly");
            specialityModel.insertOne(patientCreado);
        }
    }

    public void update(){
        showLogs();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to find"));
        Speciality gettedSpeciality = specialityModel.getOne(id);
        JTextField name = new JTextField();
        JTextField descripcion = new JTextField();
        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna
        panel.add(new JLabel("Speciality's name: "));
        panel.add(name);
        panel.add(new JLabel("Speciality's description: "));
        panel.add(descripcion);
        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Author's Data", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String nameString = name.getText();
            String descripcionString = descripcion.getText();

            Speciality specialityCreado = new Speciality(nameString, descripcionString);
            System.out.println(specialityCreado.toString());
            specialityModel.updateOne(specialityCreado);
            JOptionPane.showMessageDialog(null, "Updated Correctly");
        }

    }
}
