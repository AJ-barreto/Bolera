/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import database.Connector;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andor
 */
public class InicioDAO {
    Connector connector = null;
    
    public InicioDAO(){
        this.connector = Connector.getInstance();
    }
    
    public void EmpleadoCSV() throws IOException{
        int suma=0, vacaciones=0, noVacaciones=0;
        BufferedWriter outStream = null;
        outStream = new BufferedWriter(new FileWriter("ReporteEmpleado.csv", true));
        
        String sql = "SELECT * FROM EMPLEADO";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            preparedStatement = connector.getConnection().prepareStatement(sql);
            
            resultSet = preparedStatement.executeQuery();
            
            outStream.write("ID | Cedula | Nombre | Fecha de nacimiento | Genero | Sueldo | Vacaciones\n");
            
            while(resultSet.next()){
                int data0 = resultSet.getInt("ID_empleado");
                int data1 = resultSet.getInt("Cedula");
                String data2 = resultSet.getString("Nombre");
                String data3 = resultSet.getString("Fecha_nac");
                String data4 = resultSet.getString("Genero");
                int data5 = resultSet.getInt("Sueldo");
                boolean data6 = resultSet.getBoolean("Vacaciones");
                
                outStream.write(data0 + " , "+data1+" , "+data2+" , "+ data3 +" , "+ data4 +" , "+ data5 + "\n");
                suma++;
                if(data6){
                    vacaciones++;
                } else {
                    noVacaciones++;
                }
            }
            outStream.write("\nCantidad de empleados actuales: "+suma);
            outStream.write("\nCantidad de empleados en Vacaciones: "+vacaciones);
            outStream.write("\nCantidad de empleados Disponibles: "+noVacaciones);
            
            outStream.close();
            JOptionPane.showMessageDialog(null, "Se ha guardado exitosamente el registro de EMPLEADOS");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                //if (connector != null) connector.getConnection().close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    public void PistaCSV() throws IOException{
        int suma=0, activo=0, noActivo=0;
        BufferedWriter outStream = null;
        outStream = new BufferedWriter(new FileWriter("ReportePistas.csv", true));
        
        String sql = "SELECT * FROM PISTA";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        outStream.write("NO_Pista | Ubicacion | Libre | Activa \n");
        
        try {
            preparedStatement = connector.getConnection().prepareStatement(sql);
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                int data0 = resultSet.getInt("NO_pista");
                String data1 = resultSet.getString("Ubicacion");
                boolean data2 = resultSet.getBoolean("Libre");
                boolean data3 = resultSet.getBoolean("Activa");
                
                outStream.write(data0 + " , "+data1+" , "+data2+" , "+ data3 /*+" , "+ data4 +" , "+ data5*/ + "\n");
                
                suma++;
                if(data3){
                    activo++;
                } else{
                    noActivo++;
                }
            }
            outStream.write("\nCantidad de pistas actuales: "+suma);
            outStream.write("\nCantidad de pista disponibles: "+activo);
            outStream.write("\nCantidad de pista NO disponibles: "+noActivo);
            outStream.close();
            JOptionPane.showMessageDialog(null, "Se ha guardado exitosamente el registro de PISTAS");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                //if (connector != null) connector.getConnection().close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    public void BoloCSV() throws IOException{
        int suma=0;
        BufferedWriter outStream = null;
        outStream = new BufferedWriter(new FileWriter("ReporteBolos.csv", true));
        
        String sql = "SELECT * FROM ELEMENTO_BOLERA_BOLOS";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        outStream.write("NO_Bolo | Peso_Bolo| Color_Bolo \n");
        
        try {
            preparedStatement = connector.getConnection().prepareStatement(sql);
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                int data0 = resultSet.getInt("Cod_elemento");
                int data1 = resultSet.getInt("Peso_bol");
                String data2=resultSet.getString("Color");
                
                outStream.write(data0 + " , "+data1+" , "+data2/*+" , "+ data3 +" , "+ data4 +" , "+ data5*/ + "\n");
                
                suma++;
            }
            outStream.write("\nCantidad de bolos actuales: "+suma);
            outStream.close();
            JOptionPane.showMessageDialog(null, "Se ha guardado exitosamente el registro de BOLOS");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                //if (connector != null) connector.getConnection().close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    public void CalzadoCSV() throws IOException{
        int suma=0;
        BufferedWriter outStream = null;
        outStream = new BufferedWriter(new FileWriter("ReporteCalzados.csv", true));
        
        String sql = "SELECT * FROM ELEMENTO_BOLERA_CALZADO";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        outStream.write("NO_Calzado | Numero de Calzado| Color del Calzado \n");
        
        try {
            preparedStatement = connector.getConnection().prepareStatement(sql);
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                int data0 = resultSet.getInt("Cod_calzado");
                int data1 = resultSet.getInt("Calzado_numero");
                String data2 = resultSet.getString("Calzado_color");
                
                outStream.write(data0 + " , "+data1+" , "+data2/*+" , "+ data3 +" , "+ data4 +" , "+ data5*/ + "\n");
                suma++;
            }
            outStream.write("\nCantidad de calzados actuales: "+suma);
            outStream.close();
            JOptionPane.showMessageDialog(null, "Se ha guardado exitosamente el registro");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                //if (connector != null) connector.getConnection().close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    public void informeReservaCSV() throws IOException{
        BufferedWriter outStream = null;
        int suma = 0, ventas = 0, crecimiento =0, resta = 0, crecimiento_total = 0, porcentaje = 0;
        outStream = new BufferedWriter(new FileWriter("InformeReservas.csv", true));
        
        String sql = "SELECT * FROM FORMA_DE_PAGO";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        outStream.write("NO_Reserva | Fecha_hora | Estado | Valor_total | PISTA_NO_pista | CLIENTE_ID_identificacion \n");
        try {
            preparedStatement = connector.getConnection().prepareStatement(sql);
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                crecimiento = ventas;
                int data0 = resultSet.getInt("NO_reserva");
                String data1 = resultSet.getString("Fecha");
                String data2 = resultSet.getString("Hora");
                boolean data3 = resultSet.getBoolean("Estado");
                int data4 = resultSet.getInt("Valor_total");
                int data5 = resultSet.getInt("PISTA_NO_pista");
                int data6 = resultSet.getInt("CLIENTE_ID");
                ventas = data4;
                resta = ventas-crecimiento;
                suma+=data4;
                crecimiento_total += resta;
                
                outStream.write(data0 + " , "+data1+" , "+data2+" , "+ data3 +" , "+ data4 +" , "+ data5 + " , "+ data6 +"\n");
            }
            porcentaje = suma/crecimiento_total;
            outStream.write("TOTAL DE VENTAS DE LAS RESERVACIONES: "+suma);
            outStream.write("\nTOTAL DE CRECIMIENTO DE LAS RESERVACIONES: "+crecimiento_total);
            outStream.write("\nPORCENTAJE DEL CRECIMIENTO DE LAS RESERVACIONES: "+porcentaje+"%");
            outStream.close();
            JOptionPane.showMessageDialog(null, "Se ha guardado exitosamente el registro");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error al conectar");
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                //if (connector != null) connector.getConnection().close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    public void informeProductoCSV() throws IOException{
        BufferedWriter outStream = null;
        int suma = 0, ventas = 0, crecimiento =0, resta = 0, crecimiento_total = 0, porcentaje = 0;
        outStream = new BufferedWriter(new FileWriter("informeProductos.csv", true));
        
        String sql = "SELECT * FROM FACT_COMES";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        outStream.write("NO_factura |   Fecha_hora | Total | NO_reserva| NO_pista| CLIENTE_ID_identificacion \n");
        try {
            preparedStatement = connector.getConnection().prepareStatement(sql);
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                crecimiento = ventas;
                int data0 = resultSet.getInt("NO_fact_comes");
                String data1 = resultSet.getString("Fecha");
                int data2 = resultSet.getInt("Total");
                int data3 = resultSet.getInt("FORMA_DE_PAGO_NO_reserva");
                int data4 = resultSet.getInt("FORMA_DE_PAGO_PISTA_NO_pista");
                int data5 = resultSet.getInt("FORMA_DE_PAGO_CLIENTE_ID");
                ventas = data2;
                resta = ventas-crecimiento;
                suma+=data3;
                crecimiento_total += resta;
                
                outStream.write(data0 + " , "+data1+" , "+data2+" , "+ data3 +" , "+ data4 +" , "+ data5 + "\n");
            }
            porcentaje = suma/crecimiento_total;
            outStream.write("TOTAL DE PRODUCTOS VENDIDOS: "+suma);
            outStream.write("\nTOTAL DE CRECIMIENTO DE LA VENTA DE PRODUCTOS: "+crecimiento_total);
            outStream.write("\nPORCENTAJE DEL CRECIMIENTO DE LAS VENTAS: "+porcentaje+"%");
            outStream.close();
            JOptionPane.showMessageDialog(null, "Se ha guardado exitosamente el registro");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error al conectar");
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                //if (connector != null) connector.getConnection().close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
}
