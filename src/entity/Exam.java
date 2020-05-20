package entity;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Exam implements SuperEntity {

    private String Exam_ID;
    private String Date;
    private String Time;
    private String Venue;


    public Exam(String exam_ID, String date, String time, String venue) {
        Exam_ID = exam_ID;
        Date = date;
        Time = time;
        Venue = venue;
    }

    public Exam() {
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
}
