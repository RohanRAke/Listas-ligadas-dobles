// This class demonstrates the usage of the modified ListaDoble class

public class UsaLista {

    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();

        // Insert nodes into the doubly linked list
        lista.insertaPrimerNodo("H");
        lista.insertaAntesPrimerNodo("O");
        lista.insertaAlFinal("Y");
        lista.insertaEntreNodos("R", "A");

        // Print the list using different methods
        System.out.println("Print using imprimir():");
        lista.imprimir();

        System.out.println("\nPrint using toString():");
        System.out.print(lista);

        // Search for a node by its key and print its reference
        String valorBuscado = "H";
        Node nodoBuscado = lista.buscarPorClave(valorBuscado);
        if (nodoBuscado != null) {
            System.out.println("\nNode [ " + valorBuscado + " ] found with value: " + nodoBuscado);
        } else {
            System.out.println("\nNode not found");
        }

        // Insert a new node after a node with a specific value
        lista.insertarDespues("Y", "Z");
        System.out.println("\nInsert Node [ Z ] after Node [ Y ]:");
        lista.imprimir();

        // Swap nodes
        lista.intercambiarNodo("H", "Z");
        System.out.println("\nSwap Node [ H ] with [ Z ]:");
        lista.imprimir();
    }
}
