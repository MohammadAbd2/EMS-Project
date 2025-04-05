package dk.easv.mohammadabd.ems.GUI.Controller;

import dk.easv.mohammadabd.ems.BE.Event;
import dk.easv.mohammadabd.ems.GUI.View.Events;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Random;

public class EventsController {

    @FXML
    private VBox eventsContainer;

    @FXML
    private TextField searchBox;

    @FXML
    private Button sortByButton, priceLowerButton, priceHighestButton, latestButton;

    @FXML
    private FlowPane eventsFlowPane;

    private List<Event> eventList = new ArrayList<>();

    @FXML
    public void initialize() {
        sortByButton.setOnAction(event -> handleSort("default"));
        priceLowerButton.setOnAction(event -> handleSort("priceLow"));
        priceHighestButton.setOnAction(event -> handleSort("priceHigh"));
        latestButton.setOnAction(event -> handleSort("latest"));

        searchBox.textProperty().addListener((observable, oldValue, newValue) -> handleSearch(newValue));

        loadRandomEvents(); // تحميل الأحداث العشوائية عند بدء التشغيل
    }

    private void handleSort(String sortType) {
        System.out.println("Sorting by: " + sortType);
    }

    private void handleSearch(String query) {
        System.out.println("Searching for: " + query);
    }

    private void loadRandomEvents() {
        Random random = new Random();
        // استخدم LocalDate لإنشاء التاريخ
        LocalDate localStartDate = LocalDate.of(2025, 7, 14);  // التاريخ 14 يوليو 2025
        LocalDate localEndDate = LocalDate.of(2025, 7, 15);    // التاريخ 15 يوليو 2025

// تحويل LocalDate إلى java.sql.Date يدويًا
        Date sqlStartDate = Date.valueOf(localStartDate);
        Date sqlEndDate = Date.valueOf(localEndDate);


        for (int i = 1; i <= 14; i++) {
            eventList.add(new Event(i, "Event " + i, (java.sql.Date) sqlStartDate, (java.sql.Date) sqlEndDate, "City " + i, "Venue " + i, "Description " + i));
        }
        displayEvents();
    }

    private void displayEvents() {
        eventsFlowPane.getChildren().clear();
        for (Event event : eventList) {
            eventsFlowPane.getChildren().add(Events.createEventCard(event));
        }
    }
}
