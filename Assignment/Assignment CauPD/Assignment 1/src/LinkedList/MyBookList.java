/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import Entity.Book;
/**
 *
 * @author Admin
 */
public class MyBookList {
    public MyBookNode head, tail;

    public MyBookList() {
        head = tail = null;
    }
    
    public boolean isEmpty() {
        return (head == null);
    }
    
    public int size() {
        int count = 0;
        MyBookNode p = head;
        while(p != null){
            count ++;
            p = p.next;
        }
        return count;
    }
    
    public void addLast(Book x) {
        MyBookNode q = new MyBookNode(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }
    
    public void addFirst(Book x) {
        head = new MyBookNode(x, head);
        if (tail == null) {
            tail = head;
        }
    }
    
    public void visit(MyBookNode p) {
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }
    
    public void traverse() {
        MyBookNode p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
    }
    
    public Book get(int i){
        int count = 0;
        for (MyBookNode temp = head; temp != null; temp = temp.next) {
            if (count == i) {
                return temp.info;
            }
            count++;
        }
        return (null);
    }
    
    //delete at position k
	public void deleteAt(int k) {
        if (isEmpty()) return;
        if (k == 0) {//check if node is head
            MyBookNode p = head;
            head = head.next;
            p.next = null;
        } else {	
            MyBookNode p = pos(k);//get node position k
            if (p == null) return;
            MyBookNode q = pos(k - 1);//q is node before of p
            // Remove p
            q.next = p.next;
            p.next = null;
            if (p == tail) tail = q;
        }
    }
        
    public void sortByBCode() {
        MyBookNode pi;
        MyBookNode pj;
        Book x;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pj.info.getBcode().compareTo(pi.info.getBcode()) < 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
 
    public MyBookNode pos(int k) {
        int count = 0;
        for (MyBookNode temp = head; temp != null; temp = temp.next) {
            if (count == k) {
                return temp;
            }
            count++;
        }
        return (null);
    }
    
    public void insertBefore(int k, Book x) {
        MyBookNode p = new MyBookNode(x);
        MyBookNode q = pos(k);
        MyBookNode temp = head;
        if (isEmpty()) {
            head = tail = p;
        } else {
            while (temp != null && temp.next != q) {
                temp = temp.next;
            };
            temp.next = p;
            p.next = q;
        }
    }
    
    public void sortByQuantity() {
        MyBookNode pi;
        MyBookNode pj;
        Book x;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pj.info.getQuantity() < pi.info.getQuantity()) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
}
