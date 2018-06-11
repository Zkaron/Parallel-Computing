/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial3.proyecto;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
/**
 *
 * @author Erik
 */

public class ServerRMI extends UnicastRemoteObject implements RemoteInterface {

    public static final DefaultListModel CLIENT_LIST = new DefaultListModel();
    public static int waitTime = 10000;
    public final String HOSTNAME = "MatricesRMI";
    public final int RMIREGISTRY = 1431;
    public String hostAddress;
    public static boolean clientAdded = false;
    public static boolean stopWaiting = false;
    public static boolean operationFinished = false;
    public static JLabel clientWaitLabel;
    public static JLabel serverStateLabel;
    public static JTextField elapsedTimeTextField;
    public static long startNanoTime;
    
    public static int matrixSize;
    public static int[][] matrixA;
    public static int[][] matrixB;
    public static int[][] matrixC;
    public static boolean matrixGenerated = false;

    
    public ServerRMI(JTextField ipAddress, JTextField RMIRegistry,JLabel serverStateLabel, JLabel clientWaitLabel, JTextField elapsedTimeTextField, JList clients) throws RemoteException {        
        try {
            java.rmi.registry.LocateRegistry.createRegistry(RMIREGISTRY);   //Equivalente a ejecutar en consola rmiregistry 1431
            
            hostAddress = java.net.InetAddress.getLocalHost().getHostAddress();   //Obtener ip de computadora actual
            //hostAddress = "127.0.0.1";
            java.rmi.Naming.rebind("rmi://" + hostAddress + ":" + RMIREGISTRY + "/" + HOSTNAME, this);
            
            ipAddress.setText(hostAddress);
            RMIRegistry.setText("" + RMIREGISTRY);
            clients.setModel(CLIENT_LIST);
            this.clientWaitLabel = clientWaitLabel;
            this.serverStateLabel = serverStateLabel;
            this.elapsedTimeTextField = elapsedTimeTextField;
            
        } catch(MalformedURLException | UnknownHostException e) {
            e.printStackTrace();
            //Mostrar error
        }
    }
    
    @Override
    public void addClient(String client) throws RemoteException{
        CLIENT_LIST.addElement(client);
        clientAdded = true;
    }

    @Override
    public void removeClient(String client) throws RemoteException{
        int index = CLIENT_LIST.indexOf(client);
        CLIENT_LIST.remove(index);
    }
    
    public static synchronized void waitForClients(long waitingTime) throws RemoteException {
        long currentTime = System.currentTimeMillis();
        long expectedTime = currentTime + waitingTime;
        while(currentTime < expectedTime) {
            if(clientAdded) {
                clientAdded = false;
                return;
            }
            currentTime = System.currentTimeMillis();
            clientWaitLabel.setText("Esperando clientes " + ((expectedTime - currentTime) / 1000) + " segundos restantes");
        }
        stopWaiting = true;
        clientWaitLabel.setText("Espera de clientes terminada");
    }
    
    @Override
    public void generateMatrix(int matrixSize) throws RemoteException {
        //Excecute only when a first client enters
        
        if(CLIENT_LIST.size() > 0 && !(CLIENT_LIST.size() > 1)) {
           this.matrixSize = matrixSize;
           new Thread(new MatrixGenerationThread(matrixSize)).start();
        } else {
            return; //Matrix is already generating, do nothing
        }
    }
    
    @Override
    public void compute(int numberOfCores, String clientName) throws RemoteException {
        //First wait 5 seconds for clients
        LinkedList<Thread> threadList = new LinkedList();
        while(!stopWaiting) {
            waitForClients(5000);
        }
        while(!matrixGenerated) {
            //Just wait
        }
        
        startNanoTime = System.nanoTime();
        //get number of clients
        int numberOfClients = CLIENT_LIST.size();
        //Get client index
        int clientIndex = CLIENT_LIST.indexOf(clientName);
        
        //Excecute the code
        //Fist decide which section of the matrix is going to be multiplied
        int sectionToCover = (matrixSize / numberOfClients);
        int startRow = sectionToCover * clientIndex;
        int startCol = sectionToCover * clientIndex;
        //int end = start + sectionToCover;
        
        //Then divide the work by the number of cores
        //if(matrixSize < numberOfCores) {
            for(int i = 0; i < matrixSize; i++) {
                threadList.add(new Thread(
                new MatrixMultiplicationThread(startRow, 
                        startCol + i, sectionToCover)));

            //And start the threads
            threadList.get(i).start();
            } 
            
           // itsTheEndFolks();
        //} 
        /*else {   
            for(int i = 0; i < numberOfCores; i++) {
                //Crear hilos de acuerdo al numero de hilos
                threadList.add(new Thread(
                    new MatrixMultiplicationThread(startRow + i, 
                            startCol, sectionToCover / numberOfCores)));

                //And start the threads
                threadList.get(i).start();
            }
        }*/
    }
    
    public void itsTheEndFolks() {
        if(CLIENT_LIST.size() == 0) {
            long elapsedNanoTime = System.nanoTime() - startNanoTime;
            elapsedNanoTime /= 1000000;
            elapsedTimeTextField.setText(elapsedNanoTime + " milisegudos");
        }
    }
    
    @Override
    public void displayResultingMatrix() throws RemoteException {
        //If all clients have finished their work
        if(CLIENT_LIST.size() == 0) {
            itsTheEndFolks();
            serverStateLabel.setText("Imprimiendo Resultados...");
            for(int i = 0; i < matrixC.length; i++) {
                for(int j = 0; j < matrixC.length; j++) {
                    System.out.print(matrixC[i][j] + ", ");
                }
                System.out.println();
            }
            serverStateLabel.setText("Terminado");
        }
    }
    
}
 