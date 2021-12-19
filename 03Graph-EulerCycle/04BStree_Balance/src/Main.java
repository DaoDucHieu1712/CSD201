
public class Main {
    public static void main(String[] args) {
        int[] a={16,6,18,1,10,25,8,12,22};
        BSTree t=new BSTree();
        t.insertMany(a);
        System.out.println("1. Pre-order traversal");
        t.preOrder(t.root);
        System.out.println();
        System.out.println("2. In-order traversal");
        t.inOrder(t.root);
        System.out.println();
        System.out.println("3. Post-order traversal");
        t.postOrder(t.root);
        System.out.println();
        System.out.println("4. Breadth-first traversal");
        t.breadth(t.root);
        System.out.println();
        System.out.println("5. Test simple balancing");
        t.balance();
        t.breadth(t.root);
        System.out.println();
    }
}
