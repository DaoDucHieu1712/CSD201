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
public class Reader_Node {
    Reader info;
    Reader_Node next;

    public Reader_Node(Reader x, Reader_Node p) {
        info = x;
        next = p;
    }
    
    public Reader_Node(Reader x){
        this(x,null);
    }
}
