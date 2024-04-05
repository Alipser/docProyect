package Controllers;

import Entitys.Pasajero;
import Entitys.Vuelo;
import Models.PasajeroModel;
import Models.VueloModel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class VueloController {

    AvionController avionController = new AvionController();
    VueloModel vueloModel = new VueloModel();
    Generic<VueloModel, Vuelo>  generico =  new Generic<>(vueloModel);

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
        avionController.getAll();
        int iddoc = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Airplane's Flight"));

        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna
        JTextField destino = new JTextField();
        JTextField fecha = new JTextField();
        JTextField hora= new JTextField();
        JTextField idAvion = new JTextField();

// Añadimos los componentes al panel
        panel.add(new JLabel("Flight destination"));
        panel.add(destino);
        panel.add(new JLabel("Flight Date :"));
        panel.add(fecha);
        panel.add(new JLabel("Flight Time :"));
        panel.add(hora);
        panel.add(new JLabel("Airplane Id :"));
        panel.add(idAvion);
        idAvion.setText(String.valueOf(iddoc));
        idAvion.setEditable(false);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Airplane's Data", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String destinoString = destino.getText();
            String fechaString = fecha.getText();
            String horaString= hora.getText();
            Vuelo vueloCreado = new Vuelo(destinoString, LocalDate.parse(fechaString), LocalTime.parse(horaString), iddoc);
            vueloModel.insertOne(vueloCreado);
            JOptionPane.showMessageDialog(null, "Created Correctly");
        }

    }

    public void update() {

        this.getAll();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to find"));
        Vuelo gettedVuelo = vueloModel.getOne(id);

        avionController.getAll();
        int iddoc = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Airplane's Flight"));

        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna
        JTextField destino = new JTextField();
        JTextField fecha = new JTextField();
        JTextField hora= new JTextField();
        JTextField idVuelo = new JTextField();

// Añadimos los componentes al panel
        panel.add(new JLabel("Flight destination"));
        panel.add(destino);
        panel.add(new JLabel("Flight Date :"));
        panel.add(fecha);
        panel.add(new JLabel("Flight Time :"));
        panel.add(hora);
        panel.add(new JLabel("Airplane Id :"));
        panel.add(idVuelo);
        idVuelo.setText(String.valueOf(iddoc));
        idVuelo.setEditable(false);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Airplane's Data", JOptionPane.OK_CANCEL_OPTION);


        if (result == JOptionPane.OK_OPTION) {
            String destinoString = destino.getText();
            String fechaString = fecha.getText();
            String horaString= hora.getText();
            Vuelo vueloCreado = new Vuelo(gettedVuelo.getId_vuelo(), destinoString, LocalDate.parse(fechaString), LocalTime.parse(horaString), id);
            vueloModel.updateOne(vueloCreado);
            JOptionPane.showMessageDialog(null, "Created Correctly");
        }
    }




}
