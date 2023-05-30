/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO.Empleado.Interface;

import Modelo.Empleado.Modelo_empleado;
import java.util.ArrayList;

/**
 *
 * @author Andor
 */
public interface EmpleadoDaoInterface {
    public void update(Modelo_empleado model);
    public void create(Modelo_empleado model);
    public void deleteById(int id);
    public Modelo_empleado findById(int id);
    public ArrayList<Modelo_empleado> findAll();
}
