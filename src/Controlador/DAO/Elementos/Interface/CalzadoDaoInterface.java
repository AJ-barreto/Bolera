/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO.Elementos.Interface;

import Modelo.Elementos.Modelo_calzado;
import java.util.ArrayList;

/**
 *
 * @author Andor
 */
public interface CalzadoDaoInterface {
    public void update(Modelo_calzado model);
    public void create(Modelo_calzado model);
    public void deleteById(int id);
    public Modelo_calzado findById(int id);
    public ArrayList<Modelo_calzado> findAll();
}
