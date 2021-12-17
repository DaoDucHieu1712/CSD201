/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 10/08/2021    1.0            Vanhv   
 */


/**
 *
 * @author vanhv
 */
public class Node {

    Node next;
    Book info;

    public Node() {
    }

    public Node(Book info, Node next) {
        this.next = next;
        this.info = info;
    }

    public Node(Book b) {
        this(b, null);
    }

}
