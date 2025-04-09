package Progress_250409.collection.link;

public class NodeMain1 {
    public static void main(String[] args) {
//         노드 생성 후 연결하기 : A > B > C
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");
        first.next.next.next = new Node("D");
        first.next.next.next.next = new Node("E");

        System.out.println("모든 노드 탐색하기");
        Node x = first;
//        while (x != null) {
//            System.out.println(x.item);
//            x = x.next;
//        }
        while (x != null) {
            if (x.item.equals("C")) {
                System.out.println("요청 값 찾음! : " + x.item);
                x = x.next;
                continue;
            }
            System.out.println(x.item);
            x = x.next;

        }
    }
}
