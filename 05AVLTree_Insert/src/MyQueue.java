
public class MyQueue {
    QNode head,last;
    MyQueue() {
        head=last=null;
    }
    void clear() {head=last=null;}
    boolean isEmpty() {return(head==null);}
    void enqueue(Object x)
    {
        QNode q = new QNode(x);
        if(isEmpty()){
            head=last=q;
            return;
        }
        last.next=q;last=q;
    }
    Object dequeue()
   {
       if(isEmpty()) 
           return(null);
        Object x = head.info;
        head=head.next; if(head==null) last=null;
        return(x);
   }
}
