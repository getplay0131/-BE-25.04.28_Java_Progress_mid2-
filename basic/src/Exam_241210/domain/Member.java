package Exam_241210.domain;
//회원정보 관리 클래스
public class Member {
private static int memberCounter; // 회원 ID 자동 생성용 카운터
private String memberId; // 회원 ID M1,M2...
private String name; //회원 이름
//    borrowedCount를 static으로 선언한 것은 재고려가 필요함
private  int borrowedCount; // 현재 대출 중인 책 수

    public Member(String name){
        this.name = name;
        memberId = "M" + memberCounter;
//        Member 클래스의 memberCounter 증가가 누락됨
        memberCounter++;
    }
    
    public String getterMemberId(){
        return memberId;
    }
    
    public String getterName(){
        return name;
    }
    
    public  boolean loanBook(){
//        파라미터로 borrowedCount를 받는 것보다 클래스의 필드를 직접 사용하는 것이 더 안전합니다
//반환값이 있지만 실제로 필드를 수정하지 않고 있습니다
        if (borrowedCount >= 3) {
            System.out.println("추가 대출이 불가합니다.");
            return false;
        }
        borrowedCount++;
        return true;
    }

    public String  returnBook(){
//        파라미터로 borrowedCount를 받을 필요 없음
//loanBook()처럼 내부 필드를 사용하도록 수정 필요
        borrowedCount--;
        return "회원 ID : " + getterMemberId() + ", 회원 이름 : " + getterName() + ", 현재 대출중인 책 수 : " + this.borrowedCount + "권 입니다. " ;
    }
}