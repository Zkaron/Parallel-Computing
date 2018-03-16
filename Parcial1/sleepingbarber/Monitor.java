/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial1.sleepingbarber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author Erik
 */
public class Monitor implements Runnable{
    //clase Monitor es la que controla el acceso de los clientes a las sillas
    
    //Contiene numero de sillas
    int nSillas;
    
    //silla de barbero
    boolean masterChair;
    
    int clientesEspera;
    
    JLabel stateBarBer;
    
    DefaultListModel listModel;
    
    JLabel chairStatus;
    
    JProgressBar progress;
    
    //constructor de la clase
    Monitor(int num, JLabel stateBarBer, DefaultListModel defaultList, JLabel chairStatus, JProgressBar progress){
        nSillas = num;
        masterChair = false;
        clientesEspera = 0;
        this.stateBarBer = stateBarBer;
        listModel = defaultList;
        this.chairStatus = chairStatus;
        this.progress = progress;
    }
    
    public synchronized void cortarPelo(int posInList){
        try {
            masterChair = true;
            
            //quitar 1 cliente de la lista de espera
            clientesEspera--;
            listModel.removeElement("Cliente Numero "+posInList);
            
            chairStatus.setText("ocupado por cliente "+posInList);
            //metodo que simula el tiempo en que le corta el pelo a un cliente
            Log("Barbero cortando el pelo...");
            stateBarBer.setText("Barbero cortando el pelo...");
            
            Random r = new Random();
            int i = 0;
            int max = r.nextInt(5000);
            progress.setMaximum(max);
            while(i<max){
                Thread.sleep(1);
                progress.setValue(i);
                i++;
            }
            
            //Una ves que termina desocupa su silla de peluquero
            Log("Servido");
            Log("Clientes esperando: "+clientesEspera);
            masterChair = false;
            chairStatus.setText("desocupado");
        } catch (InterruptedException ex) {
            Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getCuantosClientes(){
        return clientesEspera;
    }

    @Override
    public void run() {
        while(true){
            //solo necesita estar vivo para que puedan acceder a la masterChair.
        }
    }
    
    public void Log(String mensaje){
        System.out.println(mensaje);
    }
    
}
