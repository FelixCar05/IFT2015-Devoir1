package ift2015_a25_tp1;

public class Node {
	String value; // data of the node
	Node next; // pointer to the next node

    /**
     * Constructeur qui crée un nœud de valeur chaînes en ne mettant aucune valeur pour le noeud suivant
     * @param s La chaîne de caractères à stocker dans ce nœud.
     */

	public Node(String s) {
        value = s;
        next = null;
	}

    /**
     * Constructeur qui crée un nœud de valeur chaînes en spécifiant une valeur pour le noeud suivant
     * @param s La chaîne de caractères à stocker dans ce nœud.
     * @param next Le nœud suivant dans la liste ou null si aucun.
     */

	public Node(String s, Node next) {
		value = s;
        this.next = next;
	}

    /**
     * Méthode qui ajoute un élément à la fin de la liste d'une manière itérative.
     * Parcours la liste jusqu'au dernier nœud itérativement, puis crée un nouveau noeud avec
     * la valeur du string à l'aide du constructeur node.
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
     * Méthode qui ajoute un élément à la fin de la liste d'une manière récursive.
     * Parcourt la liste en appelant récursivement la méthode jusqu'à atteindre la fin de la liste(null).
     * Une fois atteinte, un nouveau noeud est créé avec la valeur du string à l'aide du constructeur node.
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
     * Méthode qui retourne à l'aide d'un compteur la longueur de la liste de façon itérative.
     * Parcours itérativement chaque nœud à partir du début jusqu'à la fin de la liste en incrémentant le compteur.
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
     * Méthode qui retourne la longueur de la liste de façon récursive.
     * On ajoute 1 et on appelle la méthode récursivement jusqu'à atteindre la fin de la liste(null)
     * qui nous rajoute le dernier 1.
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
