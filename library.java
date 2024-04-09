import java.util.*;

class Librarian
{
    public String[] bookNames = new String[500];
    public String[] authorNames = new String[500];
    public int numBook = 20;

    public int addBook(String[] bookNames, String[] authorNames) 
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter book name:");
        String bookName = scan.nextLine();

        System.out.println("Enter author name:");
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
		System.out.println("Sorry the book is not available");
		return false;
	    }
	}

	public boolean isBookAvail(int numBook) 
	{
	    return numBook != 0;
	}
}

class LibraryManagement extends Librarian 
{
    static int choice;
    static Librarian librarian = new Librarian();

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        System.out.println("* Library Management System *");
        System.out.println("1. Librarian Login");
        System.out.println("2. Student Login");

        System.out.print("Enter your choice  : ");
        choice = scan.nextInt();

        do {
            switch (choice) 
            {
                case 1:
                    librarianMenu(scan);
                    break;

                case 2:
                    studentMenu(scan);
                    break;

                default:
                    System.out.println("Invalid Input..");
            }
        } while (choice != 3);

        scan.close();
    }

    public static void librarianMenu(Scanner scan) 
    {
        int ch;

        while (true) 
        {
            System.out.println("Welcome...");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Available Books");
            System.out.println("4. Remove Books");
            System.out.println("5. Renew Book");
            System.out.println("6. Log Out");

            System.out.print("Perform Operation : ");
            ch = scan.nextInt();

            switch (ch) 
            {
                case 1:
                    int index = librarian.addBook(librarian.bookNames, librarian.authorNames);
                    if (index != -1)
                        System.out.println("Book added successfully.");
                    break;

                case 2:
                    // Logic for issuing book
		        System.out.println("Enter the book name: ");
		        String bName = scan.next();
		        System.out.println("Enter the author name: ");
		        String aName = scan.next();
		        System.out.println("Enter the registration number: ");
		        String regNo = scan.next();
		        librarian.issueBook(bName, aName, regNo);
		        
                    break;

                case 3:
                    // Logic for displaying available books
                    break;

                case 4:
                    // Logic for removing books
                    break;

                case 5:
                    // Logic for renewing book
                    break;

                case 6:
                    System.out.println("Logging out...");
                    return;

                default:
                    System.out.println("Invalid operation...");
            }
        }
    }

    public static void studentMenu(Scanner scan) 
    {
        int op;

        do 
        {
            System.out.println("Welcome...");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. Available Books");
            System.out.println("4. Log Out");

            System.out.print("Perform Operation : ");
            op = scan.nextInt();
            
            switch (op) 
            {
                case 1:
                    // Logic for borrowing book
                    break;

                case 2:
                    // Logic for returning book
                    break;

                case 3:
                    // Logic for displaying available books
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


