package dao;

import model.Visitor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VisitorDAO {

    public boolean addVisitor(Visitor v) {
        boolean success = false;
        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO visitors "
                   + "(student_name, visitor_name, visit_time, approval_status) "
                   + "VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, v.getStudentName());
            ps.setString(2, v.getVisitorName());
            ps.setString(3, v.getVisitTime());
            ps.setString(4, "Pending");

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }

        } catch (Exception e) {
            System.err.println("VisitorDAO.addVisitor() failed: " + e.getMessage());
            e.printStackTrace();
        }

        return success;
    }

    public boolean updateVisitorStatus(int id) {
        boolean success = false;
        Connection con = DBConnection.getConnection();

        String sql = "UPDATE visitors SET approval_status = 'Approved' WHERE visitor_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }

        } catch (Exception e) {
            System.err.println("VisitorDAO.updateVisitorStatus() failed: " + e.getMessage());
            e.printStackTrace();
        }

        return success;
    }

    public List<Visitor> getAllVisitors() {
        List<Visitor> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM visitors ORDER BY visitor_id DESC";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Visitor v = new Visitor();
                v.setVisitorId(rs.getInt("visitor_id"));
                v.setStudentName(rs.getString("student_name"));
                v.setVisitorName(rs.getString("visitor_name"));
                v.setVisitTime(rs.getString("visit_time"));
                v.setApprovalStatus(rs.getString("approval_status"));
                list.add(v);
            }

        } catch (Exception e) {
            System.err.println("VisitorDAO.getAllVisitors() failed: " + e.getMessage());
            e.printStackTrace();
        }

        return list;
    }
}
