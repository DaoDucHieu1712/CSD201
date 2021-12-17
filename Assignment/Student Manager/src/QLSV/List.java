package QLSV;

public class List {

    Node head, tail;

    public List() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void addHead(String x, int y) {
        Node p = new Node(x, y, null);
        if (isEmpty()) {

            head = tail = p;
        } else {
            p.next = head;
            head = p;

        }
    }

    void addTail(String x, int y) {
        Node p = new Node(x, y, null);
        if (isEmpty()) {

            head = tail = p;
        } else {
            tail.next = p;
            tail = p;

        }
    }

    void addposition(int k, String x, int y) {
        if (k == 0) {
            addHead(x, y);
            return;
        }
        Node p = head;
        int count = 0;
        while (p != null) {
            if (count == k - 1) {
                break;
            } else {
                p = p.next;
                count++;
            }
        }
        Node q = new Node(x, y, null);
        q.next = p.next;
        p.next = q;
        if (tail.next != null) {
            tail = q;
        }
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print(p.name + " : " + p.age);
            System.out.println(" ");
            p = p.next;
        }
        System.out.println("");
    }

    void searchByName(String x) {
        Node p = head;
        int count = 0;
        int ok = 0;
        while (p != null) {

            if (p.name.equalsIgnoreCase(x)) {
                System.out.println("Index of " + p.name + ": " + count);
                ok = 1;
                break;
            } else {
                p = p.next;

            }
            count++;
        }
        if (ok == 0) {
            System.out.println("Don't have Name in List");
        }
    }

    void searchByAge(int y) {
        Node p = head;
        int count = 0;
        int ok = 0;
        while (p != null) {

            if (p.age == y) {
                System.out.println(p.age + " Have index: " + count);
                ok = 1;
                break;
            } else {
                p = p.next;

            }
            count++;
        }
        if (ok == 0) {
            System.out.println("Don't have age in List");
        }
    }

    void delete_head() {
        Node pi;
        pi = head;
        if (isEmpty()) {
            return;
        }
        System.out.println("\nList after delete head :");
        pi = head.next;
        head = pi;

    }

    void delete_tail() {
        Node temp;
        temp = head;
        if (isEmpty()) {
            head = tail = temp;
        }
        while (temp.next != tail) {
            temp = temp.next;
        }
        System.out.println("\nList after delete tail :");
        temp.next = null;
        tail = temp;

    }

    void deleteAt(int index) {
        if (head == null) {
            System.out.println("Node empty. Can not delete");
            return;
        }
        if (index == 0) {
            delete_head();
            return;
        }
        Node p = head;
        int i = 1;
        while (p.next != null) {
            if (i == index) {
                break;
            } else {
                p = p.next;
                i++;
            }
        }
        if (p.next == null) {
            System.out.println("The index does not exist");
        } else {
            p.next = p.next.next;
        }
    }
}
