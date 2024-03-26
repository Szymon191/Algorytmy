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

    public void addElement(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void removeElement(int value) {
        if (head == null) {
            System.out.println("Lista jest pusta.");
            return;
        }

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node prev = null;
        Node current = head;

        while (current != null && current.data != value) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Element nie istnieje w liście.");
            return;
        }

        prev.next = current.next;
    }


    public int search(int value) {
        Node current = head;
        int index=0;
        while (current != null) {
            if (current.data == value) {
                return index; // Znaleziono element

            }
            index+=1;
            current = current.next;
        }
        return -1;
    }

    public void displayList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + ",");
            current = current.next;
        }
        System.out.println();
    }

}
