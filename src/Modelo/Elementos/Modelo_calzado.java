/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Elementos;

/**
 *
 * @author Andor
 */
public class Modelo_calzado {
    private int cod_calzado;
    private int calzado_numero;
    private String calzado_color;

    public Modelo_calzado(int cod_calzado, int calzado_numero, String color) {
        this.cod_calzado = cod_calzado;
        this.calzado_numero = calzado_numero;
        this.calzado_color = color;
    }

    public int getCod_calzado() {
        return cod_calzado;
    }

    public int getCalzado_numero() {
        return calzado_numero;
    }
    
    public String getCalzado_color() {
        return calzado_color;
    }
    
}
