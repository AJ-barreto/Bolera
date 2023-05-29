/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Elementos;

/**
 *
 * @author Andor
 */
public class Modelo_pista {
    private int no_Pista;
    private String ubicacion;
    private boolean libre;

    public Modelo_pista(int no_Pista, String ubicacion, boolean libre) {
        this.no_Pista = no_Pista;
        this.ubicacion = ubicacion;
        this.libre = libre;
    }

    public int getNo_Pista() {
        return no_Pista;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public boolean isLibre() {
        return libre;
    }
    
    
}
