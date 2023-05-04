/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Modelo_reserva;
import Vista.Vista_reserva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }
    
    public void inciar(){
        view.setTitle("Bolera la Roca");
        view.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e){
        
    }
    
}
