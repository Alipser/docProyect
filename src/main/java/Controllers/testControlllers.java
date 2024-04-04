package Controllers;

public class testControlllers {


    public static void main(String[] args){
        DoctorController prueba = new DoctorController();

        SpecialityController prueba2 = new SpecialityController();
        AppoimentController prueba3 = new AppoimentController();

        PatientController prueba4 = new PatientController();
        prueba3.showLogs();
    }
}
