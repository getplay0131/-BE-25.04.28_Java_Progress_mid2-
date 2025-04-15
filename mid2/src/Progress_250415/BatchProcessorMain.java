package Progress_250415;

public class BatchProcessorMain {
    public static void main(String[] args) {

//        MyArrayList<Integer> list = new MyArrayList<>();
        MyLinkedList<Integer> list = new MyLinkedList<>();

        BatchProcessor batchProcessor = new BatchProcessor(list);
        batchProcessor.logic(50000);
    }
}
