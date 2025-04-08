package Progress_250407.collection.array;

import java.util.Arrays;

public class ArrayMain2 {
    public static void main(String[] args) {
        int [] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        System.out.println(Arrays.toString(arr));

//        배열에 첫번째 위치에 추가
//        기본 배열의 데이터를 한칸식 뒤로 밀고 배열의 첫번째 위치에 추가
        int newValue = 3;
        addFirst(arr,newValue);

//        idx위치에 추가
//        기본 배열의 데이터를 한 칸식 뒤로 밀고 배열의 index 위치에 추가
        System.out.println("배열의 index(2) 위치에 4 추가 O(n)");
        int idx = 2;
        int value = 4;
        addIndex(arr,idx,value);

        System.out.println("배열의 마지막 위치에 5추가 O(1)");
        addLast(arr,5);

    }

    public static void addFirst(int[] arr, int value){
        for (int i = arr.length-1; i > 0 ; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = value;
        System.out.println("배열의 첫번째 위치에 " + value + " 추가 O(n)");
        System.out.println(Arrays.toString(arr));
    }

    public static void addLast(int[] arr, int value){
        if (arr[arr.length-1] == 0) {
            arr[arr.length-1] = value;
            System.out.println(Arrays.toString(arr));
        } else {
            System.out.println("배열의 마지막에 값이 이미 존재합니다.");
        }
    }

    public static void addIndex(int[] arr,int idx, int value){
        for (int i = arr.length-1; i > idx ; i--) {
            arr[i] = arr[i - 1];
        }

        arr[idx] = value;
        System.out.println(Arrays.toString(arr));
    }
}
