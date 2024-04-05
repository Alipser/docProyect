package UImenu;

import javax.swing.*;
import static UImenu.MenuAirplane.*;
import static UImenu.MenuPassenger.showMenuPassenger;
import static UImenu.MenuReservation.showMenuReservation;
import static UImenu.MenuVuelo.showMenuFlight;

public class PrincipalMenu {

    public static void startMenu(){
        JDialog.setDefaultLookAndFeelDecorated(true);
        Object[] selectionValues = { "Airplane", "Passenger", "BooKing", "Flights"};
        String initialSelection = "Doctors";
        Object selection = JOptionPane.showInputDialog(null, "Please, Select one option to Administrate",
                "Administration System", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        System.out.println(selection);
        if (selection == "Airplane"){
            showMenuAirplane();
        } else if (selection == "Passenger") {
           showMenuPassenger();
        }else if (selection == "BooKing") {
            showMenuReservation();
        } else if (selection == "Flights") {
            showMenuFlight();
        }else if (  selection == null) {
            return;
        }
    }



}
