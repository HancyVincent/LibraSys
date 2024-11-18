# Library Management System

## Description
The **Library Management System** is a console-based application developed in Java. It allows users to manage books, patrons, and borrow records for a simple library system. The system supports functionality such as adding books, registering patrons, borrowing books, returning books, and viewing available books.

### Features:
- Add books to the library.
- Register new patrons.
- Borrow books by patrons.
- Return borrowed books.
- View available books.

## Project Structure
```
LibraryManagementSystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── library/
│   │   │               ├── model/
│   │   │               │   ├── Book.java
│   │   │               │   ├── Patron.java
│   │   │               │   └── BorrowRecord.java
│   │   │               ├── service/
│   │   │               │    └── LibraryService.java
│   │   │               ├── util/
│   │   │               │   ├── FileHandler.java
│   │   │               └── Main.java
│   └── resources/
│       ├── books.txt
│       ├── patrons.txt
│       └── records.txt
├── README.md
└── pom.xml (or build.gradle)
```

### `src/main/java/com/example/library`
Contains the main application logic:
- **`model/`**: Contains the data models `Book`, `Patron`, and `BorrowRecord`.
- **`service/`**: Contains `LibraryService`, which implements the library functionalities.
- **`util/`**: Contains utility classes like `FileHandler` for reading and writing data files.

### `src/main/resources`
Contains text files that store books, patrons, and borrowing records:
- **`books.txt`**: Contains the list of books with title, author, and ISBN.
- **`patrons.txt`**: Contains the list of patrons with name and ID.
- **`records.txt`**: Contains the borrowing records of patrons with book ISBN and borrow/return dates.

## Setup & Installation

### Prerequisites:
1. Java 8 or higher installed.
2. A text editor or IDE (e.g., IntelliJ IDEA, Eclipse) for working with Java.
3. Maven or Gradle for dependency management (optional for advanced build).

### Steps:
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/LibraryManagementSystem.git
   cd LibraryManagementSystem
2. (Optional) If using Maven, build the project:

    ```bash
    mvn clean install
    ```
3.  Open the Main.java file in your IDE and run the application.

4.  You can modify the books.txt, patrons.txt, and records.txt files in the resources/ directory to test different inputs.

### Usage
When the program is running, you will be prompted with a menu of operations:

1.  Add a new book.
2.  Register a new patron. 
3. Borrow a book. 
4. Return a book. 
5. View available books. 
6. Exit and save the current records.
#### Example Interaction:
```bash
Library Management System
1. Add Book
2. Register Patron
3. Borrow Book
4. Return Book
5. View Available Books
6. Exit

Enter your choice: 1
Enter book title: The Great Gatsby
Enter book author: F. Scott Fitzgerald
Enter book ISBN: 9780743273565

Book added.
```
### Dependencies
Java 8 or higher for compiling and running the project.
Maven/Gradle for managing dependencies and build automation.

### License
This project is open source and available under the MIT License.

### Contributing
1.  Fork the repository.
2.  Create a new branch (` git checkout -b feature-name`).
3.  Make your changes.
4.  Commit your changes (`git commit -am 'Add new feature'`).
5.  Push to the branch (`git push origin feature-name`).
6.  Open a pull request.


### Instructions:
- You can copy and paste the above content into your `README.md` file.
- Update the repository URL (in the `git clone` command) to match your project's location if it's hosted on GitHub or any other platform.
- Feel free to modify and expand it based on further features or changes in your project.

Let me know if you need any further modifications!
