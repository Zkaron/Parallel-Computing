/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial1.readersandwriters;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author Erik
 */
public class Database {
    private int bookings;
    private final Lock lock = new ReentrantLock();
    private Random rand;
    public boolean locked;
    private JLabel output;
    
    public Database(JLabel output) {
        this.output = output;
        bookings = 0;
        locked = false;
        rand = new Random();
    }
    
    public int getBookings() {
        return bookings;
    }
    
    public void setBookings(int bookings) {
        this.bookings = bookings;
    }
    
    public void read(Client c) {
        //System.out.println("" + locked);
        if(!locked) {
            c.outputReadValue.setText(bookings + "");
            System.out.println(c.getName() + " readed: " + bookings);
        }
    }
    
    public void write(Client c) {
        if(impedingReadingOrWriting()) {
            try {
                c.outputState.setText("<html><font color='red'>Escribiendo</font></html>");
                long t = System.currentTimeMillis();
                long end = t + rand.nextInt(5000) + 1;
                System.out.println(c.getName() + " is writing on the database...");
                while(System.currentTimeMillis() < end) {
                    bookings = rand.nextInt();
                    this.output.setText(bookings + "");
                }      
            } finally {
                lock.unlock();
                locked = false;
                c.outputState.setText("Leyendo");
                System.out.println(c.getName() + " stopped writing on the database...");
            } 
        } else {
            //System.out.println("Another thread is writing on the database");
        }
    }
    
    public boolean impedingReadingOrWriting() {
       boolean writerLock = false;
       try {
           writerLock = lock.tryLock();
       } finally {
           if(writerLock)
           locked = true;
       }
       return writerLock;
    }
}
