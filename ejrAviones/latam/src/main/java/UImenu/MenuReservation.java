package UImenu;

import Controllers.ReservacionController;

import javax.swing.*;

import static UImenu.PrincipalMenu.startMenu;

public class MenuReservation {

    public  static void showMenuReservation() {

        ReservacionController respectiveController = new ReservacionController();
        String opcionesMenu = " 1. Show All Booking \n 2.Delete Booking By Id. \n 3. Create Booking. \n 4. Update Booking . \n 5.Exit";
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
                    respectiveController.create();
                    break;
                case 4:
                    respectiveController.update();
                    break;
                case 5:
                    startMenu();
                    return;
            }
            showMenuReservation();
        } catch (Exception e) {
            System.out.println((Integer) select);
            JOptionPane.showMessageDialog(null, "Only number characters are allowed" + e.getMessage());
            startMenu();
        }

    }

}
