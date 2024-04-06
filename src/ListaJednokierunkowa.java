public class ListaJednokierunkowa {

    private Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public ListaJednokierunkowa() {
        this.head = null;
    }

    public void addElement(int index,int value) {
        Node newNode = new Node(value);

        if (index < 0) {
            System.out.println("Indeks nie może być ujemny.");
            return;
        }

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            int currentIndex = 0;
            while (current != null && currentIndex < index - 1) {
                current = current.next;
                currentIndex++;
            }
            if (current == null) {
                System.out.println("Podany indeks wykracza poza granice listy.");
                return;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void removeElement(int value) {
        if (head == null) {
            System.out.println("Lista jest pusta.");
            return;
        }

        // Usuwanie pierwszego elementu o wartości value, jeśli jest to głowa listy
        if (head.data == value) {
            head = head.next;
            return;
        }

        Node prev = head;
        Node current = head.next;

        while (current != null) {
            if (current.data == value) {
                prev.next = current.next;
                return;
            } else {
                prev = current;
                current = current.next;
            }
        }
    }


    public boolean search(int value) {
        Node current = head;

        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void displayList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " | ");
            current = current.next;
        }
        System.out.println();
    }

}
