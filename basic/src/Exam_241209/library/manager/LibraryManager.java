package Exam_241209.library.manager;

import Exam_241209.library.domain.Book;
import Exam_241209.library.domain.BorrowInfo;
import Exam_241209.library.domain.Member;

public class LibraryManager {
private Book[] books; // 도서관의 전체 책 목록
private Member[] members; // 도서관의 전체 회원 목록
private BorrowInfo[] borrows; // 전체 대출 정보 목록
private  int bookCount; // 등록된 책 수
private int memberCount; // 등록된 회원 수
private int borrowCount; // 현재 대출중인 수

    public void addBooks(Book book){
        if (bookCount < 0) {
            return;
        }

        if (book == null) {
            System.out.println("도서 정보를 입력해주세요!");
            return;
        }
        books[bookCount] = book;
        bookCount++;

    }

    public void addMember(Member member){
        if (memberCount < 0) {
            return;
        }

        if (member == null) {
            System.out.println("회원 정보를 입력해주세요!");
            return;
        }

        members[memberCount] = member;
        memberCount++;
    }

    public void isBookLoanCheck(Book book, Member member){
        boolean returnResultCheck = false;
        boolean loanCheck = book.isAvailableCheck();
        for (Member memberCheck : members) {
        if(member == memberCheck && loanCheck){
            returnResultCheck = true;
        }
        }

        for (int i = 0; i < bookCount; i++) {
            if (books[i].equals(book.getterTitle())) {
//                도서 해당 인덱스와, 해당 인덱스의 대출 정보에 값 삽입 해야하는데..
            }
        }


        if (returnResultCheck) {
            System.out.println("대출 가능");
        } else {
            System.out.println("대출 불가");
        }
    }

    public void bookReturn(Book book){
        for (int i = 0; i < bookCount; i++) {
                books[i] = book;
        }
    }

    public boolean bookFind(String book){
        boolean isFind = false;
        for (int i = 0; i < bookCount; i++) {
            String bookTitle =   books[i].toString();
            if (bookTitle.contains(book)) {
                isFind = true;
                return isFind;
            }
        }
        return isFind;
    }

    public void memberBorrow(Member member){
        for (int i = 0; i < bookCount; i++) {
//            모르겠다.
        }
    }

    public void totalLoan(){
//        모르겠다..ㅠㅠ
    }
}