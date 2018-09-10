/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.math;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author 2114816
 */
public class StandardDeviation {
    
    Stat mean = new Stat();
    
    public Double standardD(List<Double> listaNumeros) {
        long suma = 0;
        double avg = mean.mean(listaNumeros);
        Iterator<Double> i = listaNumeros.iterator();
        while(i.hasNext()){
            Double valor = i.next();
            suma += Math.pow(valor-avg,2);
        }
        return Math.sqrt(suma/(listaNumeros.size()-1));
    }
}
