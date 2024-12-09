package Exam_241206.bank.domain;
/*
 * 학습 포인트:
 * 1. private 멤버 변수와 public 메서드를 통한 캡슐화
 * 2. static 변수를 통한 전체 계좌 수 관리
 * 3. 패키지 구조화
 */
public class Account {
    private static int totalAccounts = 0; // 총 계좌 수 관리
    private String accountNumber;
    private String ownerName;
    private double balance;

    public Account(String ownerName, double initialBalance) {
        this.accountNumber = "A" + (totalAccounts + 1); // 단순한 계좌번호 생성 방식
        this.ownerName = ownerName;
        this.balance = initialBalance;
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getAccountInfo() {
        // 문자열 결합으로 단순화
        return "계좌번호: " + accountNumber + ", 소유주: " + ownerName + ", 잔액: " + balance;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public boolean transfer(Account targetAccount, double amount){
//    // 1. 출금계좌 잔액 검증
//        if (balance > 0) {
//    // 2. 출금계좌에서 금액 차감
//            balance -= amount;
//        // 3. 입금계좌에 금액 추가
//            targetAccount.balance += amount;
//            return true;
//        } else {
//            return false;
//        }

//        개선 버전
        // 체크해야 할 것들:
// 1. 출금하려는 금액(amount)이 잔액(balance)보다 큰지 검사
// 2. 이미 만들어둔 withdraw, deposit 메서드를 재사용하면 코드 중복을 막을 수 있음
// 3. 출금 실패시 이체도 실패해야 함

//        ====================
        // 1. 출금액이 0보다 큰지도 체크하면 좋음 (음수 금액 체크)
// 2. targetAccount가 null인 경우도 체크하면 좋음
// 3. 이체 성공/실패 메시지를 좀 더 구체적으로 (예: 이체 금액, 잔액 등 포함)
        if ((balance < amount && amount > 0) && targetAccount != null) {
            System.out.println("잔액 부족이나, 이체 가능 금액 초과로 계좌 이체에 실패하였습니다.");
            return false;
        } else {
            this.withdraw(amount);
            targetAccount.deposit(amount);
            System.out.println("계좌 이체에 성공하였습니다.");
            return true;
        }
    }
}
