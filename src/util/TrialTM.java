package util;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;

public class TrialTM {

    private String Trail_ID;
    private String Date;
    private String Time;
    private String Venue;
    private String tot;
    private String totpass;
    private String totfail;
    private String totab;

    public TrialTM() {
    }

    public TrialTM(String trail_ID, String date, String time, String venue, String tot, String totpass, String totfail, String totab) {
        Trail_ID = trail_ID;
        Date = date;
        Time = time;
        Venue = venue;
        this.tot = tot;
        this.totpass = totpass;
        this.totfail = totfail;
        this.totab = totab;
    }



    public String getTrail_ID() {
        return Trail_ID;
    }

    public void setTrail_ID(String trail_ID) {
        Trail_ID = trail_ID;
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
        return "TrialTM{" +
                "Trail_ID='" + Trail_ID + '\'' +
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
