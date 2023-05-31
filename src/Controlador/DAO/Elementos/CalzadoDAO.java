/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO.Elementos;

import Controlador.DAO.Elementos.Interface.CalzadoDaoInterface;
import Modelo.Elementos.Modelo_calzado;
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
public class CalzadoDAO implements CalzadoDaoInterface{
    Connector connector = null;
    
    public CalzadoDAO(){
        this.connector = Connector.getInstance();
    }
    
    public ArrayList<Modelo_calzado> findAll(){
        String sql = "select * from ELEMENTO_BOLERA_CALZADO"; 
        ArrayList<Modelo_calzado> lista = new ArrayList<>();
        
        try {
            Statement statement;
       
            statement = connector.getConnection().createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(sql);
        
            while (resultSet.next()) {
                Modelo_calzado model = new Modelo_calzado(
                   resultSet.getInt("Cod_calzado"),
                   resultSet.getInt("Calzado_numero"),
                   resultSet.getString("Calzado_color")
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
    
    public void create(Modelo_calzado model) {
       String sql = "insert into ELEMENTO_BOLERA_CALZADO (Calzado_numero, Calzado_color) values (?, ?)";
       
        try{
            Modelo_calzado modelUpdate = (Modelo_calzado) model;
            
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            
            statement.setInt(1, modelUpdate.getCalzado_numero());
            statement.setString(2, modelUpdate.getCalzado_color());
                    
            statement.executeUpdate();
            
            statement.close();
            //connector.getConnection().close();
        } catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    public void deleteById(int id) {
        String sql = "delete from ELEMENTO_BOLERA_CALZADO where Cod_calzado = ?";
        
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
    
    public void update(Modelo_calzado model) {
        String sql = "update ELEMENTO_BOLERA_CALZADO set Calzado_numero = ?, Calzado_color = ? where Cod_calzado = ?";
       
        try{
            Modelo_calzado modelUpdate = (Modelo_calzado) model;
            
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            
            statement.setInt(1, modelUpdate.getCalzado_numero());
            statement.setString(2, modelUpdate.getCalzado_color());
            statement.setInt(3, modelUpdate.getCod_calzado());
                    
            statement.executeUpdate();
            
            statement.close();
            //connector.getConnection().close();
        } catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    public Modelo_calzado findById(int id) {
        String sql = "select * from ELEMENTO_BOLERA_CALZADO where Cod_calzado = ?";
        Modelo_calzado model = null;
         
        try{
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            ResultSet resultSet;
            
            statement.setInt(1, id);
                    
            resultSet = statement.executeQuery();
            
            if (resultSet.next()){
                model = new Modelo_calzado(
                   resultSet.getInt("Cod_calzado"),
                   resultSet.getInt("Calzado_numero"),
                   resultSet.getString("Calzado_color"));
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
