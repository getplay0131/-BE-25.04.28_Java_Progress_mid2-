//헷갈려 하는 부분 클래스와 메서드간 구분 => 클래스에서 매기변수 받으려 함
//코드 구성에서 효율적으로 구현하는 부분

package Progress_250219.nested.test2nd.ex1_2nd;

import java.awt.print.Book;

public class Library {
    Book[] books;
    int bookCount;

    public Library(int size) {
        books = new Book[size];
//        this.bookCount = 0;
    }

    public void addbook(String title, String author){
        if (bookCount < books.length) {
            books[bookCount++] = new Book(title,author);
        } else {
            System.out.println("도서관 저장 공간이 부족합니다.");
        }
    }

     public void showBook(){
        for (Book book : books) {
            System.out.println("도서 제목 : " + book.title + ", 저자 : " + book.author);
        }
     }



    private static class Book{
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }
}
