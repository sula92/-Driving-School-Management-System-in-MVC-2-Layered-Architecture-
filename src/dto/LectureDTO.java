package dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class LectureDTO {

    private String lecture_id;
    private String lecture_name;
    private LocalDate date;
    private LocalTime time;
    private String venue;


    public LectureDTO() {
    }

    public LectureDTO(String lecture_id, String lecture_name, LocalDate date, LocalTime time, String venue) {
        this.lecture_id = lecture_id;
        this.lecture_name = lecture_name;
        this.date = date;
        this.time = time;
        this.venue = venue;
    }

    public String getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(String lecture_id) {
        this.lecture_id = lecture_id;
    }

    public String getLecture_name() {
        return lecture_name;
    }

    public void setLecture_name(String lecture_name) {
        this.lecture_name = lecture_name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @Override
    public String toString() {
        return "LectureDTO{" +
                "lecture_id='" + lecture_id + '\'' +
                ", lecture_name='" + lecture_name + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", venue='" + venue + '\'' +
                '}';
    }
}
