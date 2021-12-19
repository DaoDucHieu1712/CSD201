public class BSTree {
   Node root;
   BSTree() {
     root=null;  
   }
   void clear() {
     root=null;  
   }
   boolean isEmpty() {
      return(root==null); 
   }
   Node search(Node p, int x) {
      if(p==null) return(null);
      if(p.info==x) return(p);
      if(x<p.info)
         return(search(p.left,x));
        else
         return(search(p.right,x));
   }
   void insert(int x) {
      if(isEmpty()) {
         root=new Node(x);
         return;
      }
      Node f,p;
      f=null;p=root;
      while(p!=null) {
         if(p.info==x) {
           System.out.println("The key " + 
            x + " already exists!");
           return;
         }
         f=p;
         if(x<p.info)
             p=p.left;
            else
             p=p.right;
      }
      if(x<f.info)
         f.left=new Node(x);
        else
          f.right=new Node(x);
   }
   void insertMany(int [] a) {
      for(int i=0;i<a.length;i++) insert(a[i]); 
   }
   void visit(Node p) {
      if(p!=null) System.out.print(p.info + " ");
   }
   void breadth(Node p) {
      if(p==null) return;
      MyQueue q = new MyQueue();
      q.enqueue(p); Node r;
      while(!q.isEmpty()) {
         r=q.dequeue();
         visit(r);
         if(r.left!=null) q.enqueue(r.left);
         if(r.right!=null) q.enqueue(r.right);
      }
   }
   void preOrder(Node p) {
      if(p==null) return;
      visit(p);
      preOrder(p.left);
      preOrder(p.right);
   }
   void inOrder(Node p) {
      if(p==null) return;
      inOrder(p.left);
      visit(p);
      inOrder(p.right);
   }
   void postOrder(Node p) {
      if(p==null) return;
      postOrder(p.left);
      postOrder(p.right);
      visit(p);
   }
   void deleteByCopy(int x){
       Node f,p;
       p=root;
       f=null;
       //tim nut can xoa
       while(p!=null){
           if(p.info==x) break;//tim thay node can xoa
           f=p;//cha cua p
           if(x<p.info)
               p=p.left;
           else
               p=p.right;
       }
       if(p==null) return;//khong tim thay
       //node leaf-node
       if(p.left==null && p.right==null){
           if(f==null){
               root=null;
           }else{
               if(p==f.left)
                   f.left=null;
               else
                   f.right=null;
           }
           return;
       }
       //p has left-son
       if(p.left!=null && p.right==null){
           if(f==null){
               root=p.left;
           }else{
              if(p==f.left)
                  f.left=p.left;
              else
                  f.right=p.left;
           }
           return;
       }
       //p has right-son
       if(p.left==null && p.right!=null){
           if(f==null){
               root=p.right;
           }else{
              if(p==f.left)
                  f.left=p.right;
              else
                  f.right=p.right;
           }
           return;
       }
       // p has 2 sons
       if(p.left!=null && p.right!=null){
           Node q=p.left;
           Node fp1,p1;
           p1=q;
           fp1=null;
           while(p1.right!=null){
               fp1=p1;
               p1=p1.right;
           }
           //p1 is the right-most node
           p.info=p1.info;
           //p1 hasa not right-son
           if(fp1==null)
               p.left=q.left;
           else
               fp1.right=p1.left;
       }
   }
}
