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
public class MyBookNode {
    Book info;
    MyBookNode next;

    public MyBookNode(Book x, MyBookNode p) {
        info = x;
        next = p;
    }
    
    public MyBookNode(Book x){
        this(x,null);
    }
}
