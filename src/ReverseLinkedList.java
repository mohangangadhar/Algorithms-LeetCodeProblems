class Node{
    int val;
    Node next = null;

    Node(int val){
        this.val = val;
    }
}

public class ReverseLinkedList {

    public static void main(String... args){
        Node val = createNewLinkedList(5);
        printLinkedList(val);
        Node reversedList = reverseLinkedList(val);
        System.out.println("--- Reversed Linked List ---");
        printLinkedList(reversedList);

    }

    // Method to create a new single Linked list
    public static Node createNewLinkedList(int size){
        if(size < 0) throw new IllegalArgumentException("Size cannot be less than 0");

        // create a new node
        Node curr = new Node(0);
        // Keep the head at the newly created node
        Node head = curr;

        for(int i = 1; i< size; i++){
            // Create a new node and assign it to the next of the curr node
            curr.next = new Node(i);
            // Move the pointer of curr to curr.next. Even though this is moved, head is still at the starting point.
            curr = curr.next;
        }
        return head;
    }

    // Print the single linked list from head to tail
    public static void printLinkedList(Node inp){
        do {
            System.out.println(inp.val);
            inp = inp.next;
        } while (inp!= null);
    }

    // Reverse a Linked list and return the list
    public static Node reverseLinkedList(Node val){
        return new Node(1);
    }

}
