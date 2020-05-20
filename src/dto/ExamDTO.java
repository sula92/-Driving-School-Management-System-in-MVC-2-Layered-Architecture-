package dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ExamDTO {

    private String Exam_ID;
    private String Date;
    private String Time;
    private String Venue;


    public ExamDTO(String exam_ID, String date, String time, String venue) {
        Exam_ID = exam_ID;
        Date = date;
        Time = time;
        Venue = venue;
    }

    public ExamDTO() {
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

    @Override
    public String toString() {
        return "ExamDTO{" +
                "Exam_ID='" + Exam_ID + '\'' +
                ", Date='" + Date + '\'' +
                ", Time='" + Time + '\'' +
                ", Venue='" + Venue + '\'' +
                '}';
    }
}
