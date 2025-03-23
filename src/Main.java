public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        try {
            library.listBooks();
        } catch (EmptyLibraryException e) {
            System.out.println("Library id empty");
        }

        Book book1 = null;
        Book book2 = null;
        Book book3 = null;
        Book book4 = null;


        try {
            book1 = new Book("Java Programming", 300);
            book2 = new Book("Design Patterns", -3);
            book3 = new Book(null, 100);
            book4 = new Book("", 400);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Title cannot be empty or Page count must be positive");
        }


        try {
            library.addBook(book1);
            library.addBook(book2);
            library.addBook(book3);
            library.addBook(book4);

        } catch (InvalidBookException e) {
            System.out.println("Book should not be null");
        }



        try {
            library.listBooks();
        } catch (EmptyLibraryException e) {
            System.out.println("Library id empty");
        }


        try {
            library.borrowBook("Java Programming");
            library.returnBook("Clean Code");
        }
        catch (EmptyLibraryException | BookNotFoundException e) {
            System.out.println("Library is empty, no books to borrow.");

        }


        try {
            library.returnBook("Java Programming");
        } catch (BookNotFoundException e) {
            System.out.println ("Cannot return.");

        }
    }

}
