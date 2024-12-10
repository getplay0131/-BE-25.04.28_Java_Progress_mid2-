package Exam_241210.domain.manager;

import Exam_241210.domain.Book;
import Exam_241210.domain.BorrowInfo;
import Exam_241210.domain.Member;

public class LibraryManager {
    //    배열들이 초기화되지 않았습니다
//LibraryManager의 생성자에서 적절한 크기로 배열들을 초기화해주세요
    private Book[] books = new Book[10]; // 도서관의 전체 책 목록
    private Member[] members = new Member[10];// 도서관의 전체 회원 목록
    private BorrowInfo[] borrows = new BorrowInfo[10]; // 전체 대출 정보 목록
    private int bookCount; // 등록된 책 수
    private int memberCount; // 등록된 회원 수
    private int borrowCount; // 현재 대출중인 수

    public void addBooks(Book book) {
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

    public void addMember(Member member) {
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

    //    대출 가능 여부만 체크해보기
    public void isBookLoanCheck(Book book, Member member, String bookName) {

//        책 대출 가능 상태 확인
//        책 존재 여부 확인에서 존재 여부는 확인 했으니, 해당 책의 대출 가능 여부를 확인 한다.
//        ===============================
//        현재는 매개변수로 받은 book의 상태만 확인
//실제 도서관 목록(books 배열)에서 찾은 책의 상태를 확인해야 함

//        로직이 복잡하고 중복 검사를 하고 있음
//찾은 책의 상태만 확인하면 됨
        boolean bookLoanStat = false;
//        bookLoanStat 값이 설정되지 않음
//두 번 상태 체크하는 중복 있음
        if (!book.isAvailableCheck()) {
            return;
        }
        bookLoanStat = true;
//회원 대출 가능 점수 확인
        if (!member.loanBook()) {
            return;
        }

//        모든 조건 충족시 대출 정보 생성하기

//        이미 검증이 끝난 후라 반복문이 불필요
//BorrowInfo 객체 생성이 누락됨
//        for (int i = 0; i < bookCount; i++) {
        if (checkList(member, bookName)) {
            BorrowInfo borrow = new BorrowInfo(book, member, "24-12-10");
//            생성한 BorrowInfo 객체를 borrows 배열에 저장하는 로직 필요
            borrows[borrowCount] = borrow;
//            borrowCount++;

//borrowCount 증가 처리 필요
            book.isAvailableReverse();
            member.loanBook();
            System.out.println("대출 가능");
        } else {
            System.out.println("대출 불가");
        }
//        }

//
    }


    public void bookReturn(Book book, Member member, String bookName) {
        boolean returnCheck = false;
        if (!checkList(member, bookName)) {
            System.out.println("입력하신 회원 정보와 일치하는 정보가 없습니다.");
        }
        for (BorrowInfo borrow : borrows) {
            if (borrow.bookInfoReturn().isAvailableCheck()) {
                System.out.println("해당 도서는 대출 상태가 아닙니다.");
            }
        }

        for (int i = 0; i < borrowCount; i++) {
            if (borrows[i].bookInfoReturn().getterTitle().equals(bookName) && !borrows[i].bookInfoReturn().isAvailableCheck()) {
                borrows[i].bookInfoReturn().isAvailableReverse();
                borrows[i].memberInfoReturn().returnBook();

                borrows[i] = null;

                for (int j = i; j < borrowCount - 1; j++) {
                    borrows[j] = borrows[j + 1];
                }
                borrowCount--;
                returnCheck = true;
                break;
            }

        }

        if (returnCheck) {
            System.out.println("반납 성공");
        } else {
            System.out.println("반납 실패");
        }
    }

    public boolean bookFind(String bookName) {
//        toString() 대신 책 제목을 직접 비교하는 것이 더 정확합니다
//getterTitle() 메서드를 활용하세요
        boolean isFind = false;
        for (int i = 0; i < bookCount; i++) {
//            String bookTitle =   books[i].toString();
            if (bookName.equals(books[i].getterTitle())) {
                isFind = true;
                return isFind;
            }
        }
        return isFind;
    }

    //    borrows 배열을 순회하면서 해당 회원의 대출 정보를 찾아야 합니다
//BorrowInfo의 getMember()를 활용해 비교하면 됩니다
    public void memberBorrow(Book book, Member member, String date) {
        boolean isBookBorrow = false;
        for (int i = 0; i < borrowCount; i++) {
            if (borrows[i].memberInfoReturn().getterMemberId().equals(member.getterMemberId())) {
                System.out.println(borrows[i].returnBookInfo());
                isBookBorrow = true;
            }
        }

        if (!isBookBorrow) {
            System.out.println("해당 회원의 대출 기록이 없습니다.");
        }
    }

    //    전체 대출 현황 조회
    public void totalLoan() {
//        전체 현황 조회는 매개변수가 필요 없음
        boolean bookStatCheck = false;
        int loanCount = 0;
        if (borrowCount == 0) {
            System.out.println("현재 대출중인 도서가 없습니다.");
            return;
        }

        System.out.println("==전체 대출 현황==");
        for (int i = 0; i < borrowCount; i++) {
            if (borrows[i] != null && !borrows[i].bookInfoReturn().isAvailableCheck()) {
                System.out.println("책 : " + borrows[i].bookInfoReturn().getterTitle() + ", 대출자 : " + borrows[i].memberInfoReturn().getterName() + ", 대출일 : " + borrows[i].getBorrowDate());
                loanCount++;
            }
        }
        System.out.println("=============");
        System.out.println("전체 대출 건수 : " + loanCount + "건");
    }

    public boolean checkList(Member member, String bookName) {
        // 회원 존재 여부 확인
//        일단 클래스의 배열에 해당 회원의 아이디와 일치하는 아이디가 있는지 확인해야겠지?
        if (bookCount >= books.length || borrowCount >= borrows.length || memberCount >= members.length) {
            System.out.println("입력 가능값 초과로 프로그램 진행이 불가합니다.");
            return false;
        }

        boolean MemberFind = false;
        for (Member member1 : members) {
//            member1.getterMemberId()와 비교해야 함
//            여전히 Member 객체와 String을 비교하고 있음
//회원 ID끼리 비교해야 함
            if (member1.getterMemberId().equals(member.getterMemberId())) {
//        만약 있다면 불리언 타입의 결과를 트루로 반환하여 이후 과정에서 이용할 수 있게 구성하면 될거 같아
                MemberFind = true;
            } else {
                return false;
            }
//            여전히 첫 불일치에서 종료됨
//책 검색처럼 전체 검색 후 결과 처리 필요
        }

//        책 존재 여부 확인
//        우선 책 정보를 입력 받기 위해 매개변수를 추가로 설정하고
//        위의 회원 정보 확인하는 것처럼 비교 과정을 거치고
//        책이 있다면 불리언 변수를 결과값을 트루로 설정한다.
        boolean bookFinds = false;
        for (Book book1 : books) {
//book1.getterTitle()과 비교해야 함
            if (book1.getterTitle().equals(bookName)) {
                bookFinds = true;
//                for-each 루프 내에서 else로 처리하면 첫 번째 불일치에서 바로 종료됨
//전체 검색 후 결과 처리해야 함
            } else {
                return false;
            }
        }
        return true;
    }
}
