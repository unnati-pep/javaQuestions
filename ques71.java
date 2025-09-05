// Implement binary search tree.

// Node class
class Node {
    int data;
    Node2 left, right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

// Binary Search Tree class
public class ques71 {
    Node2 root;

    // Insert a node
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node2 insertRec(Node2 root, int value) {
        if (root == null) {
            return new Node2(value);
        }

        if (value < root.data) {
            root.left = insertRec(root.left, value);
        } else if (value > root.data) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    // Inorder traversal (Left, Root, Right)
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node2 root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Search for a value
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node2 root, int value) {
        if (root == null) return false;
        if (root.data == value) return true;
        return value < root.data
                ? searchRec(root.left, value)
                : searchRec(root.right, value);
    }

    // Main method with user input
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        ques71 bst = new ques71();

        System.out.print("Enter number of elements to insert: ");
        int n = scanner.nextInt();
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            bst.insert(scanner.nextInt());
        }

        System.out.print("Inorder traversal: ");
        bst.inorder();

        System.out.print("Enter value to search: ");
        int key = scanner.nextInt();
        if (bst.search(key)) {
            System.out.println(key + " found in the BST.");
        } else {
            System.out.println(key + " not found in the BST.");
        }
    }
}
