/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackArray;

/**
 *
 * @author ADMIN
 */
public class Stack {

    Node head;

    public Stack() {
        head = null;
    }
    
    public void clear() {
        head = null;
    }
    
    public void traversal() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info + "  ");
            p = p.next;
        }
        System.out.println("");
    }
    
    public boolean isEmpty() {
        return head == null;
    }

    public void push(int info) {
        Node p = new Node(info);
        if (isEmpty()) {
            head = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    public int pop() {
        if (isEmpty()) {
            return 0;
        }
        int info = head.info;
        head = head.next;
        return info;
    }

    public int top() {
        if (isEmpty()) {
            return 0;
        }
        int info = head.info;
        return info;
    }

     public int size() {
        Node p = head;
        int c = 0;
        while (p != null) {
            c++;
            p = p.next;
        }
        return c;
    }
}
