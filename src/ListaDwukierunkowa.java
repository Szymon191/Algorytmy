public class ListaDwukierunkowa {
    private class Element {
        int value;
        Element previous;
        Element next;

        Element(int value) {
            this.value = value;
            this.previous = null;
            this.next = null;
        }
    }

    private Element head;
    private Element tail;

    // Constructor initializing an empty list
    public ListaDwukierunkowa() {
        this.head = null;
        this.tail = null;
    }

    public void add(int index, int value) {
        Element newNode = new Element(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Element current = head;
            if (index == 0) {
                current.previous = newNode;
                newNode.next = current;
                head = newNode;
            } else {
                int i = 1;
                while (i != index && current.next != null) {
                    current = current.next;
                    i++;
                }
                if (current.next != null) {
                    current.next.previous = newNode;
                }
                newNode.next = current.next;
                newNode.previous = current;
                current.next = newNode;
                if (current == tail) {
                    tail = newNode;
                }
            }
        }
    }

    public void remove(int value) {
        Element current = head;
        while (current != null) {
            if (current.value == value) {
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.previous = null;
                    } else {
                        tail = null;
                    }
                } else if (current == tail) {
                    tail = tail.previous;
                    tail.next = null;
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }

                break;
            }
            current = current.next;
        }
    }

    public void removeFromEnd() {
        if (tail != null) {
            if (tail == head) {
                head = null;
                tail = null;
            } else {
                tail = tail.previous;
                tail.next = null;
            }
        }
    }

    public void removeFromBeginning() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.previous = null;
            } else {
                tail = null;
            }
        }
    }

    public boolean search(int value) {
        Element current = head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void display() {
        Element current = head;

        while (current != null) {
            System.out.print(current.value + " | ");
            current = current.next;
        }

        System.out.println();
    }
}
