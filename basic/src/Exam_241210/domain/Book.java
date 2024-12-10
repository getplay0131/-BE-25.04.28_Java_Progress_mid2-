package Exam_241210.domain;


//책 정보 관리 클래스
public class Book {
    private static int bookIdCounter; //책 ID 자동 생성용 카운터
    private String BookId; // 책 ID
    private String title; // 책 제목
    private String author; // 저자
    private boolean isAvailable = true; // 대출 가능 여부

    public Book(String title, String author) {
        this.BookId = "B" + bookIdCounter;
        this.title = title;
        this.author = author;
//        bookIdCounter가 증가되지 않고 있습니다
//생성자에서 bookIdCounter++를 추가하여 ID가 자동으로 증가하도록 개선하면 좋겠습니다
        bookIdCounter++;
    }

    public Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
//        Book 클래스의 두 번째 생성자에서 bookIdCounter 증가가 누락됨
        bookIdCounter++;
    }

    public String getterTitle() {
        return title;
    }

    public String getterAuthor() {
        return author;
    }

    public Boolean isAvailableCheck() {
        return isAvailable;
    }

    public boolean isAvailableReverse() {
        //       상태를 변경하는 메서드인데 단순히 반환만 하고 있음
//isAvailable 값을 실제로 변경해야 함
        if (this.isAvailable) {
            isAvailable = false;
        } else {
            isAvailable = true;
        }
        return isAvailable;
    }

    //    Java 명명 규칙에 따라 getBook()과 같은 형태가 더 적절합니다
//일관성 있는 네이밍을 사용하면 좋겠습니다
    public String getBookInfo() {
        return "책ID : " + this.BookId + ", 제목 : " + this.title + ", 저자 : " + this.author + ", 대출가능여부 : " + this.isAvailable;
    }
}