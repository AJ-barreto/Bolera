/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Modelo_ingresar;
import Vista.Vista_ingresar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Andor
 */
public class Controlador_ingresar implements ActionListener{
    
    private Vista_ingresar view;
    private Modelo_ingresar model;
    
    public Controlador_ingresar(Vista_ingresar view, Modelo_ingresar model){
        this.view = view;
        this.model = model;
        this.view.buttonInicio.addActionListener(this);
    }
    
    public void inciar(){
        view.setTitle("Bolera la Roca");
        view.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e){
        model.setUsusario(view.TextUsuario.getText());
        model.setContraseña(view.TextContra.getText());
        model.inicioSesion();
        if(model.inicioSesion()){
            JOptionPane.showConfirmDialog(view, "Inicio Sesion Correto");
        } else {
            JOptionPane.showConfirmDialog(view, "Inicio Sesion Incorrecto");
        }
    }
}
