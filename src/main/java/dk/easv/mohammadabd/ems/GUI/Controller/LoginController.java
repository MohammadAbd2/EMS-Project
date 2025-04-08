package dk.easv.mohammadabd.ems.GUI.Controller;
import dk.easv.mohammadabd.ems.BLL.LoginBLL;
import dk.easv.mohammadabd.ems.GUI.View.SceneManager;

import javafx.fxml.FXML;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

public class LoginController {

    @FXML
    private AnchorPane loginPageContent;
    @FXML
    private ImageView logo;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    private final LoginBLL loginBLL = new LoginBLL();

    @FXML
    public void initialize() {
        loginButton.setOnAction(event -> handleLogin());
    }
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        boolean result = loginBLL.login(username, password);

        if (result) {
            System.out.println("You have successfully logged in!");

            Stage stage = SceneManager.getStage();

            Scene currentScene = stage.getScene();
            stage.setScene(currentScene);
            stage.show();

        } else {
            showAlert("Failed to login!", "Incorrect username or password.", Alert.AlertType.ERROR);
        }
    }


    private void showAlert(String title, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
