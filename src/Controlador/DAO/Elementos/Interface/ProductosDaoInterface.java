/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO.Elementos.Interface;

import Modelo.Elementos.Modelo_productos;
import java.util.ArrayList;

/**
 *
 * @author Andor
 */
public interface ProductosDaoInterface {
    public void update(Modelo_productos model);
    public void create(Modelo_productos model);
    public void deleteById(int id);
    public Modelo_productos findById(int id);
    public ArrayList<Modelo_productos> findAll();
}
