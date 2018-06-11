/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial3.proyecto;

import static Parcial3.proyecto.ServerRMI.matrixA;
import static Parcial3.proyecto.ServerRMI.matrixB;
import static Parcial3.proyecto.ServerRMI.matrixC;

/**
 *
 * @author Erik
 */
public class MatrixMultiplicationThread implements Runnable {
   
    /*private final int rowA;
    private final int colA;
    private final int rowB;
    private final int colB;*/
    private final int size;
    
    private final int startRow;
    private final int startCol;
    private final int sectionToMultiply;
    /*private final int[][] mB;
    private final int[][] mA;
    private final int[][] mC;*/
    
    public MatrixMultiplicationThread(int row, int col, int sectionToMultiply) {
        //this.mA = mA;
        //this.rowA = rowA;
        //this.colA = colA;
        //this.mB = mB;
        //this.rowB = rowB;
        //this.colB = colB;
        //this.mC = mC;
        this.size = matrixC.length;
        this.startRow = row;
        this.startCol = col;
        this.sectionToMultiply = sectionToMultiply;
    }

    @Override
    public void run() {
       //mC[sectionToMultiply][sectionToMultiply] = 0;
        for(int i = startRow; i < matrixC.length; i++){
            for(int j = startCol; j < matrixC.length; j++) {
                for(int k = 0; k < matrixC.length; k++) {
                    matrixC[i][j] += matrixA[i][k]*matrixB[k][j];
                }
                break;
            }
         }
        
        /*//matriz A
        System.out.println("La A");
        for(int i = 0; i < matrixA.length; i++) {
            for(int j = 0; j < matrixA.length; j++) {
                System.out.print(matrixA[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println();
        
        //matriz B
        System.out.println("La B");
        for(int i = 0; i < matrixB.length; i++) {
            for(int j = 0; j < matrixB.length; j++) {
                System.out.print(matrixB[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println();*/
    }
    
}
