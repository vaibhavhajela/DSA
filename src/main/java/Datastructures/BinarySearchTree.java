package Datastructures;

/**
 * Created by vaibhavhajela on 27/11/20.
 */


import java.io.PrintWriter;
import java.util.*;

public class BinarySearchTree {
    BTreePrinter printer = new BTreePrinter();

    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();

        Node root = bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        bt.delete(6);

        bt.traverseInOrder(root);
        System.out.println("++++++++++++++++++");
        bt.traversePreOrder(root);
        System.out.println("++++++++++++++++++");
        bt.traversePostOrder(root);

    //  L < Root < R
    }

    Node root;

    public Node add(int value) {
        root = addRecursive(root, value);
        return root;
    }


    private Node addRecursive(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }
        //
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }
        printer.printNode(root);
        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean searchNode(int value) {
        return searchNodeRecursive(root, value);
    }

    private boolean searchNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        return value < current.value
                ? searchNodeRecursive(current.left, value)
                : searchNodeRecursive(current.right, value);
    }


    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        printer.printNode(root);

        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: only 1 child
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            // Case 3: 2 children
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            printer.printNode(root);

            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            visit(node.value);
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            visit(node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            visit(node.value);
        }
    }



    private void visit(int value) {
        System.out.print(" " + value);
    }


    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }


    }

    class BTreePrinter {

        public void printNode(Node root) {
            int maxLevel = maxLevel(root);

            printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        }

        private  void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
            if (nodes.isEmpty() || isAllElementsNull(nodes))
                return;

            int floor = maxLevel - level;
            int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
            int firstSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

            printWhitespaces(firstSpaces);

            List<Node> newNodes = new ArrayList<Node>();
            for (Node node : nodes) {
                if (node != null) {
                    System.out.print(node.value);
                    newNodes.add(node.left);
                    newNodes.add(node.right);
                } else {
                    newNodes.add(null);
                    newNodes.add(null);
                    System.out.print(" ");
                }

                printWhitespaces(betweenSpaces);
            }
            System.out.println("");

            for (int i = 1; i <= endgeLines; i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    printWhitespaces(firstSpaces - i);
                    if (nodes.get(j) == null) {
                        printWhitespaces(endgeLines + endgeLines + i + 1);
                        continue;
                    }

                    if (nodes.get(j).left != null)
                        System.out.print("/");
                    else
                        printWhitespaces(1);

                    printWhitespaces(i + i - 1);

                    if (nodes.get(j).right != null)
                        System.out.print("\\");
                    else
                        printWhitespaces(1);

                    printWhitespaces(endgeLines + endgeLines - i);
                }

                System.out.println("");
            }

            printNodeInternal(newNodes, level + 1, maxLevel);
            System.out.println("================================================");

        }

        private void printWhitespaces(int count) {
            for (int i = 0; i < count; i++)
                System.out.print(" ");
        }

        private int maxLevel(Node node) {
            if (node == null)
                return 0;

            return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
        }

        private boolean isAllElementsNull(List list) {
            for (Object object : list) {
                if (object != null)
                    return false;
            }

            return true;
        }


    }
}