package ift2015_a25_tp1;

public class Node {
	String value; // data of the node
	Node next; // pointer to the next node

    /**
     * Constructeur qui crée un nœud avec la valeur spécifiée
     * et sans nœud suivant, next est mis à null.
     *
     * @param s La chaîne de caractères à stocker dans ce nœud.
     */

	public Node(String s) {
        value = s;
        next = null;
	}

    /**
     * Constructeur qui crée un nœud avec la valeur spécifiée
     * et un lien vers le nœud suivant.
     *
     * @param s La chaîne de caractères à stocker dans ce nœud.
     * @param next Le nœud suivant dans la liste ou null si aucun.
     */

	public Node(String s, Node next) {
		value = s;
        this.next = next;
	}

    /**
     * Ajoute un nouveau nœud contenant la chaîne spécifiée à la fin de la liste chaînée.
     * Parcourt la liste jusqu'au dernier nœud itérativement, puis ajoute le nouveau nœud comme suivant.
     *
     * @param s La chaîne de caractères à ajouter à la fin de la liste.
     */

	public void add_iter(String s) {
        Node current_node = this;
        // Passe à travers tous les noeuds jusqu'au dernier, puis on ajoute newNode comme étant le next
		while (current_node.next != null) {
            current_node = current_node.next;
        }
        current_node.next =  new Node(s);
	}

    /**
     * Ajoute récursivement un nouveau nœud contenant la chaîne spécifiée à la fin de la liste chaînée.
     * Parcourt la liste en profondeur jusqu'au dernier nœud, puis ajoute le nouveau nœud comme suivant.
     *
     * @param s La chaîne de caractères à ajouter à la fin de la liste.
     */

	public void add_rec(String s) {
        // Récursion lorsque le prochain noeud n'est pas nul
		if (this.next != null) {
            this.next.add_rec(s);
        } else {
            // Sinon cas de base, on ajoute le noeud à la fin
            this.next = new Node(s);
        }
	}

    /**
     * Calcule et retourne la longueur de la liste chaînée de façon itérative.
     * Parcourt chaque nœud à partir de celui-ci jusqu'à la fin de la liste.
     *
     * @return La longueur de la liste.
     */

	public int length_iter() {
		int compteur  = 1;
		Node current_node = this;
        // Tant que le noeud a un prochain on augmente le compteur
		while (current_node.next != null) {
            compteur++;
            current_node = current_node.next;
        }
        return compteur;
	}

    /**
     * Calcule et retourne la longueur de la liste chaînée de façon récursive.
     * Ajoute 1 pour chaque nœud jusqu'à atteindre la fin de la liste.
     *
     * @return La longueur de la liste.
     */

	public int length_rec() {
		Node node_next = this.next;
        // Cas de base, on retourne 1
        if(node_next == null) {
            return 1;
        } else {
            // Si le prochain n'est pas null, on ajoute et appel récursif
            return 1 + node_next.length_rec();
        }
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
