package dao;

import model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public boolean addBook(Book b) {
        boolean success = false;
        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO books (title, author, genre, total_copies, available_copies, status) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, b.getTitle());
            ps.setString(2, b.getAuthor());
            ps.setString(3, b.getGenre());
            ps.setInt(4, b.getTotalCopies());
            ps.setInt(5, b.getTotalCopies());
            ps.setString(6, "Available");

            int rows = ps.executeUpdate();
            if (rows > 0) success = true;

        } catch (Exception e) {
            System.err.println("BookDAO.addBook() error: " + e.getMessage());
            e.printStackTrace();
        }
        return success;
    }

    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM books ORDER BY book_id DESC";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Book b = new Book();
                b.setBookId(rs.getInt("book_id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setGenre(rs.getString("genre"));
                b.setTotalCopies(rs.getInt("total_copies"));
                b.setAvailableCopies(rs.getInt("available_copies"));
                b.setStatus(rs.getString("status"));
                list.add(b);
            }

        } catch (Exception e) {
            System.err.println("BookDAO.getAllBooks() error: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public Book getBookById(int id) {
        Book b = null;
        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM books WHERE book_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                b = new Book();
                b.setBookId(rs.getInt("book_id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setGenre(rs.getString("genre"));
                b.setTotalCopies(rs.getInt("total_copies"));
                b.setAvailableCopies(rs.getInt("available_copies"));
                b.setStatus(rs.getString("status"));
            }

        } catch (Exception e) {
            System.err.println("BookDAO.getBookById() error: " + e.getMessage());
            e.printStackTrace();
        }
        return b;
    }

    public void updateAvailableCopies(int bookId, int availableCopies) {
        Connection con = DBConnection.getConnection();

        String newStatus = (availableCopies <= 0) ? "Out of Stock" : "Available";

        String sql = "UPDATE books SET available_copies = ?, status = ? WHERE book_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, availableCopies);
            ps.setString(2, newStatus);
            ps.setInt(3, bookId);
            ps.executeUpdate();

        } catch (Exception e) {
            System.err.println("BookDAO.updateAvailableCopies() error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean deleteBook(int id) {
        boolean success = false;
        Connection con = DBConnection.getConnection();

        String sql = "DELETE FROM books WHERE book_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) success = true;

        } catch (Exception e) {
            System.err.println("BookDAO.deleteBook() error: " + e.getMessage());
            e.printStackTrace();
        }
        return success;
    }
}