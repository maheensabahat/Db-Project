/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbproject;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;

/**
 *
 * @author Hp
 */
public class Database {

    static Connection con;
    static PreparedStatement pst;
    static Statement st;
    static ResultSet rs;

    public void openConnection() throws SQLException {
        if (con == null) {
            String url = "jdbc:mysql://localhost/";
            String dbName = "employeemanagementsystem";
            String driver = "com.mysql.cj.jdbc.Driver";
            String username = "root";
            String pass = "";
            try {
                Class.forName(driver);
                this.con = (Connection) DriverManager.getConnection(url + dbName, username, pass);
                System.out.println("Connected");

            } catch (ClassNotFoundException ex) {
                System.out.println("not Connected");

//                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
