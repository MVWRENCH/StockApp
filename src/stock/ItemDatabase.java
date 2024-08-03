/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author reynn
 */
public class ItemDatabase {
    private static Connection connection;
    
    public static Connection getConnection(){
        //pengecekan koneksi database
        // Load the JDBC driver
        if (connection==null){
            try{
              String username = "root";
              String password = "";
              String url = "jdbc:mysql://localhost:3306/stock";
              
                MysqlDataSource source = new MysqlDataSource();
              source.setUser(username);
              source.setPassword(password);
              source.setURL(url);
              
              connection = source.getConnection();
            } catch (SQLException ex){
              System.out.println("Error koneksi database");  
            }
        }       
        
        return connection;
    }
}
