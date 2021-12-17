

public class MyList <T> {
    Node <T> head, tail;

    MyList(){
        head = tail = null;
    }

    boolean isEmpty(){
        return head == null;
    }

    int size(){
        Node<T> cu = head;
        int size = 0;
        while(cu != null){
            size++;
            cu = cu.next;
        }return size;
    }

    void addFirst(T data){
        Node<T> n = new Node<>(data);
        if (isEmpty()){
            head = tail = n;
        }else {
            Node<T> cu = head;
            n.next = cu;
            cu = cu.next;
            head = n;
        }
    }

    void addLast(T data){
        Node <T> n = new Node<>(data);
        if (isEmpty()){
            head = tail = n;
        }else{
            tail.next = n;
            tail = n;
        }
    }

    void addAfterPosition(T data, int k){
        if (isEmpty()){
            System.out.println("List empty");
        }else {
            int cnt = k;
            Node<T> cu = head, n = new Node(data);
            while(cnt-- != 0){
                cu = cu.next;
            }
            n.next = cu.next;
            cu.next = n;
        }
    }

    Node<T> traversal(Node n){
        Node<T> cu = head;
        while(cu != null){
            if (cu.data == n.data){
                return cu;
            }
            cu = cu.next;
        }
        return null;
    }

    void delete(Node n){
        Node<T> f = traversal(n);
        if (isEmpty() || f == null){
            return;
        }else if (f == tail){
            Node<T> second_last = head;
            while (second_last.next.next != null)
                second_last = second_last.next;

            // Change next of second last
            second_last.next = null;
        }
        else{
            f.next = f.next.next;
        }
    }

    void display(){
        Node<T> cu = head;
        while(cu != null){
            System.out.println(cu.data.toString());
            cu = cu.next;
        }
    }

    void clear(){
        head = null;
    }
}
