/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO.Elementos.Interface;

import Modelo.Elementos.Modelo_pista;
import java.util.ArrayList;

/**
 *
 * @author Andor
 */
public interface PistaDaoInterface {
    public void update(Modelo_pista model);
    public void create(Modelo_pista model);
    public void deleteById(int id);
    public Modelo_pista findById(int id);
    public ArrayList<Modelo_pista> findAll();
}
