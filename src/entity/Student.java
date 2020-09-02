package entity;

import java.sql.Date;

public class Student extends Person implements SuperEntity {

    private String stdId;
    private String nic;
    private String branchId;
    private String courseId;
    private Date dateOfJoined;
    private String examId;
    private String trialId;
    private String trainingId;
    private String lecId;

    public Student() {
    }

    public Student(String stdId, String nic, String branchId, String courseId, Date dateOfJoined, String examId, String trialId, String trainingId, String lecId) {
        this.stdId = stdId;
        this.nic = nic;
        this.branchId = branchId;
        this.courseId = courseId;
        this.dateOfJoined = dateOfJoined;
        this.examId = examId;
        this.trialId = trialId;
        this.trainingId = trainingId;
        this.lecId = lecId;
    }

    public Student(String NIC, String name, String DOB, String age, String gender, Person_Contact person_contact, String stdId, String nic, String branchId, String courseId, Date dateOfJoined, String examId, String trialId, String trainingId, String lecId) {
        super(NIC, name, DOB, age, gender, person_contact);
        this.stdId = stdId;
        this.nic = nic;
        this.branchId = branchId;
        this.courseId = courseId;
        this.dateOfJoined = dateOfJoined;
        this.examId = examId;
        this.trialId = trialId;
        this.trainingId = trainingId;
        this.lecId = lecId;
    }

    public Student(String NIC, String name, String DOB, String age, String gender,  String address, String mob, String phone, String email, String stdId, String nic, String branchId, String courseId, Date dateOfJoined, String examId, String trialId, String trainingId, String lecId) {
        super(NIC, name, DOB, age, gender, address, mob, phone, email);
        this.stdId = stdId;
        this.nic = nic;
        this.branchId = branchId;
        this.courseId = courseId;
        this.dateOfJoined = dateOfJoined;
        this.examId = examId;
        this.trialId = trialId;
        this.trainingId = trainingId;
        this.lecId = lecId;
    }

    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Date getDateOfJoined() {
        return dateOfJoined;
    }

    public void setDateOfJoined(Date dateOfJoined) {
        this.dateOfJoined = dateOfJoined;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getTrialId() {
        return trialId;
    }

    public void setTrialId(String trialId) {
        this.trialId = trialId;
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        this.trainingId = trainingId;
    }

    public String getLecId() {
        return lecId;
    }

    public void setLecId(String lecId) {
        this.lecId = lecId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stdId='" + stdId + '\'' +
                ", nic='" + nic + '\'' +
                ", branchId='" + branchId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", dateOfJoined=" + dateOfJoined +
                ", examId='" + examId + '\'' +
                ", trialId='" + trialId + '\'' +
                ", trainingId='" + trainingId + '\'' +
                ", lecId='" + lecId + '\'' +
                '}';
    }
}
