public class Book {

    // Private fields
    private String title;
    private String author;
    private boolean isBorrowed;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Getter for borrowed status
    public boolean isBorrowed() {
        return isBorrowed;
    }

    // Borrow the book
    public void borrow() {
        isBorrowed = true;
    }

    // Return the book
    public void returnBook() {
        isBorrowed = false;
    }

    // Describe the book
    public String describe() {
        String status;

        if (isBorrowed) {
            status = "Borrowed";
        } else {
            status = "Available";
        }

        return "Title: " + title
                + " | Author: " + author
                + " | Status: " + status;
    }
}
```

