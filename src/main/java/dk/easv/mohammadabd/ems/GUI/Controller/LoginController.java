package dk.easv.mohammadabd.ems.GUI.Controller;

import dk.easv.mohammadabd.ems.GUI.Model.LoginML;
import dk.easv.mohammadabd.ems.GUI.View.Events;
import dk.easv.mohammadabd.ems.GUI.View.Header.CustomTitleBar;
import dk.easv.mohammadabd.ems.GUI.View.Header.Navbar;
import dk.easv.mohammadabd.ems.GUI.View.Header.Slider;
import dk.easv.mohammadabd.ems.GUI.View.HomePage;
import dk.easv.mohammadabd.ems.GUI.View.SceneManager;
import dk.easv.mohammadabd.ems.Utils.LoggedInUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Button loginButton;

    LoginML login = new LoginML();
    public void loginButtonClicked(ActionEvent event) throws SQLException {
        loginButton.setDisable(true);
        username.setDisable(true);
        password.setDisable(true);
        String usernameText = username.getText();
        String passwordText = password.getText();


        if (login.Login(usernameText, passwordText)) {
            LoggedInUser.getInstance().setAuthenticated(true);
            HomePage homePage = new HomePage();
            homePage.loadPage(event);
        }


    }
}

