import java.util.*;

class LibraryManagement
{
    public String[] bookNames = new String[500];
    public String[] authorNames = new String[500];
    public int numBook = 0;

	//Add Book
    public int addBook(String[] bookNames, String[] authorNames) 
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Book name:");
        String bookName = scan.nextLine();

        System.out.println("Author name:");
        String authorName = scan.nextLine();

        if (numBook < 500) 
        {
            bookNames[numBook] = bookName;
            authorNames[numBook] = authorName;
            numBook++;
            return numBook - 1;
        } 
        else 
        {
            System.out.println("No space available to add the book.");
            return -1;
        }
    }
    
    	//ISSUE BOOK
       public boolean issueBook(String BookName, String AuthorName, String RegNo) 
       {
	    if (isBookAvail(numBook)) 
	    {
		System.out.println("Issued "+BookName + " to "+ RegNo);
		numBook = numBook - 1;
		
		return true;
	    } 
	    else 
	    {
		System.out.println("Book is not available");
		return false;
	    }
	}

	public boolean isBookAvail(int numBook) 
	{
	    return numBook != 0;
	}
	
	//AVAILABLE BOOK
	public String[] availableBooks() 
	{
		String[] available = new String[numBook];
		for (int i = 0; i < numBook; i++) 
		{
		    available[i] = bookNames[i] + " by " + authorNames[i];
		}
		return available;
	}
	
	//REMOVE BOOK
	public boolean removeBook(String bookName) 
	    {
		for (int i = 0; i < numBook; i++) 
		{
		    if (bookNames[i].equalsIgnoreCase(bookName)) 
		    {
		        // Shift elements to the left to remove the book
		        for (int j = i; j < numBook - 1; j++) 
		        {
		            bookNames[j] = bookNames[j + 1];
		            authorNames[j] = authorNames[j + 1];
		        }
		        bookNames[numBook - 1] = null; // Set the last element to null
		        authorNames[numBook - 1] = null; // Set the last element to null
		        numBook--;
		        System.out.println("Book removed.");
		        return true;
		    }
		}
		System.out.println("Book not found.");
		return false;
	    }
	    
		    // Renew Book
	    public boolean renewBook(String bookName) 
	    {
		for (int i = 0; i < numBook; i++) 
		{
		    if (bookNames[i].equalsIgnoreCase(bookName)) 
		    {
		        numBook++; // Increase the availability of the book
		        System.out.println("Book renewed.");
		        return true;
		    }
		}
		System.out.println("Book not found or cannot be renewed.");
		return false;
	    }
	    
		    // Borrow Book
	    public boolean borrowBook(String bookName, String studentName) 
	    {
		for (int i = 0; i < numBook; i++) 
		{
		    if (bookNames[i].equalsIgnoreCase(bookName)) 
		    {
		        // Assuming borrowed books are not removed from the library's records
		        System.out.println("Book '" + bookName + "' borrowed by " + studentName);
		        return true;
		    }
		}
		System.out.println("Book not found or cannot be borrowed.");
		return false;
	    }
	    
	    
	static int choice;
       static Librarian librarian = new Librarian();

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        boolean exit = false;

      do 
      {
        System.out.println("\n* Library Management System *");
        System.out.println("1. Librarian Login");
        System.out.println("2. Student Login");
        System.out.println("3. Faculty Login");
        System.out.println("4. Exit");

        System.out.print("Enter your choice  : ");
        choice = scan.nextInt();

        
            switch (choice) 
            {
                case 1:
                    Librarian.librarianMenu(scan);
                    break;

                case 2:
                    Student.studentMenu(scan);
                    break;
                
                case 3:
                    Faculty.facultyMenu(scan);
                    break;
                    
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Input..");
            }
        }  while (!exit);

        scan.close();
    }

}

	

class Librarian extends LibraryManagement
{
    static Scanner scan = new Scanner(System.in);
    
    public static void librarianMenu(Scanner scan) 
    {
        int ch
;	

        while (true) {
            //System.out.println("Welcome...");
            System.out.println("\n1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Available Books");
            System.out.println("4. Remove Books");
            System.out.println("5. Renew Book");
            System.out.println("6. Log Out");

            System.out.print("Perform Operation : ");
            ch = scan.nextInt();

            switch (ch) {
                case 1:
                    int index = librarian.addBook(librarian.bookNames, librarian.authorNames);
                    if (index != -1)
                        System.out.println("Book added.");
                    break;

                case 2:
                    // Logic for issuing book
		        System.out.println("Book name: ");
		        String bName = scan.next();
		        System.out.println("Author name: ");
		        String aName = scan.next();
		        System.out.println("Registration number: ");
		        String regNo = scan.next();
		        librarian.issueBook(bName, aName, regNo);
		        
                    break;

                case 3:
                    String[] available = librarian.availableBooks();
                    if (available.length == 0) 
                    {
                        System.out.println("No books available.");
                    } 
                    else 
                    {
                        System.out.println("Available Books:");
                        for (String book : available) 
                        {
                            System.out.println(book);
                        }
                    }
                    break;

                case 4:
                    // Logic for removing books
                    
                    System.out.println("Enter the name of the book to remove:");
                    String bookToRemove = scan.next();
                    librarian.removeBook(bookToRemove);
                    
                    break;

                case 5:
                    // Logic for renewing book
                    System.out.println("Enter the name of the book to renew:");
                    String bookToRenew = scan.next();
                    if (librarian.renewBook(bookToRenew)) 
                    {
                        System.out.println("Book renewed successfully.");
                    } else 
                    {
                        System.out.println("Book not found or cannot be renewed.");
                    }
                    
                    break;

                case 6:
                    System.out.println("Logging out...");
                    return;

                default:
                    System.out.println("Invalid operation...");
            }
        }
    }	
}
class Student extends LibraryManagement
{
	static Scanner scan = new Scanner(System.in);
	
	public static void studentMenu(Scanner scan) {
        int op;

        do {
            //System.out.println("Welcome...");
            System.out.println("\n1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. Available Books");
            System.out.println("4. Log Out");

            System.out.print("Perform Operation : ");
            op = scan.nextInt();

            switch (op) {
                case 1:
                    // Logic for borrowing book
                    System.out.println("Book name: ");
                    String bookToBorrow = scan.next();
                    System.out.println("Enter your name: ");
                    String studentName = scan.next();
                    librarian.borrowBook(bookToBorrow, studentName);
                    break;

                case 2:
                    // Logic for returning book
                    System.out.println("Book name: ");
                    String bookToReturn = scan.next();
                    System.out.println("Enter your name: ");
                    String studentNameReturn = scan.next();
                    // Assuming returning a book doesn't need additional logic, just acknowledging it.
                    System.out.println("Book '" + bookToReturn + "' returned by " + studentNameReturn);
                    
                    break;

                case 3:
                    // Logic for displaying available books
                     String[] available = librarian.availableBooks();
                    if (available.length == 0) 
                    {
                        System.out.println("No books available.");
                    } 
                    else 
                    {
                        System.out.println("Available Books:");
                        for (String book : available) 
                        {
                            System.out.println(book);
                        }
                    }
                    
                    break;

                case 4:
                    System.out.println("Logging out...");
                    break;

                default:
                    System.out.println("Invalid operation...");
            }
        } while (op != 4);
    }
    
	
}
class Faculty extends LibraryManagement
{	
	static Scanner scan = new Scanner(System.in);
	
	public static void facultyMenu(Scanner scan)
    	{
    	int op;

        do {
            //System.out.println("Welcome...");
            System.out.println("\n1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. Available Books");
            System.out.println("4. Log Out");

            System.out.print("Perform Operation : ");
            op = scan.nextInt();

            switch (op) {
                case 1:
                    // Logic for borrowing book
                    System.out.println("Book name: ");
                    String bookToBorrow = scan.next();
                    System.out.println("Enter your name: ");
                    String studentName = scan.next();
                    librarian.borrowBook(bookToBorrow, studentName);
                    break;

                case 2:
                    // Logic for returning book
                    System.out.println("Book name: ");
                    String bookToReturn = scan.next();
                    System.out.println("Enter your name: ");
                    String studentNameReturn = scan.next();
                    // Assuming returning a book doesn't need additional logic, just acknowledging it.
                    System.out.println("Book '" + bookToReturn + "' returned by " + studentNameReturn);
                    
                    break;

                case 3:
                    // Logic for displaying available books
                     String[] available = librarian.availableBooks();
                    if (available.length == 0) 
                    {
                        System.out.println("No books available.");
                    } 
                    else 
                    {
                        System.out.println("Available Books:");
                        for (String book : available) 
                        {
                            System.out.println(book);
                        }
                    }
                    
                    break;

                case 4:
                    System.out.println("Logging out...");
                    break;

                default:
                    System.out.println("Invalid operation...");
            }
        } while (op != 4);
    }
}
