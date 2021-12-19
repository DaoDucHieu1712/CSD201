
import java.util.LinkedList;

public class MyStack {
    LinkedList a;
    MyStack() {a = new LinkedList();}
    boolean isEmpty() {return(a.isEmpty());}
    void push(Object x)
   {a.add(x);
   }
    Object pop()
   {return(a.removeLast());
   }
}
