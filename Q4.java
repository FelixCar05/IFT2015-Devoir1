package ift2015_a25_tp1;

public class Q4 {
	
	public static Stack names = new Stack(10);

    // Question que faire quand la liste n'a qu'un seul noeud ??
	
    // Retire l'élément à la position centrale de la liste, l'ajoute à la pile puis retourne le début de la liste.
	public static Node rm_mid(Node head) {
		// Position centrale
        int central_index = (int) Math.ceil(head.length_rec()/2.0);
        // Retire et retourne la personne à la position
        Node mid_node = rm_index(head, central_index);
        // Ajoute le nom de la personne dans la stack
        names.push(mid_node.value);
        // Retourne le début de la liste
        return head;
	}

    // Retire le noeud à l'index i, l'indexation de la liste commence à 1, donc si on retire à l'index 5 ce sera le
    // 5ème élément qui sera retiré.
    public static Node rm_index(Node head, int index) {
        Node current_node = head;
        Node rm_node;
        // On arrête à la position avant le noeud
        for (int i = 0; i < index - 1; i++) {
            current_node = current_node.next;
        }
        rm_node = current_node.next;
        current_node.next = rm_node.next;
        return rm_node;
    }
	
	
	public static Node rm_k_end_iter(Node head, int k) {
		// TODO
        return null;
	}
	
	
	public static Node rm_k_end_rec(Node head, int k) {
		// TODO
        return null;
	}
	
	
	public static Node rm_after_k(Node head, int k) {
		// TODO
        return null;
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
