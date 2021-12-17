/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Binary;

/**
 *
 * @author Admin
 */
public class BinaryTree {

    Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public void insertNode(int insertValues) {
        int value = root.getValues();
        Node temp = root;
        while (true) {
            if (insertValues > value) {
                if (temp.right == null) {
                    temp.right = new Node(insertValues);
                    break;
                } else {
                    temp = temp.right;
                    value = temp.getValues();
                }
            } else {
                if (temp.left == null) {
                    temp.left = new Node(insertValues);
                    break;
                } else {
                    temp = temp.left;
                    value = temp.getValues();
                }
            }
        }
    }

    public Node search(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (node.getValues() == key) {
            return node;
        }
        if (node.getValues() > key) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    public void breadth(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValues() + " ");
        breadth(node.left);
        breadth(node.right);
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.printf("%s ", node.getValues());
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.getValues() + " ");
        inOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.getValues() + " ");
    }

    public Node min(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public Node max(Node node) {
        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public void deleteKey(int key) {
        root = deleteRec(root, key);
    }
    private Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.getValues()) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.getValues()) {
            root.right = deleteRec(root.right, key);
        } 
        else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.setValues(min(root.right).getValues());
            root.right = deleteRec(root.right, root.getValues());
        }

        return root;
    }

    public int count(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + count(node.right) + count(node.left);
    }

    public int sum(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getValues() + sum(node.right) + sum(node.left);
    }

    public float avg(Node node) {
        return (float) sum(node) / count(node);
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.right), height(node.left));
    }
}
