/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Reserva;

/**
 *
 * @author Andor
 */
public class Modelo_reserva {
    private int no_reserva;
    private String fecha;
    private String hora;
    private boolean estado;
    private int valor_total;
    private int no_pista;
    private int id;

    public Modelo_reserva(int no_reserva, String fecha, String hora, boolean estado, int valor_total, int no_pista, int id) {
        this.no_reserva = no_reserva;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.valor_total = valor_total;
        this.no_pista = no_pista;
        this.id = id;
    }

    public int getNo_reserva() {
        return no_reserva;
    }

    public String getFecha() {
        return fecha;
    }
    
    public String getHora() {
        return hora;
    }

    public boolean isEstado() {
        return estado;
    }

    public int getValor_total() {
        return valor_total;
    }

    public int getNo_pista() {
        return no_pista;
    }

    public int getId() {
        return id;
    }
    
    
    
    
}
