package exception;
/*
 * 유효하지 않은 결제 예외 클래스
 *
 * 구현 방법:
 * 1. Exception 클래스 상속
 * 2. 생성자 구현 (오류 메시지 전달)
 */
public class InvalidPaymentException extends Exception{
    public InvalidPaymentException(String message) {
        super(message);
    }
}
