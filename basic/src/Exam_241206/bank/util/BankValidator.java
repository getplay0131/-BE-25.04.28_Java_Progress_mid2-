package Exam_241206.bank.util;

public class BankValidator {
    private BankValidator() {
        // private 생성자로 인스턴스화 방지
    }

    public static boolean validateAmount(double amount) {
        return amount > 0 && amount <= 1000000;
    }

    public static boolean validateName(String name) {
        // 이름 길이만 체크하는 단순한 검증
        return name != null && name.length() >= 2 && name.length() <= 10;
    }
}