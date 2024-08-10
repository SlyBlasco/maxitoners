/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maxitoners.conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luism
 */
public class Conector {

    private static final String url = "jdbc:mysql://localhost:3306/maxitoners";
    private static final String user = "root";
    private static final String contraseña = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, contraseña);
    }

    public static void main(String[] args) throws SQLException {
        getConnection();
        System.out.println("SE CONECTO A BD");
    }
}
