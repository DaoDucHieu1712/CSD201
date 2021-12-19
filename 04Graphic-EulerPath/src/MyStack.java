import java.util.*;
public class MyStack {
  LinkedList<Integer> t;
  MyStack() {
    t = new LinkedList<Integer>();  
  }
  void clear() {
    t.clear();  
  }
  boolean isEmpty() {
    return(t.isEmpty());  
  }
  void push(Integer p) {
    t.addFirst(p);  
  }
  Integer pop() {
    if(t.isEmpty()) return(null); 
    return(t.removeFirst());
  }
  Integer top() {
    if(t.isEmpty()) return(null); 
    return(t.getFirst());
  }
  
}
