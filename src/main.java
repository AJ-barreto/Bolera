
import Controlador.Controlador_ingresar;
import Modelo.Modelo_ingresar;
import Vista.Vista_ingresar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Andor
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Modelo_ingresar mod = new Modelo_ingresar();
        Vista_ingresar view = new Vista_ingresar();
        
        Controlador_ingresar ctrl = new Controlador_ingresar(view, mod);
        ctrl.inciar();
        view.setVisible(true);
    }
    
}
