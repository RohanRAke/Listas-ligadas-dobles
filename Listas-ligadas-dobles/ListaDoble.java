// This class represents a doubly linked list with a more efficient structure
public class ListaDoble {

    // Top pointers for forward and backward traversal
    Node topForward;
    Node topBackward;

    // Method to insert the first node
    public boolean insertaPrimerNodo(String dato) {
        if (topForward == null) {
            // The list is empty
            topForward = new Node();
            topForward.name = dato;
            topForward.previous = null;
            topForward.next = null;

            topBackward = topForward;

            return true;
        } else {
            return false;
        }
    }

    // Method to print the list
    public void imprimir() {
        System.out.print("[X]");

        for (Node temp = this.topForward; temp != null; temp = temp.next) {
            System.out.print(" <- [ " + temp.name + " ] -> ");
        }

        System.out.print("[X]\n");
    }

    // Method to convert the list to a string
    public String toString() {
        String ToStringV = "[X]";
        for (Node temp = this.topForward; temp != null; temp = temp.next) {
            ToStringV += " <- [ " + temp.name + " ] -> ";
        }

        ToStringV += "[X]\n";

        return ToStringV;
    }

    // Method to insert before the first node
    public void insertaAntesPrimerNodo(String nombre) {
        Node temp = new Node();
        temp.name = nombre;
        temp.next = this.topForward;
        this.topForward.previous = temp;
        this.topForward = temp;
        temp = null;
    }

    // Method to insert at the end
    public void insertaAlFinal(String nombre) {
        Node temp = new Node();
        temp.name = nombre;
        temp.next = null;

        temp.previous = this.topBackward;
        this.topBackward.next = temp;
        this.topBackward = temp;
        temp = null;
    }

    // Method to insert between nodes
    public boolean insertaEntreNodos(String nombre, String buscado) {
        Node temp = new Node();
        temp.name = nombre;
        Node temp2 = this.topForward;

        while ((temp2 != null) && !temp2.name.equals(buscado)) {
            temp2 = temp2.next;
        }

        if (temp2 != null) {
            temp.next = temp2.next;
            temp2.next = temp;

            temp.previous = temp2;
            temp.next.previous = temp;

            temp = null;
            temp2 = null;

            return true;
        } else {
            return false;
        }
    }

    // Methods for deletion
    public void borrarPrimerNodo() {
        this.topForward = this.topForward.next;
        this.topForward.previous.next = null;
        this.topForward.previous = null;
    }

    public void borrarUltimoNodo() {
        this.topBackward = this.topBackward.previous;
        this.topBackward.next.previous = null;
        this.topBackward.next = null;
    }

    // Delete any node other than the first
    public boolean borrarCualquierNodo(String buscado) {
        Node temp = this.topForward;

        while ((temp != null) && !temp.name.equals(buscado)) {
            temp = temp.next;
        }

        if (temp != null) {
            temp.next = temp.next.next;
            temp.next.previous.previous = null;
            temp.next.previous.next = null;
            temp.next.previous = temp;
            temp = null;

            return true;
        } else {
            return false;
        }
    }

    // Method to search for a node by its key field value and return a reference
    public Node buscarPorClave(String clave) {
        Node temp = this.topForward;

        while (temp != null) {
            if (temp.name.equals(clave)) {
                return temp;
            }
            temp = temp.next;
        }

        return null; // Node not found
    }

    // Method to search for a node by its key field and insert a new node after it
    public boolean insertarDespues(String clave, String nombre) {
        Node nodoBuscado = buscarPorClave(clave);

        if (nodoBuscado != null) {
            // Check if the searched node is the last in the list
            if (nodoBuscado.next == null) {
                // Use the insertaAlFinal method
                insertaAlFinal(nombre);
            } else {
                // Use the insertarDespuesDe method
                Node nuevoNodo = new Node();
                nuevoNodo.name = nombre;
                nuevoNodo.next = nodoBuscado.next;
                nodoBuscado.next = nuevoNodo;

                nuevoNodo.previous = nodoBuscado;
                nuevoNodo.next.previous = nuevoNodo;
            }
            return true;
        }

        return false; // Node not found
    }

    // Swap one node with another searched node
    public boolean intercambiarNodo(String nombre, String buscado) {
        Node nodo1 = buscarPorClave(nombre);
        Node nodo2 = buscarPorClave(buscado);

        if (nodo1 != null && nodo2 != null) {
            String temp = nodo1.name;
            nodo1.name = nodo2.name;
            nodo2.name = temp;
            return true;
        }

        return false; // Nodes not found
    }
}
