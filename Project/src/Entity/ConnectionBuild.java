package Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionBuild {
    public static Connection getConnection(){
        Connection con = null;
        String url = "jdbc:derby://localhost:1527/sample";
        String username = "app";
        String password = "app";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con  =  DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionBuild.class.getName()).log(Level.SEVERE, null, ex);
        }         
        return con;
    }
}
