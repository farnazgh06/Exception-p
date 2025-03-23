import java.util.ArrayList;

public class Library {
    private ArrayList<Book>books;

    public Library(){
        books = new ArrayList<>();
    }

    public void addBook(Book book) throws InvalidBookException{
        if(book == null){
            throw new InvalidBookException ("Book should not be null");
        }
        books.add(book);
    }

    private Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String title) throws BookNotFoundException, EmptyLibraryException{
        if(books.size() == 0){
            throw new EmptyLibraryException ("Library is empty, no books to borrow.");
        }
        Book book = findBook(title);
        if (book == null){
            throw new BookNotFoundException ("Book with title '" + title + "' not found.");
        }
        else{
            System.out.println("borrow successful");
            books.remove(book);
        }

    }
    public void returnBook(String title) throws BookNotFoundException{
        Book book = findBook(title);
        if(book == null){
            throw new BookNotFoundException("Cannot return. Book with title '" + title + "' not found.");
        }
        else {
            System.out.println("return successful");
            books.add(book);
        }
    }
    public void listBooks() throws EmptyLibraryException{
        if(books.isEmpty()){
            throw new EmptyLibraryException("Library id empty");
        }
        else{
            System.out.println("Books in the library : ");
            for(Book book : books){
                System.out.println(book);
            }

        }

    }

    public ArrayList<Book> getBooks(){
        return books;
    }



}
