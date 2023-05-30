/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

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
    
    public Controlador_inicio(Vista_inicio view, Modelo_inicio model){
        this.view = view;
        this.model = model;
        Reloj reloj = new Reloj(view);
        reloj.start();
        this.view.jMenuItem1.addActionListener(this);
        this.view.jMenuItem2.addActionListener(this);
        this.view.jMenuItem3.addActionListener(this);
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
    }
    
    public void inciar(){
        view.setTitle("Bolera la Roca");
        view.setLocationRelativeTo(null);
    }
}
