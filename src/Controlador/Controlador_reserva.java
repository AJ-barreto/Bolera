/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Modelo_elementos;
import Modelo.Modelo_empl;
import Modelo.Modelo_inicio;
import Modelo.Modelo_reserva;
import Vista.Vista_elementos;
import Vista.Vista_empl;
import Vista.Vista_inicio;
import Vista.Vista_reserva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andor
 */
public class Controlador_reserva implements ActionListener{
    
    private Vista_reserva view;
    private Modelo_reserva model;
    
    public Controlador_reserva(Vista_reserva view, Modelo_reserva model){
        this.view = view;
        this.model = model;
        this.view.jMenuItem1.addActionListener(this);
        this.view.jMenuItem2.addActionListener(this);
        this.view.jMenuItem3.addActionListener(this);
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
            Modelo_empl mod = new Modelo_empl();
            Vista_empl view = new Vista_empl();
        
            Controlador_empl ctrl = new Controlador_empl(view, mod);
            ctrl.inciar();
            this.view.close();
            view.setVisible(true);
        }
    }
    
}
