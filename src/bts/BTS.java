package bts;

import java.util.LinkedList;
import java.util.Queue;

public class BTS {
    class Node{
        int key;
        Node left,right;
        public Node(int data){
            key = data;
            left = right = null;
        }
    }
    Node root;
    public BTS(){
        root = null;
    }
    public void insert(int key) {
        root = insert_Recursive(root,key);
    }
    public Node insert_Recursive(Node root, int key){
        if (root == null){
            root = new Node(key);
            return root;
        }
        if (key<root.key){
            root.left = insert_Recursive(root.left,key);
        } else if (key> root.key){
            root.right = insert_Recursive(root.right,key);
        }
        return root;
    }

    public void inorder(){
        inorder_Recursive(root);
    }
    void inorder_Recursive(Node root){
        if (root!=null){
            inorder_Recursive(root.left);
            System.out.println(root.key + " ");
            inorder_Recursive(root.right);
        }
    }
    public void postOrder(){
        postOrder_Recursive(root);
    }
    void postOrder_Recursive(Node root){
        if (root!=null){
            postOrder_Recursive(root.left);
            postOrder_Recursive(root.right);
            System.out.println(root.key+" ");
        }
    }
    public void preOrder() {
        preOrder_Recursive(root);
    }

    void preOrder_Recursive(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder_Recursive(root.left);
            preOrder_Recursive(root.right);
        }
    }
    public void breadthFirst() {
        breadthFirst_Recursive(root);
    }
    void breadthFirst_Recursive(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node tempNode = queue.poll();
            System.out.println(tempNode.key+ " ");
            if (tempNode.left != null){
                queue.add(tempNode.left);
            }
            if (tempNode.right!=null){
                queue.add(tempNode.right);
            }
        }
    }
    public void deleteKey(int key){
        root = delete_Recursive(root,key);
    }
    Node delete_Recursive(Node root,int key){
        if (root == null) {
            return root;
        }
        if (key<root.key){
            root.left = delete_Recursive(root.left,key);
        } else if (key>root.key){
            root.right = delete_Recursive(root.right,key);
        } else {
            if (root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }
            root.key = minValue(root.right);
            root.right = delete_Recursive(root.right,root.key);
        }
        return root;
    }

    int minValue(Node root){
        int minval = root.key;
        while (root.left!=null){
            minval = root.left.key;
            root = root.left;
        }
        return minval;
    }
    public boolean search(int key){
        root = search_Recursive(root,key);
        if (root!=null){
            return true;
        } else {
            return false;
        }
    }
    Node search_Recursive(Node root,int key){
        if (root == null||root.key == key){
            return root;
        }
        if (root.key >key){
            return search_Recursive(root.left,key);
        }
        return search_Recursive(root.right,key);
    }
}
