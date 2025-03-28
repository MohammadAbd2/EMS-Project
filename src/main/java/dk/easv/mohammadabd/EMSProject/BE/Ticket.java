package dk.easv.mohammadabd.EMSProject.BE;

import java.lang.reflect.Array;
import java.util.Date;

public class Ticket {
    private int id;
    private String title;
    private String note;
    private int price;
    private String location;
    private Date date;
    private boolean isVip;

    public Ticket(int id, String title, String note, int price, String location, Date date, boolean isVip) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.price = price;
        this.location = location;
        this.date = date;
        this.isVip = isVip;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public boolean isVip() {
        return isVip;
    }
    public void setVip(boolean isVip) {
        this.isVip = isVip;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
