package QLSV;

public class Node {

    String name;
    int age;
    Node next;

    public Node() {

    }

    public Node(String name, int age, Node next) {
        this.name = name;
        this.age = age;
        this.next = next;
    }
}
