package Progress_250409.collection.link;

public class NodeMain2 {
    public static void main(String[] args) {
//         노드 생성 후 연결하기 : A > B > C
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");
        first.next.next.next = new Node("D");
        first.next.next.next.next = new Node("E");

        if (first.next != null) {
        System.out.println("연결된 노트 출력하기");
        System.out.println(first);
        }

    }
}
