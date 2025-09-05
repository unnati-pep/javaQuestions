import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node2 {
    int data;
    Node2 left, right;

    public Node2(int value) {
        data = value;
        left = right = null;
    }
}

public class ques72 {
    Node2 root;

    // Insert a node
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node2 insertRec(Node2 root, int value) {
        if (root == null) return new Node2(value);
        if (value < root.data) root.left = insertRec(root.left, value);
        else if (value > root.data) root.right = insertRec(root.right, value);
        return root;
    }

    // Level-order traversal using Queue
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<Node2> queue = new LinkedList<>();
        queue.add(root);

        System.out.print("Level-order traversal: ");
        while (!queue.isEmpty()) {
            Node2 current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }

    // Main method with user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ques72 bst = new ques72();

        System.out.print("Enter number of elements to insert: ");
        int n = scanner.nextInt();
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            bst.insert(scanner.nextInt());
        }

        bst.levelOrderTraversal();
    }
}
