package dk.easv.mohammadabd.ems.BE;

import java.util.Date;

public class Ticket {
    private int id;
    private String eventName;
    private int start_time;
    private int end_time;
    private String location;
    private String locationGuidance;
    private String notes;

    public Ticket(int id, String eventName, int start_time, int end_time, String location, String locationGuidance, String notes) {
        this.id = id;
        this.eventName = eventName;
        this.start_time = start_time;
        this.end_time = end_time;
        this.location = location;
        this.locationGuidance = locationGuidance;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getStart_time() {
        return start_time;
    }
    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getEnd_time() {
        return end_time;
    }
    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationGuidance() {
        return locationGuidance;
    }
    public void setLocationGuidance(String locationGuidance) {
        this.locationGuidance = locationGuidance;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
