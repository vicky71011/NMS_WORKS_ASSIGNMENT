package model;

public class Complaint {

    private int    complaintId;
    private String studentName;
    private String roomNo;
    private String complaintType;
    private String description;
    private String status;

    public int getComplaintId()                   { return complaintId; }
    public void setComplaintId(int complaintId)   { this.complaintId = complaintId; }

    public String getStudentName()                { return studentName; }
    public void setStudentName(String studentName){ this.studentName = studentName; }

    public String getRoomNo()                     { return roomNo; }
    public void setRoomNo(String roomNo)          { this.roomNo = roomNo; }

    public String getComplaintType()              { return complaintType; }
    public void setComplaintType(String t)        { this.complaintType = t; }

    public String getDescription()                { return description; }
    public void setDescription(String description){ this.description = description; }

    public String getStatus()                     { return status; }
    public void setStatus(String status)          { this.status = status; }
}
