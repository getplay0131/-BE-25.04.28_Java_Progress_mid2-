package Progress_250409.collection.link;

import java.util.ArrayList;

public class NodeMain3 {
    public static void main(String[] args) {
//         노드 생성 후 연결하기 : A > B > C
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");
        first.next.next.next = new Node("D");
        first.next.next.next.next = new Node("E");
        System.out.println(first);
        printLine();

//        모든 노드 탐색하기
        System.out.println("모든 노드 탐색하기");
        printAll(first);
        printLine();

// 마지막 노드 탐색하기
        System.out.println("마지막 노드 탐색하기");
        Node lastNode = findLastNode(first);
        System.out.println("lastNode = " + lastNode);
        printLine();

//        findLastNode(first);

//    특정 인덱스의 노드 조회하기
        System.out.println("특정 인덱스의 노드 찾기");
        findIndexNode(first, 4);
        printLine();


//데이터 추가하기
        System.out.println("데이터 추가하기");
        addData(first, "F");
        System.out.println(first);
        printLine();

        addData(first, "G");
        System.out.println(first);
        printLine();

        addData(first, "H");
        System.out.println(first);
    }
    public static void printLine(){
        System.out.println(" ---------------------------------- ");

        System.out.println(" ---------------------------------- ");
    }


    public static void printAll(Node node) {
        Node x = node;
        while (x != null) {
            System.out.println(x.item);
            x = x.next;
        }
    }

    public static Node findLastNode(Node node) {
        Node node1 = node;
        while (node1.next != null) {
            node1 = node1.next;
        }
        return node1;
    }


    public static void findIndexNode(Node node, int idx) {
        int count = 0;
        Node node1 = node;
        Node node2 = node;

        int nodeCount = 0;
        while (node2.next != null) {
            nodeCount++;
            node2 = node2.next;
        }
        System.out.println(nodeCount + "이내의 인덱스로 조회 가능!");

        if (idx > nodeCount) {
            System.out.println("입력 범위 오류!");
        }

        if (node1 != null) {
            while (count < idx) {
                node1 = node1.next;
                count++;
            }
            System.out.println("노드의 " + idx + "번 째 아이템 : " + node1.item);
        }
    }

    public static void addData(Node node, Object data) {
        Node lastNode = findLastNode(node);
        lastNode.next = new Node(data);
    }
}

