/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.DAO.Elementos.BolosDAO;
import Controlador.DAO.Elementos.CalzadoDAO;
import Controlador.DAO.Elementos.PistaDAO;
import Controlador.DAO.Elementos.ProductosDAO;
import Modelo.Elementos.Modelo_bolos;
import Modelo.Elementos.Modelo_calzado;
import Modelo.Modelo_elementos;
import Modelo.Modelo_empl;
import Modelo.Modelo_inicio;
import Modelo.Elementos.Modelo_pista;
import Modelo.Elementos.Modelo_productos;
import Modelo.Modelo_reserva;
import Vista.Vista_elementos;
import Vista.Vista_empl;
import Vista.Vista_inicio;
import Vista.Vista_reserva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andor
 */
public class Controlador_elementos implements ActionListener{
    
    private Vista_elementos view;
    private Modelo_elementos model;
    private PistaDAO pistaDao;
    private BolosDAO bolosDao;
    private CalzadoDAO calzadoDao;
    private ProductosDAO productosDao;
    
    public Controlador_elementos(Vista_elementos view, Modelo_elementos model) throws SQLException{
        this.view = view;
        this.model = model;
        this.pistaDao = new PistaDAO();
        this.bolosDao = new BolosDAO();
        this.calzadoDao = new CalzadoDAO();
        this.productosDao = new ProductosDAO();
        mostrarDatos();
        /*BOTONES MENU*/
        this.view.jMenuItem1.addActionListener(this);
        this.view.jMenuItem2.addActionListener(this);
        this.view.jMenuItem3.addActionListener(this);
        
        /*BOTONES BOLOS*/
        this.view.jButton6.addActionListener(this);
        this.view.jButton10.addActionListener(this);
        this.view.jButton11.addActionListener(this);
        this.view.jButton7.addActionListener(this);
        
        /*BOTONES CALZADO*/
        this.view.jButton8.addActionListener(this);
        this.view.jButton9.addActionListener(this);
        this.view.jButton12.addActionListener(this);
        this.view.jButton13.addActionListener(this);
        
        /*BOTONES PISTA*/
        this.view.jButton14.addActionListener(this);
        this.view.jButton15.addActionListener(this);
        this.view.jButton16.addActionListener(this);
        this.view.jButton17.addActionListener(this);
        
    }
    
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == this.view.jMenuItem1){
            Modelo_inicio mod = new Modelo_inicio();
            Vista_inicio view = new Vista_inicio();
        
            Controlador_inicio ctrl = new Controlador_inicio(view, mod);
            ctrl.inciar();
            this.view.close();
            view.setVisible(true);
        }
        if(e.getSource() == this.view.jMenuItem2){
            Modelo_reserva mod = new Modelo_reserva();
            Vista_reserva view = new Vista_reserva();
        
            Controlador_reserva ctrl = new Controlador_reserva(view, mod);
            ctrl.inciar();
            this.view.close();
            view.setVisible(true);
        }
        if(e.getSource() == this.view.jMenuItem3){
            Modelo_empl mod = new Modelo_empl();
            Vista_empl view = new Vista_empl();
        
            Controlador_empl ctrl = new Controlador_empl(view, mod);
            ctrl.inciar();
            this.view.close();
            view.setVisible(true);
        }
        if(e.getSource() == this.view.jButton10){
            try {
                String dato = JOptionPane.showInputDialog(null,"Introduce el código del bolo a eliminar");
                int codBolo = Integer.parseInt(dato);
                bolosDao.deleteById(codBolo);
                actualizar();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_elementos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton6){
            try {
                String dato1 = JOptionPane.showInputDialog(null,"Introduce el código del bolo");
                int codBolo = Integer.parseInt(dato1);
                String dato2 = JOptionPane.showInputDialog(null,"Introduzca el Peso del Bolo");
                int pesoBolo = Integer.parseInt(dato2);
                Modelo_bolos model = new Modelo_bolos(codBolo, pesoBolo);
                bolosDao.create(model);
                actualizar();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_elementos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton7){
            try {
                String dato1 = JOptionPane.showInputDialog(null,"Introduce el código del bolo");
                int codBolo = Integer.parseInt(dato1);
                String dato2 = JOptionPane.showInputDialog(null,"Introduzca el Peso del Bolo");
                int pesoBolo = Integer.parseInt(dato2);
                Modelo_bolos model = new Modelo_bolos(codBolo, pesoBolo);
                bolosDao.update(model);
                actualizar();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_elementos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton11){
            String dato = JOptionPane.showInputDialog(null,"Digita el cod a buscar");
            int codBolo = Integer.parseInt(dato);
            Modelo_bolos model = bolosDao.findById(codBolo);
            JOptionPane.showMessageDialog(view, "Cod_elemento: "+model.getCod_elemento()+"// Peso_bolo: "+model.getPeso_bolo());
        }
        //---------------------------------------------------------------------------------------------------------------------------------
        if(e.getSource() == this.view.jButton9){
            try {
                String dato = JOptionPane.showInputDialog(null,"Introduce el código del calzado a eliminar");
                int codCalz = Integer.parseInt(dato);
                calzadoDao.deleteById(codCalz);
                actualizar();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_elementos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton8){
            try {
                String dato1 = JOptionPane.showInputDialog(null,"Introduce el código del calzado");
                int codCalz = Integer.parseInt(dato1);
                String dato2 = JOptionPane.showInputDialog(null,"Introduzca el número de calzado");
                int numCalz = Integer.parseInt(dato2);
                Modelo_calzado model = new Modelo_calzado(codCalz, numCalz);
                calzadoDao.create(model);
                actualizar();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_elementos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton12){
            try {
                String dato1 = JOptionPane.showInputDialog(null,"Introduce el código del calzado");
                int codCalz = Integer.parseInt(dato1);
                String dato2 = JOptionPane.showInputDialog(null,"Introduzca el número de calzado");
                int numCalz = Integer.parseInt(dato2);
                Modelo_calzado model = new Modelo_calzado(codCalz, numCalz);
                calzadoDao.update(model);
                actualizar();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_elementos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton13){
            String dato = JOptionPane.showInputDialog(null,"Digita el cod a buscar");
            int codCalz = Integer.parseInt(dato);
            Modelo_calzado model = calzadoDao.findById(codCalz);
            JOptionPane.showMessageDialog(view, "Cod_calzado: "+model.getCod_calzado()+"// Numero de calzado: "+model.getCalzado_numero());
        }
        
        //-----------------------------------------------------------------------------------------------------------------------------------
        if(e.getSource() == this.view.jButton15){
            try {
                String dato = JOptionPane.showInputDialog(null,"Introduce el número de la pista a eliminar");
                int numPista = Integer.parseInt(dato);
                pistaDao.deleteById(numPista);
                actualizar();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_elementos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton14){
            try {
                String dato1 = JOptionPane.showInputDialog(null,"Introduce el número de la pista");
                int numPista = Integer.parseInt(dato1);
                String ubicacion = JOptionPane.showInputDialog(null,"Introduzca la ubicacion de la pista");
                String dato3 = JOptionPane.showInputDialog(null,"Introduzca si la pista está libre actualmente");
                boolean libre = Boolean.parseBoolean(dato3);
                Modelo_pista model = new Modelo_pista(numPista,ubicacion,libre);
                pistaDao.create(model);
                actualizar();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_elementos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton16){
            try {
                String dato1 = JOptionPane.showInputDialog(null,"Introduce el número de la pista");
                int numPista = Integer.parseInt(dato1);
                String ubicacion = JOptionPane.showInputDialog(null,"Introduzca la ubicacion de la pista");
                String dato3 = JOptionPane.showInputDialog(null,"Introduzca si está libre actualmente");
                boolean libre = Boolean.parseBoolean(dato3);
                Modelo_pista model = new Modelo_pista(numPista, ubicacion,libre);
                pistaDao.update(model);
                actualizar();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_elementos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton17){
            String dato = JOptionPane.showInputDialog(null,"Digita el número de la pista a buscar");
            int numPista = Integer.parseInt(dato);
            Modelo_pista model = pistaDao.findById(numPista);
            JOptionPane.showMessageDialog(view, "NO_pista: "+model.getNo_Pista()+"// Ubicacion: "+model.getUbicacion()+"// Estado: "+model.isLibre());
        }
        
    }
    
    public void inciar(){
        view.setTitle("Bolera la Roca");
        view.setLocationRelativeTo(null);
    }
    
    public void actualizar() throws SQLException{
        Modelo_elementos mod = new Modelo_elementos();
        Vista_elementos view = new Vista_elementos();
        
        Controlador_elementos ctrl = new Controlador_elementos(view, mod);
        ctrl.inciar();
        this.view.close();
        view.setVisible(true);
    }
    
    void mostrarDatos() throws SQLException{
        ArrayList<Modelo_pista> models = pistaDao.findAll();
        this.view.mostrarDatosPista(models);
   // }
    
    //void mostrarDatosCalzado()throws SQLException{
        ArrayList<Modelo_calzado> models2 = calzadoDao.findAll();
        this.view.mostrarDatosCalzado(models2);
    //}
    
    //void mostrarDatosProductos()throws SQLException{
        ArrayList<Modelo_productos> models3 = productosDao.findAll();
        this.view.mostrarDatosProductos(models3);
    //}
    
    //void mostrarDatosBolos()throws SQLException{
        ArrayList<Modelo_bolos> models4 = bolosDao.findAll();
        this.view.mostrarDatosBolos(models4);
    }
    
}
