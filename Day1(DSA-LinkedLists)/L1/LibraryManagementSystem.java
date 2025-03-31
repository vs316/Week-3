package DSA.LinkedLists;

class BookNode {
    String bookTitle;
    String author;
    String genre;
    int bookId;
    boolean availabilityStatus;
    BookNode prev;
    BookNode next;

    public BookNode(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availabilityStatus = availabilityStatus;
        this.prev = null;
        this.next = null;
    }
}

class BooksLinkedList {
    private BookNode head;
    private BookNode tail;

    public void addBookAtBeginning(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        BookNode newNode = new BookNode(bookTitle, author, genre, bookId, availabilityStatus);
        if (head == null) {//empty list
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Added Book at beginning: " + bookTitle);
    }

    public void addBookAtEnd(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        BookNode newNode = new BookNode(bookTitle, author, genre, bookId, availabilityStatus);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Added Book at the end: " + bookTitle);
    }

    public void addBookAtPosition(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus, int position) {
        if (position == 1) {
            addBookAtBeginning(bookTitle, author, genre, bookId, availabilityStatus);
            return;
        }
        BookNode newNode = new BookNode(bookTitle, author, genre, bookId, availabilityStatus);
        BookNode temp = head;
        for (int i = 1; i < position - 1; i++) {
            if (temp == null) throw new IndexOutOfBoundsException("Invalid position.");
            temp = temp.next;
        }
        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        } else {//if adding at the end, update the tail
            tail = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp;
        System.out.println("Added book at position: " + position + " : " + bookTitle);
    }

    public void removeBookById(int bookId) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        BookNode temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp == null) {// book not found
            System.out.println("Book not found with ID: " + bookId);
            return;
        }
        if (temp == head) {//removing the head
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {//if list becomes empty
                tail = null;
            }
        } else if (temp == tail) {//removing the tail
            tail = tail.prev;
            tail.next = null;
        } else {//removing from the middle
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        System.out.println("Removed Book with ID: " + bookId);
    }
    public void SearchByBookTitleOrAuthor(String bookTitle, String author){
        BookNode temp=head;
        boolean found=false;
        while(temp!=null){
            if((temp.bookTitle.equalsIgnoreCase(bookTitle))||temp.author.equalsIgnoreCase(author)){
                System.out.println("Found Book: "+temp.bookTitle+" written by "+temp.author);
                found=true;
            }
            temp=temp.next;
        }
        if(!found){
            System.out.println("No book found matching the criteria.");
        }
    }
    public void updateBookAvailabilityStatus(String bookTitle, boolean availabilityStatus){
        BookNode temp=head;
        while (temp!=null){
            if(temp.bookTitle.equalsIgnoreCase(bookTitle)){
                temp.availabilityStatus=availabilityStatus;
                System.out.println("Updated availability Status of "+temp.bookTitle+" to "+ temp.availabilityStatus);
                return;
            }
            temp=temp.next;
        }
    }

    public void displayBooksForward(){
        BookNode temp=head;
        if(temp==null){
            System.out.println("No books to display.");
            return;
        }
        System.out.println("Books in Forward Order: ");
        while(temp!=null){
            System.out.println(temp.bookTitle+" written by "+temp.author+" , Genre "+temp.genre+" - Book ID: "+temp.bookId+" Availability Status: "+temp.availabilityStatus);
            temp=temp.next;
        }
    }
    public void displayBooksReverse(){
        BookNode temp=tail;
        if(temp==null){
            System.out.println("No books to display.");
            return;
        }
        System.out.println("Books in Reverse Order: ");
        while(temp!=null){
            System.out.println(temp.bookTitle+" written by "+temp.author+" , Genre "+temp.genre+" - Book ID: "+temp.bookId+" Availability Status: "+temp.availabilityStatus);
            temp=temp.prev;
        }
    }

    public void countTotalBooksInLibrary(){
        BookNode temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        System.out.println("Total number of books in the library: "+count);
    }

}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        BooksLinkedList library = new BooksLinkedList();

        // Add books to the library
        library.addBookAtBeginning("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101, true);
        library.addBookAtEnd("1984", "George Orwell", "Dystopian", 102, true);
        library.addBookAtEnd("To Kill a Mockingbird", "Harper Lee", "Historical", 103, true);
        library.addBookAtPosition("Moby Dick", "Herman Melville", "Adventure", 104, true, 2);

        // Display all books in forward order
        System.out.println("\nDisplaying all books in forward order:");
        library.displayBooksForward();

        // Display all books in reverse order
        System.out.println("\nDisplaying all books in reverse order:");
        library.displayBooksReverse();

        // Search for books by title or author
        System.out.println("\nSearching for books:");
        library.SearchByBookTitleOrAuthor("1984", null);  // Search by title
        library.SearchByBookTitleOrAuthor(null, "Harper Lee"); // Search by author

        // Update availability status of a book
        System.out.println("\nUpdating book availability status:");
        library.updateBookAvailabilityStatus("To Kill a Mockingbird", false);

        // Remove a book by its ID
        System.out.println("\nRemoving a book:");
        library.removeBookById(101); // Removing "The Great Gatsby"
        library.displayBooksForward();

        // Count the total number of books in the library
        System.out.println("\nCounting total number of books in the library:");
        library.countTotalBooksInLibrary();
    }
}
