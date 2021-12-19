
public class AVLTree {
    Node root;
    AVLTree() {root=null;}
    boolean isEmpty()
   {return(root==null);
   }
//======================================================================
  /* Tac vu rotateLeft: xoay trai cay nhi phan tim kiem co nut goc
     la root, yeu cau root phai co nut con ben phai (goi la nut p)
     Sau khi xoay trai thi nut con ben phai p tro thanh nut goc, nut goc
     cu tro thanh nut con ben trai cua nut goc moi
     Tac vu nay tra ve con tro chi nut goc moi 
  */
   Node rotateLeft(Node p)
   {if(p == null || p.right==null)
     {System.out.println(" Cannot rotate left.");return p;}
      Node pr = p.right;
      p.right = pr.left;
      pr.left = p;
      return(pr);
   }
//---------------------------
  /* Tac vu rotateRight: xoay phai cay nhi phan tim kiem co nut goc
     la root, yeu cau root phai co nut con ben trai (goi la nut p)
     Sau khi xoay phai thi nut con ben trai p tro thanh nut goc, nut goc
     cu tro thanh nut con ben phai cua nut goc moi
     Tac vu nay tra ve con tro chi nut goc moi
  */
   Node rotateRight(Node p)
   {if(p == null || p.left==null)
     {System.out.println(" Cannot rotate right.");return p;}
      Node pl = p.left;
      p.left = pl.right;
      pl.right = p;
      return(pl);
   }
//---------------------------
  //Neu cay goc p bi lech trai thi phai can bang lai
   Node leftBal(Node p)
   {if(p.bal!=-2) 
     {System.out.println(" No need for left balancing");}
    Node p1, p2;
    p1=p.left;
    switch(p1.bal)
      {case -1: /*Cay goc p1 lech trai, nghia la lech cung phia voi p
                   chi can quay phai nut p*/
	         p.bal=0;p1.bal=0;
                 return(rotateRight(p));
       case +1: /*Cay goc p1 lech phai, nghia la lech khac phia voi p
	          phai quay kep: quay trai p1, roi quay phai p*/
	        p2=p1.right;
	        switch(p2.bal)
	         {case  0:p.bal= 0; p1.bal= 0;break;//p2 can bang
	          case -1:p.bal=+1; p1.bal= 0;break;//p2 lech trai
	          case +1:p.bal= 0; p1.bal=-1;break;//p2 lech phai
	         }
	        //Xoay trai p1, roi xoay phai p
	        p2.bal=0;
	        p.left=rotateLeft(p1);
	        return(rotateRight(p));//Chinh la nut p2
      }
    return(p);//Neu trong truong hop khac thi khong lam gi
   }
//---------------------------
  //Neu cay goc p bi lech phai thi phai can bang lai
  Node rightBal(Node p)
   {if(p.bal!=+2) {System.out.println(" No need for right balancing");}
    Node p1, p2;
    p1=p.right;
    switch(p1.bal)
     {case +1: /*Cay goc p1 lech phai, nghia la lech cung phia voi p
	         chi can quay trai nut p*/
	       p.bal=0;p1.bal=0;
               return(rotateLeft(p));
      case -1: /*Cay goc p1 lech trai, nghia la lech khac phia voi p
	         phai quay kep: quay phai p1, roi quay trai p*/
	       p2=p1.left;
	       switch(p2.bal)
	        {case  0:p.bal= 0;p1.bal= 0;break;//p2 can bang
	         case -1:p.bal= 0;p1.bal=+1;break;//p2 lech trai
	         case +1:p.bal=-1;p1.bal= 0;break;//p2 lech phai
	        }
	       //Xoay phai p1, roi xoay trai p
	       p2.bal=0;
	       p.right=rotateRight(p1);
	       return(rotateLeft(p));//Chinh la nut p2
      }
    return(p);//Neu trong truong hop khac thi khong lam gi
   }
//==========================================================================
  void insert(int x)
   {if(root==null)
      {root = new Node(x);
       return; 
      }
    Node fp,p, q;//fp is a father of node p, q is the node to be inserted.
    Node fs,s; // s is a nearest node before p, which may be unbalanced. fs is a father of s
    fp=null; p=root;
    fs=null; s=p;
    Node pp; // Node for temporary use

    // Find fp, s and fs. The new node will be the child of fp
    while(p!=null)
     {if(p.info==x)
       {System.out.println(" The key " + x + " already exists, no insertion");
        return;
       }
      if(x<p.info)
        {fp=p;p=p.left;}
        else
        {fp=p;p=p.right;}
      if(p!=null && p.bal!=0){fs=fp;s=p;}/*Mark the node s, which may become unbalanced*/
     }
    q = new Node(x);
    if(x<fp.info)
      fp.left=q;
       else
        fp.right=q;
    /* Recalculate balance factors for all nodes from s to the father of q.
       If the new node q is on the left then bal is decreased by 1;if it is
       on the right then bal is increased by 1.
    */
    p=s;
    while(p != q)  //Cac nut tu s den cha nut q
      {if(x<p.info)
         {p.bal--;p = p.left;}
          else
          {p.bal++;p = p.right;}
      }//end of while(p != q)

    if(Math.abs(s.bal)!=2) return;// The sub-tree with root s is still balanced.
    if(s.bal==-2)
      pp=leftBal(s);
       else
        pp=rightBal(s);

    if(fs == null)
      {root = pp;
       return;
      }
    if(s == fs.right)
      fs.right = pp; //if s was the right son of fs, now pp will be the right son of fs
       else
        fs.left = pp; //if s was the left son of fs, now pp will be the left son of fs
   }
//=====================================================================
  void visit(Node p)
   {if(p==null) return;
    System.out.print("  " + p.info + "(" + p.bal + ")");
   }
  void preOrder(Node p)
   {if(p==null) return;
    visit(p);
    preOrder(p.left);
    preOrder(p.right);
   }
  void inOrder(Node p)
   {if(p==null) return;
    inOrder(p.left);
    visit(p);
    inOrder(p.right);
   }
  void addArray(int [] a)
   {for(int i=0;i<a.length;i++)
      insert(new Integer(a[i]));
   }
  void breadthTraverse()
   {MyQueue q = new MyQueue();
    q.enqueue(root);
    Node p;
    while(!q.isEmpty())
     {p = (Node) q.dequeue();
      visit(p);
      if(p.left!=null) q.enqueue((Object) p.left);
      if(p.right!=null) q.enqueue((Object) p.right);
     }
   }    
}