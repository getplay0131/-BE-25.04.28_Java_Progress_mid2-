package Exam_241209.library.domain;


//책 정보 관리 클래스
public class Book {
private static int bookIdCounter; //책 ID 자동 생성용 카운터
private String BookId; // 책 ID
private String title; // 책 제목
private String author; // 저자
private boolean isAvailable; // 대출 가능 여부

   public Book (String title, String author){
        this.BookId = "B" + bookIdCounter;
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author, boolean isAvailable){
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String  getterTitle(){
        return title;
    }

    public String getterAuthor(){
        return author;
    }

    public Boolean isAvailableCheck(){
       return isAvailable;
    }

    public String bookInfoReturn(){
        return "책ID : " + this.BookId + ", 제목 : " + this.title + ", 저자 : " + this.author + ", 대출가능여부 : " + this.isAvailable;
    }
}