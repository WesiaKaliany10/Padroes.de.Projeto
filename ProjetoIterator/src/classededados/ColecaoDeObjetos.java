/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classededados;
import java.util.Iterator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.Stack;
import java.util.function.Consumer;

/**
 *
 * @author Wésia
 */

public class ColecaoDeObjetos implements Iterator {
    
 HashSet<Piloto> hashSet = new HashSet<>();
 TreeSet<Piloto> treeSet = new TreeSet<>();
 LinkedList<Piloto> LinkedList = new LinkedList<>();
 PriorityQueue<Piloto> PriorityQueue = new PriorityQueue<>();
 Stack<Piloto> Stack = new Stack<>();

    public void adicionarPiloto(Piloto p) {
        hashSet.add(p);
        treeSet.add(p);
        LinkedList.add(p);
        PriorityQueue.add(p);
        Stack.add(p);
        
    }

    public HashSet<Piloto> getHashSet() {
        return hashSet;
    }

    public void setHashSet(HashSet<Piloto> hashSet) {
        this.hashSet = hashSet;
    }

    public TreeSet<Piloto> getTreeSet() {
        return treeSet;
    }

    public void setTreeSet(TreeSet<Piloto> treeSet) {
        this.treeSet = treeSet;
    }

    public LinkedList<Piloto> getLinkedList() {
        return LinkedList;
    }

    public void setLinkedList(LinkedList<Piloto> LinkedList) {
        this.LinkedList = LinkedList;
    }

    public PriorityQueue<Piloto> getPriorityQueue() {
        return PriorityQueue;
    }

    public void setPriorityQueue(PriorityQueue<Piloto> PriorityQueue) {
        this.PriorityQueue = PriorityQueue;
    }

    public Stack<Piloto> getStack() {
        return Stack;
    }

    public void setStack(Stack<Piloto> Stack) {
        this.Stack = Stack;
    }

    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object next() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remove() {
        Iterator.super.remove(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void forEachRemaining(Consumer action) {
        Iterator.super.forEachRemaining(action); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
      
        
     


    