package ift2015_a25_tp1;

public class Q4 {
	
	public static Stack names = new Stack(10);
	
    
	public static Node rm_mid(Node head) {
		// TODO
	}
	
	
	public static Node rm_k_end_iter(Node head, int k) {
		// TODO
	}
	
	
	public static Node rm_k_end_rec(Node head, int k) {
		// TODO
	}
	
	
	public static Node rm_after_k(Node head, int k) {
		// TODO
	}
	
	
	// some tests
	public static void main(String[] args) {
        // Create a list
        Node head = new Node("Alice");
        head.add_iter("Bob");
        head.add_iter("Claude");
        head.add_iter("Duke");
        head.add_iter("Elaine");
        
        Node.print_list(head);
        System.out.println();

        // 1. Remove middle person
        System.out.println("---Remove middle person---");
        head = rm_mid(head);
        Node.print_list(head);
        names.print_stack();
        System.out.println();
        
        // 2. Remove kth from end (iterative)
        System.out.println("---Remove 4th person from end---");
        head = rm_k_end_iter(head, 4);
        Node.print_list(head);
        names.print_stack();
        System.out.println();

        // 3. Remove kth from end (recursive)
        System.out.println("---Remove 4nd person from end---");
        head = rm_k_end_rec(head, 4);
        Node.print_list(head);
        names.print_stack();
        System.out.println();

        // 4. Remove the person after k 
        System.out.println("---Remove person after the first---");
        head = rm_after_k(head, 1);
        Node.print_list(head);
        names.print_stack();
        System.out.println();


    }

}
