/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO.Elementos;

import Controlador.DAO.Elementos.Interface.PistaDaoInterface;
import Modelo.Elementos.Modelo_pista;
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
public class PistaDAO implements PistaDaoInterface{
    Connector connector = null;
    
    public PistaDAO(){
        this.connector = Connector.getInstance();
    }
    
    public ArrayList<Modelo_pista> findAll(){
        String sql = "select * from PISTA"; 
        ArrayList<Modelo_pista> lista = new ArrayList<>();
        
        try {
            Statement statement;
       
            statement = connector.getConnection().createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(sql);
        
            while (resultSet.next()) {
                Modelo_pista model = new Modelo_pista(
                   resultSet.getInt("NO_pista"),
                   resultSet.getString("Ubicacion"),
                   resultSet.getBoolean("Libre"),
                   resultSet.getBoolean("Activa")
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
    
    public void create(Modelo_pista model) {
       String sql = "insert into PISTA (Ubicacion, Libre, Activa) values (?, ?, ?)";
       
        try{
            Modelo_pista modelUpdate = (Modelo_pista) model;
            
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            
            //statement.setInt(1, modelUpdate.getNo_Pista());
            statement.setString(1, modelUpdate.getUbicacion());
            statement.setBoolean(2, modelUpdate.isLibre());
            statement.setBoolean(3, modelUpdate.isActivo());
                    
            statement.executeUpdate();
            
            statement.close();
            //connector.getConnection().close();
        } catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    public void deleteById(int id) {
        String sql2 = "SET FOREIGN_KEY_CHECKS = 0 ;";
        String sql = "delete from PISTA where NO_pista = ?";
        
        try{
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql2);            
            statement.executeUpdate();
            
            //PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);            
            statement.setString(1, id + "");

            statement.executeUpdate();
            
            statement.close();
            //connector.getConnection().close();
        } catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    public void update(Modelo_pista model) {
        String sql = "update PISTA set Ubicacion = ?, Libre = ?, Activa = ?  where NO_pista = ?";
       
        try{
            Modelo_pista modelUpdate = (Modelo_pista) model;
            
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            
            statement.setString(1, modelUpdate.getUbicacion());
            statement.setBoolean(2, modelUpdate.isLibre());
            statement.setBoolean(3, modelUpdate.isActivo());
            statement.setInt(4, modelUpdate.getNo_Pista());
                    
            statement.executeUpdate();
            
            statement.close();
            //connector.getConnection().close();
        } catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    public Modelo_pista findById(int id) {
        String sql = "select * from PISTA where NO_pista = ?";
        Modelo_pista model = null;
         
        try{
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            ResultSet resultSet;
            
            statement.setInt(1, id);
                    
            resultSet = statement.executeQuery();
            
            if (resultSet.next()){
                model = new Modelo_pista(
                   resultSet.getInt("NO_pista"),
                   resultSet.getString("Ubicacion"),
                   resultSet.getBoolean("Libre"),
                   resultSet.getBoolean("Activa"));
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
