/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList
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

  void loadData(int k)  //do not edit this function
   {String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int [] c = Lib.readLineToIntArray("data.txt", k+2);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i],c[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void addFirst(Radio x) {
       head = new Node(x,head);
       if(tail == null) 
           tail = head;
    }
  
  void addLast(Radio x) {
        Node q = new Node(x);
        
        if(isEmpty()) {
            head = tail = q;
            return;
        }
        
        tail.next = q;
        tail = q;
    }
  
  void addLast(String xOwner, int xVolume, int xWeight)
   {//You should write here appropriate statements to complete this function.
       if(xOwner.charAt(0) == 'A') return;
        
        Radio radio = new Radio(xOwner, xVolume, xWeight);
        addLast(radio);

   }

  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
     */
     clear();
     loadData(2);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     f.close();
    }  

//==================================================================
  void f2() throws Exception
    {clear();
     loadData(6);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Radio x, y;
     x = new Radio("X",1,2);
     y = new Radio("Y",3,4);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     addFirst(y);
     addLast(x);

    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  

//==================================================================
 
  void f3() throws Exception
   {clear();
    loadData(10);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     Node foundNode = head;
    Node prev = null;
    
    
    
    if(foundNode != null) {
        if(prev == null) {
            this.head = foundNode.next;
        } else {
            prev.next = foundNode.next;
        }   
    }

    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

//==================================================================
  
  
  void f4() throws Exception
   {clear();
    loadData(14);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

Node x,y;
    x = head;
    while(x != null) {
        y = x.next;
        while(y != null) {
            // Thay doi dieu kien o day.
            // Day la sap xep tang dan
            // Sap xep dan dan thi doi dau be hon thanh dau lon hon
            if(y.info.weight < x.info.weight) {
                Radio tmp = x.info;
                x.info = y.info;
                y.info = tmp;
            }
            y = y.next;
        }
        x =  x.next;
    }

    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

 }
