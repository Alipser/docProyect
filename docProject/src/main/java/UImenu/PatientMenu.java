package UImenu;

import Controllers.DoctorController;
import Controllers.PatientController;

import javax.swing.*;

import static UImenu.Menu.startMenu;

public class PatientMenu {

    public static void showMenuPatient(){
        PatientController patientController = new PatientController();
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
                    patientController.showLogs();
                    break;
                case 2:
                    patientController.delete();
                    break;
                case 3:
                    patientController.create();
                    break;
                case 4:
                    patientController.update();
                    break;
                case 5:
                    startMenu();
                    return;
            }
            showMenuPatient();
        }catch (Exception e){
            System.out.println((Integer) select);
            JOptionPane.showMessageDialog(null, "Only number characters are allowed" + e.getMessage());
            startMenu();
        }

    }



}
