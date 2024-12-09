package Exam_241209.library.domain;
//회원정보 관리 클래스
public class Member {
private static int MemberCounter; // 회원 ID 자동 생성용 카운터
private String memberId; // 회원 ID M1,M2...
private String name; //회원 이름
private int borrowedCount; // 현재 대출 중인 책 수

    public Member(String name){
        this.name = name;
        memberId = "M" + MemberCounter;
    }
    
    public String getterMemberId(){
        return memberId;
    }
    
    public String getterName(){
        return name;
    }
    
    public int loanBook(int borrowedCount){
        if (borrowedCount >= 3) {
            System.out.println("추가 대출이 불가합니다.");
            return borrowedCount;
        }
        return borrowedCount++;
    }

    public int returnBook(int borrowedCount){
//        if (borrowedCount >= 3) {
//            System.out.println("추가 대출이 불가합니다.");
//            return borrowedCount;
//        }
        return borrowedCount--;
    }
}