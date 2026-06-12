import java.util.*;

class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }

    @Override
    public String toString() {
        return "'" + title + "' by " + author + " [ID: " + bookId + "]";
    }
}

public class LibraryManagement {

    public static Book linearSearchByTitle(List<Book> books, String targetTitle) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(targetTitle)) {
                return b;
            }
        }
        return null;
    }

    public static Book binarySearchByTitle(List<Book> books, String targetTitle) {
        int low = 0;
        int high = books.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = books.get(mid).getTitle().compareToIgnoreCase(targetTitle);

            if (cmp == 0) {
                return books.get(mid);
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<Book> library = new ArrayList<>();
        library.add(new Book("B1", "A Game of Thrones", "George R.R. Martin"));
        library.add(new Book("B2", "Brave New World", "Aldous Huxley"));
        library.add(new Book("B3", "Catch-22", "Joseph Heller"));
        library.add(new Book("B4", "The Hobbit", "J.R.R. Tolkien"));

        System.out.println(linearSearchByTitle(library, "Catch-22"));
        System.out.println(binarySearchByTitle(library, "The Hobbit"));
    }
}