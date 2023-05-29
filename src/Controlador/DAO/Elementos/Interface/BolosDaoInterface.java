/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO.Elementos.Interface;

import Modelo.Elementos.Modelo_bolos;
import java.util.ArrayList;

/**
 *
 * @author Andor
 */
public interface BolosDaoInterface {
    public void update(Modelo_bolos model);
    public void create(Modelo_bolos model);
    public void deleteById(int id);
    public Modelo_bolos findById(int id);
    public ArrayList<Modelo_bolos> findAll();
}
