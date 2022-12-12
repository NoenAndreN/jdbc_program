package control;

import model.Book;
import repo.BookDao;

import java.util.List;
import java.util.Scanner;

public class BookControlledCMD {
    private final BookDao bookDao = new BookDao();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean notExit = true;
        while (notExit) {
            printMenu();
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    addBook();
                    break;
                case 2:
                    getBook();
                    break;
                case 3:
                    getAllBooks();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    updateBook();
                    break;
                case 6:
                default:
                    notExit = false;
                    break;
            }
        }
    }


    private void printMenu() {
        System.out.println("--- Choose Option ---");
        System.out.println("1. Add book");
        System.out.println("2. Get book");
        System.out.println("3. Get all book");
        System.out.println("4. Delete book");
        System.out.println("5. Update book");
        System.out.println("6. Exit");
    }

    private void addBook() {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Enter book id");
        book.setId(scanner.nextLong());
        System.out.println("Enter the name of book:");
        String name = scanner.nextLine();
        name = scanner.nextLine();
        book.setName(name);
        System.out.println("Enter author:");
        String author = scanner.nextLine();
        book.setAuthor(author);
        System.out.println("Enter price:");
        book.setPrice(scanner.nextDouble());
        System.out.println("Enter quantity:");
        book.setQuantity(scanner.nextInt());
        bookDao.saveBook(book);
    }

    private void getBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book id:");
        Book bookById = bookDao.getBookById(scanner.nextLong());
        System.out.println(bookById);
        System.out.println();
    }

    private void getAllBooks() {
        List<Book> books = bookDao.getBooks();
        System.out.println("Here's the all books:");
        books.forEach(System.out::println);
        System.out.println();
    }

    private void deleteBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id of the book:");
        bookDao.deleteBook(scanner.nextLong());
    }

    private void updateBook() {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Enter id:");
        book.setId(scanner.nextLong());
        System.out.println("Enter new name:");
        String name = scanner.next();
        book.setName(name);
        System.out.println("Enter author:");
        String author = scanner.next();
        book.setAuthor(author);
        System.out.println("Enter new price:");
        book.setPrice(scanner.nextInt());
        System.out.println("Enter new quantity:");
        book.setQuantity(scanner.nextInt());
        bookDao.updateBook(book);
    }

}
