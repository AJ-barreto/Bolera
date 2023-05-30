/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO.Reserva.Interface;

import Controlador.DAO.Elementos.Interface.*;
import Modelo.Reserva.Modelo_cliente;
import java.util.ArrayList;

/**
 *
 * @author Andor
 */
public interface ClienteDaoInterface {
    public void update(Modelo_cliente model);
    public void create(Modelo_cliente model);
    public void deleteById(int id);
    public Modelo_cliente findById(int id);
    public ArrayList<Modelo_cliente> findAll();
}
