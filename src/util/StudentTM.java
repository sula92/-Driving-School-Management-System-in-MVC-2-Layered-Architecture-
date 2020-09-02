package util;

import javafx.scene.control.Button;

import java.util.Date;

public class StudentTM {

    private String stdId;
    private String name;
    private String nic;
    private String branch;
    private String courseId;
    private Date doj;
    private String contact;
    private Button del;

    public StudentTM() {
    }

    public StudentTM(String stdId, String name, String nic, String branch, String courseId, Date doj, String contact, Button del) {
        this.stdId = stdId;
        this.name = name;
        this.nic = nic;
        this.branch = branch;
        this.courseId = courseId;
        this.doj = doj;
        this.contact = contact;
        this.del = del;
    }

    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Button getDel() {
        return del;
    }

    public void setDel(Button del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "StudentTM{" +
                "stdId='" + stdId + '\'' +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", branch='" + branch + '\'' +
                ", courseId='" + courseId + '\'' +
                ", doj=" + doj +
                ", contact='" + contact + '\'' +
                ", del=" + del +
                '}';
    }
}
