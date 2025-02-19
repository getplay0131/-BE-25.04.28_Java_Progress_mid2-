package Progress_250219.nested.test2nd.ex1_2nd;

public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library(4);
        library.addbook("책1", "저자1");
        library.addbook("책2", "저자2");
        library.addbook("책3", "저자3");
        library.addbook("책4", "저자4");
        library.addbook("책5", "저자5");
        library.showBook();
    }
}
