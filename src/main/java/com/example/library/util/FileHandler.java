package com.example.library.util;

import com.example.library.models.Book;
import com.example.library.models.BorrowRecord;
import com.example.library.models.Patron;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private FileHandler() {
        // Prevent instantiation
    }

    public static List<Book> loadBooks(String filePath) throws IOException {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    books.add(new Book(parts[0].trim(), parts[1].trim(), parts[2].trim()));
                }
            }
        }
        return books;
    }

    public static List<BorrowRecord> loadRecords(String filePath) throws IOException {
        List<BorrowRecord> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    // Parse dates properly
                    records.add(new BorrowRecord(new Patron(parts[0], null), new Book(null, null, parts[1]), java.time.LocalDate.parse(parts[2])));
                }
            }
        }
        return records;
    }

    public static void saveRecords(List<BorrowRecord> records, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (BorrowRecord record : records) {
                writer.write(record.toString());
                writer.newLine();
            }
        }
    }
}
