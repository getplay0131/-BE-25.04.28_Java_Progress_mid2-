package Exam_241206.bank.domain;

public class AccountManagerComment {
//    기본 변수 선언
//  private 를 사용하여 외부 호출 차단
    private Account[] accounts = new Account[10]; // 최대 10개 계좌 관리
    private int accountCount = 0;

//    외부공개 반환필요없음
    public void addAccount(Account account) {
        // 배열에 계좌 추가
//        for (int i = 0; i < accountCount; i++) {
//            accounts[accountCount] = account;
//        }
        // 고려해야 할 것들:
//        =========================
// 3. 배열이 꽉 찼는지 체크 필요 (accounts.length와 비교)
        if (accountCount >= accounts.length) {
            System.out.println("등록 가능한 최대 계좌 개수에 도달하였습니다.");
            return;
        }
// 2. 이미 동일한 계좌가 있는지 체크하는 로직도 고려
            if (accounts[accountCount] != account) {
// 1. 배열에 추가할 때는 반복문이 필요없음 (왜냐하면 한번에 하나씩만 추가하니까)
// 2. accountCount는 현재 저장된 계좌의 개수이자, 다음 계좌가 저장될 위치
        accounts[accountCount] = account;
// 3. accountCount 증가 전에 account null 체크하는게 더 안전
        if (account != null) {
        accountCount++;
        // 1. 계좌가 추가되었다는 성공 메시지도 있으면 좋음
            System.out.println("계좌 추가가 성공하였습니다.");
            }
        }
    }

//    외부 공개 타입을 객체로 설정한다.
    public Account findAccount(String accountNumber) {
        // 계좌번호로 계좌 찾기
        // 주의할 점들:
// 1. 계좌번호(String)와 Account 객체는 다른 타입이므로 직접 비교 불가
// 2. 새로운 Account 객체를 만들 필요 없음
// 3. null 체크 필요
// 4. 계좌번호 비교시 equals() 메서드 사용해야 함
// 5. 찾지 못했을 때의 처리도 고려 >> 모르겠음
//        ==========================
// 1. accounts[i]가 null인 경우 체크 필요 (NullPointerException 방지)
// 2. accounts[i]의 계좌번호를 가져올 때는 getAccountNumber() 메서드 사용
// 3. String.valueOf() 대신 직접 getAccountNumber()와 비교
// 4. 찾은 계좌를 반환해야 함 (현재는 반환값이 없음)
// 5. 메시지 출력과 계좌 찾기 로직은 분리하는 것이 좋음
// 6. 찾지 못한 경우 null을 반환하도록 구현
// 7. accounts.length 대신 accountCount 사용 (실제 저장된 계좌 수만큼만 검색)

        // 1. 입력받은 계좌번호가 null인지 먼저 체크
        // - 검색하려는 계좌번호가 null이면 찾을 수 없으므로 null 반환
        if (accountNumber == null) {
            return null;
        }

        // 2. 배열을 돌면서 계좌 찾기
        // - 배열은 실제 저장된 계좌 수만큼만 반복 (accountCount 사용)
        for (int i = 0; i < accountCount; i++) {
        // 3. 각 배열 요소 검사시 순서
        // - accounts[i]가 null인지 먼저 체크 (NullPointerException 방지)
        // - null이 아닐 경우에만 계좌번호 비교 수행
        // - accounts[i].getAccountNumber()로 계좌번호 가져오기
        // - equals()로 계좌번호 비교
            if (accounts[i] == null) {
                return null;
            }

//            작업의 편의를 위해 계좌 번호를 변수에 저장
            String accountNumbers = accounts[i].getAccountNumber();
//            조건문을 이용해 매개변수의 값이 지금 저장된 계좌번호와 일치하는지를 판단한다.
            if (accountNumber.equals(accountNumbers)) {
//                일치할시 해당 계과 번호를 반환한다.
                return accounts[i];
            }
        }

        // 4. 계좌를 찾았을 때
        // - 해당 계좌(accounts[i]) 반환

        // 5. 반복문이 끝날 때까지 못 찾은 경우
        // - null 반환
        return null;
    }
//               String okMsg = "검색하신 내용과 일치하는 계좌번호를 찾았습니다. ";
//               String failMsg = "검색 내용과 일치하는 내용을 찾을 수 없습니다.";
//        Account inputAccount = new Account(accountNumber, 0);
//        if (accountNumber != null) {
//            for (int i = 0; i < accounts.length; i++) {
//        if (accountNumber.equals(accounts[i])) {
//            System.out.println("검색하신 내용과 일치하는 계좌번호를 찾았습니다. " + accounts[i]);
//        }
//            }
//        }
//        return inputAccount;

    // 계좌 검색 결과를 출력하는 별도의 메서드
// - findAccount의 결과를 받아서 적절한 메시지 출력
    public void printAccountSearchResult(String accountNumber) {
        // 1. findAccount 메서드 호출하여 결과 저장
//        String result = String.valueOf(this.findAccount(accountNumber));
        Account isFound = findAccount(accountNumber);
        // 2. 결과가 null이 아니면 계좌 정보 출력

        // - getAccountInfo() 사용
        if (isFound != null) {
            System.out.println("검색하신 내용과 일치하는 계좌번호를 찾았습니다. " + isFound.getAccountInfo());
        } else {
            System.out.println("검색 내용과 일치하는 내용을 찾을 수 없습니다.");
        }
        // 3. 결과가 null이면 "찾을 수 없음" 메시지 출력
    }
}
