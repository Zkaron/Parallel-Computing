/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial1.productorconsumidor;

/**
 *
 * @author luis
 */
public class Almacen {
    final int CAPACIDAD;
    int almacenado;
    
    public Almacen(int capacidad) {
        this.CAPACIDAD = capacidad;
    }
    
    public synchronized int tomar() {
        while(almacenado == 0) { 
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }        
        almacenado--;
        notifyAll();
        
        return almacenado;
    }
    
    public synchronized void agregar() {
        while(almacenado == CAPACIDAD) {
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        almacenado++;
        notifyAll();
    }
    
}
