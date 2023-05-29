/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Elementos;

/**
 *
 * @author Andor
 */
public class Modelo_productos {
    private int cod_producto;
    private String descripcion;
    private String tipo;
    private int valor_compra;
    private int valor_venta;
    private int cantidad;

    public Modelo_productos(int cod_producto, String descripcion, String tipo, int valor_compra, int valor_venta, int cantidad) {
        this.cod_producto = cod_producto;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.valor_compra = valor_compra;
        this.valor_venta = valor_venta;
        this.cantidad = cantidad;
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public int getValor_compra() {
        return valor_compra;
    }

    public int getValor_venta() {
        return valor_venta;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    
}
