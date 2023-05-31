/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Modelo_ingresar;
import Modelo.Modelo_inicio;
import Vista.Vista_ingresar;
import Vista.Vista_inicio;
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
        if(e.getSource() == this.view.buttonInicio){
            model.setUsusario(view.TextUsuario.getText());
            model.setContraseña(view.TextContra.getText());
            model.inicioSesion();
            if(model.inicioSesion()){
            JOptionPane.showMessageDialog(view, "Inicio Sesion Correcto");
            
            Modelo_inicio mod = new Modelo_inicio();
            Vista_inicio vist = new Vista_inicio();
        
            Controlador_inicio ctrl = new Controlador_inicio(vist, mod);
            ctrl.inciar();
            vist.setVisible(true);
            
            this.view.close();
            } else {
            JOptionPane.showMessageDialog(view, "Contraseña o Usuario Incorrecto");
            }
        }
        if(e.getSource() == this.view.ButtonCancelar){
            JOptionPane.showConfirmDialog(view, "Se ha cancelado el inicio de Sesion");
        }
        
    }
}
