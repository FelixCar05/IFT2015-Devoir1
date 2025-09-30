package ift2015_a25_tp1;

public class Node {
	String value; // data of the node
	Node next; // pointer to the next node
	
	public Node(String s) {
		// TODO
	}
	
	public Node(String s, Node next) {
		// TODO
	}
	
	public void add_iter(String s) {
		// TODO
	}
	
	public void add_rec(String s) {
		// TODO
	}
	
	public int length_iter() {
		// TODO
	}
	
	public int length_rec() {
		// TODO
	}
	
	// Print entire list
    public static void print_list(Node n) {
        System.out.print("List: ");
        while (n != null) {
            System.out.print(n.value + "->");
            n = n.next;
        }
        System.out.println();
    }
    
	// some tests
	public static void main(String[] args) {
        // Create the head node
        Node head = new Node("A");
        
        // Add elements using iterative method
        head.add_iter("B");
        
        // Add elements using recursive method
        head.add_rec("C");
        
        // Print list elements
        print_list(head);
        
        // Test length methods
        System.out.println("Length (iterative): " + head.length_iter());
        System.out.println("Length (recursive): " + head.length_rec());
    }
}
