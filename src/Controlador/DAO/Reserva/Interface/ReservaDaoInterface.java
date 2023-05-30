/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO.Reserva.Interface;

import Controlador.DAO.Elementos.Interface.*;
import Modelo.Elementos.Modelo_bolos;
import Modelo.Reserva.Modelo_reserva;
import java.util.ArrayList;

/**
 *
 * @author Andor
 */
public interface ReservaDaoInterface {
    public void update(Modelo_reserva model);
    public void create(Modelo_reserva model);
    public void deleteById(int id);
    public Modelo_reserva findById(int id);
    public ArrayList<Modelo_reserva> findAll();
}
