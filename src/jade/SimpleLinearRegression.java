/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jade;

import javax.swing.*;
import java.util.*;

/**
 *
 * @author ratedstark
 */
public class SimpleLinearRegression {
    //beta0 = a
    double beta0, beta1;
    int[] dataX = {651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518}; 
    int[] dataY = {23, 26, 30, 34, 43, 48, 52, 57, 58}; 

    double sumaX = 0, x, y;
    double sumaY = 0, promedioX = 0, promedioY = 0, totalNumerador = 0, totalDenominador = 0;
    double advertising = 0;
    
    private Double redondear(Double n) {
        return Math.rint(n * 10000) / 10000;
    }
    
    public void formula(){
        System.out.println("+------+-------+-------------+\n" +
                           "| Año  | Ventas| Publicidad  |\n" +
                           "+------+-------+-------------+\n" +
                           "| 1    | 651   | 23          |\n" +
                           "+------+-------+-------------+\n" +
                           "| 2    | 856   | 26          |\n" +
                           "+------+-------+-------------+\n" +
                           "| 4    | 1063  | 34          |\n" +
                           "+------+-------+-------------+\n" +
                           "| 5    | 1190  | 43          |\n" +
                           "+------+-------+-------------+\n" +
                           "| 6    | 1298  | 48          |\n" +
                           "+------+-------+-------------+\n" +
                           "| 7    | 1421  | 52          |\n" +
                           "+------+-------+-------------+\n" +
                           "| 8    | 1440  | 57          |\n" +
                           "+------+-------+-------------+\n" +
                           "| 9    | 1518  | 58          |\n" +
                           "+------+-------+-------------+");
        
             // Suma de X e Y 
        for (int i = 0; i < dataX.length; i++) {
            sumaX += dataX[i];
            sumaY += dataY[i];
        }
        
        promedioX = sumaX / dataX.length;
        promedioY = sumaY / dataX.length;
        
        
        //Sumatioria (x-x1) (y-y1)
        for (int i = 0; i < dataX.length; i++) {
            x = dataX[i];
            y = dataY[i];

           totalNumerador  += (x - promedioX) * (y - promedioY);
           totalDenominador += (x - promedioX) * (x - promedioX);
        }
        //b 
        beta1 = totalNumerador / totalDenominador;
        //a
        beta0 = promedioY - beta1 * promedioX;
        
        beta0 = redondear(beta0);
        beta1 = redondear(beta1);

  
        System.out.println("ŷ = " + beta1 + "x + " + beta0);  
        int fieldX = Integer.parseInt(JOptionPane.showInputDialog("Ventas: "));
        
        advertising = (beta1 * fieldX) + (beta0);
        System.out.println("\n");
        System.out.println("Publicidad = " + beta1 + "x + " + beta0);
        System.out.println("Publicidad = " + advertising);
    }
}
