package com.example.library;

import com.example.library.models.Book;
import com.example.library.models.BorrowRecord;
import com.example.library.models.Patron;
import com.example.library.service.LibraryService;
import com.example.library.util.FileHandler;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        Scanner scanner = new Scanner(System.in);

        loadData(libraryService);

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    addBook(libraryService, scanner);
                    break;
                case 2:
                    registerPatron(libraryService, scanner);
                    break;
                case 3:
                    borrowBook(libraryService, scanner);
                    break;
                case 4:
                    returnBook(libraryService, scanner);
                    break;
                case 5:
                    viewAvailableBooks(libraryService);
                    break;
                case 6:
                    saveData(libraryService);
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Library Management System.");
    }

    private static void displayMenu() {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add Book");
        System.out.println("2. Register Patron");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. View Available Books");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume invalid input
        }
        return scanner.nextInt();
    }

    private static void loadData(LibraryService libraryService) {
        try {
            List<Book> books = FileHandler.loadBooks("src/main/resources/books.txt");
            books.forEach(libraryService::addBook);

        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

    private static void addBook(LibraryService libraryService, Scanner scanner) {
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();

        libraryService.addBook(new Book(title, author, isbn));
        System.out.println("Book added successfully.");
    }

    private static void registerPatron(LibraryService libraryService, Scanner scanner) {
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter patron name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patron ID: ");
        String id = scanner.nextLine();

        libraryService.registerPatron(new Patron(name, id));
        System.out.println("Patron registered successfully.");
    }

    private static void borrowBook(LibraryService libraryService, Scanner scanner) {
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter patron ID: ");
        String patronId = scanner.nextLine();
        System.out.print("Enter ISBN of the book to borrow: ");
        String isbn = scanner.nextLine();

        libraryService.borrowBook(patronId, isbn);
    }

    private static void returnBook(LibraryService libraryService, Scanner scanner) {
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter ISBN of the book to return: ");
        String isbn = scanner.nextLine();

        libraryService.returnBook(isbn);
    }

    private static void viewAvailableBooks(LibraryService libraryService) {
        List<Book> books = libraryService.getAvailableBooks();
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private static void saveData(LibraryService libraryService) {
        try {
            FileHandler.saveRecords(libraryService.getBorrowRecords(), "src/main/resources/records.txt");
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }
}
