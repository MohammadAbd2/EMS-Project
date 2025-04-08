package dk.easv.mohammadabd.ems.GUI.Controller;

import dk.easv.mohammadabd.ems.GUI.Model.LoginML;
import dk.easv.mohammadabd.ems.GUI.View.SceneManager;
import dk.easv.mohammadabd.ems.Utils.LoggedInUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
            // إذا تم تسجيل الدخول بنجاح، نعرض النافذة الرئيسية
            Stage currentStage = (Stage) loginButton.getScene().getWindow();  // الحصول على النافذة الحالية
            currentStage.close();  // إغلاق نافذة تسجيل الدخول

            // عرض النافذة الرئيسية باستخدام SceneManager
            SceneManager.showMainScene(new Stage());  // نمرر Stage جديدة لعرض المشهد الرئيسي
        } else {
            // إذا فشل تسجيل الدخول
            System.out.println("Login Failed");
        }
    }


    }

