package dk.easv.mohammadabd.ems.GUI.Controller;

import dk.easv.mohammadabd.ems.GUI.View.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class NavbarController {
    @FXML
    private ImageView profile_pic;

    public void initialize() {
        // Load profile image
        Image image = new Image(getClass().getResource("/img/logo.png").toExternalForm());
        profile_pic.setImage(image);

        // Apply circular clipping
        Circle clip = new Circle(profile_pic.getFitWidth() / 3, profile_pic.getFitHeight() / 3,
                Math.min(profile_pic.getFitWidth(), profile_pic.getFitHeight()) / 3);
        profile_pic.setClip(clip);
    }

    public void ticketTab(ActionEvent event) {
        try {
            // declaration of the variables
            VBox Application = new VBox();
            VBox WindowBox = new VBox();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            VBox rootContainer = new VBox();
            VBox Body  = new VBox();
            // Random Component to add to the Tab pages
            CustomTitleBar customTitleBar = new CustomTitleBar(currentStage);

            // sort VBoxes
            Application.getChildren().add(WindowBox);
            Application.getChildren().add(rootContainer);
            WindowBox.getChildren().add(customTitleBar);
            rootContainer.getChildren().add(Navbar.loadNavbar());
            Body.getChildren().add(Slider.loadSlider());
            Body.getChildren().add(Slider.loadSlider());
            Body.getChildren().add(Slider.loadSlider());
            Body.getChildren().add(Slider.loadSlider());
            Body.getChildren().add(Slider.loadSlider());
            Body.getChildren().add(Slider.loadSlider());
            Body.getChildren().add(Slider.loadSlider());
            // Add the ScrollPane
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(Body);
            scrollPane.setFitToWidth(true);
            scrollPane.setFitToHeight(true);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.getStyleClass().add("scroll-pane");

            rootContainer.getChildren().add(scrollPane);
            // set the new Scene to the Stage
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
            Body.getChildren().add(Login.loadLogin());


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
