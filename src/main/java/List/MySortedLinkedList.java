package List;

public class MySortedLinkedList extends MyLinkedList {

    @SuppressWarnings("unchecked")
    public void add(Comparable c) {

        Node newNode = new Node(c);

        if (head == null) {
            // Adding first item to the list
            head = newNode;
            tail = newNode;
        }
        else {
            // Adding to a list with at least one element
            Node current = head;
            Node prev = null;
            Comparable currentItem;
            while(current != null) {
                currentItem = (Comparable) current.item;
                if (currentItem.compareTo(c) < 0) {
                    prev = current;
                    current = current.next;
                }
                else {
                    break;
                }
            }

            if (prev == null) {
                // inserting at beginning of list
                newNode.next = head;
                head = newNode;
            }
            else if (prev == tail) {
                // appending at end of list
                tail.next = newNode;
                tail = newNode;
            }
            else {
                // Inserting in the middle of the list
                newNode.next = prev.next;
                prev.next = newNode;
            }
        }
        size++;
    }

    public void add(int index, Object o) {
        throw new UnsupportedOperationException("Do not call add(int, Object) on MySortedLinkedList");
    }

}