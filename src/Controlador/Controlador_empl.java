/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.DAO.Empleado.EmpleadoDAO;
import Modelo.Empleado.Modelo_empleado;
import Modelo.Modelo_elementos;
import Modelo.Modelo_empl;
import Modelo.Modelo_inicio;
import Modelo.Modelo_reserv;
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
public class Controlador_empl implements ActionListener{
    
    private Vista_empl view;
    private Modelo_empl model;
    private EmpleadoDAO empleadoDao;
    
    public Controlador_empl(Vista_empl view, Modelo_empl model) throws SQLException{
        this.view = view;
        this.model = model;
        /*DAOS*/
        this.empleadoDao = new EmpleadoDAO();
        mostrarDatos();
        /*BOTONES MENU*/
        this.view.jMenuItem1.addActionListener(this);
        this.view.jMenuItem2.addActionListener(this);
        this.view.jMenuItem3.addActionListener(this);
        
        /*BOTONES EMPLEADO*/
        this.view.jButton1.addActionListener(this);
        this.view.jButton2.addActionListener(this);
        this.view.jButton3.addActionListener(this);
        this.view.jButton4.addActionListener(this);
        this.view.X.addActionListener(this);
    }
    
    public void inciar(){
        view.setTitle("Bolera la Roca");
        view.setLocationRelativeTo(null);
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
            try {
                Modelo_elementos mod = new Modelo_elementos();
                Vista_elementos view = new Vista_elementos();
                
                Controlador_elementos ctrl = new Controlador_elementos(view, mod);
                ctrl.inciar();
                this.view.close();
                view.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_empl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jMenuItem3){
            try {
                Modelo_reserv mod = new Modelo_reserv();
                Vista_reserva view = new Vista_reserva();
                
                Controlador_reserva ctrl = new Controlador_reserva(view, mod);
                ctrl.inciar();
                this.view.close();
                view.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_empl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /////////////////////////////*BOTONES DE PRODUCTOS*/////////////////////////
        if(e.getSource() == this.view.jButton2){
            try {
                String dato = JOptionPane.showInputDialog(null,"Introduce código del empleado a eliminar");
                int codEmpleado = Integer.parseInt(dato);
                empleadoDao.deleteById(codEmpleado);
                actualizar();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_elementos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton1){
            try {
                String dato1 = JOptionPane.showInputDialog(null,"Introduce la cédula del empleado");
                int cedEmpleado = Integer.parseInt(dato1);
                String nombre = JOptionPane.showInputDialog(null,"Introduzca el nombre del empleado");
                String fecha = JOptionPane.showInputDialog(null,"Introduzca la fecha de nacimiento del empleado");
                String genero = JOptionPane.showInputDialog(null,"Introduzca el genero del empleado");
                String dato3 = JOptionPane.showInputDialog(null,"Introduzca el sueldo del empleado");
                int sueldo = Integer.parseInt(dato3);
                String dato4 = JOptionPane.showInputDialog(null,"Introduzca si está en vacaiones");
                boolean vacaciones = Boolean.parseBoolean(dato4);
                Modelo_empleado model = new Modelo_empleado(0,cedEmpleado, nombre, fecha, genero, sueldo, vacaciones);
                empleadoDao.create(model);
                actualizar();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_elementos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton3){
            try {
                String dato = JOptionPane.showInputDialog(null,"Introduce el código del empleado");
                int codEmpleado = Integer.parseInt(dato);
                String dato1 = JOptionPane.showInputDialog(null,"Introduce la cédula del empleado");
                int cedEmpleado = Integer.parseInt(dato1);
                String nombre = JOptionPane.showInputDialog(null,"Introduzca el nombre del empleado");
                String fecha = JOptionPane.showInputDialog(null,"Introduzca la fecha de nacimiento del empleado");
                String genero = JOptionPane.showInputDialog(null,"Introduzca el genero del empleado");
                String dato3 = JOptionPane.showInputDialog(null,"Introduzca el sueldo del empleado");
                int sueldo = Integer.parseInt(dato3);
                String dato4 = JOptionPane.showInputDialog(null,"Introduzca si está en vacaiones");
                boolean vacaciones = Boolean.parseBoolean(dato4);
                Modelo_empleado model = new Modelo_empleado(codEmpleado,cedEmpleado, nombre, fecha, genero, sueldo, vacaciones);
                empleadoDao.update(model);
                actualizar();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_elementos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton4){
            String dato = JOptionPane.showInputDialog(null,"Digita la cedula a buscar");
            int cedEmpleado = Integer.parseInt(dato);
            Modelo_empleado model = empleadoDao.findById(cedEmpleado);
            JOptionPane.showMessageDialog(view, "CODIGO empleado: "+model.getId()+"// CEDULA: "+model.getCedula()+"// NOMBRE: "+model.getNombre()+"// FECHA de nacimiento: "+model.getFecha()+"// GENERO: "+model.getGenero()+"// SUELDO: "+model.getSueldo()+"// VACACIONES: "+model.isVacaciones());
        }
        if(e.getSource() == this.view.X){
            int i = JOptionPane.showConfirmDialog(this.view,"¿Estás seguro de eliminar el registro?");
            int codCalz;
            int fila = this.view.jTable3.getSelectedRow();
            //i == 0 : SI;
            //i == 1 : NO;
            //i == 2 : CANCELAR;
            if(i==0){
                if(fila >= 0){
                    try {
                        codCalz = Integer.parseInt((String) this.view.jTable3.getValueAt(fila, 0));
                        empleadoDao.deleteById(codCalz);
                        actualizar();
                    } catch (SQLException ex) {
                        Logger.getLogger(Controlador_elementos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(this.view, "Seleccione una fila por favor");
                }
            } else if (i == 1){
                JOptionPane.showMessageDialog(this.view, "Se ha cancelado eliminar un registro");
            }
        }
    }
    
    public void actualizar() throws SQLException{
        Modelo_empl mod = new Modelo_empl();
        Vista_empl view = new Vista_empl();
        
        Controlador_empl ctrl = new Controlador_empl(view, mod);
        ctrl.inciar();
        this.view.close();
        view.setVisible(true);
    }
    
    void mostrarDatos() throws SQLException{
        ArrayList<Modelo_empleado> models = empleadoDao.findAll();
        this.view.mostrarDatosPista(models);
    }
}
