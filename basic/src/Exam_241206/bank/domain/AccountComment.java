package Exam_241206.bank.domain;
/*
 * 학습 포인트:
 * 1. private 멤버 변수와 public 메서드를 통한 캡슐화
 * 2. static 변수를 통한 전체 계좌 수 관리
 * 3. 패키지 구조화
 */
public class AccountComment {
//    변수 설정
//    private 외부에서 검색 안되게, 외부 호출 차단
//    static 공유 변수로 설정하기 위해 해당 키워드 사용
    private static int totalAccounts = 0; // 총 계좌 수 관리
    private String accountNumber;
    private String ownerName;
    private double balance;

//    생성자 설정
//    public로 외부에 해당 메소드를 공개한다.
    public AccountComment(String ownerName, double initialBalance) {
//         this를 사용해 해당 인스턴스를 지정한다.
//        스트링에 번호를 붙여 간단한 계좌번호를 만든다.
        this.accountNumber = "A" + (totalAccounts + 1); // 단순한 계좌번호 생성 방식
        this.ownerName = ownerName;
        this.balance = initialBalance;
//        작업이 성공적으로 수행되면 카운트를 증가시킨다.
        totalAccounts++;
    }

//    입금 메서드
//    void  키워드로 반환이 필요 없음을 지정
    public void deposit(double amount) {
        if (amount > 0) {
//            해당 클래스의 해당 변수의 값에 매개변수의 값을 더한다.
            this.balance += amount;
        }
    }

//  public : 외부 공개
//    인출 메서드
    public boolean withdraw(double amount) {
//        조건문을 활용해 입력값의 값을 검증하고, 또 현재 잔액의 값을 체크한다.
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
//            작업 수행시 작업 성공을 리턴한다.
            return true;
        }
//        작업 수행을 못하면 작업 실패를 리턴한다.
        return false;
    }

//    외부 공개
//    현재 잔액을 반환하는 기능이므로, 현재 잔액을 반환한다
    public double getBalance() {
        return this.balance;
    }

//    외부 공개
//    현재 계좌번호를 반환하는 기능이므로, 현재 계좌번호를 반환한다
    public String getAccountNumber() {
        return this.accountNumber;
    }

//    외부 공개
//    계자 정보 반환 메서드
    public String getAccountInfo() {
        // 문자열 결합으로 단순화
        return "계좌번호: " + accountNumber + ", 소유주: " + ownerName + ", 잔액: " + balance;
    }

//    외부공개 공유 메서드
//    총 카운트 값을 반환한다.
    public static int getTotalAccounts() {
        return totalAccounts;
    }

//    외부 공개
    public boolean transfer(AccountComment targetAccount, double amount){
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
//        조건문을 이용해 현재 잔액보다 큰지, 0보다 큰지를 확인하고, 이체할 계좌 유무에 대해서도 체크한다.
        if ((balance < amount && amount > 0) && targetAccount != null) {
            System.out.println("잔액 부족이나, 이체 가능 금액 초과로 계좌 이체에 실패하였습니다.");
//            작업 수행에 필요한 값이 없다면 작업 수행 여부에 관해 부정 결과를 반환한다.
            return false;
        } else {
//            이 클래스 내 인출 메서드를 호출하여 매개변수로 해당 값을 전달한다.
            this.withdraw(amount);
//            해당 계좌에 매개변수로 받은 금액을 입금한다.
            targetAccount.deposit(amount);
            System.out.println("계좌 이체에 성공하였습니다.");
//            작업 수행 성공 여부를 반환한다.
            return true;
        }
    }
}
