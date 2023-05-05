/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Modelo_inicio;
import Vista.Vista_inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Andor
 */
public class Controlador_empl implements ActionListener{
    
    private Vista_inicio view;
    private Modelo_inicio model;
    
    public Controlador_empl(Vista_inicio view, Modelo_inicio model){
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
