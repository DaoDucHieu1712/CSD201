/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }
    
    /**
     * 
     */
    void clear() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void visit(Node p) {
        if (p != null) {
            System.out.print(p.info);
        }
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    void addMany(String[] a, int[] b) {
        int n, i;
        n = a.length;
        for (i = 0; i < n; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }

    void addLast(Person x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void addFirst(Person x) {
//         Node q=new Node(x, head);
//         head=q;
        head = new Node(x, head);
        //ban dau chua co phan tu nao
        if (tail == null) {
            tail = head;
        }
    }

    void insertAfter(Node q, Person x) {
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

    Node searchByName(String xName) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(xName)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

    void insertBefore(Node q, Person x) {
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

    void reverse() {
        MyList m = new MyList();
        Node p = head;
        while (p != null) {
            m.addFirst(new Person(p.info.name, p.info.age));
            p = p.next;
        }
        head = m.head;
        tail = m.tail;
    }
}
