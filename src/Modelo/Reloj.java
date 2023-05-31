/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.Vista_inicio;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andor
 */
public class Reloj extends Thread implements Runnable{
    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    Vista_inicio view;
    
    public Reloj(Vista_inicio view){
        //h1 = new Thread(this);
        //h1.start();
        this.view = view;
    }
    
    public void run(){
        while(true){
            try {
                Calendar c=Calendar.getInstance();
                int hora=c.get(Calendar.HOUR);
                int minutos=c.get(Calendar.MINUTE);
                int segundos=c.get(Calendar.SECOND);
                Calendar calendario = new GregorianCalendar();
                ampm = calendario.get(Calendar.AM_PM) == Calendar.AM?"AM":"PM";
                String tiempo = hora+":"+minutos+":"+segundos+ " "+ampm;
                this.view.lblReloj.setText("Hora: "+tiempo);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Error del hilo");
            }
        }
    }
}
