
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
    Node search(Node p,int xPrice){
        if(p==null) return null;
        if(p.infor.price==xPrice) return p;
        if(xPrice<p.infor.price)
            return search(p.left, xPrice);
        else
            return search(p.right, xPrice);
    }
    void insert(Car x){
        //cay rong
        if(isEmpty()){
            root=new Node(x);
            return;
        }
        Node f,p;
        f=null;p=root;
        while(p!=null){
            //neu tim thay trung key x
            if(p.infor.price==x.price){
                System.out.println("The key "+x.price+" already exists!");
                return;
            }
            f=p;
            if(x.price<p.infor.price)
                p=p.left;
            else
                p=p.right;
        }
        //khi nay p==null va f la nut la
        if(x.price<f.infor.price)
            f.left=new Node(x);
        else
            f.right=new Node(x);
    }
    void insertMany(String[] b,int[] a){
        for (int i = 0; i < a.length; i++) {
            insert(new Car(b[i], a[i]));
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
}
