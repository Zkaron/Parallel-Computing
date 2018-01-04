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
public class ThreadClass extends Thread {
    public ThreadClass(String str) {
        super(str);
    }
    
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
        }
        System.out.println("Termina el thread " + getName());
    }
    
    public static void main(String[] args) {
        new ThreadClass("Pepe").start();
        new ThreadClass("Juan").start();
        System.out.println("Termina thread main");
    }
}
