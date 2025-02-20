package Progress_250220.nested.test3nd.ex1;

public class Library implements LibraryInterface {
    Book [] books;
    int bookCounts;

    public Library(int size) {
        books = new Book[size];
    }

    @Override
    public void addBook(String title, String author) {
        if (bookCounts < books.length) {
            books[bookCounts++] = new Book(title, author);
        } else {
            System.out.println("도서관 저장 공간이 부족합니다.");
        }
    }

    @Override
    public void showBooks() {
        for (Book book : books) {
            System.out.println("도서 제목 : " + book.title + ", 저자 : " + book.author);
        }
    }

    static class Book{
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }
}
