package dk.easv.mohammadabd.ems.GUI.View;

import dk.easv.mohammadabd.ems.BE.Event;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Events {

    public static VBox loadEventsComponent() {

        VBox mainContainer = new VBox();
        mainContainer.setPadding(new Insets(15));
        mainContainer.setPrefWidth(700);
        mainContainer.setAlignment(Pos.TOP_RIGHT);

        // Set width after the scene is initialized
        Platform.runLater(() -> {
            Scene scene = mainContainer.getScene();
            if (scene != null) {
                mainContainer.prefWidthProperty().bind(((javafx.scene.Scene) scene).widthProperty().multiply(0.7));
            }
        });

        // TextField for searching events
        TextField searchBox = new TextField();
        searchBox.setStyle("-fx-background-color: white;");
        searchBox.setPromptText("Search events...");
        searchBox.setPrefWidth(300);


        // Filter options
        HBox filterBox = new HBox(10);
        filterBox.setStyle("-fx-background-color: transparent;");
        filterBox.setAlignment(Pos.TOP_RIGHT);
        Button sortByBtn = new Button("Sort By");
        sortByBtn.setStyle("-fx-background-color: #DF6800; -fx-text-fill: white;");
        Button priceLowBtn = new Button("Price: Lower");
        Button priceHighBtn = new Button("Price: Highest");
        Button latestBtn = new Button("Latest");
        filterBox.getChildren().addAll(sortByBtn, priceLowBtn, priceHighBtn, latestBtn);
        filterBox.setPadding(new Insets(5));

        // Top bar containing the search box and filter box
        HBox topBar = new HBox();
        topBar.setStyle("-fx-background-color: transparent;");
        topBar.getChildren().addAll(searchBox, filterBox);
        topBar.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(filterBox, Priority.ALWAYS);

        // ScrollPane to hold the event cards
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setStyle("-fx-background-color: #0abae0 !important;");
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(600);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        // FlowPane to display events
        FlowPane eventPane = new FlowPane();
        eventPane.setStyle("-fx-background-color: linear-gradient(to right, #87CEFA, #0b48cd, #0d80ad);");
        eventPane.setHgap(20);
        eventPane.setVgap(20);
        eventPane.setPrefWrapLength(600);

        List<Event> events = generateRandomEvents(14);
        for (Event event : events) {
            eventPane.getChildren().add(createEventCard(event));
        }

        scrollPane.setContent(eventPane);
        mainContainer.getChildren().addAll(topBar, scrollPane);
        mainContainer.setStyle("-fx-background-color: linear-gradient(to right, #87CEFA, #0b48cd, #0d80ad);");
        return mainContainer;
    }



    public static VBox createEventCard(Event event) {
        VBox eventCard = new VBox();
        eventCard.setStyle("-fx-background-color: transparent;");
        eventCard.setSpacing(8);
        eventCard.setPadding(new Insets(10));
        eventCard.setPrefWidth(160);

        ImageView eventImage = new ImageView(new Image("/img/logo.png"));
        eventImage.setFitWidth(160);
        eventImage.setFitHeight(120);

        Text eventDescription = new Text(event.getEventName());
        Text eventPrice = new Text("Location: " + event.getLocation());

        eventCard.getChildren().addAll(eventImage, eventDescription, eventPrice);
        return eventCard;
    }

    private static List<Event> generateRandomEvents(int count) {
        Random random = new Random();
        LocalDate startDate = LocalDate.of(2025, 7, 14);
        LocalDate endDate = LocalDate.of(2025, 7, 15);
        Date sqlStartDate = Date.valueOf(startDate);
        Date sqlEndDate = Date.valueOf(endDate);

        return IntStream.range(1, count + 1).mapToObj(i ->
                new Event(i, "Event " + i,  sqlStartDate,  sqlEndDate, "Location " + i, "Venue " + i, "Description " + i)
        ).collect(Collectors.toList());
    }
}
