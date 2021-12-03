/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Linked_List;

/**
 *
 * @author DucHieu
 */
public class Main {

    public static void main(String[] args) {

        MyList m = new MyList();
        Node q, p;
        m.addLast(10);
        m.addLast(30);
        m.addFirst(60);
        m.addFirst(40);
        m.addFirst(50);
        q = m.search(40);
        m.insertAfter(q, 70);
        p = m.search(60);
        m.insertBefore(p, 80);
//      m.reverse();
        m.traversal();
        System.out.println("After Sort :");
        m.sort();
        m.traversal();
    }
}
