package dk.easv.mohammadabd.ems.GUI.Model;

import dk.easv.mohammadabd.ems.BLL.LoginBL;
import dk.easv.mohammadabd.ems.Utils.UserSession;

import java.sql.SQLException;

public class LoginML {
    LoginBL loginBL = new LoginBL();

    public boolean Login(String email, String password) throws SQLException {
        boolean success = loginBL.login(email, password);
        if (success) {
            UserSession.setLoggedIn(true);
            System.out.println("Login Successful");
        } else {
            UserSession.setLoggedIn(false);
            System.out.println("Login Failed");
        }
        return success;
    }
}
