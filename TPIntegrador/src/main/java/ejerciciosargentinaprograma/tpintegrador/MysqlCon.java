
package ejerciciosargentinaprograma.tpintegrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class MysqlCon {
    public static void main(String args[]){
        
                
         try{
              Class.forName("com.mysql.jdbc.Driver");
              Connection
                      con=DriverManager.getConnection("\"jdbc:mysql://localhost:3306/tpintegrador\",\"root\",\"");
              Statement stmt=con.createStatement();
              System.out.println("Conexion exitosa");
              //USO DE LA DB
              con.close();
              System.out.println("Conexion cerrada");
         }catch (Exception e){ System.out.println(e);}


    
    }

}