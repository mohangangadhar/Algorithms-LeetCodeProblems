class Node {
    int val;
    Node next = null;

    Node(int val) {
        this.val = val;
    }
}

public class ReverseLinkedList {

    public static void main(String... args) {
        Node val = createNewLinkedList(100);
        printLinkedList(val);
        Node reversedList = reverseLinkedList(val);
        System.out.println("--- Reversed Linked List ---");
        printLinkedList(reversedList);

    }

    // Method to create a new single Linked list
    public static Node createNewLinkedList(int size) {
        if (size < 0) throw new IllegalArgumentException("Size cannot be less than 0");

        // create a new node
        Node curr = new Node(0);
        // Keep the head at the newly created node
        Node head = curr;

        for (int i = 1; i < size; i++) {
            // Create a new node and assign it to the next of the curr node
            curr.next = new Node(i);
            // Move the pointer of curr to curr.next. Even though this is moved, head is still at the starting point.
            curr = curr.next;
        }
        return head;
    }

    // Print the single linked list from head to tail
    public static void printLinkedList(Node inp) {
        do {
            System.out.println(inp.val);
            inp = inp.next;
        } while (inp != null);
    }

    // Reverse a Linked list and return the list
    // Step 1: Create three Nodes, namely current, next and previous
    // Step 2: Initialize current to the head, next and previous to null
    // Step 3: Point next to the node next to current
    // Step 4: Point current node's next to previous
    // Step 5: Move previous to current node
    // Step 6: Move current to next
    // Step 7: continue from step 3 to 6 until current is null

    public static Node reverseLinkedList(Node val) {
        if (val == null) throw new IllegalArgumentException("Invalid input");

        Node curr = val;
        Node prev = null;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
