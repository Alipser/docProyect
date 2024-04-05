package Controllers;

import Entitys.Avion;
import Entitys.Pasajero;
import Models.AvionModel;
import Models.PasajeroModel;

import javax.swing.*;
import java.awt.*;

public class PasajeroController {

    PasajeroModel pasajeroModel = new PasajeroModel();

    Generic<PasajeroModel, Pasajero>  generico =  new Generic<>(pasajeroModel);

    public void getAll(){
        generico.getAll();
    }

    public void delete(){
        generico.delete();
    }

    public  void getOneById(){
        generico.getOneById();
    }

    public void Create(){
        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna
        JTextField nombre = new JTextField();
        JTextField apellido = new JTextField();
        JTextField documento= new JTextField();



// Añadimos los componentes al panel
        panel.add(new JLabel("Passenger's Name: "));
        panel.add(nombre);
        panel.add(new JLabel("Passenger's Lastname :"));
        panel.add(apellido);
        panel.add(new JLabel("Passenger's ID :"));
        panel.add(documento);


        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Airplane's Data", JOptionPane.OK_CANCEL_OPTION);



        if (result == JOptionPane.OK_OPTION) {
            String nombreString = nombre.getText();
            String apellidodString = apellido.getText();
            String documentoString = documento.getText();
            Pasajero pasajeroCreado = new Pasajero(nombreString, apellidodString, documentoString);
            pasajeroModel.insertOne(pasajeroCreado);
            JOptionPane.showMessageDialog(null, "Created Correctly");
        }

    }

    public void update() {
        this.getAll();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to find"));
        Pasajero gettedPasajero = pasajeroModel.getOne(id);

        JTextField nombre = new JTextField();
        JTextField apellido = new JTextField();
        JTextField documento = new JTextField();

        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna

// Añadimos los componentes al panel
        panel.add(new JLabel("Passenger's Name: "));
        panel.add(nombre);
        nombre.setText(gettedPasajero.getNombre());
        panel.add(new JLabel("Passenger's Lastname :"));
        panel.add(apellido);
        apellido.setText(gettedPasajero.getApellido());
        panel.add(new JLabel("Passenger's ID :"));
        panel.add(documento);
        documento.setText(gettedPasajero.getDocumento_identidad());

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Airplane's Data", JOptionPane.OK_CANCEL_OPTION);


        if (result == JOptionPane.OK_OPTION) {
            String nombreString = nombre.getText();
            String apellidoString = apellido.getText();
            String documentoString = documento.getText();
            Pasajero pasajeroCreado = new Pasajero(gettedPasajero.getId_pasajero(), nombreString, apellidoString, documentoString);
            pasajeroModel.updateOne(pasajeroCreado);
            JOptionPane.showMessageDialog(null, "Inserted Correctly");
        }
    }
}
