package exception;
/*
 * 재고 부족 예외 클래스
 *
 * 구현 방법:
 * 1. Exception 클래스 상속
 * 2. 생성자 구현 (오류 메시지 전달)
 */


public class OutOfStockException extends Exception {
    String message;

    public OutOfStockException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
