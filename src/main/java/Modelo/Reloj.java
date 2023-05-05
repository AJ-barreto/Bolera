/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.Vista_inicio;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Andor
 */
public class Reloj implements Runnable{
    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    
    Vista_inicio view;
    
    public Reloj(){
        h1 = new Thread(this);
        h1.start();
    }
    
    public void run(){
        Thread ct = Thread.currentThread();
        
        
        while(ct == h1){
            calcula();
            view.lblReloj.setText(hora + ":"+ minutos+ ":"+ segundos+ " "+ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
    
    public void calcula(){
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();
        
        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM?"AM":"PM";
        
        if(ampm.equals("PM")){
            int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
            hora = h>9?""+h:"0"+h;
        } else {
            minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
            segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
        }
    }
}
