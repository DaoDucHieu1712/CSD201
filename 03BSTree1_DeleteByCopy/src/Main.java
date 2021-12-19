public class Main {
    public static void main(String[] args) {
      int [] a = {8,6,9,2,7,1,3,5,4};
      BSTree t = new BSTree();
      t.insertMany(a);
      System.out.println("1. Breadth-first traversal");
      t.breadth(t.root);
      System.out.println();
        System.out.println("2. Test delete by copy");
        t.deleteByCopy(7);
        t.breadth(t.root);
        System.out.println();
//      System.out.println("2. Pre-order traversal");
//      t.preOrder(t.root);
//      System.out.println();
//      System.out.println("3. In-order traversal");
//      t.inOrder(t.root);
//      System.out.println();
//      System.out.println("4. Post-order traversal");
//      t.postOrder(t.root);
//      System.out.println();
    }    
}
