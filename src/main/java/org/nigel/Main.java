package org.nigel;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Book> LibraryBooks = new ArrayList<>();
    public static ArrayList<Book> AvailableLibraryBooks = new ArrayList<>();

    static void main() {
        Scanner scan = new Scanner(System.in);
        init(); // registers the provided books& Displays menu
        while(true) { // forever run
            System.out.print("Public Library: "); // Give the user a play to type
            String UserArg = scan.nextLine();
            String[] UserArgSplit = UserArg.split(" "); // split users arguments in to arrays
            
            switch(UserArgSplit[0].toLowerCase()) { // get the first array and convert it to lower case to match.
                case "home": // The Store Home Screen -
                    TextMenu();
                    break;
                case "books": // Show Available Books
                    booksCommand(scan);
                    break;
                case "show": // Show Checked Out books
                    showCommand(scan);
                    break;
                case "check": // Check In a book - Prompt the user for the ID of the book they want to check in.
                    CheckInCommand(scan);
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.printf("Provied argument: %s is invalid", UserArgSplit[0]);
            }

        }


    }
    private static void init() {
        // registers books

        Book book = new Book();
        Book bookOne = new Book(1242, "isbn_test", "How did Nigel save the universe", true, "", "Joe");
        Book bookTwo = new Book(1242, "isbn_test", "Nigel need for speed", true, "", "Jimmy");
        Book bookThree = new Book(122542, "isbn_test", "How did Nigel defeat the dragon", false, "Nigel Davey", "Bob");
        Book bookFour = new Book(122542, "isbn_test", "Nigel the magic dude", false, "Nigel Davey", "Nigel the 3rd");
        Book bookFive = new Book(1234, "isbn_001", "Nigel and the Crystal Cavern", true, "Nigel Davey", "Alice");
        Book bookSix = new Book(1235, "isbn_002", "Nigel and the Time Machine", false, "Nigel Davey", "Tom");
        Book bookSeven = new Book(1236, "isbn_003", "Nigel and the Lost City", true, "", "Jerry");
        Book bookEight = new Book(1237, "isbn_004", "Nigel's Galactic Journey", false, "Nigel Davey", "Luna");
        Book bookNine = new Book(1238, "isbn_005", "Nigel the Pirate King", true, "Nigel Davey", "Tim");
        Book bookTen = new Book(1239, "isbn_006", "The Legend of Nigel", true, "", "Sara");
        Book bookEleven = new Book(1240, "isbn_007", "Nigel and the Forbidden Forest", false, "Nigel Davey", "Emma");
        Book bookTwelve = new Book(1241, "isbn_008", "Nigel: Master of Shadows", true, "Nigel Davey", "Liam");
        Book bookThirteen = new Book(1243, "isbn_009", "Nigel and the Phoenix Flame", false, "Jimmy Hendrix", "Olivia");
        Book bookFourteen = new Book(1244, "isbn_010", "Nigel the Hacker", true, "", "Noah");
        Book bookFifteen = new Book(1245, "isbn_011", "Nigel in the Parallel World", true, "Brue Lee", "Mia");
        Book bookSixteen = new Book(1246, "isbn_012", "The Return of Nigel", false, "Nigel Davey", "Ava");
        Book bookSeventeen = new Book(1247, "isbn_013", "Nigel's Final Quest", true, "Nigel Davey", "Lucas");
        Book bookEighteen = new Book(1248, "isbn_014", "The Rise of Nigel", true, "Nigel Davey", "Isabella");
        Book bookNineteen = new Book(1249, "isbn_015", "Nigel and the Quantum Code", false, "Nigel Davey", "Ethan");
        Book bookTwenty = new Book(1250, "isbn_016", "Nigel and the Eternal Flame", true, "Nigel Davey", "Sophia");

        LibraryBooks.add(bookOne);
        LibraryBooks.add(bookTwo);
        LibraryBooks.add(bookThree);
        LibraryBooks.add(bookFour);
        LibraryBooks.add(bookFive);
        LibraryBooks.add(bookSix);
        LibraryBooks.add(bookSeven);
        LibraryBooks.add(bookEight);
        LibraryBooks.add(bookNine);
        LibraryBooks.add(bookTen);
        LibraryBooks.add(bookEleven);
        LibraryBooks.add(bookTwelve);
        LibraryBooks.add(bookThirteen);
        LibraryBooks.add(bookFourteen);
        LibraryBooks.add(bookFifteen);
        LibraryBooks.add(bookSixteen);
        LibraryBooks.add(bookSeventeen);
        LibraryBooks.add(bookEighteen);
        LibraryBooks.add(bookNineteen);
        LibraryBooks.add(bookTwenty);
        // you can also register books by doing
        // LibaryBooks.add(new Book(1250, "isbn_016", "Nigel and the Eternal Flame", true, "Nigel Davey", "Sophia"))

        book.setLibary(LibraryBooks); // register library
        TextMenu();
    }
    private static void TextMenu() {
        System.out.println("====Public Library====");
        System.out.println("\tHome - displays this menu");
        System.out.println("\tbooks - displays available books");
        System.out.println("\tshow - checked out books");
        System.out.println("\tcheck - check in a checked out book.");
        System.out.println("==== By Nigel Davey ====");
        System.out.println();
    }
    private static Book ArrayTest(ArrayList<Book> Arr, int ChosenIndex) { // this function returns a book so you can start an preview at 1. wtv, 2.test_two | instead of starting at 0
        // Helps select a book from a List.
        return Arr.get(ChosenIndex - 1);
    }
    private static void booksCommand(Scanner scan) {
        System.out.println();
        System.out.println("===Available Books===");
        for (int i = 0; i < LibraryBooks.size(); i++) {
            if(LibraryBooks.get(i).getCheckedOut() == false) {
                System.out.printf("Id: %d | Title: %s | ISBN: %s\n", LibraryBooks.get(i).getId(), LibraryBooks.get(i).getTitle(), LibraryBooks.get(i).getIsbn());
            }
        }
        System.out.println();
        System.out.println("Do you wish to check out a book [y/n]: ");
        String CheckOutOptionBooks = scan.nextLine();
        if(CheckOutOptionBooks.equalsIgnoreCase("y") || CheckOutOptionBooks.equalsIgnoreCase("yes")) {
            System.out.println("Select the index number.");
            int index = 1;
            for (int i = 0; i < LibraryBooks.size(); i++) {
                if(LibraryBooks.get(i).getCheckedOut() == false) {
                    System.out.printf("Index: %d |Id: %d | Title: %s | ISBN: %s\n", index, LibraryBooks.get(i).getId(), LibraryBooks.get(i).getTitle(), LibraryBooks.get(i).getIsbn());
                    index++;
                    AvailableLibraryBooks.add(LibraryBooks.get(i));
                }
            }

            String IndexChoice = scan.nextLine();
            Book IndexSelected = ArrayTest(AvailableLibraryBooks, Integer.parseInt(IndexChoice));
            System.out.printf("You have selected: %s by %s. The ISBN is: %s\n", IndexSelected.getTitle(), IndexSelected.getAuthor(), IndexSelected.getIsbn());

            System.out.println("What is your name? ");
            System.out.print("My name is: ");
            String CheckOutName = scan.nextLine();
            IndexSelected.checkOut(CheckOutName);

            System.out.printf("Successfully checked out: %s by %s to %s\n", IndexSelected.getTitle(), IndexSelected.getAuthor(), CheckOutName);
            AvailableLibraryBooks.clear(); // remove for next result

        }

    }
    private static void showCommand(Scanner scan) {
        System.out.println();
        System.out.println("===Checked-out Books===");
        for (int i = 0; i < LibraryBooks.size(); i++) {
            if(LibraryBooks.get(i).getCheckedOut() == true) {
                System.out.printf("Id: %d | Title: %s | ISBN: %s | Checked out by: %s \n", LibraryBooks.get(i).getId(), LibraryBooks.get(i).getTitle(), LibraryBooks.get(i).getIsbn(), LibraryBooks.get(i).getCheckedOutTo());
            }
        }
        System.out.println();
        System.out.println("===Checked-out Command Options===");
        System.out.println("\tc - Check in a book");
        System.out.println("\tx - go back to menu.");
        System.out.print("Library Command Option: ");
        String OptionToDoNext = scan.nextLine();
        if(OptionToDoNext.equalsIgnoreCase("c")) {
            CheckInCommand(scan);
        } else if(OptionToDoNext.equalsIgnoreCase("x")) {
            main();
        }
        System.out.println();
    }
    
    private static void CheckInCommand(Scanner scan) {
        String UserName = scan.nextLine();
        boolean HasBooks = false;

        System.out.println();
        System.out.println("===Checked-in Books===");
        System.out.println("Whats your name? ");
        System.out.print("My name is: ");
        
        for (int i = 0; i < LibraryBooks.size(); i++) {
            if(LibraryBooks.get(i).getCheckedOutTo().equalsIgnoreCase(UserName)) {
                System.out.printf("Id: %d | Title: %s | ISBN: %s | Checked out by: %s \n", LibraryBooks.get(i).getId(), LibraryBooks.get(i).getTitle(), LibraryBooks.get(i).getIsbn(), LibraryBooks.get(i).getCheckedOutTo());
                HasBooks = true;
                AvailableLibraryBooks.add(LibraryBooks.get(i));
            }
        }
        
        if(!HasBooks) {
            System.out.println("You do not have any books checked out.");
            main();
        } else {
            Book bookData = new Book();
            
            System.out.println("Type in the ISBN you want to check in.");
            String IsbnSelected = scan.nextLine();
            
            for (int i = 0; i < AvailableLibraryBooks.size(); i++) {
                if(AvailableLibraryBooks.get(i).getIsbn().equals(IsbnSelected.strip())) {
                    bookISBN = AvailableLibraryBooks.get(i);
                }
            }
            bookData.checkIn();
            System.out.printf("Successfully checked in %s by %s | ISBN: %s", bookData.getTitle(), bookData.getAuthor(), bookData.getIsbn());
            AvailableLibraryBooks.clear(); // remove data for next use.
        }
    }
}
