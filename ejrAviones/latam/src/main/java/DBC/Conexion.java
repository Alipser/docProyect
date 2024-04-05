package DBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conexion {


    public static Connection dbConnection;
    public static PreparedStatement pstm;

    public Conexion() {
        dbConnection = null;
    }

    public static void openConnection(){
        if(dbConnection ==null){
            String user = "root";
            String password = "";
            String uriLike = "jdbc:mysql://127.0.0.1:3306/ejraviones";
            try{
                dbConnection = DriverManager.getConnection(uriLike, user, password);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("Already Connected");
        }

    }

    public static void closeConnection(){
        try{
            if (dbConnection !=null){
                dbConnection.close();
                dbConnection = null;
                System.out.println("Connection to DB has been closed");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
