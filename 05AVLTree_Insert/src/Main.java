
public class Main {
    public static void main(String [] args)
   {AVLTree t = new AVLTree();
    int [] a = {4,3,1,11,5,9,2,6,15,12};
    int [] b = {12,7,1,3,2,5,10,8,6,9};
    t.addArray(a);

    System.out.println("\n Pre-order traverse:");
    t.preOrder(t.root);
    System.out.println("\n In-order traverse:");
    t.inOrder(t.root);
    System.out.println("\n Breadth first traverse:");
    t.breadthTraverse(); 
   }    
}
