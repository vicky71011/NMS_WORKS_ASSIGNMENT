package model;

public class Visitor {

    private int    visitorId;
    private String studentName;
    private String visitorName;
    private String visitTime;
    private String approvalStatus;


    public int getVisitorId()                      { return visitorId; }
    public void setVisitorId(int visitorId)        { this.visitorId = visitorId; }

    public String getStudentName()                 { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getVisitorName()                 { return visitorName; }
    public void setVisitorName(String visitorName) { this.visitorName = visitorName; }

    public String getVisitTime()                   { return visitTime; }
    public void setVisitTime(String visitTime)     { this.visitTime = visitTime; }

    public String getApprovalStatus()              { return approvalStatus; }
    public void setApprovalStatus(String s)        { this.approvalStatus = s; }
}
