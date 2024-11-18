package com.example.library.models;
import java.time.LocalDate;
import java.util.Objects;

public class BorrowRecord {
    private final Patron patron;
    private final Book book;
    private final LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowRecord(Patron patron, Book book, LocalDate borrowDate) {
        this.patron = patron;
        this.book = book;
        this.borrowDate = borrowDate;
    }

    public Patron getPatron() {
        return patron;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return String.format("BorrowRecord [Patron: %s, Book: %s, Borrowed: %s, Returned: %s]",
                patron.getName(), book.getTitle(), borrowDate, returnDate != null ? returnDate : "Not Returned");
    }
}
