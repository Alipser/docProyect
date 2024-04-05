package UImenu;

import Controllers.AvionController;

import javax.swing.*;
import static UImenu.PrincipalMenu.*;

public class MenuAirplane {


    public  static void showMenuAirplane(){

        AvionController avionController = new AvionController();
        String opcionesMenu = " 1. Show All Airplanes \n 2.Delete Aiplane By Id. \n 3. Create Airplane. \n 4. Update Airplane . \n 5.Exit";
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
                    avionController.getAll();
                    break;
                case 2:
                    avionController.delete();
                    break;
                case 3:
                    avionController.create();
                    break;
                case 4:
                    avionController.update();
                    break;
                case 5:
                    startMenu();
                    return;
            }
            showMenuAirplane();
        }catch (Exception e){
            System.out.println((Integer) select);
            JOptionPane.showMessageDialog(null, "Only number characters are allowed" + e.getMessage());
            startMenu();
        }

    }



}
