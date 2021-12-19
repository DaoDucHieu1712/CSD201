
import java.util.LinkedList;


public class MyQueue {
   LinkedList<Node> q;

    public MyQueue() {
        q=new LinkedList<>();
    }
    void clear(){
        q.clear();
    }
    boolean isEmpty(){
        return q.isEmpty();
    }
    void enqueue(Node p){
        q.addLast(p);
    }
    Node dequeue(){
        if(isEmpty()) return null;
        return q.removeFirst();
    }
    Node front(){
        if(isEmpty()) return null;
        return q.getFirst();
    }
   
}
