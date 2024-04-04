package UImenu;

import Controllers.AppoimentController;
import Controllers.DoctorController;

import javax.swing.*;

import static UImenu.Menu.startMenu;

public class AppoimentMenu {

    public static void showMenuAppoiment(){
        AppoimentController appoimentController = new AppoimentController();
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
                    appoimentController.showLogs();
                    break;
                case 2:
                    appoimentController.delete();
                    break;
                case 3:
                    appoimentController.create();
                    break;
                case 4:
                    appoimentController.update();
                    break;
                case 5:
                    startMenu();
                    return;
            }
            showMenuAppoiment();
        }catch (Exception e){
            System.out.println((Integer) select);
            JOptionPane.showMessageDialog(null, "Only number characters are allowed" + e.getMessage());
            startMenu();
        }

    }


}
