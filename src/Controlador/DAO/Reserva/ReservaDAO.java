/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO.Reserva;


import Controlador.DAO.Reserva.Interface.ReservaDaoInterface;
import Modelo.Reserva.Modelo_reserva;
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
public class ReservaDAO implements ReservaDaoInterface{
    Connector connector = null;
    
    public ReservaDAO(){
        this.connector = Connector.getInstance();
    }
    
    public ArrayList<Modelo_reserva> findAll(){
        String sql = "select * from FORMA_DE_PAGO"; 
        ArrayList<Modelo_reserva> lista = new ArrayList<>();
        
        try {
            Statement statement;
       
            statement = connector.getConnection().createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(sql);
        
            while (resultSet.next()) {
                Modelo_reserva model = new Modelo_reserva(
                   resultSet.getInt("NO_reserva"),
                   resultSet.getString("Fecha_hora"),
                   resultSet.getBoolean("Estado"),
                   resultSet.getInt("Valor_total"),
                   resultSet.getInt("PISTA_NO_pista"),
                   resultSet.getInt("CLIENTE_ID_identificacion")
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
    
    public void create(Modelo_reserva model) {
       String sql = "insert into FORMA_DE_PAGO (NO_reserva, Fecha_hora, Estado, Valor_total, PISTA_NO_pista, CLIENTE_ID_identificacion) values (?, ?, ?, ?, ?, ?)";
       
        try{
            Modelo_reserva modelUpdate = (Modelo_reserva) model;
            
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            
            statement.setInt(1, modelUpdate.getNo_reserva());
            statement.setString(2, modelUpdate.getFecha());
            statement.setBoolean(3, modelUpdate.isEstado());
            statement.setInt(4, modelUpdate.getValor_total());
            statement.setInt(5, modelUpdate.getNo_pista());
            statement.setInt(6, modelUpdate.getId());
                    
            statement.executeUpdate();
            
            statement.close();
            //connector.getConnection().close();
        } catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    public void deleteById(int id) {
        String sql = "delete from FORMA_DE_PAGO where NO_reserva = ?";
        
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
    
    public void update(Modelo_reserva model) {
        String sql = "update FORMA_DE_PAGO set Fecha_hora = ?, Estado = ?, Valor_total = ?, PISTA_NO_pista = ?, CLIENTE_ID_identificacion = ? where NO_reserva = ?";
       
        try{
            Modelo_reserva modelUpdate = (Modelo_reserva) model;
            
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            
            statement.setString(1, modelUpdate.getFecha());
            statement.setBoolean(2, modelUpdate.isEstado());
            statement.setInt(3, modelUpdate.getValor_total());
            statement.setInt(4, modelUpdate.getNo_pista());
            statement.setInt(5, modelUpdate.getId());
            statement.setInt(6, modelUpdate.getNo_reserva());
                    
            statement.executeUpdate();
            
            statement.close();
            //connector.getConnection().close();
        } catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    public Modelo_reserva findById(int id) {
        String sql = "select * from FORMA_DE_PAGO where NO_reserva = ?";
        Modelo_reserva model = null;
         
        try{
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            ResultSet resultSet;
            
            statement.setInt(1, id);
                    
            resultSet = statement.executeQuery();
            
            if (resultSet.next()){
                model = new Modelo_reserva(
                   resultSet.getInt("NO_reserva"),
                   resultSet.getString("Fecha_hora"),
                   resultSet.getBoolean("Estado"),
                   resultSet.getInt("Valor_total"),
                   resultSet.getInt("PISTA_NO_pista"),
                   resultSet.getInt("CLIENTE_ID_identificacion"));
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
