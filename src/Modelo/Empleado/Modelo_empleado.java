/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Empleado;

/**
 *
 * @author Andor
 */
public class Modelo_empleado {
    private int id;
    private int cedula;
    private String nombre;
    private String fecha;
    private String genero;
    private int sueldo;
    private boolean vacaciones;

    public Modelo_empleado(int id,int cedula, String nombre, String fecha, String genero, int sueldo, boolean vacaciones) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fecha = fecha;
        this.genero = genero;
        this.sueldo = sueldo;
        this.vacaciones = vacaciones;
    }

    public int getId() {
        return id;
    }

    public int getCedula() {
        return cedula;
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

    public int getSueldo() {
        return sueldo;
    }

    public boolean isVacaciones() {
        return vacaciones;
    }
}
