/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Andor
 */
public class Modelo_ingresar {
    
    private String usuario;
    private String contraseña;
    
    ///////////////////////////

    public String getUsusario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setUsusario(String ususario) {
        this.usuario = ususario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    ////////////
    
    public boolean inicioSesion(){
        if(this.usuario.equals("Andres") && this.contraseña.equals("a")){
        return true;
        } else {
            return false;
        }
    } 
    
    
}
