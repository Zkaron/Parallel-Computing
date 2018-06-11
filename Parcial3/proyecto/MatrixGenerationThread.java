/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial3.proyecto;

import static Parcial3.proyecto.ServerRMI.matrixA;
import static Parcial3.proyecto.ServerRMI.matrixB;
import static Parcial3.proyecto.ServerRMI.matrixC;
import static Parcial3.proyecto.ServerRMI.matrixGenerated;
import static Parcial3.proyecto.ServerRMI.serverStateLabel;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Erik
 */
public class MatrixGenerationThread implements Runnable {
    int matrixSize;
    
    public MatrixGenerationThread(int matrixSize) {
        this.matrixSize = matrixSize;
    }
    
    @Override
    public void run() {
        serverStateLabel.setText("Generando Matriz...");
        matrixA = new int[matrixSize][matrixSize];
        matrixB = new int[matrixSize][matrixSize];
        matrixC = new int[matrixSize][matrixSize];

        for(int i = 0; i < matrixC.length; i++) {
            for(int j = 0; j < matrixC.length; j++) {
                matrixA[i][j] = ThreadLocalRandom.current().nextInt(0, 10 + 1);
                matrixB[i][j] = ThreadLocalRandom.current().nextInt(0, 10 + 1);

            }
        }
        matrixGenerated = true;      
        serverStateLabel.setText("Generación de matriz terminada");

    }
    
}
