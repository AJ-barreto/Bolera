/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.DAO.Reserva.ClienteDAO;
import Controlador.DAO.Reserva.ReservaDAO;
import Modelo.Modelo_elementos;
import Modelo.Modelo_empl;
import Modelo.Modelo_inicio;
import Modelo.Modelo_reserv;
import Modelo.Reserva.Modelo_cliente;
import Modelo.Reserva.Modelo_reserva;
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
public class Controlador_reserva implements ActionListener{
    
    private Vista_reserva view;
    private Modelo_reserv model;
    private ReservaDAO reservaDao;
    private ClienteDAO clienteDao;
    
    public Controlador_reserva(Vista_reserva view, Modelo_reserv model) throws SQLException{
        this.view = view;
        this.model = model;
        /*DAOS*/
        this.clienteDao = new ClienteDAO();
        this.reservaDao = new ReservaDAO();
        mostrarDatos();
        
        /*BOTONES MENU*/
        this.view.jMenuItem1.addActionListener(this);
        this.view.jMenuItem2.addActionListener(this);
        this.view.jMenuItem3.addActionListener(this);
        
        /*BOTONES CLIENTE*/
        this.view.jButton1.addActionListener(this);
        this.view.jButton2.addActionListener(this);
        this.view.jButton3.addActionListener(this);
        this.view.jButton4.addActionListener(this);
        
        /*BOTONES RESERVA*/
        this.view.jButton5.addActionListener(this);
        this.view.jButton6.addActionListener(this);
        this.view.jButton7.addActionListener(this);
        this.view.jButton8.addActionListener(this);
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
                Logger.getLogger(Controlador_reserva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jMenuItem3){
            try {
                Modelo_empl mod = new Modelo_empl();
                Vista_empl view = new Vista_empl();
                
                Controlador_empl ctrl = new Controlador_empl(view, mod);
                ctrl.inciar();
                this.view.close();
                view.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_reserva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /////////////////////////////*BOTONES DE CLIENTE*/////////////////////////
        if(e.getSource() == this.view.jButton2){
            try {
                String dato = JOptionPane.showInputDialog(null,"Introduce el id del cliente");
                int id = Integer.parseInt(dato);
                clienteDao.deleteById(id);
                actualizar();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_elementos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton1){
            try {
                String dato1 = JOptionPane.showInputDialog(null,"Introduce la cedula del cliente");
                int id = Integer.parseInt(dato1);
                String nombre = JOptionPane.showInputDialog(null,"Introduzca el nombre del cliente");
                String fecha = JOptionPane.showInputDialog(null,"Introduzca la fecha de nacimiento del cliente");
                String genero = JOptionPane.showInputDialog(null,"Introduzca el genero del cliente");
                String dato2 = JOptionPane.showInputDialog(null,"Introduzca la última vez que el cliente reservó una pista");
                int inactividad = Integer.parseInt(dato2);
                Modelo_cliente model = new Modelo_cliente(0,id, nombre, fecha, genero, inactividad);
                clienteDao.create(model);
                actualizar();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_elementos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton3){
            try {
                String dato = JOptionPane.showInputDialog(null,"Introduce el id del cliente");
                int id = Integer.parseInt(dato);
                String dato1 = JOptionPane.showInputDialog(null,"Introduce la cedula del cliente");
                int ced = Integer.parseInt(dato1);
                String nombre = JOptionPane.showInputDialog(null,"Introduzca el nombre del cliente");
                String fecha = JOptionPane.showInputDialog(null,"Introduzca la fecha de nacimiento del cliente");
                String genero = JOptionPane.showInputDialog(null,"Introduzca el genero del cliente");
                String dato2 = JOptionPane.showInputDialog(null,"Introduzca la última vez que el cliente reservó una pista");
                int inactividad = Integer.parseInt(dato2);
                Modelo_cliente model = new Modelo_cliente(id, ced, nombre, fecha, genero, inactividad);
                clienteDao.update(model);
                actualizar();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_elementos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton4){
            String dato = JOptionPane.showInputDialog(null,"Digita el cod a buscar");
            int id = Integer.parseInt(dato);
            Modelo_cliente model = clienteDao.findById(id);
            JOptionPane.showMessageDialog(view, "Identificacion: "+model.getId()+"// Nombre: "+model.getNombre()+"// Fecha de nacimiento: "+model.getFecha()+"// Genero: "+model.getGenero()+"// Inactividad: "+model.getInactividad());
        }
        /////////////////////////////*BOTONES DE RESERVA*/////////////////////////
        if(e.getSource() == this.view.jButton6){
            try {
                String dato = JOptionPane.showInputDialog(null,"Introduce el código de la reserva");
                int codReserva = Integer.parseInt(dato);
                reservaDao.deleteById(codReserva);
                actualizar();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_elementos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton5){
            try {
                /*String dato1 = JOptionPane.showInputDialog(null,"Introduce el número de reserva");
                int codReserva = Integer.parseInt(dato1);*/
                String fecha = JOptionPane.showInputDialog(null,"Introduzca la fecha de la reserva");
                String hora = JOptionPane.showInputDialog(null,"Introduzca la hora de la reserva");
                String dato5 = JOptionPane.showInputDialog(null,"Introduzca si ya ha pagado la reserva");
                boolean estado = Boolean.parseBoolean(dato5);
                String dato3 = JOptionPane.showInputDialog(null,"Introduzca el valor total de la reserva");
                int valor_total = Integer.parseInt(dato3);
                String dato2 = JOptionPane.showInputDialog(null,"Introduzca la pista reservada");
                int pista = Integer.parseInt(dato2);
                String dato4 = JOptionPane.showInputDialog(null,"Introduzca el id del cliente que ha reservado");
                int id = Integer.parseInt(dato4);
                Modelo_reserva model = new Modelo_reserva(0, fecha, hora, estado,valor_total,pista,id);
                reservaDao.create(model);
                actualizar();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_elementos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton7){
            try {
                String dato1 = JOptionPane.showInputDialog(null,"Introduce el número de reserva");
                int codReserva = Integer.parseInt(dato1);
                String fecha = JOptionPane.showInputDialog(null,"Introduzca la fecha de la reserva");
                String hora = JOptionPane.showInputDialog(null,"Introduzca la hora de la reserva");
                String dato5 = JOptionPane.showInputDialog(null,"Introduzca si ya ha pagado la reserva");
                boolean estado = Boolean.parseBoolean(dato5);
                String dato3 = JOptionPane.showInputDialog(null,"Introduzca el valor total de la reserva");
                int valor_total = Integer.parseInt(dato3);
                String dato2 = JOptionPane.showInputDialog(null,"Introduzca la pista reservada");
                int pista = Integer.parseInt(dato2);
                String dato4 = JOptionPane.showInputDialog(null,"Introduzca el id del cliente que ha reservado");
                int id = Integer.parseInt(dato4);
                Modelo_reserva model = new Modelo_reserva(codReserva, fecha,hora, estado,valor_total,pista,id);
                reservaDao.update(model);
                actualizar();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_elementos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton8){
            String dato1 = JOptionPane.showInputDialog(null,"Introduce el número de reserva");
                int codReserva = Integer.parseInt(dato1);
            Modelo_reserva model = reservaDao.findById(codReserva);
            JOptionPane.showMessageDialog(view, "NO_reserva: "+model.getNo_reserva()+"// Fecha: "+model.getFecha()+"// Estado: "+model.isEstado()+"// Valot total: "+model.getValor_total()+"// Pista: "+model.getNo_pista()+"// cliente: "+model.getId());
        }
    }
    
    public void actualizar() throws SQLException{
        Modelo_reserv mod = new Modelo_reserv();
        Vista_reserva view = new Vista_reserva();
        
        Controlador_reserva ctrl = new Controlador_reserva(view, mod);
        ctrl.inciar();
        this.view.close();
        view.setVisible(true);
    }
    
    void mostrarDatos() throws SQLException{
        ArrayList<Modelo_cliente> models = clienteDao.findAll();
        this.view.mostrarDatosCliente(models);
        
        ArrayList<Modelo_reserva> models2 = reservaDao.findAll();
        this.view.mostrarDatosReserva(models2);
    }
    
}
