package ift2015_a25_tp1;

public class Stack {
	private int maxSize;
    private String[] stackArray;
    private int top;

    public Stack(int size) {
        maxSize = size;
        stackArray = new String[maxSize];
        top = -1;
    }

    // Retourne la grandeur de la pile actuelle
    public int size() {
        // Le top de la file correspond au dernier index
        // Dans ce cas on retourne l'indice + 1 qui correspond à la size
		return top + 1;
    }

    // Ajoute un élément au dessus de la pile
    public void push(String s) {
        // Vérification de la taille de la pile
		if(size() < maxSize) {
            // Ajout de l'élément au dessus de la pile
            stackArray[size()] = s;
            // Mise à jour du top
            top += 1;
        } else {
            System.out.println('Capacité maximale de la pile atteinte.');
        }
    }

    public String pop() {
		// TODO
   }
    
    public String peek() {
		// TODO
   }

    public boolean isEmpty() {
		// TODO
    }
    
    // Print stack elements from top to bottom
    public void print_stack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack:");
            System.out.println("---------");
            for (int i = top; i >= 0; i--) {
                System.out.println(stackArray[i]);
                System.out.println("---------");
            }
        }
    }

    
    // some tests
    public static void main(String[] args) {
        Stack stack = new Stack(5); 

        
        stack.push("A");
        stack.push("B");
        stack.print_stack();
        
        System.out.println("Top element of the stack: " + stack.peek());

        
        stack.pop();
        stack.pop();
        stack.pop(); 

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
