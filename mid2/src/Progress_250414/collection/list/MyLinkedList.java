package Progress_250414.collection.list;

public class MyLinkedList<E> implements  MyList<E> {
    private Node<E> first;
    private int size = 0;

    @Override
    public void add(E e) {
        Node newNode = new Node(e);
        if (first == null) {
            first = newNode;
        } else {
            Node lastNode = getlastNode();
            lastNode.next = newNode;
        }
        size++;
    }

    @Override
    public void add(int idx, E e) {
        Node<E> newNode = new Node(e);
//        첫번째에 추가할 때는, 바로 노드를 연결하면 된다. 즉 참조 주소만 바꾸는 거다.
        if (idx == 0) {
            newNode.next = first;
            first = newNode;
//            하지만 중간에 추가한다면, 전에 노드를 가져와 정보를 저장한다
//            그 후 새노드의 다음 주소를 가져온 노드의 다음 주소로 바꾸고, 이전에 사용하던 노드는 새 노드로 대체한다.
        } else {
//            이전에 사용하던 노드 가져오기
            Node<E> prevNode = getNode(idx - 1);
//            새 노드의 다음 참조를 이전의 참조 주서로 저장하기
            newNode.next = prevNode.next;
//            아이템을 새로운 노드로 대체하기
            prevNode.next = newNode;
        }
//        그 후 사이즈를 키운다.
        size++;
    }

    private Node getlastNode() {
        Node x = first;
        while (x.next != null) {
            x = x.next;
        }
        return x;
    }

    @Override
    public E set(int idx, E element) {
        Node<E> x = getNode(idx);
        E oldValue = x.item;
        x.item = element;
        return oldValue;
    }

    @Override
    public E get(int idx) {
        Node<E> x = getNode(idx);
        return x.item;
    }

    private Node<E> getNode(int idx) {
        Node<E> x = first;
        for (int i = 0; i < idx; i++) {
            x = x.next;
        }
        return x;
    }

    @Override
    public E remove(int idx){
        Node<E> removeNode = getNode(idx);
        E removeItem = removeNode.item;
        if (idx == 0){
            first = removeNode.next;
        } else {
            Node<E> prevNode = getNode(idx - 1);
            prevNode.next = removeNode.next;
        }
        removeNode.next = null;
        removeNode.item = null;
        size--;
        return removeItem;
    }

    @Override
    public int indexOf(E o) {
        int index = 0;
        for (Node x = first; x != null; x = x.next) {
            if (o.equals(x.item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
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

    private static class Node<E>{
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            Node<E> x = this;
            builder.append("[ ");
            while (x != null) {
                builder.append(x.item);
                if (x.next != null) {
                    builder.append(" => ");
                } else {
                    builder.append(" ] ");
                }
                x = x.next;
            }
            return builder.toString();
        }
    }
}
