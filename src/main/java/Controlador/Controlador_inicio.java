/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Modelo_elementos;
import Modelo.Modelo_inicio;
import Modelo.Modelo_reserva;
import Vista.Vista_empl;
import Vista.Vista_inicio;
import Vista.Vista_reserva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.view.MenuElementos.addActionListener(this);
        this.view.MenuEmpl.addActionListener(this);
        this.view.MenuReser.addActionListener(this);
    }
    
    public void inciar(){
        view.setTitle("Bolera la Roca");
        view.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == view.MenuElementos){
            Modelo_elementos mod = new Modelo_elementos();
            Vista_empl view = new Vista_empl();
        
            Controlador_elementos ctrl = new Controlador_elementos(view, mod);
            ctrl.inciar();
            view.setVisible(true);
        } else if(e.getSource() == view.MenuReser){
            Modelo_reserva mod = new Modelo_reserva();
            Vista_reserva view = new Vista_reserva();
        
            Controlador_reserva ctrl = new Controlador_reserva(view, mod);
            ctrl.inciar();
            view.setVisible(true);
        } else if(e.getSource() == view.MenuEmpl){
            Modelo_reserva mod = new Modelo_reserva();
            Vista_reserva view = new Vista_reserva();
        
            Controlador_reserva ctrl = new Controlador_reserva(view, mod);
            ctrl.inciar();
            view.setVisible(true);
        }
    }
    
}
