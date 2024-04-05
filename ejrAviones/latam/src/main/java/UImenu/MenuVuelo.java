package UImenu;

import Controllers.AvionController;
import Controllers.PasajeroController;
import Controllers.VueloController;

import javax.swing.*;

import static UImenu.PrincipalMenu.startMenu;

public class MenuVuelo {

    public  static void showMenuFlight(){

        VueloController respectiveController = new VueloController();
        String opcionesMenu = " 1. Show All Flights \n 2.Delete Flights By Id. \n 3. Create Flights. \n 4. Update Flights . \n 5.Exit";
        int select = 0;
        try {
            while (select < 1 || select > 5) {
                select = Integer.parseInt(JOptionPane.showInputDialog(null, opcionesMenu));
                if (select < 1 || select > 5) {
                    JOptionPane.showMessageDialog(null, "Please Enter a number between 1 and 5");
                }
            }
            switch (select) {
                case 1:
                    respectiveController.getAll();
                    break;
                case 2:
                    respectiveController.delete();
                    break;
                case 3:
                    respectiveController.Create();
                    break;
                case 4:
                    respectiveController.update();
                    break;
                case 5:
                    startMenu();
                    return;
            }
            showMenuFlight();
        } catch (Exception e) {
            System.out.println((Integer) select);
            JOptionPane.showMessageDialog(null, "Only number characters are allowed" + e.getMessage());
            startMenu();
        }
    }
}
