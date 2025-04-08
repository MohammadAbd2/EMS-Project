package dk.easv.mohammadabd.ems.GUI.Controller;

import dk.easv.mohammadabd.ems.GUI.Model.LoginML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
        login.Login(usernameText, passwordText);
    }
}
