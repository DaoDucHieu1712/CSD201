/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import Entity.Reader;

/**
 *
 * @author Admin
 */
public class Reader_List {
    public Reader_Node head, tail;

    public Reader_List() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public int size() {
        int count = 0;
        Reader_Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    // (1) 
    public void addLast(Reader x) {
        Reader_Node q = new Reader_Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }
    
    public void addFirst(Reader x) {
        head = new Reader_Node(x, head);
        if (tail == null) {
            tail = head;
        }
    }

    public Reader get(int i) {
        int count = 0;
        for (Reader_Node temp = head; temp != null; temp = temp.next) {
            if (count == i) {
                return temp.info;
            }
            count++;
        }
        return (null);
    }

    public void visit(Reader_Node p) {
        if (p != null) {
            System.out.print(p.info + " ");
        }
    }

    public void traverse() {
        Reader_Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
    }

    //delete at position k
    public void deleteAt(int k) {
        if (isEmpty()) {
            return;
        }
        if (k == 0) {//check if node is head
            Reader_Node p = head;
            head = head.next;
            p.next = null;
        } else {
            Reader_Node p = pos(k);//get node position k
            if (p == null) {
                return;
            }
            Reader_Node q = pos(k - 1);//q is node before of p
            // Remove p
            q.next = p.next;
            p.next = null;
            if (p == tail) {
                tail = q;
            }
        }
    }

    public Reader_Node pos(int k) {
        int count = 0;
        for (Reader_Node temp = head; temp != null; temp = temp.next) {
            if (count == k) {
                return temp;
            }
            count++;
        }
        return (null);
    }
}
