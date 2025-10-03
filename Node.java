package ift2015_a25_tp1;

public class Node {
	String value; // data of the node
	Node next; // pointer to the next node

    // Constructeur sans next
	public Node(String s) {
        value = s;
        next = null;
	}

    // Constructeur avec un noeud next
	public Node(String s, Node next) {
		value = s;
        this.next = next;
	}

    // Ajout d'un noeud à la fin de la liste
	public void add_iter(String s) {
        Node currentNode = this;
        // Passe à travers tous les noeuds jusqu'au dernier, puis on ajoute newNode comme étant le next
		while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next =  new Node(s);
	}

    // Ajouter un élément à la fin de la liste
	public void add_rec(String s) {
        // Récursion lorsque le prochain noeud n'est pas nul
		if (this.next != null) {
            this.next.add_rec(s);
        } else {
            // Sinon cas de base, on ajoute le noeud à la fin
            this.next = new Node(s);
        }
	}

    // Retourner la longueur de la liste
	public int length_iter() {
		int compteur  = 1;
		Node currentNode = this;
        // Tant que le noeud a un prochain on augmente le compteur
		while (currentNode.next != null) {
            compteur++;
            currentNode = currentNode.next;
        }
        return compteur;
	}

    // Retourner la longueur
	public int length_rec() {
		Node nodeNext = this.next;
        // Cas de base, on retourne 1
        if(nodeNext == null) {
            return 1;
        } else {
            // Si le prochain n'est pas null, on ajoute et appel récursif
            return 1 + nodeNext.length_rec();
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
