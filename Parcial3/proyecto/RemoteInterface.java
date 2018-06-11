/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial3.proyecto;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Erik
 */
public interface RemoteInterface extends Remote {
    boolean ready = false;
    public void addClient(String client) throws RemoteException;
    public void removeClient(String client) throws RemoteException;
    public void generateMatrix(int matrixSize) throws RemoteException;
    public void compute(int numberOfCores, String clientName) throws RemoteException;
    public void displayResultingMatrix() throws RemoteException;
}
