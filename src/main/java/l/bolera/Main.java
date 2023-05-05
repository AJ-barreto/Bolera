/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package l.bolera;

import Controlador.Controlador_ingresar;
import Modelo.Modelo_ingresar;
import Vista.Vista_ingresar;

/**
 *
 * @author Andor
 */
public class Main {

    public static void main(String[] args) {
        
        Modelo_ingresar mod = new Modelo_ingresar();
        Vista_ingresar view = new Vista_ingresar();
        
        Controlador_ingresar ctrl = new Controlador_ingresar(view, mod);
        ctrl.inciar();
        view.setVisible(true);
    }
}
