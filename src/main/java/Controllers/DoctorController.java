package Controllers;

import Entitys.Doctor;
import Models.DoctorModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DoctorController {

    public DoctorModel doctorModel = new DoctorModel();
    public void showLogs(){
        List<Doctor> doctors = doctorModel.getallDSpeciality();
        String message = "";
        if(doctors != null && !doctors.isEmpty()){
            message = "Doctors List:  \n";
            for (Doctor temp : doctors) {
                message += temp.toString() + "\n";
            }
            JOptionPane.showMessageDialog(null, message);
        }else{
            message =  "There are no Autors to show";
            JOptionPane.showMessageDialog(null, message);
        }
    }

    public void create(){
        String[] option = {"Ok, Cancel, Show Speciality"};
        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna
        JTextField name = new JTextField();
        JTextField apellidos = new JTextField();
        JTextField idEspecialidad = new JTextField();


// Añadimos los componentes al panel
        panel.add(new JLabel("Doc's name: "));
        panel.add(name);
        panel.add(new JLabel("Doc's Lastnames: "));
        panel.add(apellidos);
        panel.add(new JLabel("Doc's Speciality Id: "));
        panel.add(idEspecialidad);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Author's Data", JOptionPane.OK_CANCEL_OPTION);
        /*JOptionPane.showMessageDialog(null, "asdas", "asdasd", JOptionPane.DEFAULT_OPTION, panel, null, option, option[0]);*/


        if (result == JOptionPane.OK_OPTION) {
            String nameString = name.getText();
            String apellidosString = apellidos.getText();
            String idEspecialidadString = idEspecialidad.getText();
            Doctor doctorCreado = new Doctor(nameString, apellidosString, Integer.parseInt(idEspecialidadString));
            System.out.println(doctorCreado.toString());
            JOptionPane.showMessageDialog(null, "Created Correctly");
            doctorModel.insertOne(doctorCreado);
        }
    }

    public void update(){

        showLogs();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to find"));
        Doctor gettedDoctor = doctorModel.getOne(id);

        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna
        JTextField name = new JTextField();
        JTextField apellidos = new JTextField();
        JTextField idEspecialidad = new JTextField();


// Añadimos los componentes al panel
        panel.add(new JLabel("Doc's name: "));
        panel.add(name);
        name.setText(gettedDoctor.getNombre());
        panel.add(new JLabel("Doc's Lastnames: "));
        panel.add(apellidos);
        apellidos.setText(gettedDoctor.getApellidos());
        panel.add(new JLabel("Doc's Speciality Id: "));
        panel.add(idEspecialidad);
        idEspecialidad.setText(Integer.toString(gettedDoctor.getId_especialidad()));

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Author's Data", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String nameString = name.getText();
            String apellidosString = apellidos.getText();
            String idEspecialidadString = idEspecialidad.getText();
            Doctor doctorCreado = new Doctor(gettedDoctor.getId_medico() ,nameString, apellidosString, Integer.parseInt(idEspecialidadString));
            System.out.println(doctorCreado.toString());

            doctorModel.updateOne(doctorCreado);
            JOptionPane.showMessageDialog(null, "Updated Correctly");
        }

    }

    public void delete() {
        showLogs();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to find"));
        doctorModel.delete(id);
        JOptionPane.showMessageDialog(null, "Deleted Succesfully");
    }
}
