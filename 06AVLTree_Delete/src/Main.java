
public class Main {
    public static void main(String [] args)
   {AVLTree t = new AVLTree();
    System.out.println(" After inserting 5, 2, 7, 1, 4, 6, 8, 3:");
    int [] a = {5, 2, 7, 1, 4, 6, 8, 3};
    t.addArray(a);

    System.out.println("\n In-order traverse:");
    t.inOrder(t.root);

    System.out.println("\n After deleting 1:");
    t.remove(new Integer(1));
    t.inOrder(t.root);
   }    
}
