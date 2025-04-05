package dk.easv.mohammadabd.ems.BE;

import java.sql.Date;
import java.time.LocalDate;

public class Event {
    private int id;
    private String eventName;
    private Date start_time; // تغيير إلى LocalDate
    private Date end_time; // تغيير إلى LocalDate
    private String location;
    private String locationGuidance;
    private String notes;

    public Event(int id, String eventName, Date start_time, Date end_time, String location, String locationGuidance, String notes) {
        this.id = id;
        this.eventName = eventName;
        this.start_time = start_time;
        this.end_time = end_time;
        this.location = location;
        this.locationGuidance = locationGuidance;
        this.notes = notes;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public Date getStart_time() {
        return start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public String getLocation() {
        return location;
    }

    public String getLocationGuidance() {
        return locationGuidance;
    }

    public String getNotes() {
        return notes;
    }

    public void setId(int anInt) {
        this.id = anInt;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }
    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setLocationGuidance(String locationGuidance) {
        this.locationGuidance = locationGuidance;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    @Override
    public String toString() {
        return "Event{id=" + id + ", eventName='" + eventName + "', start_time=" + start_time + ", end_time=" + end_time + ", location='" + location + "', locationGuidance='" + locationGuidance + "', notes='" + notes + "'}";
    }
}
