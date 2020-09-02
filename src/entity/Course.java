package entity;

public class Course implements SuperEntity {

    private String courseid;
    private String coursenm;
    private double fee;

    public Course() {
    }

    public Course(String courseid, String coursenm, double fee) {
        this.courseid = courseid;
        this.coursenm = coursenm;
        this.fee = fee;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getCoursenm() {
        return coursenm;
    }

    public void setCoursenm(String coursenm) {
        this.coursenm = coursenm;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseid='" + courseid + '\'' +
                ", coursenm='" + coursenm + '\'' +
                ", fee=" + fee +
                '}';
    }
}
