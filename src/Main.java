import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Library library = new Library();

        int choice;

        do {
            System.out.println("\n===== LIBRARY INFORMATION SYSTEM =====");
            System.out.println("1 - Add a book");
            System.out.println("2 - List all books");
            System.out.println("3 - Borrow a book");
            System.out.println("4 - Return a book");
            System.out.println("5 - Search a book");
            System.out.println("0 - Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline

            switch (choice) {

                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();

                    // Create a Book object
                    Book newBook = new Book(title, author);

                    // Add the Book object to the Library
                    library.addBook(newBook);
                    break;

                case 2:
                    library.listBooks();
                    break;

                case 3:
                    System.out.print("Enter the title of the book to borrow: ");
                    String borrowTitle = scanner.nextLine();

                    library.borrowBook(borrowTitle);
                    break;

                case 4:
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.nextLine();

                    library.returnBook(returnTitle);
                    break;

                case 5:
                    System.out.print("Enter the title of the book to search: ");
                    String searchTitle = scanner.nextLine();

                    library.searchBook(searchTitle);
                    break;

                case 0:
                    System.out.println("Goodbye! Thank you for using the Library Information System.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
```
