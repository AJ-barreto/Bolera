/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.DAO.InicioDAO;
import Modelo.Modelo_elementos;
import Modelo.Modelo_empl;
import Modelo.Modelo_inicio;
import Modelo.Modelo_reserv;
import Modelo.Reloj;
import Vista.Vista_elementos;
import Vista.Vista_empl;
import Vista.Vista_inicio;
import Vista.Vista_reserva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andor
 */
public class Controlador_inicio implements ActionListener{
    
    private Vista_inicio view;
    private Modelo_inicio model;
    private InicioDAO inicioDao;
    
    public Controlador_inicio(Vista_inicio view, Modelo_inicio model){
        this.view = view;
        this.model = model;
        /*RELOJ*/
        Reloj reloj = new Reloj(view);
        reloj.start();
        /*DAOS*/
        inicioDao = new InicioDAO();
        
        /*BOTONES MENU*/
        this.view.jMenuItem1.addActionListener(this);
        this.view.jMenuItem2.addActionListener(this);
        this.view.jMenuItem3.addActionListener(this);
        
        /*BOTONES REPORTES*/
        this.view.jButton1.addActionListener(this);
        this.view.jButton2.addActionListener(this);
        this.view.jButton3.addActionListener(this);
        this.view.jButton4.addActionListener(this);
        this.view.jButton5.addActionListener(this);
        this.view.jButton6.addActionListener(this);
    }
    
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == this.view.jMenuItem1){
            try {
                Modelo_elementos mod = new Modelo_elementos();
                Vista_elementos view = new Vista_elementos();
                
                Controlador_elementos ctrl = new Controlador_elementos(view, mod);
                ctrl.inciar();
                this.view.close();
                view.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jMenuItem2){
            try {
                Modelo_reserv mod = new Modelo_reserv();
                Vista_reserva view = new Vista_reserva();
                
                Controlador_reserva ctrl = new Controlador_reserva(view, mod);
                ctrl.inciar();
                this.view.close();
                view.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_inicio.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Controlador_inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton1){
            try {
                informeReserva();
            } catch (IOException ex) {
                Logger.getLogger(Controlador_inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton2){
            try {
                reporteEmpleado();
            } catch (IOException ex) {
                Logger.getLogger(Controlador_inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton3){
            try {
                reportePista();
            } catch (IOException ex) {
                Logger.getLogger(Controlador_inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton4){
            try {
                reporteBolo();
            } catch (IOException ex) {
                Logger.getLogger(Controlador_inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton5){
            try {
                reporteCalzado();
            } catch (IOException ex) {
                Logger.getLogger(Controlador_inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == this.view.jButton6){
            try {
                informeProducto();
            } catch (IOException ex) {
                Logger.getLogger(Controlador_inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void inciar(){
        view.setTitle("Bolera la Roca");
        view.setLocationRelativeTo(null);
    }
    
    public void informeReserva() throws IOException{
        inicioDao.informeReservaCSV();
    }
    
    public void informeProducto() throws IOException{
        inicioDao.informeProductoCSV();
    }
    
    public void reporteEmpleado() throws IOException{
        inicioDao.EmpleadoCSV();
    }
    
    public void reportePista() throws IOException{
        inicioDao.PistaCSV();
    }
    
    public void reporteBolo() throws IOException{
        inicioDao.BoloCSV();
    }
    
    public void reporteCalzado() throws IOException{
        inicioDao.CalzadoCSV();
    }
}
