package dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class TrialDTO {

    private String trial_id;
    private String date;
    private String time;
    private String venue;

    public TrialDTO() {
    }

    public TrialDTO(String trial_id, String date, String time, String venue) {
        this.trial_id = trial_id;
        this.date = date;
        this.time = time;
        this.venue = venue;
    }

    public String getTrial_id() {
        return trial_id;
    }

    public void setTrial_id(String trial_id) {
        this.trial_id = trial_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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
        return "TrialDTO{" +
                "trial_id='" + trial_id + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", venue='" + venue + '\'' +
                '}';
    }
}
