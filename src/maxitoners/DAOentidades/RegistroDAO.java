/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maxitoners.DAOentidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import maxitoners.conector.Conector;
import maxitoners.entidades.Registro;

/**
 *
 * @author luism
 */
public class RegistroDAO {
    public List<Registro> getAllRegistros() throws SQLException {
        List<Registro> registros = new ArrayList<>();
        String query = "SELECT r.id, i.marca AS marca, i.modelo AS modelo, c.nombre AS cliente, r.num_impresiones, r.fecha\n" +
                        "FROM registros r\n" +
                        "JOIN clientes c ON r.id_cliente = c.id \n"+
                        "JOIN impresoras i ON r.id_impresora = i.id;";
        try (Connection connection = Conector.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Registro registro = new Registro(resultSet.getInt("id"), resultSet.getString("modelo"), resultSet.getString("marca"),
                        resultSet.getString("cliente"), resultSet.getInt("num_impresiones"), resultSet.getDate("fecha"));
                registros.add(registro);
            }
        }
        return registros;
    }
/*
    public List<Cliente> getByIDImpresora(String filtro) {
        List<Cliente> clientes = new ArrayList<>();
        try {
            Connection conexion = Conector.getConnection();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM clientes WHERE nombre LIKE ?");
            statement.setString(1, "%" + filtro + "%");
            ResultSet resultSet = statement.executeQuery();
            boolean existeResultados = false;

            while (resultSet.next()) {
                existeResultados = true;
                Cliente c = new Cliente(resultSet.getInt("id"), resultSet.getString("nombre"),
                        resultSet.getString("direccion"), resultSet.getString("contacto"), resultSet.getString("rfc"));
                clientes.add(c);
            }
            if (existeResultados == false) {
                clientes = getByDireccion(filtro);
            }
        } catch (SQLException e) {
            System.err.print("Error:" + e.getMessage());
        }

        return clientes;
    }

    public List<Cliente> getByDireccion(String filtro) {
        List<Cliente> clientes = new ArrayList<>();
        try {
            Connection conexion = Conector.getConnection();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM clientes WHERE direccion LIKE ?");
            statement.setString(1, "%" + filtro + "%");
            ResultSet resultSet = statement.executeQuery();
            boolean existeResultados = false;
            
            while (resultSet.next()) {
                existeResultados = true;
                Cliente c = new Cliente(resultSet.getInt("id"), resultSet.getString("nombre"),
                        resultSet.getString("direccion"), resultSet.getString("contacto"), resultSet.getString("rfc"));
                clientes.add(c);
            }
            
            if (existeResultados == false) {
                clientes = getByRFC(filtro);
            }
        } catch (SQLException e) {
            System.err.print("Error:" + e.getMessage());
        }

        return clientes;
    }
    
    public List<Cliente> getByRFC(String filtro) {
        List<Cliente> clientes = new ArrayList<>();
        try {
            Connection conexion = Conector.getConnection();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM clientes WHERE rfc LIKE ?");
            statement.setString(1, "%" + filtro + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Cliente c = new Cliente(resultSet.getInt("id"), resultSet.getString("nombre"),
                        resultSet.getString("direccion"), resultSet.getString("contacto"), resultSet.getString("rfc"));
                clientes.add(c);
            }
        } catch (SQLException e) {
            System.err.print("Error:" + e.getMessage());
        }

        return clientes;
    }

*/
}
