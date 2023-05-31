/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO.Elementos;

import Controlador.DAO.Elementos.Interface.BolosDaoInterface;
import Modelo.Elementos.Modelo_bolos;
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
public class BolosDAO implements BolosDaoInterface{
    Connector connector = null;
    
    public BolosDAO(){
        this.connector = Connector.getInstance();
    }
    
    public ArrayList<Modelo_bolos> findAll(){
        String sql = "select * from ELEMENTO_BOLERA_BOLOS"; 
        ArrayList<Modelo_bolos> lista = new ArrayList<>();
        
        try {
            Statement statement;
       
            statement = connector.getConnection().createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(sql);
        
            while (resultSet.next()) {
                Modelo_bolos model = new Modelo_bolos(
                   resultSet.getInt("Cod_elemento"),
                   resultSet.getInt("Peso_bol"),
                   resultSet.getString("Color")
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
    
    public void create(Modelo_bolos model) {
       String sql = "insert into ELEMENTO_BOLERA_BOLOS (Peso_bol, Color) values (?, ?)";
       
        try{
            Modelo_bolos modelUpdate = (Modelo_bolos) model;
            
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            
            statement.setInt(1, modelUpdate.getPeso_bolo());
            statement.setString(2, modelUpdate.getColor());
                    
            statement.executeUpdate();
            
            statement.close();
            //connector.getConnection().close();
        } catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    public void deleteById(int id) {
        String sql = "delete from ELEMENTO_BOLERA_BOLOS where Cod_elemento = ?";
        
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
    
    public void update(Modelo_bolos model) {
        String sql = "update ELEMENTO_BOLERA_BOLOS set Peso_bol= ? , Color = ? where Cod_elemento = ?";
       
        try{
            Modelo_bolos modelUpdate = (Modelo_bolos) model;
            
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            
            statement.setInt(1, modelUpdate.getPeso_bolo());
            statement.setString(2, modelUpdate.getColor());
            statement.setInt(3, modelUpdate.getCod_elemento());
                    
            statement.executeUpdate();
            
            statement.close();
            //connector.getConnection().close();
        } catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    public Modelo_bolos findById(int id) {
        String sql = "select * from ELEMENTO_BOLERA_BOLOS where Cod_elemento = ?";
        Modelo_bolos model = null;
         
        try{
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            ResultSet resultSet;
            
            statement.setInt(1, id);
                    
            resultSet = statement.executeQuery();
            
            if (resultSet.next()){
                model = new Modelo_bolos(
                   resultSet.getInt("Cod_elemento"),
                   resultSet.getInt("Peso_bol"),
                   resultSet.getString("Color")
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
