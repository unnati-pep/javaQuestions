import java.util.*;

class Node4 {
    int data;
    Node4 next;

    Node4(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ques74 {
    // Function to find both middle nodes if even, or one if odd
    public static void findMiddleNodes(Node4 head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node4 slow = head;
        Node4 fast = head;
        Node4 prevSlow = null;

        while (fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null) {
            // Even number of nodes
            System.out.println("Middle nodes are: " + prevSlow.data + " and " + slow.data);
        } else {
            // Odd number of nodes
            System.out.println("Middle node is: " + slow.data);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();

        Node4 head = null, tail = null;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value for node " + (i + 1) + ": ");
            int val = scanner.nextInt();
            Node4 newNode = new Node4(val);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        findMiddleNodes(head);
    }
}
