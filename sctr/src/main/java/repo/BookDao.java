package repo;

import lombok.SneakyThrows;
import model.Book;
import repo.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class BookDao {

    private static final String SAVE_BOOK_SQL = "INSERT INTO books VALUES (?, ?, ?, ?, ?)";
    private static final String GET_ALL_BOOKS = "SELECT * FROM books";
    private static final String GET_BOOK_BY_ID = "SELECT * FROM books WHERE id = ?";
    private static final String DELETE_BOOK_BY_ID = "DELETE FROM books WHERE id = ?";
    private static final String UPDATE_BOOK_BY_ID = "UPDATE books SET name = ?, author = ?, price = ?, quantity=? WHERE id = ?";

    @SneakyThrows
    public void saveBook(Book book) {
        Connection con = DBConnection.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(SAVE_BOOK_SQL);
        preparedStatement.setLong(1, book.getId());
        preparedStatement.setString(2, book.getName());
        preparedStatement.setString(3, book.getAuthor());
        preparedStatement.setDouble(4, book.getPrice());
        preparedStatement.setInt(5, book.getQuantity());
        preparedStatement.execute();
        con.close();
    }




    @SneakyThrows
    public List<Book> getBooks() {
        Connection con = DBConnection.getConnection();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_ALL_BOOKS);
        List<Book> books = new LinkedList<>();
        while (resultSet.next()) {
            long id = resultSet.getLong(1);
            String name = resultSet.getString(2);
            String author = resultSet.getString(3);
            double price = resultSet.getDouble(4);
            int quantity = resultSet.getInt(5);
            Book book = new Book(id, name, author, price, quantity);
            books.add(book);
        }
        con.close();
        return books;
    }

    @SneakyThrows
    public Book getBookById(long bookId) {
        Connection con = DBConnection.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(GET_BOOK_BY_ID);
        preparedStatement.setLong(1, bookId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Book book = new Book(-1, "", "", 0, 0);
        if (resultSet.next()) {
            long id = resultSet.getLong(1);
            String name = resultSet.getString(2);
            String author = resultSet.getString(3);
            double price = resultSet.getDouble(4);
            int quantity = resultSet.getInt(5);
            book = new Book(id, name, author, price, quantity);
        }
        con.close();
        return book;
    }

    @SneakyThrows
    public void deleteBook(long bookId) {
        Connection con = DBConnection.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(DELETE_BOOK_BY_ID);
        preparedStatement.setLong(1, bookId);
        preparedStatement.execute();
    }




    @SneakyThrows
    public void updateBook(Book book) {
        Connection con = DBConnection.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(UPDATE_BOOK_BY_ID);
        preparedStatement.setString(1, book.getName());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setDouble(3, book.getPrice());
        preparedStatement.setInt(4, book.getQuantity());
        preparedStatement.setLong(5, book.getId());
        preparedStatement.execute();
        con.close();
    }
}
