
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Queue {

    LinkedList<Node> q;

    public Queue() {
        q = new LinkedList<>();
    }

    void clear() {
        q.clear();
    }

    boolean isEmpty() {
        return q.isEmpty();
    }

    void enqueue(Node p) {
        q.addLast(p);
    }

    Node dequeue() {
        if (isEmpty()) {
            return null;
        }
        return q.removeFirst();
    }

    Node front() {
        if (isEmpty()) {
            return null;
        }
        return q.getFirst();
    }
}
