/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Reserva;

/**
 *
 * @author Andor
 */
public class Modelo_cliente {
    private int id;
    private String nombre;
    private String fecha;
    private String genero;
    private int inactividad;

    public Modelo_cliente(int id, String nombre, String fecha, String genero, int inactividad) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.genero = genero;
        this.inactividad = inactividad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getGenero() {
        return genero;
    }

    public int getInactividad() {
        return inactividad;
    }
    
    
    
    
}
