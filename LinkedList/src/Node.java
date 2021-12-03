/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Node {

    Person info;
    Node next;

    Node() {
    }

    Node(Person x, Node q) {
        info = x;
        next = q;
    }

    Node(Person x) {
        this(x, null);
    }
}
