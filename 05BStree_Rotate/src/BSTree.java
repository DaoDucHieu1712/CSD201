
public class BSTree {
     Node root;
    BSTree() {
        root=null;
    }
    void clear(){
        root=null;
    }
    boolean isEmpty(){
        return  root==null;
    }
    Node search(Node p,int x){
        if(p==null) return null;
        if(p.infor==x) return p;
        if(x<p.infor)
            return search(p.left, x);
        else
            return search(p.right, x);
    }
    void insert(int x){
        //cay rong
        if(isEmpty()){
            root=new Node(x);
            return;
        }
        Node f,p;
        f=null;p=root;
        while(p!=null){
            //neu tim thay trung key x
            if(p.infor==x){
                System.out.println("The key "+x+" already exists!");
                return;
            }
            f=p;
            if(x<p.infor)
                p=p.left;
            else
                p=p.right;
        }
        //khi nay p==null va f la nut la
        if(x<f.infor)
            f.left=new Node(x);
        else
            f.right=new Node(x);
    }
    void insertMany(int[] a){
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }
    void visit(Node p){
        if(p!=null)
            System.out.print(p.infor+" ");
    }
    void preOrder(Node p){
        if(p==null) return;
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }
    void postOrder(Node p){
        if(p==null) return;
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }
    void inOrder(Node p){
        if(p==null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
    void breadth(Node p){
        if(p==null) return;
        MyQueue q=new MyQueue();
        q.enqueue(p);
        Node f;
        while(!q.isEmpty()){
            f=q.dequeue();
            visit(f);
            if(f.left!=null) q.enqueue(f.left);
            if(f.right!=null) q.enqueue(f.right);
        }
    }
    Node rotateRight(Node p){
        if((p==null) || (p.left==null)) 
            return p;
        Node q=p.left;
        p.left=q.right;
        q.right=p;
        return q; 
    }
    Node rotateLeft(Node p){
        if((p==null) || (p.right==null)) 
            return p;
        Node q=p.right;
        p.right=q.left;
        q.left=p;
        return q; 
    }
}
