package model;

public class BorrowRecord {

    private int recordId;
    private int bookId;
    private String bookTitle;
    private String studentName;
    private String borrowDate;
    private String returnDate;
    private String status;

    public int getRecordId() { return recordId; }
    public int getBookId() { return bookId; }
    public String getBookTitle() { return bookTitle; }
    public String getStudentName() { return studentName; }
    public String getBorrowDate() { return borrowDate; }
    public String getReturnDate() { return returnDate; }
    public String getStatus() { return status; }

    public void setRecordId(int recordId) { this.recordId = recordId; }
    public void setBookId(int bookId) { this.bookId = bookId; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public void setBorrowDate(String borrowDate) { this.borrowDate = borrowDate; }
    public void setReturnDate(String returnDate) { this.returnDate = returnDate; }
    public void setStatus(String status) { this.status = status; }
}