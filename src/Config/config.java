/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.*;
import static java.sql.JDBCType.NULL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Moatez
 */

public class config {

    static config data;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/base?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private Connection conn;
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    
    
    private config() {
        try { 
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
        } catch (SQLException ex) {
            System.out.println("construct config");
            System.out.println(ex);
        }
    }

    public Connection getConnection() {
        System.out.println("success");
        return conn;
        
    }

    public static config getInstance() {
         if (data == null) {
          data = new config();   
         }
         return data;
        }

}