package dk.easv.mohammadabd.ems.BE;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private UUID id;
    private String eventName;
    private LocalDateTime start_time;  // Use LocalDateTime for start_time
    private LocalDateTime end_time;    // Use LocalDateTime for end_time
    private String location;
    private String locationGuidance;
    private String notes;
    private String barcode;

    public Ticket(UUID id, String eventName, LocalDateTime start_time, LocalDateTime end_time, String location, String locationGuidance, String notes, String barcode) {
        this.id = id;
        this.eventName = eventName;
        this.start_time = start_time;
        this.end_time = end_time;
        this.location = location;
        this.locationGuidance = locationGuidance;
        this.notes = notes;
        this.barcode = barcode;
    }

    public Ticket() {
        // Default constructor
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
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

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
