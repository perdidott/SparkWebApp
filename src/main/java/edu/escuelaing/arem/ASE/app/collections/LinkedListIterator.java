/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.ASE.app.collections;

import java.util.ListIterator;

/**
 *
 * @author 2114816
 */
public class LinkedListIterator<T> implements ListIterator<T> {

    LinkedListNode next= null;
    LinkedListNode previous= null;
    LinkedList l;
    int index = 0;

    public LinkedListIterator(LinkedList l) {
        this.l = l;
        next = l.getFirst();
        previous = null;
    }

    public boolean hasNext() {
        if (next == null) {
            return false;
        }
        return true;
    }

    public T next() {
        if (hasNext()) {
            LinkedListNode<T> tmp = next;
            previous = tmp;
            next = tmp.getNext();
            index++;
            return tmp.getValue();
        }
        return null;
    }

    public boolean hasPrevious() {
        if (previous == null) {
            return false;
        }
        return true;
    }

    public T previous() {
        if (hasPrevious()) {
            LinkedListNode<T> tmp = previous;
            next = tmp;
            previous = getPrevious(tmp);
            index--;
            return tmp.getValue();
        }
        return null;

    }

    private LinkedListNode getPrevious(LinkedListNode tmp) {
        LinkedListNode actual = l.getFirst();
        if (tmp == actual) {
            return null;
        }
        while (actual.getNext() != tmp) {
            actual = actual.getNext();
        }
        return actual;
    }

    public int nextIndex() {
        return index + 1;
    }

    public int previousIndex() {
        return index - 1;
    }

    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void set(T e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void add(T e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    

}
