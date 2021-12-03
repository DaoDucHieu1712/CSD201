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
public class Node {

    int info;
    Node next;

    Node(int info, Node next) {
        this.info = info;
        this.next = next;
    }

    Node(int info) {
        this(info, null);
    }
}
