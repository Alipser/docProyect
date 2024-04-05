package Controllers;

import Entitys.Avion;
import Models.AvionModel;

import javax.swing.*;
import java.awt.*;

public class AvionController {

    AvionModel avionModel = new AvionModel();

    Generic<AvionModel, Avion>  generico =  new Generic<>(avionModel);

    public void getAll(){
        generico.getAll();
    }

    public void delete(){
        generico.delete();
    }

    public  void getOneById(){
        generico.getOneById();
    }

    public void create(){
        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna
        JTextField modelo = new JTextField();
        JTextField capacidad = new JTextField();



// Añadimos los componentes al panel
        panel.add(new JLabel(" Airplane model: "));
        panel.add(modelo);
        panel.add(new JLabel("Passengers Allowed: "));
        panel.add(capacidad);


        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Airplane's Data", JOptionPane.OK_CANCEL_OPTION);
        /*JOptionPane.showMessageDialog(null, "asdas", "asdasd", JOptionPane.DEFAULT_OPTION, panel, null, option, option[0]);*/


        if (result == JOptionPane.OK_OPTION) {
            String modeloString = modelo.getText();
            String capacidadString = capacidad.getText();
            Avion avionCreado = new Avion(modeloString, Integer.parseInt(capacidadString));
            avionModel.insertOne(avionCreado);
            JOptionPane.showMessageDialog(null, "Created Correctly");
        }

    }

    public void update(){
        this.getAll();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to find"));
        Avion gettedAvion = avionModel.getOne(id);

        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna
        JTextField modelo = new JTextField();
        JTextField capacidad = new JTextField();



// Añadimos los componentes al panel
        panel.add(new JLabel(" Airplane model: "));
        panel.add(modelo);
        modelo.setText(gettedAvion.getModelo());
        panel.add(new JLabel("Passengers Allowed: "));
        panel.add(capacidad);
        capacidad.setText(String.valueOf(gettedAvion.getCapacidad()));

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Airplane's Data", JOptionPane.OK_CANCEL_OPTION);


        if (result == JOptionPane.OK_OPTION) {
            String modeloString = modelo.getText();
            String capacidadString = capacidad.getText();
            Avion avionCreado = new Avion(gettedAvion.getId_avion(), modeloString, Integer.parseInt(capacidadString));
            avionModel.updateOne(avionCreado);
            JOptionPane.showMessageDialog(null, "Inserted Correctly");
        }





    }





}
