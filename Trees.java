class Node {
    int data;
    Node left, right;

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
// Binary Search Tree class
class BinarySearchTree {
    Node root;

    // Constructor to initialize an empty BST
    BinarySearchTree() {
        root = null;
    }
    // Insert method to add a node to the BST
    public void insert(int value) {
        root = insertRec(root, value);  // Calls the helper method to insert
    }
    // Helper recursive method to insert a node into the BST
    private Node insertRec(Node root, int value) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(value);
            return root;
        }

        // Otherwise, recur down the tree
        if (value < root.data) {
            root.left = insertRec(root.left, value);  // Insert in left subtree if the value is less than the root data
        } else if (value > root.data) {
            root.right = insertRec(root.right, value);  // Insert in right subtree if the value is greater than the root data
        }
        return root;
    }
    // Method to perform an inorder traversal
    public void inorder() {
        inorderRec(root);  // Calls the helper method for inorder traversal
    }

    // Helper method for inorder traversal
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);  // Visit left subtree
            System.out.print(root.data + " ");  // Visit root node
            inorderRec(root.right);  // Visit right subtree
        }
    }
}
// Main class to test the BST implementation
public class Trees {
    public static void main(String[] args) {
        // Create a new Binary Search Tree
        BinarySearchTree binarysearch = new BinarySearchTree();
        // Insert values into the BST
        binarysearch.insert(12);
        binarysearch.insert(6);
        binarysearch.insert(16);
        binarysearch.insert(4);
        binarysearch.insert(9);
        binarysearch.insert(18);
        // Perform an inorder traversal of the BST
        System.out.print("Inorder Traversal: ");
        binarysearch.inorder();  // Output will be: 4 6 9 12 15 18
    }
}