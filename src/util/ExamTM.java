package util;

import java.time.LocalDate;
import java.time.LocalTime;

public class ExamTM {

    private String Exam_ID;
    private String Date;
    private String Time;
    private String Venue;
    private String tot;
    private String totpass;
    private String totfail;
    private String totab;

    public ExamTM() {
    }

    public ExamTM(String exam_ID, String date, String time, String venue, String tot, String totpass, String totfail, String totab) {
        Exam_ID = exam_ID;
        Date = date;
        Time = time;
        Venue = venue;
        this.tot = tot;
        this.totpass = totpass;
        this.totfail = totfail;
        this.totab = totab;
    }



    public String getExam_ID() {
        return Exam_ID;
    }

    public void setExam_ID(String exam_ID) {
        Exam_ID = exam_ID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String venue) {
        Venue = venue;
    }

    public String getTot() {
        return tot;
    }

    public void setTot(String tot) {
        this.tot = tot;
    }

    public String getTotpass() {
        return totpass;
    }

    public void setTotpass(String totpass) {
        this.totpass = totpass;
    }

    public String getTotfail() {
        return totfail;
    }

    public void setTotfail(String totfail) {
        this.totfail = totfail;
    }

    public String getTotab() {
        return totab;
    }

    public void setTotab(String totab) {
        this.totab = totab;
    }

    @Override
    public String toString() {
        return "ExamTM{" +
                "Exam_ID='" + Exam_ID + '\'' +
                ", Date='" + Date + '\'' +
                ", Time='" + Time + '\'' +
                ", Venue='" + Venue + '\'' +
                ", tot='" + tot + '\'' +
                ", totpass='" + totpass + '\'' +
                ", totfail='" + totfail + '\'' +
                ", totab='" + totab + '\'' +
                '}';
    }
}
