
public class Node {
    int info;
    int bal; // bal = -1 left unbalance, 0 balance, +1 right unbalance 
    Node left,right;
    Node(int x)
   {info=x;left=right=null;
    bal=0;
   }    
}
