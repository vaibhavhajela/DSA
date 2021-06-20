package Datastructures;

public class BST {

    public static void main(String[] args) {
        Node root = new Node();
        root.value =5;
        Node node = new Node();
        node.value = 3;
        root.left = node;
        //
        // Tree is created here
        //

        search(root,4);
        inOrder(root);


    }

    public static boolean search(Node node, int valueToBeSearched){
        if ( node == null){
            return false;
        }
        if (valueToBeSearched == node.value){
            System.out.println("Node found");
            return true;
        } else if (valueToBeSearched < node.value){
            return search(node.left, valueToBeSearched);
        } else {
            return search(node.right, valueToBeSearched);
        }
    }

    public static void inOrder(Node node){
        if ( node == null ){
            return;
        }
        // L N R
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public static void preOrder(Node node){
        if ( node == null ){
            return;
        }
        // L N R
        System.out.println(node.value);
        inOrder(node.left);
        inOrder(node.right);
    }
    
    public static void postOrder(Node node){
        if ( node == null ){
            return;
        }
        // L N R
        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.value);

    }

}
class Node {
    int value;
    Node left;
    Node right;
}