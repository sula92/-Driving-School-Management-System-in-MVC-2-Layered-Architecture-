package entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Trial implements SuperEntity {

    private String Trial_ID;
    private String Date;
    private String Time;
    private String Venue;

    public Trial() {
    }

    public Trial(String trial_ID, String date, String time, String venue) {
        Trial_ID = trial_ID;
        Date = date;
        Time = time;
        Venue = venue;
    }

    public String getTrial_ID() {
        return Trial_ID;
    }

    public void setTrial_ID(String trial_ID) {
        Trial_ID = trial_ID;
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
        return "Trial{" +
                "Trial_ID='" + Trial_ID + '\'' +
                ", Date=" + Date +
                ", Time=" + Time +
                ", Venue='" + Venue + '\'' +
                '}';
    }
}
