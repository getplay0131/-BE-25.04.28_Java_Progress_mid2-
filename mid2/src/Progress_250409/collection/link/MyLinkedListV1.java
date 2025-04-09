package Progress_250409.collection.link;

public class MyLinkedListV1 {
    private Node first;
    private int size = 0;

    public void add(Object e) {
        Node newNode = new Node(e);
        if (first == null) {
            first = newNode;
        } else {
            Node lastNode = getlastNode();
            lastNode.next = newNode;
        }
        size++;
    }

    private Node getlastNode() {
        Node x = first;
        while (x.next != null) {
            x = x.next;
        }
        return x;
    }

    public Object set(int idx, Object element) {
        Node x = getNode(idx);
        Object oldValue = x.item;
        x.item = element;
        return oldValue;
    }

    public Object get(int idx) {
        Node x = getNode(idx);
        return x.item;
    }

    private Node getNode(int idx) {
        Node x = first;
        for (int i = 0; i < idx; i++) {
            x = x.next;
        }
        return x;
    }

    public int indexOf(Object o) {
        int index = 0;
        for (Node x = first; x != null; x = x.next) {
            if (o.equals(x.item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

public int size(){
        return size;
}

    @Override
    public String toString() {
        return "MyLinkedListV1{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }
}
