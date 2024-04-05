package UImenu;

import Controllers.DoctorController;

import javax.swing.*;

import static UImenu.Menu.startMenu;


public class DoctorMenu {


    public static void showMenuDoctor(){
        DoctorController doctorController = new DoctorController();
        String opcionesMenu = " 1. Show Books with Autos \n 2.Delete Book By Id. \n 3. Create Book. \n 4. Update Book . \n 5.Exit";
        int select = 0;
        try {
            while (select <1 || select >5 ){
                select = Integer.parseInt(JOptionPane.showInputDialog(null, opcionesMenu));
                if(select <1 || select >5 ){
                    JOptionPane.showMessageDialog(null, "Please Enter a number between 1 and 5");
                }
            }
            switch (select){
                case 1:
                    doctorController.showLogs();
                    break;
                case 2:
                    doctorController.delete();
                    break;
                case 3:
                    doctorController.create();
                    break;
                case 4:
                    doctorController.update();
                    break;
                case 5:
                    startMenu();
                    return;
            }
            showMenuDoctor();
        }catch (Exception e){
            System.out.println((Integer) select);
            JOptionPane.showMessageDialog(null, "Only number characters are allowed" + e.getMessage());
            startMenu();
        }

    }
}
