package dao;

import model.BorrowRecord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BorrowDAO {

    public boolean borrowBook(BorrowRecord br) {
        boolean success = false;
        Connection con = DBConnection.getConnection();

        try {
            BookDAO bookDAO = new BookDAO();
            model.Book book = bookDAO.getBookById(br.getBookId());

            if (book == null || book.getAvailableCopies() <= 0) {
                System.out.println("BorrowDAO: No copies available for book ID " + br.getBookId());
                return false;
            }

            String sql = "INSERT INTO borrow_records "
                    + "(book_id, student_name, borrow_date, status) "
                    + "VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, br.getBookId());
                ps.setString(2, br.getStudentName());
                ps.setString(3, LocalDate.now().toString());
                ps.setString(4, "Borrowed");

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    bookDAO.updateAvailableCopies(
                            br.getBookId(),
                            book.getAvailableCopies() - 1
                    );
                    success = true;
                }
            }

        } catch (Exception e) {
            System.err.println("BorrowDAO.borrowBook() error: " + e.getMessage());
            e.printStackTrace();
        }
        return success;
    }

    public boolean returnBook(int recordId) {
        boolean success = false;
        Connection con = DBConnection.getConnection();

        try {
            String findSql = "SELECT book_id FROM borrow_records WHERE record_id = ?";
            int bookId = -1;

            try (PreparedStatement find = con.prepareStatement(findSql)) {
                find.setInt(1, recordId);
                ResultSet rs = find.executeQuery();
                if (rs.next()) {
                    bookId = rs.getInt("book_id");
                }
            }

            if (bookId == -1) return false;

            String updateSql = "UPDATE borrow_records "
                    + "SET status = 'Returned', return_date = ? "
                    + "WHERE record_id = ?";

            try (PreparedStatement ps = con.prepareStatement(updateSql)) {
                ps.setString(1, LocalDate.now().toString());
                ps.setInt(2, recordId);
                int rows = ps.executeUpdate();

                if (rows > 0) {
                    BookDAO bookDAO = new BookDAO();
                    model.Book book = bookDAO.getBookById(bookId);
                    if (book != null) {
                        bookDAO.updateAvailableCopies(
                                bookId,
                                book.getAvailableCopies() + 1
                        );
                    }
                    success = true;
                }
            }

        } catch (Exception e) {
            System.err.println("BorrowDAO.returnBook() error: " + e.getMessage());
            e.printStackTrace();
        }
        return success;
    }

    public List<BorrowRecord> getAllRecords() {
        List<BorrowRecord> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();

        String sql = "SELECT br.*, b.title AS book_title "
                + "FROM borrow_records br "
                + "JOIN books b ON br.book_id = b.book_id "
                + "ORDER BY br.record_id DESC";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                BorrowRecord br = new BorrowRecord();
                br.setRecordId(rs.getInt("record_id"));
                br.setBookId(rs.getInt("book_id"));
                br.setBookTitle(rs.getString("book_title"));
                br.setStudentName(rs.getString("student_name"));
                br.setBorrowDate(rs.getString("borrow_date"));
                br.setReturnDate(rs.getString("return_date"));
                br.setStatus(rs.getString("status"));
                list.add(br);
            }

        } catch (Exception e) {
            System.err.println("BorrowDAO.getAllRecords() error: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public List<BorrowRecord> getActiveRecords() {
        List<BorrowRecord> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();

        String sql = "SELECT br.*, b.title AS book_title "
                + "FROM borrow_records br "
                + "JOIN books b ON br.book_id = b.book_id "
                + "WHERE br.status = 'Borrowed' "
                + "ORDER BY br.borrow_date ASC";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                BorrowRecord br = new BorrowRecord();
                br.setRecordId(rs.getInt("record_id"));
                br.setBookId(rs.getInt("book_id"));
                br.setBookTitle(rs.getString("book_title"));
                br.setStudentName(rs.getString("student_name"));
                br.setBorrowDate(rs.getString("borrow_date"));
                br.setStatus(rs.getString("status"));
                list.add(br);
            }

        } catch (Exception e) {
            System.err.println("BorrowDAO.getActiveRecords() error: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }
}