
import java.util.LinkedList;

public class MyStack {
   LinkedList<Integer> t;
   MyStack() {
     t=new LinkedList<>();  
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
      if(isEmpty()) return(null);
      return(t.removeFirst());
   }
   Integer top() {
      if(isEmpty()) return(null);
      return(t.getFirst());    
   }
}
