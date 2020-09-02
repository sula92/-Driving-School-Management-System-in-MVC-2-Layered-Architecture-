package util;

import javafx.scene.control.Button;



public class LectureTM {

    private String leci;
    private String lecNm;
    private String date;
    private String time;
    private String venue;
    private Button del;


    public LectureTM() {
    }

    public LectureTM(String leci, String lecNm, String date, String time, String venue, Button del) {
        this.leci = leci;
        this.lecNm = lecNm;
        this.date = date;
        this.time = time;
        this.venue = venue;
        this.del = del;
    }

    public String getLeci() {
        return leci;
    }

    public void setLeci(String leci) {
        this.leci = leci;
    }

    public String getLecNm() {
        return lecNm;
    }

    public void setLecNm(String lecNm) {
        this.lecNm = lecNm;
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

    public Button getDel() {
        return del;
    }

    public void setDel(Button del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "LectureTM{" +
                "leci='" + leci + '\'' +
                ", lecNm='" + lecNm + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", venue='" + venue + '\'' +
                ", del=" + del +
                '}';
    }
}
