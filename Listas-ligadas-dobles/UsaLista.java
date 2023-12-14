// This class demonstrates the usage of the modified ListaDoble class
public class UsaLista {

    public static void main(String[] args) {
        // Create an instance of the ListaDoble class
        ListaDoble lista = new ListaDoble();

        // Insert nodes into the doubly linked list
        lista.insertaPrimerNodo("H"); // Insert the first node with data "H"
        lista.insertaAntesPrimerNodo("O"); // Insert a node before the first node with data "O"
        lista.insertaAlFinal("Y"); // Insert a node at the end with data "Y"
        lista.insertaEntreNodos("R", "A"); // Insert a node between nodes with data "R" and "A"

        // Print the list using different methods
        System.out.println("Print using imprimir():");
        lista.imprimir(); // Print the list using the imprimir() method

        System.out.println("\nPrint using toString():");
        System.out.print(lista); // Print the list using the overridden toString() method

        // Search for a node by its key and print its reference
        String valorBuscado = "H"; // Define the key to search
        Node nodoBuscado = lista.buscarPorClave(valorBuscado); // Search for the node with the key
        if (nodoBuscado != null) {
            System.out.println("\nNode [ " + valorBuscado + " ] found with value: " + nodoBuscado);
        } else {
            System.out.println("\nNode not found");
        }

        // Insert a new node after a node with a specific value
        lista.insertarDespues("Y", "Z"); // Insert a node with data "Z" after the node with data "Y"
        System.out.println("\nInsert Node [ Z ] after Node [ Y ]:");
        lista.imprimir(); // Print the updated list

        // Swap nodes
        lista.intercambiarNodo("H", "Z"); // Swap the nodes with data "H" and "Z"
        System.out.println("\nSwap Node [ H ] with [ Z ]:");
        lista.imprimir(); // Print the updated list
    }
}
