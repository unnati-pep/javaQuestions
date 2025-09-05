import java.util.*;

class Node3 {
    int data;
    Node3 next;

    Node3(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ques73 {
    // Detect cycle using Floyd's algorithm
    public static boolean hasCycle(Node3 head) {
        Node3 slow = head;
        Node3 fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         // move by 1
            fast = fast.next.next;    // move by 2

            if (slow == fast) {
                return true; // cycle detected
            }
        }
        return false; // no cycle
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();

        Node3 head = null, tail = null;
        Map<Integer, Node3> nodeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value for node " + (i + 1) + ": ");
            int val = scanner.nextInt();
            Node3 newNode = new Node3(val);
            nodeMap.put(i, newNode);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.print("Enter index to create cycle (-1 for no cycle): ");
        int cycleIndex = scanner.nextInt();

        if (cycleIndex >= 0 && cycleIndex < n) {
            tail.next = nodeMap.get(cycleIndex);
        }

        boolean result = hasCycle(head);
        System.out.println("Cycle detected? " + result);
    }
}
