/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO.Reserva;

import Controlador.DAO.Reserva.Interface.ClienteDaoInterface;
import Modelo.Reserva.Modelo_cliente;
import database.Connector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Andor
 */
public class ClienteDAO implements ClienteDaoInterface{
    Connector connector = null;
    
    public ClienteDAO(){
        this.connector = Connector.getInstance();
    }
    
    public ArrayList<Modelo_cliente> findAll(){
        String sql = "select * from CLIENTE"; 
        ArrayList<Modelo_cliente> lista = new ArrayList<>();
        
        try {
            Statement statement;
       
            statement = connector.getConnection().createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(sql);
        
            while (resultSet.next()) {
                Modelo_cliente model = new Modelo_cliente(
                   resultSet.getInt("ID_identificacion"),
                   resultSet.getString("Nombre"),
                   resultSet.getString("Fecha_nac"),
                   resultSet.getString("Genero"),
                   resultSet.getInt("Inactividad")
                );
                lista.add(model);
            }
            
            resultSet.close();
            statement.close();
            //connector.getConnection().close();
        } catch(SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
        return lista;
    }
    
    public void create(Modelo_cliente model) {
       String sql = "insert into CLIENTE (ID_identificacion, Nombre, Fecha_nac, Genero, Inactividad) values (?, ?, ?, ?, ?)";
       
        try{
            Modelo_cliente modelUpdate = (Modelo_cliente) model;
            
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            
            statement.setInt(1, modelUpdate.getId());
            statement.setString(2, modelUpdate.getNombre());
            statement.setString(3, modelUpdate.getFecha());
            statement.setString(4, modelUpdate.getGenero());
            statement.setInt(5, modelUpdate.getInactividad());
                    
            statement.executeUpdate();
            
            statement.close();
            //connector.getConnection().close();
        } catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    public void deleteById(int id) {
        String sql = "delete from CLIENTE where ID_identificacion = ?";
        
        try{            
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);            
            statement.setString(1, id + "");

            statement.executeUpdate();
            
            statement.close();
            //connector.getConnection().close();
        } catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    public void update(Modelo_cliente model) {
        String sql = "update CLIENTE set Nombre = ?, Fecha_nac = ?, Genero = ?, Inactividad = ? where ID_identificacion = ?";
       
        try{
            Modelo_cliente modelUpdate = (Modelo_cliente) model;
            
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            
            statement.setString(1, modelUpdate.getNombre());
            statement.setString(2, modelUpdate.getFecha());
            statement.setString(3, modelUpdate.getGenero());
            statement.setInt(4, modelUpdate.getInactividad());
            statement.setInt(5, modelUpdate.getId());
                    
            statement.executeUpdate();
            
            statement.close();
            //connector.getConnection().close();
        } catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    public Modelo_cliente findById(int id) {
        String sql = "select * from CLIENTE where ID_identificacion = ?";
        Modelo_cliente model = null;
         
        try{
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            ResultSet resultSet;
            
            statement.setInt(1, id);
                    
            resultSet = statement.executeQuery();
            
            if (resultSet.next()){
                model = new Modelo_cliente(
                   resultSet.getInt("ID_identificacion"),
                   resultSet.getString("Nombre"),
                   resultSet.getString("Fecha_nac"),
                   resultSet.getString("Genero"),
                   resultSet.getInt("Inactividad")
                );
            }
            
            resultSet.close();
            statement.close();
            //connector.getConnection().close();
        } catch(SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
        
        return model;
    }
}
