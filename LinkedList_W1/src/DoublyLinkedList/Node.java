/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoublyLinkedList;

/**
 *
 * @author ADMIN
 */
public class Node {

    int value;
    Node next;
    Node prev;

    public Node(int value, Node next_node, Node prev_node) {
        this.value = value;
        this.next = next_node;
        this.prev = prev_node;
    }
}
