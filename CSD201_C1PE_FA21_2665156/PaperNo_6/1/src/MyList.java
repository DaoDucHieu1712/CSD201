/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {
  Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty() {
    return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception {
    Node p = head;
    while(p!=null) {
       fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadData(int k) { //do not edit this function
    String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int [] c = Lib.readLineToIntArray("data.txt", k+2);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i],c[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
  void addLast(Bee x) {
     Node q=new Node(x);
     if(isEmpty()) {
        head=tail=q;
        return;
     }
     tail.next=q;
     tail=q;
  }
  
  void addLast(String xForest, int xRate, int xSound) {
    //You should write here appropriate statements to complete this function.
     if(xForest.charAt(0)=='B') return;
    Bee x = new Bee();
    addLast(x);

   }

  //You do not need to edit this function. Your task is to complete the addLast function above only.
  void f1() throws Exception {
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     f.close();
    }  

//==================================================================
  
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
  
   void insertAfter(Node q, Bee x)
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
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Bee x, y;
     x = new Bee("X",1,2);
     y = new Bee("Y",3,4);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     
      insertAfter(pos(0), x);
      insertAfter(pos(1), y);


    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  

//==================================================================
  
   void removeFirst(){
       if(isEmpty()) return;
       head=head.next;
       //dslk co 1 phan tu va da bi xoa
       if(head==null)
           tail=null;
   }
  
  void remove(Node q)
     {
         if(q==null) return;
         //neu q o dau
         if(q==head){
             removeFirst();
             return;
         }
         //tim phan tu truoc q
         Node p=head;
         while(p!=null && p.next!=q)
             p=p.next;
         //khong tim thay p=null
         if(p==null) return;
         //tim thay p la node truoc cua q
         //tim node sau q
         Node q1=q.next;
         //noi truoc voi sau
         p.next=q1;
         //q la cuoi p.next==null
         if(p.next==null) tail=p;
     }
  
  void removePos(int k)
     {
         Node p=pos(k);
         remove(p);
     }
  
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      removePos(0);
      removePos(2);


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
  
  void sortByRate(int  k, int h)
     { int n=size();
       if(k>=h) return;
       if(k<0) k=0;
       if(h>n-1) h=n-1;
       Node a=pos(k);
       Node b=pos(h+1);
       Node pi,pj;
        Bee t;
         for (pi=a; pi!=b;pi=pi.next) {
             for (pj=pi.next;pj!=b;pj=pj.next) {
                 if(pj.info.rate<pi.info.rate){
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
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    
      sortByRate(0, 4);


    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

 }

