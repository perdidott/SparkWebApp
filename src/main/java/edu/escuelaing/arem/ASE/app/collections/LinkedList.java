/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.ASE.app.collections;


import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



/**
 *
 * @author 2114816
 */
public class LinkedList<T> extends AbstractSequentialList implements List{
    
    private LinkedListNode first=null;
    private LinkedListNode last=null;
    
    public LinkedList(Collection<T> c){
        Iterator<T> i = c.iterator();
        while (i.hasNext()){
            if (first == null){
                first = new LinkedListNode<T>(i.next());
                last = first;
            }
            else{
                LinkedListNode<T> tmp = new LinkedListNode<T>(i.next());
                last.setNext(tmp);
                last = tmp;
            }
        }
    }
    
    public LinkedList(){
        
    }


    @Override
    public ListIterator listIterator(int index) {
        LinkedListIterator tmp = new LinkedListIterator(this);
        while (tmp.nextIndex() != index && (index!=0)){
            tmp.next();
        }
        return tmp;
    }

    @Override
    public int size() {
        int tamano = 0;
        if (first == null){
            return 0;
        }
        LinkedListNode tmp = first;
        while (tmp.getNext() != null){
            tamano++;
            tmp = tmp.getNext();
        }
        return tamano + 1;
    }

    LinkedListNode getFirst() {
        return first;
    }

    LinkedListNode getLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
