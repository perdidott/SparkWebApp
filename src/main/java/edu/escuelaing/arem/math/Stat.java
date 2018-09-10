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
public class Stat {

    public Double mean(List<Double> listaNumeros) {
        double suma = 0;
        Iterator<Double> i = listaNumeros.iterator();
        while(i.hasNext()){
            Double valor = i.next();
            suma += valor;
        }
        return suma / listaNumeros.size();
    }

}
