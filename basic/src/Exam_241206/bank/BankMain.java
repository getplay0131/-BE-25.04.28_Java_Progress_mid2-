package Exam_241206.bank;

import Exam_241206.bank.domain.Account;
import Exam_241206.bank.util.BankValidator;

public class BankMain {
    public static void main(String[] args) {
        // 계좌 생성 및 테스트
        Account account1 = new Account("홍길동", 10000);
        Account account2 = new Account("김철수", 20000);

        System.out.println("계좌 생성 후 정보:");
        System.out.println(account1.getAccountInfo());
        System.out.println(account2.getAccountInfo());

        // 거래 테스트
        if (BankValidator.validateAmount(5000)) {
            account1.deposit(5000);
            System.out.println("\n입금 후 정보:");
            System.out.println(account1.getAccountInfo());
        }

        System.out.println("\n총 계좌 수: " + Account.getTotalAccounts());
    }
}