/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Linked_List;



/**
 *
 * @author ADMIN
 */
public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    //return true if Mylist is empty otherwise return false
    public boolean isEmpty() {
        return head == null;
    }

    //append a new node to the end of list
    public void addLast(int x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    //insert a new node to the beginning of list
    public void addFirst(int x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    //output list
    public void traversal() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info + "  ");
            p = p.next;
        }
        System.out.println("");
    }

    void insertAfter(Node q, int x) {
        if (q == null) {
            return;
        }
        //phan tu sau q
        Node q1 = q.next;
        Node p = new Node(x, q1);
        //noi q vao p
        q.next = p;
        //neu q la duoi
        if (q == tail) {
            tail = p;
        }
    }

    void insertBefore(Node q, int x) {
        if (q == null) {
            return;
        }
        //q o dau
        if (q == head) {
            addFirst(x);
            return;
        }
        //tim phan tu truoc q
        Node p = head;
        while (p != null && p.next != q) {
            p = p.next;
        }
        //p=null khong tim thay q
        if (p == null) {
            return;
        }
        //p.next=q  chen sau p - truoc q
        insertAfter(p, x);
    }

    //tra ve so luong node
    public int size() {
        Node p = head;
        int c = 0;
        while (p != null) {
            c++;
            p = p.next;
        }
        return c;
    }

    //tra ve vi tri index 
    public Node get(int k) {
        Node p = head;
        int c = 0;
        while (p != null && c < k) {
            c++;
            p = p.next;
        }
        return p;
    }

    // tim vi tri cua Node
    public Node search(int x) {
        Node p = head;
        while (p != null && p.info != x) {
            p = p.next;
        }
        return p;
    }

    // xoa dau 
    void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        //dslk co 1 phan tu va da bi xoa
        if (head == null) {
            tail = null;
        }
    }

    // dao nguoc
    public void reverse() {
        int n = size();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            Node pi = get(i), pj = get(j);
            int t = pi.info;
            pi.info = pj.info;
            pj.info = t;
        }
    }

    //sap xep
    void sort() {
        Node pi, pj;
        int t;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pj.info < pi.info) {
                    t = pi.info;
                    pi.info = pj.info;
                    pj.info = t;
                }
            }
        }

    }

}
