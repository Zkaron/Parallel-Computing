/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial1.productorconsumidor.philosopherdinner;

import java.util.Random;
import java.util.concurrent.Semaphore;
import javax.swing.JLabel;

/**
 *
 * @author Erik Thousand Names
 */
public class Philosopher extends Thread {
    private boolean running;
    private boolean isHungry;
    
    private byte philosopherId;
    private int rightHand;
    private int leftHand;
    private JLabel output;
    
    private Semaphore[] semaphoreForks;
    private Random sleepTime;
    
    private final String EATING = "Eating";
    private final String HUNGRY = "Hungry";
    private final String THINKING = "Thinking";
    
    public Philosopher(byte philosopherId, Semaphore[] semaphoreForks, byte[][] philosopherForks, JLabel label) {
        this.sleepTime = new Random();
        this.running = true;
        this.isHungry = false;
        
        this.philosopherId = philosopherId;
        this.rightHand = philosopherForks[this.philosopherId][0];
        this.leftHand = philosopherForks[this.philosopherId][1];
        this.semaphoreForks = semaphoreForks;
        this.output = label;
    }
    
    public void eat() {
        if(semaphoreForks[rightHand].tryAcquire()) {
            if(semaphoreForks[leftHand].tryAcquire()) {
            output.setText(EATING);
            isHungry = false;
            try {
                sleep(sleepTime.nextInt(2000) + 100);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            semaphoreForks[rightHand].release();
        } else {
           output.setText(HUNGRY);
           isHungry = true;
        }
            semaphoreForks[leftHand].release();
        } else {
            output.setText(HUNGRY);
            isHungry = true;
        }
    }
    
    public void think() {
        if(isHungry) {
            output.setText(HUNGRY);
        } else {
            output.setText(THINKING);
        }
            try {
                sleep(sleepTime.nextInt(1000) + 100);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
    }
    
    public void terminate() {
        running = false;
    }

    @Override
    public void run() {
        super.run(); 
        while(running) {
            eat();
            think();
        }
    }
    
    
}
