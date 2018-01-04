/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial1.productorconsumidor;

import javax.swing.JLabel;

/**
 *
 * @author luis
 */
public class Consumidor extends Thread {
    int maxRapidez = 11;
    int rapidez = 5;
    private Almacen almacen;
    private JLabel output;
    private volatile boolean running = true;
    
    public Consumidor(Almacen almacen, JLabel output) {
        super("Consumidor");
        this.almacen = almacen;
        this.output = output;
    }
    
    public void terminate() {
        running = false;
    }
    
    public void run() {
        while(running) {
            almacen.tomar();
            output.setText(almacen.almacenado + "");
            try{
                sleep((maxRapidez - rapidez) * 150);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " consumió " + almacen.almacenado);
        }
    }
}
