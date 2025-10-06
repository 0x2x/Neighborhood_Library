package org.nigel;

import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {
    public static ArrayList<BookTest> LibraryBooks = new ArrayList<>();
    public static ArrayList<BookTest> AvailableLibraryBooks = new ArrayList<>();

    static void main() {
        Scanner scan = new Scanner(System.in);
        init();
        while(true) {
            System.out.print("Public Library: ");
            String UserArg = scan.nextLine();
            String[] UserArgSplit = UserArg.split(" ");
            switch(UserArgSplit[0].toLowerCase()) {
                case "home": // The Store Home Screen -
                    TextMenu();
                    break;
                case "books": // Show Available Books
                    booksCommand(scan);
                    break;
                case "show":
                    showCommand(scan);
                    break;
                case "check":
                    break;
            }

        }


    }
    private static void init() {
        // registers books

        BookTest book = new BookTest();
        BookTest bookOne = new BookTest(1242, "isbn_test", "how did Nigel save the universe", true, "Nigel Davey", "Joe");
        BookTest bookTwo = new BookTest(1242, "isbn_test", "Nigel need for speed", true, "Nigel Davey", "Jimmy");
        BookTest bookThree = new BookTest(122542, "isbn_test", "How did Nigel defeat the dragon", false, "Nigel Davey", "Bob");
        BookTest bookFour = new BookTest(122542, "isbn_test", "Nigel the magic dude", false, "Nigel Davey", "Nigel the 3rd");

        LibraryBooks.add(bookOne);
        LibraryBooks.add(bookTwo);
        LibraryBooks.add(bookThree);
        LibraryBooks.add(bookFour);
        book.setLibary(LibraryBooks); // register library

        System.out.printf(String.valueOf(book.getLibary()));
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
    private static BookTest ArrayTest(ArrayList<BookTest> Arr, int ChosenIndex) {
        return Arr.get(ChosenIndex - 1);
    }

    private static void booksCommand(Scanner scan) {
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
            BookTest IndexSelected = ArrayTest(AvailableLibraryBooks, Integer.parseInt(IndexChoice));
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
        System.out.println("===Checked-out Books===");
        for (int i = 0; i < LibraryBooks.size(); i++) {
            if(LibraryBooks.get(i).getCheckedOut() == true) {
                System.out.printf("Id: %d | Title: %s | ISBN: %s | Checked out by: %s \n", LibraryBooks.get(i).getId(), LibraryBooks.get(i).getTitle(), LibraryBooks.get(i).getIsbn(), LibraryBooks.get(i).getCheckedOutTo());
            }
        }
        System.out.println();
    }
}
