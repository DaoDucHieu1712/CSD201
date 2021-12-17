/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import Entity.Book;

/**
 *
 * @author Kien
 */
public class Node {
    public Book info;
    public Node left;
    public Node right;

    public Node() {
    }
    
    public Node(Book info){
        this.info = info;
        left = right = null;
    }
}
