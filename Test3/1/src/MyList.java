/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

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

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(Castor x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void addLast(String xPlace, int xDepth, int xType) {
        //You should write here appropriate statements to complete this function.
        if (xPlace.charAt(0)=='A') {
           return;
       }else{
           Castor s = new Castor(xPlace, xDepth, xType);
            addLast(s);
       }
    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void addFirst(Castor x)
     {
//         Node q=new Node(x, head);
//         head=q;
         head=new Node(x, head);
         //ban dau chua co phan tu nao
         if(tail==null){
             tail=head;
         }
     }
    
    Node pos(int k)
     {
         int i=0;
         Node p=head;
         while(p!=null){
             if(i==k) return(p);
             p=p.next;
             i++;
         }
         return(null);
     }
    
    void insertAfter(Node q, Castor x)
     {
         if(q==null) return;
         //phan tu sau q
         Node q1=q.next;
         Node p=new Node(x, q1);
         //noi q vao p
         q.next=p;
         //neu q la duoi
         if(q==tail)
             tail=p;
     }

    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Castor x, y;
        x = new Castor("X", 1, 2);
        y = new Castor("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        
        addFirst(y);
        insertAfter(pos(2), x);
       
        
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    Node findMaxType()
     {  if(isEmpty()) return null;
        Node p,q;//q danh dau
        
        p=q=head;
        int max=p.info.type;
        while(p!=null){
            if(p.info.type>max){
                q=p;
                max=p.info.type;
            }
            p=p.next;
        }
         return(q);
     }
    
    

    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        
        Node n = findMaxType();
        n.info.place="XX";
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    int size()
     { 
         int count=0;
         Node p=head;
         while(p!=null){
             count++;
             p=p.next;
         }
         return(count);
     }
    
    void sortByAge(int  k, int h)
     { int n=size();
       if(k>=h) return;
       if(k<0) k=0;
       if(h>n-1) h=n-1;
       Node a=pos(k);
       Node b=pos(h+1);
       Node pi,pj;
        Castor t;
         for (pi=a; pi!=b;pi=pi.next) {
             for (pj=pi.next;pj!=b;pj=pj.next) {
                 if(pj.info.depth<pi.info.depth){
                     t=pi.info;
                     pi.info=pj.info;
                     pj.info=t;
                 }
             }
         }
       
     }

    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        
        sortByAge(2, 5);
        
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
