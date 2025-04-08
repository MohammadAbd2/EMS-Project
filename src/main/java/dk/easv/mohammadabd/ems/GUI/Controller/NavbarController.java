package dk.easv.mohammadabd.ems.GUI.Controller;

import dk.easv.mohammadabd.ems.GUI.View.*;
import dk.easv.mohammadabd.ems.GUI.View.Header.CustomTitleBar;
import dk.easv.mohammadabd.ems.GUI.View.Header.Navbar;
import dk.easv.mohammadabd.ems.GUI.View.Header.Slider;
import dk.easv.mohammadabd.ems.Utils.LoggedInUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class NavbarController {
    @FXML
    private Button ticketTab;
    @FXML
    private Button EventTab;
    @FXML
    private Button CoordinatorTab;
    @FXML
    private ImageView profile_pic;

    public void initialize() {
        // Load profile image
        Image image = new Image(getClass().getResource("/img/logo.png").toExternalForm());
        profile_pic.setImage(image);

        // Apply circular clipping
        Circle clip = new Circle(profile_pic.getFitWidth() / 1.75, profile_pic.getFitHeight() / 2.5,
                Math.min(profile_pic.getFitWidth(), profile_pic.getFitHeight()) / 2.4);
        profile_pic.setClip(clip);

        if(LoggedInUser.getInstance().isAuthenticated()){
            ticketTab.setDisable(false);
            EventTab.setDisable(false);
            CoordinatorTab.setDisable(false);
        }else{
            ticketTab.setDisable(true);
            EventTab.setDisable(true);
            CoordinatorTab.setDisable(true);
        }
    }

    public void ticketTab(ActionEvent event) {
        try {
            // Declare the variables
            VBox Application = new VBox();
            VBox WindowBox = new VBox();
            VBox rootContainer = new VBox();
            VBox Body  = new VBox();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Load Header components such as Navbar and CustomTitleBar
            CustomTitleBar customTitleBar = new CustomTitleBar(currentStage);
            WindowBox.getChildren().add(customTitleBar);
            rootContainer.getChildren().add(WindowBox);  // Load the Navbar
            rootContainer.getChildren().add(Navbar.loadNavbar());  // Load the Navbar

            // Add the Body with the Ticket-specific components
            Body.getChildren().add(Slider.loadSlider());  // Add the Slider as an example
            // Here you can add components specific to the Ticket
            Body.getChildren().add(TicketPage.loadPage(event));

            // Add ScrollPane to enable vertical and horizontal scrolling
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(Body);
            scrollPane.setFitToWidth(true);
            scrollPane.setFitToHeight(true);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.getStyleClass().add("scroll-pane");

            // Add ScrollPane to root container
            rootContainer.getChildren().add(scrollPane);

            // Set the new Scene to the Stage
            Application.getChildren().add(rootContainer);
            Scene currentScene = currentStage.getScene();
            currentScene.setRoot(Application);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void HomeTab(ActionEvent event) {
        try {
            // declaration of the variables
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            VBox Application = new VBox();
            VBox WindowBox = new VBox();
            VBox rootContainer = new VBox();
            VBox Body  = new VBox();

            // Sort the VBox to fit with the style and Application
            CustomTitleBar customTitleBar = new CustomTitleBar(currentStage);
            WindowBox.getChildren().add(customTitleBar);
            Application.getChildren().add(WindowBox);
            rootContainer.getChildren().add(Navbar.loadNavbar());

            //add the new component here bellow
            Body.getChildren().add(Slider.loadSlider());
            Body.getChildren().add(Events.loadEventsComponent());


            // create and add the ScrollPane
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(Body);
            scrollPane.setFitToWidth(true);
            scrollPane.setFitToHeight(true);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.getStyleClass().add("scroll-pane");
            rootContainer.getChildren().add(scrollPane);

            //render & set the new Scene to the Stage
            Application.getChildren().add(rootContainer);
            Scene currentScene = currentStage.getScene();
            currentScene.setRoot(Application);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void EventTab(ActionEvent event) {
        try {
            // declaration of the variables
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            VBox Application = new VBox();
            VBox WindowBox = new VBox();
            VBox rootContainer = new VBox();
            VBox Body  = new VBox();

            // Sort the VBox to fit with the style and Application
            CustomTitleBar customTitleBar = new CustomTitleBar(currentStage);
            WindowBox.getChildren().add(customTitleBar);
            Application.getChildren().add(WindowBox);
            rootContainer.getChildren().add(Navbar.loadNavbar());

            //add the new component here bellow
            Body.getChildren().add(Slider.loadSlider());
            Body.getChildren().add(Slider.loadSlider());


            // create and add the ScrollPane
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(Body);
            scrollPane.setFitToWidth(true);
            scrollPane.setFitToHeight(true);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.getStyleClass().add("scroll-pane");
            rootContainer.getChildren().add(scrollPane);

            //render & set the new Scene to the Stage
            Application.getChildren().add(rootContainer);
            Scene currentScene = currentStage.getScene();
            currentScene.setRoot(Application);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CoordinatorTab(ActionEvent event) {
        try {
            // declaration of the variables
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            VBox Application = new VBox();
            VBox WindowBox = new VBox();
            VBox rootContainer = new VBox();
            VBox Body  = new VBox();

            // Sort the VBox to fit with the style and Application
            CustomTitleBar customTitleBar = new CustomTitleBar(currentStage);
            WindowBox.getChildren().add(customTitleBar);
            Application.getChildren().add(WindowBox);
            rootContainer.getChildren().add(Navbar.loadNavbar());

            //add the new component here bellow
            Body.getChildren().add(Slider.loadSlider());
            Body.getChildren().add(Slider.loadSlider());


            // create and add the ScrollPane
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(Body);
            scrollPane.setFitToWidth(true);
            scrollPane.setFitToHeight(true);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.getStyleClass().add("scroll-pane");
            rootContainer.getChildren().add(scrollPane);

            //render & set the new Scene to the Stage
            Application.getChildren().add(rootContainer);
            Scene currentScene = currentStage.getScene();
            currentScene.setRoot(Application);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void ProfileTab(javafx.scene.input.MouseEvent event) {
        try {
            // declaration of the variables
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            VBox Application = new VBox();
            VBox WindowBox = new VBox();
            VBox rootContainer = new VBox();
            VBox Body  = new VBox();

            // Sort the VBox to fit with the style and Application
            CustomTitleBar customTitleBar = new CustomTitleBar(currentStage);
            WindowBox.getChildren().add(customTitleBar);
            Application.getChildren().add(WindowBox);
            rootContainer.getChildren().add(Navbar.loadNavbar());

            //add the new component here bellow
            Body.getChildren().add(Slider.loadSlider());
            if(LoggedInUser.getInstance().isAuthenticated()){
                System.out.println("Already logged in");

            }else {
                Body.getChildren().add(Login.loadLogin());
            }



            // create and add the ScrollPane
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(Body);
            scrollPane.setFitToWidth(true);
            scrollPane.setFitToHeight(true);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.getStyleClass().add("scroll-pane");
            rootContainer.getChildren().add(scrollPane);

            //render & set the new Scene to the Stage
            Application.getChildren().add(rootContainer);
            Scene currentScene = currentStage.getScene();
            currentScene.setRoot(Application);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
