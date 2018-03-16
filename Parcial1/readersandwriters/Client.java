/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial1.readersandwriters;

import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author Erik
 */
public class Client extends Thread {
    private Random rand;
    private volatile boolean running = true;
    private Database db;
    public JLabel outputState;
    public JLabel outputReadValue;
    
    private long currentTime;
    private long nextWrite;
    
    public Client(String name, Database db, JLabel output, JLabel outputReadValue) {
        this.setName(name);
        rand = new Random();
        this.db = db;
        this.outputState = output;
        this.outputReadValue = outputReadValue;
        
        currentTime = System.currentTimeMillis();
        nextWrite = currentTime + rand.nextInt(10000) + 1;  //leer cada 1 o 10000 milisegundos
    }
    
    public void terminate() {
        running = false;
    }
    
    public void run() {
        while(running) {
            try {
                Thread.sleep(rand.nextInt(2000) + 500);
            } catch(Exception e) {
                e.printStackTrace();
            }
            /*if(db.locked) {
               output.setText("Escribiendo");

            } else {
                output.setText("Libre");
            }*/
            
                if(System.currentTimeMillis() >= nextWrite) {  //if is time to read, try to
                    //System.out.println("Escribiendo!");
                    db.write(this);
                    currentTime = System.currentTimeMillis();
                    nextWrite = currentTime + rand.nextInt(30000) + 5000;  //leer cada 1 o 10000 milisegundos
                } else {  //read the database
                    db.read(this);
                }
        }
    }
    
}
