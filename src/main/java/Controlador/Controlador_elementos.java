/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Modelo_elementos;
import Vista.Vista_elementos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Andor
 */
public class Controlador_elementos implements ActionListener{
    
    private Vista_elementos view;
    private Modelo_elementos model;
    
    public Controlador_elementos(Vista_elementos view, Modelo_elementos model){
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
