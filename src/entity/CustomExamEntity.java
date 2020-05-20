package entity;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class CustomExamEntity implements SuperEntity {

    private String Exam_ID;
    private LocalDate Date;
    private LocalTime Time;
    private String Venue;
    private String Total;
    private String Total_Pass;
    private String Total_Fail;
    private String Total_Absent;

    public CustomExamEntity() {
    }

    public CustomExamEntity(String exam_ID, LocalDate date, LocalTime time, String venue, String total, String total_Pass, String total_Fail, String total_Absent) {
        Exam_ID = exam_ID;
        Date = date;
        Time = time;
        Venue = venue;
        Total = total;
        Total_Pass = total_Pass;
        Total_Fail = total_Fail;
        Total_Absent = total_Absent;
    }

    public String getExam_ID() {
        return Exam_ID;
    }

    public void setExam_ID(String exam_ID) {
        Exam_ID = exam_ID;
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

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getTotal_Pass() {
        return Total_Pass;
    }

    public void setTotal_Pass(String total_Pass) {
        Total_Pass = total_Pass;
    }

    public String getTotal_Fail() {
        return Total_Fail;
    }

    public void setTotal_Fail(String total_Fail) {
        Total_Fail = total_Fail;
    }

    public String getTotal_Absent() {
        return Total_Absent;
    }

    public void setTotal_Absent(String total_Absent) {
        Total_Absent = total_Absent;
    }

    @Override
    public String toString() {
        return "CustomExamEntity{" +
                "Exam_ID='" + Exam_ID + '\'' +
                ", Date=" + Date +
                ", Time=" + Time +
                ", Venue='" + Venue + '\'' +
                ", Total='" + Total + '\'' +
                ", Total_Pass='" + Total_Pass + '\'' +
                ", Total_Fail='" + Total_Fail + '\'' +
                ", Total_Absent='" + Total_Absent + '\'' +
                '}';
    }
}
