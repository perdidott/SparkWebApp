/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.ASE.app.collections;

/**
 *
 * @author 2114816
 */
public class LinkedListNode<T> {
    private T value;
    private LinkedListNode next;
    
    public LinkedListNode(T elemento){
        value = elemento;
        next = null;
    }
    
    public LinkedListNode(T elemento, LinkedListNode nodo){
        value = elemento;
        next = nodo;
    }
    
    public T getValue(){
        return value;
    }
    
    public void setValue(T elemento){
        value = elemento;
    }
    
    public LinkedListNode getNext(){
        return next;
    }
    
    public void setNext(LinkedListNode nodo){
        next = nodo;
    }
    
    
}
