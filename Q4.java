package ift2015_a25_tp1;

public class Q4 {
	
	public static Stack names = new Stack(10);

    // Retire l'élément à la position centrale de la liste, l'ajoute à la pile puis retourne le début de la liste.
	public static Node rm_mid(Node head) {
        // On s'assure que la liste n'est pas vide
        if(head == null) {
            names.push("???");
            return null;
        }
        int length = head.length_rec();
		// Position centrale
        int central_index = (int) Math.ceil(length/2.0);
        // Retire et retourne la personne à la position
        Node mid_node = rm_index(head, central_index, length);
        // Dans le cas où le noeud retiré est la tête, alors la nouvelle tête est son prochain, on en déduit que si la
        // la liste est vide alors null sera retourné.
        if(mid_node == head) {
            head = head.next;
        }
        // Dans le cas d'un retrait impossible on ne fait rien
        if (mid_node == null) {
            names.push("???");
            return head;
        }
        // Ajoute le nom de la personne dans la stack
        names.push(mid_node.value);
        // Retourne le début de la liste
        return head;
	}

    // Retire le noeud à l'index i, l'indexation de la liste commence à 1, donc si on retire à l'index 5 ce sera le
    // 5ème élément qui sera retiré. Si l'index est 1, alors rien n'est fait et on retourne le head
    public static Node rm_index(Node head, int index, int length) {
        Node current_node = head;
        Node rm_node;
        // Cas où l'index est 1 on retourne le head
        if(index == 1){
            return head;
        // Index invalide
        } else if (index > length || index < 1) {
            return null;
        }
        // On arrête à la position avant le noeud
        for (int i = 1; i < index - 1; i++) {
            current_node = current_node.next;
        }
        // On retire le noeud et lie ses voisins
        rm_node = current_node.next;
        current_node.next = rm_node.next;
        return rm_node;
    }
	
	// Étant donné une file et un entier K on retire la K ième personne à partir de la fin de la file puis place son nom
    // dans la pile. Retourne la tête.
	public static Node rm_k_end_iter(Node head, int k) {
		int length = head.length_iter();
        // Index pour retirer le bon noeud
        int index = length - k + 1;
        Node rm_node = rm_index(head, index, length);
        // Si le retrait n'a pas été possible
        if(rm_node == null) {
            names.push("???");
            return head;
        }
        // Si le noeud retiré est le head alors on change le head
        if (rm_node == head) {
            head = head.next;
        }
        names.push(rm_node.value);
        return head;
	}

    // Étant donné une file et un entier K on retire la K ième personne à partir de la fin de la file puis place son nom
    // dans la pile. Retourne la tête. Récursivement
	public static Node rm_k_end_rec(Node head, int k) {
        // Indice ou liste invalide
        if(head == null || k <= 0) {
            names.push("???");
            return head;
        }
        // Valide k
        if(k > head.length_iter()) {
            names.push("???");
            return head;
        }
        // Créer une fausse head pour gérer lorsqu'on supprime le premier élément.
        Node false_head = new Node(null, head);
        rmv_rec_k(false_head, k);
        return false_head.next;
	}

    // Fonction qui retourne la distance de puis la fin et supprime si nous sommes rendu au k ieme depuis la fin.
    // Récursif
    public static int rmv_rec_k(Node current, int k) {
        // Rendu à la fin de la liste
        if(current.next == null) {
            return 0;
        }
        // Appel récursif nous retourne la distance de current.next
        int dist_next = rmv_rec_k(current.next, k) + 1;
        // Si la prochaine distance est k alors on retire le prochain noeud
        if(dist_next == k) {
            Node rm_node = current.next;
            current.next = rm_node.next;
            names.push(rm_node.value);
        }
        return dist_next;
    }

    // Fonction qui retire après le Kème indide, retourne ce noeud et place son nom dans la file.
    public static Node rm_after_k(Node head, int k) {
        // Liste invalide ou index, si index = 0 ça n'a pas vraiment de sens.
		if(head == null || k < 1){
            names.push("???");
            return head;
        }
        Node node_rm = rm_index(head, k+1, head.length_iter());
        // Si le retrait n'a pas fonctionné
        if(node_rm == null) {
            names.push("???");
        } else {
            names.push(node_rm.value);
        }
        return head;
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
