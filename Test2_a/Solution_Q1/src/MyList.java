/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class MyList
 {Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty()
   {return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception
   {if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception
   {Node p = head;
    while(p!=null)
      {fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadDataToLast(int k)  //do not edit this function
   {String [] a = Lib.readLineToStrArray("person.txt", k);
    int [] b = Lib.readLineToIntArray("person.txt", k+1);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i]);
   }

  void loadDataToFirst(int k)  //do not edit this function
   {String [] a = Lib.readLineToStrArray("person.txt", k);
    int [] b = Lib.readLineToIntArray("person.txt", k+1);
    int n = a.length;
    for(int i=0;i<n;i++) addFirst(a[i],b[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void addLast(Person x) {
     Node q=new Node(x);
     if(isEmpty()) {
        head=tail=q;
        return;
     }
     tail.next=q;
     tail=q;
  }
  void addLast(String xName, int xAge)
   {//You should write here appropriate statements to complete this function.
    if(xName.charAt(0)=='B') return;
    Person x = new Person(xName,xAge);
    addLast(x);
   }

  void addFirst(Person x) {
    head = new Node(x,head);
    if(tail==null) tail=head;
  }
  void addFirst(String xName, int xAge)
   {//You should write here appropriate statements to complete this function.
    if(xName.charAt(0)=='B') return;
    Person x = new Person(xName,xAge);
    addFirst(x);
   }

//=================================================================
  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
     */
     clear();
     loadDataToLast(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     ftraverse(f123);
     f123.close();
    }  

//=================================================================
  void f2() throws Exception
    {/* You do not need to edit this function. Your task is to complete the addFirst  function
        above only.
     */
     clear();
     loadDataToFirst(1);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     ftraverse(f123);
     f123.close();
    }  

//=================================================================
  void f3() throws Exception
   {clear();
    loadDataToLast(4);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);

    MyList  h = new MyList();
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     Node p = head;
     while(p!=null) {
       if(p.info.age>4)  {
         Person x = new Person(p.info.name,p.info.age);
         h.addLast(x);
       }
       p=p.next;
               
     }
    //-------------------------------------------------------------------------------------
    h.ftraverse(f123);
    f123.close();
   }

//=================================================================
  void remove(Node q) {
    if(q==null) return;
    Node f = head;
    while(f!=null && f.next!=q) f=f.next;
    if(f==null) return; // q is not found in the list
    Node q1 = q.next;
    f.next = q1;
    if(q==tail) tail=f;
  }
  Node search() {
    Node p=head;
    while(p!=null) {
      if(p.info.age<6) return(p);
      p=p.next;
    }
    return(null);
  }
  void f4() throws Exception
   {clear();
    loadDataToLast(4);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     Node p = search();
     if(p!=null) remove(p);
    //-------------------------------------------------------------------------------------
     ftraverse(f123);
     f123.close();
   }

//=================================================================
  void sortByName() {
    Node pi,pj;
    pi=head;Person x;
    while(pi!=null) {
      pj=pi.next;
      while(pj!=null) {
       if(pj.info.name.compareTo(pi.info.name)<0) {
         x=pi.info;pi.info=pj.info; pj.info=x;
       }
       pj=pj.next;
      }
     pi=pi.next;
    }
  }
  void f5() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f5.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

       sortByName();
    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }


//=================================================================
  void f6() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f6.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    
    MyList h = new MyList();
    Node p=head;
    while(p!=null) {
      h.addFirst(p.info);
      p=p.next;
    }
    head = h.head;
    tail = h.tail;
    //--------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

//=================================================================
  void f7() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f7.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    MyList h = new MyList();
    h.loadDataToLast(7);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     Node p=h.head;
     while(p!=null) {
       addLast(p.info);
       p=p.next;
     }

    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

//=================================================================
  Node pos(int k) {
    int i=0;
    Node p=head;
    while(p!=null) {
      if(i==k) return(p);
      i++; p=p.next;
    }
    return(null);
  }
  void f8() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f8.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    int k = 3;
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     Node q = pos(k);
     remove(q);
    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

//=================================================================
  Node searchByName(String xName) {
      Node p=head;
      while(p!=null) {
         if(p.info.name.equals(xName)){
            return(p);
         }
         p=p.next;
      }
     return(null); 
  }
  void f9() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f9.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    String xName = "C6";
    String yName = "CX";
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

    Node q = searchByName(xName);
    if(q!=null) q.info.name = "CX";
    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

 }
