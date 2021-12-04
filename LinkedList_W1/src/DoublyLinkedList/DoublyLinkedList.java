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
public class DoublyLinkedList {

    Node header;
    Node trailer;

    public DoublyLinkedList() {
        header = new Node(Integer.MIN_VALUE, null, null);
        trailer = new Node(Integer.MIN_VALUE, null, header);
        header.next = trailer;
    }
    
    public void checkEmpty() {
        if (header == null) {
            System.out.println("List Empty");
            return;
        } else {
            System.out.println("List not Empty");
        }
    }

    private void insert(int value, Node font, Node back) {
        Node new_node = new Node(value, back, font);
        font.next = new_node;
        back.prev = new_node;
    }

    public void addLast(int value) {
        insert(value, header, header.next);
    }

    public void addFirst(int value) {
        insert(value, trailer.prev, trailer);
    }

    public Node remove(Node n) {
        if (n != header && n != trailer) {
            Node font = n.prev;
            Node back = n.next;
            font.next = back;
            back.prev = font;
        }
        return n;
    }

    public int removeFirst() {
        return remove(header.next).value;
    }

    public int removeLast() {
        return remove(trailer.prev).value;
    }

    public void traversal() {
        for (Node n = header.next; n != trailer; n = n.next) {
            System.out.print(n.value + " ");
        }
        System.out.print("\r\n");
    }
    
    public void insertBefore(Node q, int x) {
        if (q == null) {
            return;
        }
        //phan tu sau q
        Node q1 = q.next;
        Node q2 = q.next;
        Node p = new Node(x, q1, q2);
        //noi q vao p
        q.next = p;
        //neu q la duoi
        if (q == trailer) {
            trailer = p;
        }
    }

    void insertAfter(Node q, int x) {
        if (q == null) {
            return;
        }
        //q o dau
        if (q == header) {
            addFirst(x);
            return;
        }
        //tim phan tu truoc q
        Node p = header;
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
    
    
     //tra ve vi tri index 
    public Node get(int k) {
        Node p = header;
        int c = 0;
        while (p != null && c < k) {
            c++;
            p = p.next;
        }
        return p;
    }

    // tim vi tri cua Node
    public Node search(int x) {
        Node p = header;
        while (p != null && p.value != x) {
            p = p.next;
        }
        return p;
    }
}
