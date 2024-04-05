package Conection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbConection {

    public static Connection dbConection;

    public static PreparedStatement pstm;

    public DbConection(){
        dbConection = null;
        pstm = null;
    }

    public static void openConnection(){
        try{
            String user = "root";
            String password = "";
            String uriLike = "jdbc:mysql://127.0.0.1:3306/doc_ejercicio";
            dbConection = DriverManager.getConnection(uriLike, user, password);
            System.out.println( "Now you are connected to  DB" + uriLike );
        }catch (Exception e){
            System.out.println( e.getMessage());
        }
    }

    public  static void closeConnection(){
        try{
            if (dbConection !=null){
                dbConection.close();
                dbConection = null;
                System.out.println("Connection to DB has been closed");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
