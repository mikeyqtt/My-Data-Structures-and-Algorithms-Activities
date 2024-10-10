class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class LinkedList {
    Node head; // Head of the list


    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // If the list is empty, make the new node the head
        } else {
            Node temp = head;
            while (temp.next != null) { // Traverse to the end of the list
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to insert a node at the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head; // Make the new node point to the current head
        head = newNode; // Update the head to the new node
    }

    // Method to delete a node with a specific value
    public void delete(int key) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data == key) { // If the head node is to be deleted
            head = head.next; // Move the head to the next node
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != key) { // Search for the node
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Element not found.");
        } else {
            temp.next = temp.next.next; // Skip the node to be deleted
        }
    }

    // Method to display the elements of the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Inserting nodes
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtBeginning(5);

        // Displaying the list
        System.out.print("Linked List: ");
        list.display();

        // Deleting a node
        list.delete(20);
        System.out.print("After deletion: ");
        list.display();
    }
}