package com.example.library.service;

import com.example.library.models.Book;
import com.example.library.models.BorrowRecord;
import com.example.library.models.Patron;
import com.example.library.util.FileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryService {

    private final List<Book> books = new ArrayList<>();
    private final List<Patron> patrons = new ArrayList<>();
    private final List<BorrowRecord> borrowRecords = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public void borrowBook(String patronId, String isbn) {
            Patron patron = findPatronById(patronId);
            Book book = findBookByIsbn(isbn);

            if (patron != null && book != null) {
                BorrowRecord record = new BorrowRecord(patron, book, java.time.LocalDate.now());
                borrowRecords.add(record);
                System.out.println("Book borrowed successfully.");
            } else {
                System.out.println("Book or Patron not found.");
            }
        }

    public void returnBook(String isbn) {
        BorrowRecord record = findBorrowRecordByIsbn(isbn);
        if (record != null) {
            record.setReturnDate(java.time.LocalDate.now());
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Record not found.");
        }
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            boolean isBorrowed = borrowRecords.stream()
                    .anyMatch(record -> record.getBook().equals(book) && record.getReturnDate() == null);
            if (!isBorrowed) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    private Patron findPatronById(String id) {
        return patrons.stream().filter(patron -> patron.getId().equals(id)).findFirst().orElse(null);
    }

    private Book findBookByIsbn(String isbn) {
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().orElse(null);
    }

    private BorrowRecord findBorrowRecordByIsbn(String isbn) {
        return borrowRecords.stream().filter(record -> record.getBook().getIsbn().equals(isbn) && record.getReturnDate() == null).findFirst().orElse(null);
    }

    public List<BorrowRecord> getBorrowRecords() {
        return borrowRecords;
    }
}
