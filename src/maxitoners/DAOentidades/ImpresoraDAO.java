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
import maxitoners.entidades.Impresora;

/**
 *
 * @author luism
 */
public class ImpresoraDAO {
    public List<Impresora> getAllImpresoras() throws SQLException {
        List<Impresora> impresoras = new ArrayList<>();
        String query = "SELECT * FROM impresoras";
        try (Connection connection = Conector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Impresora impresora = new Impresora(resultSet.getInt("id"), resultSet.getString("numero_serie"),
                                        resultSet.getString("marca"), resultSet.getString("modelo"), resultSet.getInt("cliente_id"));
                impresoras.add(impresora);
            }
        }
        return impresoras;
    }
    
    public List<Impresora> getByMarca(String filtro) {
        List<Impresora> impresoras = new ArrayList<>();
        try {
            Connection conexion = Conector.getConnection();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM impresoras WHERE marca LIKE ?");
            statement.setString(1, "%" + filtro + "%");
            ResultSet resultSet = statement.executeQuery();
            boolean existeResultados = false;

            while (resultSet.next()) {
                existeResultados = true;
                Impresora im = new Impresora(resultSet.getInt("id"), resultSet.getString("numero_serie"),
                        resultSet.getString("marca"), resultSet.getString("modelo"), resultSet.getInt("cliente_id"));
                impresoras.add(im);
            }
            if (existeResultados == false) {
                impresoras = getByModelo(filtro);
            }
        } catch (SQLException e) {
            System.err.print("Error:" + e.getMessage());
        }

        return impresoras;
    }

    public List<Impresora> getByModelo(String filtro) {
        List<Impresora> impresoras = new ArrayList<>();
        try {
            Connection conexion = Conector.getConnection();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM impresoras WHERE modelo LIKE ?");
            statement.setString(1, "%" + filtro + "%");
            ResultSet resultSet = statement.executeQuery();
            boolean existeResultados = false;

            while (resultSet.next()) {
                existeResultados = true;
                Impresora im = new Impresora(resultSet.getInt("id"), resultSet.getString("numero_serie"),
                        resultSet.getString("marca"), resultSet.getString("modelo"), resultSet.getInt("cliente_id"));
                impresoras.add(im);
            }
            if (existeResultados == false) {
                impresoras = getByNoSerie(filtro);
            }
        } catch (SQLException e) {
            System.err.print("Error:" + e.getMessage());
        }

        return impresoras;
    }
    
    public List<Impresora> getByNoSerie(String filtro) {
        List<Impresora> impresoras = new ArrayList<>();
        try {
            Connection conexion = Conector.getConnection();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM impresoras WHERE numero_serie LIKE ?");
            statement.setString(1, "%" + filtro + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Impresora im = new Impresora(resultSet.getInt("id"), resultSet.getString("numero_serie"),
                        resultSet.getString("marca"), resultSet.getString("modelo"), resultSet.getInt("cliente_id"));
                impresoras.add(im);
            }
        } catch (SQLException e) {
            System.err.print("Error:" + e.getMessage());
        }

        return impresoras;
    }
    
    public Impresora getByNoSerieIND(String filtro) {
        Impresora im = null;
        try {
            Connection conexion = Conector.getConnection();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM impresoras WHERE numero_serie LIKE ?");
            statement.setString(1, "%" + filtro + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            im = new Impresora(resultSet.getInt("id"), resultSet.getString("numero_serie"),
                    resultSet.getString("marca"), resultSet.getString("modelo"), resultSet.getInt("cliente_id"));
            }
        } catch (SQLException e) {
            System.err.print("Error:" + e.getMessage());
        }
        return im;
    }
}
