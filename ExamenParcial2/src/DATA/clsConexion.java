/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author geovanni
 */
public class clsConexion {
     public static Connection getConexion(){
         String Conexion = "jdbc:sqlserver://localhost:1433;databaseName=BOLETOS; "
                          + "user=sa; password=my-secret-pw; loginTimeout=30";
         try{
             Connection con = DriverManager.getConnection(Conexion);
             return con;
         }catch(SQLException ex){
             System.out.println(ex.toString());
             return null;
         }
     }
     
     
}
