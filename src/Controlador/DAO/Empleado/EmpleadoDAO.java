/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO.Empleado;


import Controlador.DAO.Empleado.Interface.EmpleadoDaoInterface;
import Modelo.Empleado.Modelo_empleado;
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
public class EmpleadoDAO implements EmpleadoDaoInterface{
    Connector connector = null;
    
    public EmpleadoDAO(){
        this.connector = Connector.getInstance();
    }
    
    public ArrayList<Modelo_empleado> findAll(){
        String sql = "select * from EMPLEADO"; 
        ArrayList<Modelo_empleado> lista = new ArrayList<>();
        
        try {
            Statement statement;
       
            statement = connector.getConnection().createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(sql);
        
            while (resultSet.next()) {
                Modelo_empleado model = new Modelo_empleado(
                   resultSet.getInt("ID_empleado"),
                   resultSet.getInt("Cedula"),
                   resultSet.getString("Nombre"),
                   resultSet.getString("Fecha_nac"),
                   resultSet.getString("Genero"),
                   resultSet.getInt("Sueldo"),
                   resultSet.getBoolean("Vacaciones")
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
    
    public void create(Modelo_empleado model) {
       String sql = "INSERT INTO EMPLEADO (Cedula, Nombre, Fecha_nac, Genero, Sueldo, Vacaciones) VALUES (?, ?, ?, ?, ?, ?)";
       
        try{
            Modelo_empleado modelUpdate = (Modelo_empleado) model;
            
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            
            statement.setInt(1, modelUpdate.getCedula());
            statement.setString(2, modelUpdate.getNombre());
            statement.setString(3, modelUpdate.getFecha());
            statement.setString(4, modelUpdate.getGenero());
            statement.setInt(5, modelUpdate.getSueldo());
            statement.setBoolean(6, modelUpdate.isVacaciones());
                    
            statement.executeUpdate();
            
            statement.close();
            //connector.getConnection().close();
        } catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    public void deleteById(int id) {
        String sql = "delete from EMPLEADO where ID_empleado = ?";
        
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
    
    public void update(Modelo_empleado model) {
        String sql = "update EMPLEADO set Cedula = ?, Nombre = ? , Fecha_nac = ?, Genero = ?, Sueldo = ?, Vacaciones = ? where ID_empleado = ?";
       
        try{
            Modelo_empleado modelUpdate = (Modelo_empleado) model;
            
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            
            
            statement.setInt(1, modelUpdate.getCedula());
            statement.setString(2, modelUpdate.getNombre());
            statement.setString(3, modelUpdate.getFecha());
            statement.setString(4, modelUpdate.getGenero());
            statement.setInt(5, modelUpdate.getSueldo());
            statement.setBoolean(6, modelUpdate.isVacaciones());
            statement.setInt(7, modelUpdate.getId());
                    
            statement.executeUpdate();
            
            statement.close();
            //connector.getConnection().close();
        } catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    public Modelo_empleado findById(int id) {
        String sql = "select * from EMPLEADO where Cedula = ?";
        Modelo_empleado model = null;
         
        try{
            PreparedStatement statement;
            statement = connector.getConnection().prepareStatement(sql);
            ResultSet resultSet;
            
            statement.setInt(1, id);
                    
            resultSet = statement.executeQuery();
            
            if (resultSet.next()){
                model = new Modelo_empleado(
                   resultSet.getInt("ID_empleado"),
                   resultSet.getInt("Cedula"),
                   resultSet.getString("Nombre"),
                   resultSet.getString("Fecha_nac"),
                   resultSet.getString("Genero"),
                   resultSet.getInt("Sueldo"),
                   resultSet.getBoolean("Vacaciones"));
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
