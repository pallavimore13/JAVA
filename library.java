import java.util.ArrayList;

class Person {
    String name;
    int id;

    // Constructor
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Student extends Person {
    int studentId;

    // Constructor for Student
    public Student(String name, int id, int studentId) {
        super(name, id);
        this.studentId = studentId;
    }
}

class Staff extends Student {
    String designation;

    // Constructor for Staff
    public Staff(String name, int id, int studentId, String designation) {
        super(name, id, studentId);
        this.designation = designation;
    }
}

class Book {
    String title;
    String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

class Library {
    ArrayList<Book> books;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to display all books in the library
    public void displayBooks() {
        for (Book book : books) {
            System.out.println("Title: " + book.title + ", Author: " + book.author);
        }
    }
}

class LibraryManagementSystem {
    public static void main(String[] args) {
        // Creating a library
        Library library = new Library();

        // Adding books to the library
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));

        // Displaying all books in the library
        System.out.println("Books in the Library:");
        library.displayBooks();

        // Creating a staff member
        Staff staffMember = new Staff("John Doe", 101, 201, "Librarian");

        // Displaying staff member details
        System.out.println("\nStaff Member Details:");
        System.out.println("Name: " + staffMember.name);
        System.out.println("ID: " + staffMember.id);
        System.out.println("Student ID: " + staffMember.studentId);
        System.out.println("Designation: " + staffMember.designation);
    }
}
