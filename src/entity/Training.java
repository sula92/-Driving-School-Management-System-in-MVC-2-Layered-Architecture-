package entity;

import java.sql.Date;
import java.sql.Time;

public class Training implements SuperEntity {

    private String Training_ID;
    private Date date;
    private Time time;
    private String venue;

    public Training() {
    }

    public Training(String training_ID, Date date, Time time, String venue) {
        Training_ID = training_ID;
        this.date = date;
        this.time = time;
        this.venue = venue;
    }

    public String getTraining_ID() {
        return Training_ID;
    }

    public void setTraining_ID(String training_ID) {
        Training_ID = training_ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
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
        return "Training{" +
                "Training_ID='" + Training_ID + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", venue='" + venue + '\'' +
                '}';
    }
}
