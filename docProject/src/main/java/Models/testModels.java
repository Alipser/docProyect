package Models;

import Entitys.Doctor;
import Entitys.Speciality;

public class testModels {





    public static void main (String[] args){
        Speciality prueba = new Speciality("Especialidad Prueba", "Test01");
        SpecialityModel aVer = new SpecialityModel();
        DoctorModel averDoctor = new DoctorModel();
        Doctor pruebaDoc =  new Doctor("Roma", "Julio", 1);

        averDoctor.insertOne(pruebaDoc);





    }
}
