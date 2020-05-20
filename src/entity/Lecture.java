package entity;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Lecture implements SuperEntity {

    private String Lecture_ID;
    private String Lecture_Name;
    private LocalDate Date;
    private LocalTime Time;
    private String Venue;

    public Lecture() {
    }

    public Lecture(String lectureid, String lecturename, java.sql.Date date, java.sql.Time time, String venue) {

        Lecture_ID=lectureid;
        Lecture_Name=lecturename;
        Date=date.toLocalDate();
        Time=time.toLocalTime();
        Venue=venue;

    }

    public Lecture(String lecture_ID, String lecture_Name, LocalDate date, LocalTime time, String venue) {
        Lecture_ID = lecture_ID;
        Lecture_Name = lecture_Name;
        Date = date;
        Time = time;
        Venue = venue;
    }

    public String getLecture_ID() {
        return Lecture_ID;
    }

    public void setLecture_ID(String lecture_ID) {
        Lecture_ID = lecture_ID;
    }

    public String getLecture_Name() {
        return Lecture_Name;
    }

    public void setLecture_Name(String lecture_Name) {
        Lecture_Name = lecture_Name;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public LocalTime getTime() {
        return Time;
    }

    public void setTime(LocalTime time) {
        Time = time;
    }

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String venue) {
        Venue = venue;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "Lecture_ID='" + Lecture_ID + '\'' +
                ", Lecture_Name='" + Lecture_Name + '\'' +
                ", Date=" + Date +
                ", Time=" + Time +
                ", Venue='" + Venue + '\'' +
                '}';
    }
}
