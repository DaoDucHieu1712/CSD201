
public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    // (1) 
    void addLast(Person x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
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

    // (2)
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

    Node searchByAge(int xAge) {
        Node p = head;
        while (p != null) {
            if (p.info.age == xAge) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }
    // (3)

    void addFirst(Person x) {
//         Node q=new Node(x, head);
//         head=q;
        head = new Node(x, head);
        //ban dau chua co phan tu nao
        if (tail == null) {
            tail = head;
        }
    }

    // (4) O(hs)
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

    // (5)
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

    // (6)
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

    void remove(Node q) {
        if (q == null) {
            return;
        }
        //neu q o dau
        if (q == head) {
            removeFirst();
            return;
        }
        //tim phan tu truoc q
        Node p = head;
        while (p != null && p.next != q) {
            p = p.next;
        }
        //khong tim thay p=null
        if (p == null) {
            return;
        }
        //tim thay p la node truoc cua q
        //tim node sau q
        Node q1 = q.next;
        //noi truoc voi sau
        p.next = q1;
        //q la cuoi p.next==null
        if (p.next == null) {
            tail = p;
        }
    }

    // (7)
    void remove(String xName) {
        //tim ra cai phan tu co info name la xName
        //remove()
        Node q = searchByName(xName);
        remove(q);
    }

    // (8)
    void remove(int xAge) {
        Node q = searchByAge(xAge);
        remove(q);
    }

    // (9)
    void removeAll(int xAge) {
        Node q;
        while (true) {
            q = searchByAge(xAge);
            if (q == null) {
                break;
            }
            remove(q);
        }
    }

    // (10)
    Node pos(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return (p);
            }
            p = p.next;
            i++;
        }
        return (null);
    }

    // (11)
    void removePos(int k) {
        Node p = pos(k);
        remove(p);
    }

    // (12)
    void sortByName() {
        Node pi, pj;
        Person t;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pj.info.name.compareTo(pi.info.name) < 0) {
                    t = pi.info;
                    pi.info = pj.info;
                    pj.info = t;
                }
            }
        }
    }

    // (13)
    void sortByAge() {
        Node pi, pj;
        Person t;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pj.info.age < pi.info.age) {
                    t = pi.info;
                    pi.info = pj.info;
                    pj.info = t;
                }
            }
        }

    }

    // (14)
    int size() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return (count);
    }

    // (15)
    Person[] toArray() {
        int n = size();
        Person[] arr = new Person[n];
        int i = 0;
        Node p = head;
        while (p != null) {
            //arr[i]=p.info;//khong cap phat dic chi
            arr[i] = new Person(p.info.name, p.info.age);
            p = p.next;
            i++;
        }
        return (arr);
    }

    // (16)
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

    // (17) 
    Node findMaxAge() {
        if (isEmpty()) {
            return null;
        }
        Node p, q;//q danh dau

        p = q = head;
        int max = p.info.age;
        while (p != null) {
            if (p.info.age > max) {
                q = p;
                max = p.info.age;
            }
            p = p.next;
        }
        return (q);
    }

    // (18) 
    Node findMinAge() {
        if (isEmpty()) {
            return null;
        }
        Node p, q;//q danh dau

        p = q = head;
        int min = p.info.age;
        while (p != null) {
            if (p.info.age < min) {
                q = p;
                min = p.info.age;
            }
            p = p.next;
        }
        return (q);
    }

    // (19) 
    void setData(Node p, Person x) {
        if (p == null) {
            return;
        }
        p.info = x;
    }

    // (20) 
    void sortByAge(int k, int h) {
        int n = size();
        if (k >= h) {
            return;
        }
        if (k < 0) {
            k = 0;
        }
        if (h > n - 1) {
            h = n - 1;
        }
        Node a = pos(k);
        Node b = pos(h + 1);
        Node pi, pj;
        Person t;
        for (pi = a; pi != b; pi = pi.next) {
            for (pj = pi.next; pj != b; pj = pj.next) {
                if (pj.info.age < pi.info.age) {
                    t = pi.info;
                    pi.info = pj.info;
                    pj.info = t;
                }
            }
        }

    }

    // (21) 
    void reverse(int k, int h) // reverse from k to h 
    {
        int n = size();
        if (k >= h) {
            return;
        }
        if (k < 0) {
            k = 0;
        }
        if (h > n - 1) {
            h = n - 1;
        }
        Person[] s = toArray();
        Person x;
        int i = k;
        int j = h;
        while (i < j) {
            x = s[i];
            s[i] = s[j];
            s[j] = x;
            i++;
            j--;
        }
        clear();
        for (i = 0; i < n; i++) {
            addLast(s[i]);
        }
    }
}
