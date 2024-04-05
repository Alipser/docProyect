package UImenu;

import javax.swing.*;

import static UImenu.AppoimentMenu.showMenuAppoiment;
import static UImenu.DoctorMenu.showMenuDoctor;
import static UImenu.PatientMenu.showMenuPatient;
import static UImenu.SpecialityMenu.showMenuSpeciality;

public class Menu {

    public static void startMenu(){
        JDialog.setDefaultLookAndFeelDecorated(true);
        Object[] selectionValues = { "Doctors", "Appoiments", "Patients", "Specialities"};
        String initialSelection = "Doctors";
        Object selection = JOptionPane.showInputDialog(null, "Please, Select one option to Administrate",
                "Administration System", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        System.out.println(selection);
        if (selection == "Doctors"){
            showMenuDoctor();
        } else if (selection == "Appoiments") {
            showMenuAppoiment();
        }else if (selection == "Patients") {
            showMenuPatient();
        } else if (selection == "Specialities") {
            showMenuSpeciality();
        }else if (  selection == null) {
            return;
        }else{
            System.out.println("Author");
        }

    }
}
