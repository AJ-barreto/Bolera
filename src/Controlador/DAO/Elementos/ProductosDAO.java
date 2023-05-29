/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO.Elementos;

import Modelo.Elementos.Modelo_productos;
import database.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Andor
 */
public class ProductosDAO {
    Connector connector = null;
    
    public ProductosDAO(){
        this.connector = new Connector();
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
            connector.getConnection().close();
        } catch(SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
        return lista;
    }
}
