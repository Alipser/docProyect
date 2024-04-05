package Conection;


public class testConection {

    public static void main(String[] args){
        DbConection.openConnection();
        DbConection.closeConnection();
        System.out.println(DbConection.dbConection);
        DbConection.openConnection();
        System.out.println(DbConection.dbConection);
    }
}
