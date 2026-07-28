import java.util.ArrayList;

public class Library {

    // Collection of books
    private ArrayList<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    // List all books
    public void listBooks() {

        if (books.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }

        System.out.println("\n===== ALL BOOKS =====");

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);

            String status;

            if (book.isBorrowed()) {
                status = "Borrowed";
            } else {
                status = "Available";
            }

            System.out.println(
                    (i + 1) + ". "
                    + book.getTitle()
                    + " by "
                    + book.getAuthor()
                    + " - "
                    + status
            );
        }
    }

    // Borrow a book by title
    public void borrowBook(String title) {

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {

                if (book.isBorrowed()) {
                    System.out.println("The book is already borrowed.");
                } else {
                    book.borrow();
                    System.out.println(
                            "You have successfully borrowed: "
                            + book.getTitle()
                    );
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Return a book by title
    public void returnBook(String title) {

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {

                if (!book.isBorrowed()) {
                    System.out.println("The book is already available.");
                } else {
                    book.returnBook();
                    System.out.println(
                            "You have successfully returned: "
                            + book.getTitle()
                    );
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Search for a book by title
    public void searchBook(String title) {

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {

                System.out.println("Book found!");
                System.out.println(book.describe());
                return;
            }
        }

        System.out.println("Book not found.");
    }
}
```
