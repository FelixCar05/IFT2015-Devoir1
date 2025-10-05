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

    /**
     * Retourne le nombre d'éléments actuellement présents dans la pile.
     * La taille correspond à l'indice du sommet + 1.
     *
     * @return Le nombre d'éléments dans la pile.
     */

    public int size() {
		return top + 1;
    }

    /**
     * Ajoute un élément au sommet de la pile si la capacité maximale n'est pas atteinte
     * et si l'élément n'est pas nul.
     * Affiche un message d'erreur si la pile est pleine.
     *
     * @param s L'élément string ajouté à la pile.
     */

    public void push(String s) {
        // Vérification de la taille de la pile
		if(size() < maxSize && s != null) {
            // Mise à jour du top
            top += 1;
            // Ajout de l'élément au dessus de la pile
            stackArray[top] = s;
        } else {
            System.out.println("Capacité maximale de la pile atteinte.");
        }
    }

    /**
     * Retire et retourne l'élément au sommet de la pile.
     * Si la pile est vide, affiche un message et retourne null.
     *
     * @return L'élément retiré du sommet de la pile, ou null si la pile est vide.
     */

    public String pop() {
        // Vérification de la taille de la pile
        if(size() > 0) {
            // Prend le dernier elem, l'enlève du tableau, ajuste l'indice du top et retourne celui-ci.
            String elem = stackArray[top];
            stackArray[top] = null;
            top -= 1;
            return elem;
        } else {
            System.out.println("Pile vide");
            return null;
        }
   }

    /**
     * Retourne l'élément au sommet de la pile sans le retirer.
     * Si la pile est vide, retourne null.
     *
     * @return L'élément au sommet de la pile, ou null si la pile est vide.
     */

    public String peek() {
        if(size() > 0) {
            return stackArray[top];
        }
        // Null si la pile est vide
		return null;
   }

    /**
     * Vérifie si la pile est vide.
     *
     * @return true si la pile ne contient aucun élément, false sinon.
     */

    public boolean isEmpty() {
		return size() == 0;
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

        
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}

