/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial2;

/**
 *
 * @author luis
 */
public class ThreadInterface implements Runnable {
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
        }
        System.out.println("Termina thread " + Thread.currentThread().getName());
    }
    
    public static void main(String[] args) {
        new Thread(new ThreadInterface(), "Pepe").start();
        new Thread(new ThreadInterface(), "Juan").start();
        System.out.println("Termina thread main");
    }
}
