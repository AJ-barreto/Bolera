/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package database;

import java.sql.*;

public class Connector {
    private String userDatabase = "root";
    private String passwordDatabase = "123456";
    private String nameDatabase = "cine";
    
    private Connection connection = null;
    private static Connector conn;
    
    
    public Connector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + nameDatabase,
                userDatabase, passwordDatabase);
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }
    
    public static synchronized Connector getInstance(){
        if(conn == null){
            conn = new Connector();
        }
        
        return conn;
    }

    public Connection getConnection() {
        return connection;
    }
}
