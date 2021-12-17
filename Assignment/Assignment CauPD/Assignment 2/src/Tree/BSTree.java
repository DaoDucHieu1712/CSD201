/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import Entity.Book;
import java.util.ArrayList;

/**
 *
 * @author Kien
 */
public class BSTree {

    public Node root;

    public BSTree() {
        root = null;
    }

    public void clear() {
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public void insert(Book x) {
        Node p = new Node(x);
        if (isEmpty()) {
            root = p;
            return;
        }
        Node f = null;
        Node q = root;
        while (q != null) {
            if (q.info.getBcode().equals(x.getBcode())) {
                System.out.println("Insertion failed, duplicated key");
                return;
            } else if (q.info.getBcode().compareToIgnoreCase(x.getBcode()) > 0) {
                f = q;
                q = q.left;
            } else {
                f = q;
                q = q.right;
            }
        }
        if (f.info.getBcode().compareToIgnoreCase(x.getBcode()) > 0) {
            f.left = p;
        } else {
            f.right = p;
        }
    }

    void visit(Node p) {
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    public  void inorder(Node p) {
        if (p == null) {
            return;
        }
        inorder(p.left);
        visit(p);
        inorder(p.right);
    }

    public void bfs(Node p) { //input root
        if (p == null) {
            return;
        }
        MyQueue m = new MyQueue();
        m.enqueue(p);
        while (!m.isEmpty()) {
            Node q = (Node) m.dequeue();// get node
            if (q.left != null) { // if lever still hava node left
                m.enqueue(q.left);
            }
            if (q.right != null) { //if lever still hava node right
                m.enqueue(q.right);
            }
            visit(q);// traversal them
        }
    }

    public static Node search(Node p, String bCode) {
        if (p == null) {
            return null;
        }
        if (p.info.getBcode().equalsIgnoreCase(bCode)) {
            return p;
        } else if (p.info.getBcode().compareToIgnoreCase(bCode) > 0) {
            return search(p.left, bCode);
        } else {
            return search(p.right, bCode);
        }
    }

    public void deleByCopy(String bCode) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.getBcode().equals(bCode)) {
                break;
            }
            f = p;
            if (bCode.compareTo(p.info.getBcode()) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            System.out.println("Code not found"); // not found
        }
        // p is leaf node
        if (p.left == null && p.right == null) {
            if (f == null) // p=root
            {
                root = null;
            } else {
                if (p == f.left) {
                    f.left = null;
                }
                f.right = null;
            }
            return;
        }

        // p has left child only
        if (p.left != null && p.right == null) {
            if (f == null) // p=root
            {
                root = p.left;
            } else {
                if (p == f.left) {
                    f.left = p.left;
                }
                f.right = p.left;
            }
            return;
        }

        // p has right child only
        if (p.left == null && p.right != null) {
            if (f == null) // p=root
            {
                root = p.right;
            } else {
                if (p == f.left) {
                    f.left = p.right;
                }
                f.right = p.right;
            }
            return;
        }

        // p has both 2 children
        if (p.left != null && p.right != null) {// find the right most node
            Node q = p.left;
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            // rp is the right most node on the left child
            p.info = rp.info;
            if (frp == null) // rp=q
            {
                p.left = q.left;
            } else {
                frp.right = rp.left;
            }
        }
    }

    void inOrder(ArrayList<Book> t, Node p) {
        if (p == null) {
            return;
        }
        inOrder(t, p.left);
        t.add(p.info);
        inOrder(t, p.right);
    }

    void balance(ArrayList<Book> t, int i, int j) {
        if (i > j) {
            return;
        }
        int k = (i + j) / 2;
        Book x = t.get(k);
        insert(x);
        balance(t, i, k - 1);
        balance(t, k + 1, j);
    }

    public void bal() {
        ArrayList<Book> t = new ArrayList<>();
        inOrder(t, root);
        clear();
        int n = t.size();
        balance(t, 0, n - 1);
    }
    
    public int countNode() {
        if (root == null) {
            return 0;
        } else {
            return getSize(root);
        }
    }

    int getSize(Node p) {
        int count = 1;
        if (p.left != null) {
            count += getSize(p.left);
        }
        if (p.right != null) {
            count += getSize(p.right);
        }
        return count;
    }

    public void buildArray(ArrayList a, Node p){
        if(p == null){
            return;
        }
        buildArray(a, p.left);
        a.add(p);
        buildArray(a, p.right);
    }
    //balance tree
    public void balance1(ArrayList a, int first, int last){
        if(first > last) return;
        int m = (first + last) /2;
        Book x = ((Node)a.get(m)).info;
        insert(x);
        balance1(a, first, m-1);
        balance1(a, m+1, last);
    }
	
//balance simple array list
    public void balance(Node p){
        ArrayList a = new ArrayList();
        buildArray(a, p);
        int first = 0;
        int last = a.size() - 1;
        BSTree b = new BSTree(); //create new tree 
        b.balance1(a, first, last);
        root = b.root; //referen root to root b
    } 
    
}
