/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Elementos;

/**
 *
 * @author Andor
 */
public class Modelo_bolos {
    private int cod_elemento;
    private int peso_bolo;

    public Modelo_bolos(int cod_elemento, int peso_bolo) {
        this.cod_elemento = cod_elemento;
        this.peso_bolo = peso_bolo;
    }

    public int getCod_elemento() {
        return cod_elemento;
    }

    public int getPeso_bolo() {
        return peso_bolo;
    }
    
    
}
