package Controllers;

import Entitys.Avion;
import Entitys.Reservacion;
import Entitys.Vuelo;
import Models.ReservacionModel;
import Models.VueloModel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class ReservacionController {

    ReservacionModel reservacionModel = new ReservacionModel();
    VueloController vueloController = new VueloController();


    PasajeroController pasajeroController= new PasajeroController();

    VueloModel vueloModel = new VueloModel();


    Generic<ReservacionModel, Reservacion>  generico =  new Generic<>(reservacionModel);

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



        vueloController.getAll();
        int iddoc = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Fligth ID for Booking"));

        Vuelo vueloq = vueloModel.getOne(iddoc);
        System.out.println(vueloq.toString());
        Avion avionq = vueloq.getAvion();
        int capacidad = avionq.getCapacidad();

        int sillas = reservacionModel.getNumberOfSitsReserved(iddoc);

        if (capacidad>sillas){
            pasajeroController.getAll();
            int idPas = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Passenger ID"));

            JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna
            JTextField aciento = new JTextField();
            JTextField fecha = new JTextField();
            JTextField idPasajero= new JTextField();
            JTextField idVuelo = new JTextField();

            // Añadimos los componentes al panel
            panel.add(new JLabel("Enter your Sit"));
            panel.add(aciento);
            panel.add(new JLabel("Flight Date :"));
            panel.add(fecha);
            panel.add(new JLabel("Selected Passenger ID:"));
            panel.add(idPasajero);
            idPasajero.setText(String.valueOf(idPas));
            idPasajero.setEditable(false);
            panel.add(new JLabel("Flight Id :"));
            panel.add(idVuelo);
            idVuelo.setText(String.valueOf(iddoc));
            idVuelo.setEditable(false);
            int result = JOptionPane.showConfirmDialog(null, panel, "Enter Booking Data", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                String acientooString = aciento.getText();
                String fechaString = fecha.getText();
                String idpasString= idPasajero.getText();
                String idflight = idVuelo.getText();
                Reservacion reservacionCreada = new Reservacion( Integer.parseInt(idpasString),Integer.parseInt(idflight), LocalDate.parse(fechaString), acientooString);
                reservacionModel.insertOne(reservacionCreada);
                JOptionPane.showMessageDialog(null, "Created Correctly");
            }

        }else{
            JOptionPane.showMessageDialog(null, "The Flight is full, Search another flight");
            this.create();
        }


    }

    public void update(){
        this.getAll();
        int resId = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Reservation tu update"));

        vueloController.getAll();
        int iddoc = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Fligth ID for Booking"));

        pasajeroController.getAll();
        int idPas = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Passenger ID"));

        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna
        JTextField aciento = new JTextField();
        JTextField fecha = new JTextField();
        JTextField idPasajero= new JTextField();
        JTextField idVuelo = new JTextField();

        // Añadimos los componentes al panel
        panel.add(new JLabel("Enter your Sit"));
        panel.add(aciento);
        panel.add(new JLabel("Flight Date :"));
        panel.add(fecha);
        panel.add(new JLabel("Selected Passenger ID:"));
        panel.add(idPasajero);
        idPasajero.setText(String.valueOf(idPas));
        idPasajero.setEditable(false);
        panel.add(new JLabel("Flight Id :"));
        panel.add(idVuelo);
        idVuelo.setText(String.valueOf(iddoc));
        idVuelo.setEditable(false);
        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Booking Data", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String acientooString = aciento.getText();
            String fechaString = fecha.getText();
            String idpasString= idPasajero.getText();
            String idflight = idVuelo.getText();
            Reservacion reservacionCreada = new Reservacion(Integer.parseInt(idpasString), Integer.parseInt(idflight), LocalDate.parse(fechaString), acientooString);
            reservacionModel.updateOne(reservacionCreada);
            JOptionPane.showMessageDialog(null, "Created Correctly");
        }

    }
}
