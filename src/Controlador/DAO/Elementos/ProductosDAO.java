/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO.Elementos;

import Controlador.DAO.Elementos.Interface.ProductosDaoInterface;
import Modelo.Elementos.Modelo_productos;
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
public class ProductosDAO implements ProductosDaoInterface{
    Connector connector = null;
    
    public ProductosDAO(){
        this.connector = Connector.getInstance();
    }
    
    public ArrayList<Modelo_productos> findAll(){
        String sql = "select * from PRODUCTO_CONSUMIBLE"; 
        ArrayList<Modelo_productos> lista = new ArrayList<>();
        
        try {
            Statement statement;
       
            statement = connector.getConnection().createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(sql);
        
            while (resultSet.next()) {
                Modelo_productos model = new Modelo_productos(
                   resultSet.getInt("COD_producto"),
                   resultSet.getString("Descripcion"),
                   resultSet.getString("Tipo"),
                   resultSet.getInt("Valor_compra"),
                   resultSet.getInt("Valor_venta"),
                   resultSet.getInt("Cantidad_exist")
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
    
    public void create(Modelo_productos model) {
       String sql = "insert into PRODUCTO_CONSUMIBLE (COD_producto, Descripcion, Tipo, Valor_compra, Valor_venta, Cantidad_exist) values (?, ?, ?, ?, ?, ?)";
       
        try{
            Modelo_productos modelUpdate = (Modelo_productos) model;
            
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            
            statement.setInt(1, modelUpdate.getCod_producto());
            statement.setString(2, modelUpdate.getDescripcion());
            statement.setString(3, modelUpdate.getTipo());
            statement.setInt(4, modelUpdate.getValor_compra());
            statement.setInt(5, modelUpdate.getValor_venta());
            statement.setInt(6, modelUpdate.getCantidad());
                    
            statement.executeUpdate();
            
            statement.close();
            //connector.getConnection().close();
        } catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    public void deleteById(int id) {
        String sql2 = "SET FOREIGN_KEY_CHECKS = 0 ;";
        String sql = "delete from PRODUCTO_CONSUMIBLE where COD_producto = ?";
        
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
    
    public void update(Modelo_productos model) {
        String sql = "update PRODUCTO_CONSUMIBLE set Descripcion = ?, Tipo = ?, Valor_compra = ?, Valor_venta = ?, Cantidad_exist = ? where COD_producto = ?";
       
        try{
            Modelo_productos modelUpdate = (Modelo_productos) model;
            
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            
            statement.setString(1, modelUpdate.getDescripcion());
            statement.setString(2, modelUpdate.getTipo());
            statement.setInt(3, modelUpdate.getValor_compra());
            statement.setInt(4, modelUpdate.getValor_venta());
            statement.setInt(5, modelUpdate.getCantidad());
            statement.setInt(6, modelUpdate.getCod_producto());
                    
            statement.executeUpdate();
            
            statement.close();
            //connector.getConnection().close();
        } catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    public Modelo_productos findById(int id) {
        String sql = "select * from PRODUCTO_CONSUMIBLE where COD_producto = ?";
        Modelo_productos model = null;
         
        try{
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            ResultSet resultSet;
            
            statement.setInt(1, id);
                    
            resultSet = statement.executeQuery();
            
            if (resultSet.next()){
                model = new Modelo_productos(
                   resultSet.getInt("COD_producto"),
                   resultSet.getString("Descripcion"),
                   resultSet.getString("Tipo"),
                   resultSet.getInt("Valor_compra"),
                   resultSet.getInt("Valor_venta"),
                   resultSet.getInt("Cantidad_exist")
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
