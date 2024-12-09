package Exam_241206.bank.util;

public class BankValidatorMain {
    private BankValidatorMain() {
        // private 생성자로 인스턴스화 방지
    }

//    외부공개 공유메서드
//    매개변수의 값이 0 초과이고, 최대액보다 작으면 트루를 반환한다.
    public static boolean validateAmount(double amount) {
        return amount > 0 && amount <= 1000000;
    }

//    외부공개 공유메서드
    public static boolean validateName(String name) {
        // 이름 길이만 체크하는 단순한 검증
        return name != null && name.length() >= 2 && name.length() <= 10;
    }
}