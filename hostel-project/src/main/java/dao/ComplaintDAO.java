package dao;

import model.Complaint;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ComplaintDAO {

    public boolean addComplaint(Complaint c) {
        boolean success = false;

        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO complaints "
                   + "(student_name, room_no, complaint_type, description, status) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getStudentName());
            ps.setString(2, c.getRoomNo());
            ps.setString(3, c.getComplaintType());
            ps.setString(4, c.getDescription());
            ps.setString(5, "Pending");

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }

        } catch (Exception e) {
            System.err.println("ComplaintDAO.addComplaint() failed: " + e.getMessage());
            e.printStackTrace();
        }

        return success;
    }

    public boolean updateComplaintStatus(int id) {
        boolean success = false;
        Connection con = DBConnection.getConnection();

        String sql = "UPDATE complaints SET status = 'Resolved' WHERE complaint_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }

        } catch (Exception e) {
            System.err.println("ComplaintDAO.updateComplaintStatus() failed: " + e.getMessage());
            e.printStackTrace();
        }

        return success;
    }

    public List<Complaint> getAllComplaints() {
        List<Complaint> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM complaints ORDER BY complaint_id DESC";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Complaint c = new Complaint();
                c.setComplaintId(rs.getInt("complaint_id"));
                c.setStudentName(rs.getString("student_name"));
                c.setRoomNo(rs.getString("room_no"));
                c.setComplaintType(rs.getString("complaint_type"));
                c.setDescription(rs.getString("description"));
                c.setStatus(rs.getString("status"));
                list.add(c);
            }

        } catch (Exception e) {
            System.err.println("ComplaintDAO.getAllComplaints() failed: " + e.getMessage());
            e.printStackTrace();
        }

        return list;
    }
}
