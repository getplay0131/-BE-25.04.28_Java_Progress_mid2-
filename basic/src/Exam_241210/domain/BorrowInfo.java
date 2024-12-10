package Exam_241210.domain;

//대출 정보 관리 클래스
public class BorrowInfo {

    private Book book ; //대출된 책
    private Member member; //대출한 회원
    private String borrowDate; // 대출 날짜

    public BorrowInfo(Book book, Member member, String borrowDate){
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
    }

    public Book bookInfoReturn(){
        return this.book;
    }

    public Member memberInfoReturn(){
        return this.member;
    }

    public String getBorrowDate(){
        return this.borrowDate;
    }

    public String returnBookInfo(){
        return "회원: " + member.getterMemberId() + "("+member.getterName() + "), 책 : " + member.getterMemberId() + "(" + book.getterTitle() + ") , 대출일 : " + this.borrowDate;
    }

}