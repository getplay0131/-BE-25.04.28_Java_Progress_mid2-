package Progress_250409.collection.link;

public class Node {
    Object item;
    Node next;

    public Node(Object item) {
        this.item = item;
    }

//    @Override
//    public String toString() {
//        return "Node{" +
//                "item=" + item +
//                ", next=" + next +
//                '}';
//    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node x = this;
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
